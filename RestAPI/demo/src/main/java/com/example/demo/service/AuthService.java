package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.exceptions.AuthException;
import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.jwt.JwtRequest;
import com.example.demo.security.jwt.JwtResponse;

import io.jsonwebtoken.Claims;

@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	
    private final Map<String, String> refreshStorage = new HashMap<>();
    
    @Autowired
    private JwtProvider jwtProvider;

	public AuthService(UserService userService, JwtProvider jwtProvider) {
		super();
		this.userService = userService;
		this.jwtProvider = jwtProvider;
	}
    
	public JwtResponse login(@NonNull JwtRequest authRequest) {
        final Optional<? extends User> user = userService.getUserByLogin(authRequest.getLogin());
        if (user == null) {
        	throw new AuthException("Пользователь не найден");
        }
                
        if (user.get().getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.get().getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }
	
	public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
            	final Optional<? extends User> user = userService.getUserByLogin(login);
                if (user == null) {
                	throw new AuthException("Пользователь не найден");
                }
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }
	
	public JwtResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
            	final Optional<? extends User> user = userService.getUserByLogin(login);
                if (user == null) {
                	throw new AuthException("Пользователь не найден");
                }
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.get().getLogin(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }
	
//	public JwtAuthentication getAuthInfo() {
//        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
//    }
}
