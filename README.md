# PsychologyPetProject

# Краткое описание
Данный проект представляет REST API для сайта, на котором можно искать психологов исходя из региона, больницы и комментариев пациентов.

# Описание функционала
Запросы к API отправляются по протоколу HTTP на URL вида http://localhost:18080/:resourse/:id, где :resourse - имя запрашиваемого ресурса, :id - опциональный
идентификатор ресурса. Формат возвращаемого значения - JSON 

/api/find - по заданному url можно передавать вплоть до трех параметров(name, lastName, region). Возвращается множество уникальных результатов
поиска по заданным параметрам.

/registration - по заданному url просходит регистрация пациента либо психолога.

/api/auth - по этому url происходит авторизация и выдача access и refresh JWT токенов.

/image/img/:id - по этому url реализовано получение картинки из базы данных, необходимоц для работы frontend.

Реализованы несколько сущностей, объединенные связями OneToOne, ManyToOne.

# Используемые технологии
Для данного проекта я использовал:
* Java версии 17
* Фреймворк Spring (Boot, Data, MVC, Security)
* Hibernate
* База данных PostgreSQL


