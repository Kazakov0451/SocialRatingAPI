# Документация по API

# Преподаватель:
## Создание Преподавателя
### [post] /api/v1/teachers/create
**BodyRequest:**
```
{
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "role": "TEACHER",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```
**Ответ:**
```
{
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "role": "TEACHER",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```
## Получить всех Преподавателей
### [GET] /api/v1/teachers
**Ответ:**
```
[ 
    {
        "id" : 1,
        "..." : "..."
    }, 
    {
        "id" : 2,
        "..." : "..."
    }
]
```

## Получить Преподавателя по идентификатору
### [GET] /api/v1/teachers/{teacherId}
**Ответ:**
```
{
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "role": "TEACHER",
    "faculty": "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```

## Обновить данные Преподавателя
### [PATCH] /api/v1/teachers/update/{teacherId}
**BodyRequest:**
```
{
    "points": 5
}
```
#### Заполняется JSON теми данными, которые хотим обновить у Преподавателя
**Ответ:**
```
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "group": "group",
    "role": "TEACHER",
    "faculty": "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 5
```
#### В ответе приходит JSON сущности с измененными данными


## Передать баллы Студенту
### [PATCH] /api/v1/teachers/give_points
**BodyRequest:**
```
{
    "toId" : 1,
    "fromId" : 1,
    "points" : 5
}
```
#### toId - Идентификатор Студента
#### fromId - Идентификатор Преподавателя
#### points - Сколько передаем баллов

## Удалить Преподавателя
### [DELETE] /api/v1/teachers/delete/{teacherId}

# Студент:

## Создание Студента
### [post] /api/v1/students/create
**BodyRequest:**
```
{
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "group": "group",
    "role": "STUDENT",
    "faculty" : "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```
**Ответ:**
```
{
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "group": "group",
    "role": "STUDENT",
    "faculty": "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```

## Получить всех Студентов
### [GET] /api/v1/students
**Ответ:**
```
[ 
    {
        "id" : 1,
        "..." : "..."
    }, 
    {
        "id" : 2,
        "..." : "..."
    }
]
```

## Получить Студента по идентификатору
### [GET] /api/v1/students/{studentId}
**Ответ:**
```
{
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "group": "group",
    "role": "STUDENT",
    "faculty": "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```

## Обновить данные Студента
### [PATCH] /api/v1/students/update/1
**BodyRequest:**
```
{
    "points": 5
}
```
#### Заполняется JSON теми данными, которые хотим обновить у Студента
**Ответ:**
```
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "group": "group",
    "role": "STUDENT",
    "faculty": "faculty",
    "password": "password",
    "gender": "MEN",
    "points": 5
```
#### В ответе приходит JSON с измененными данными

## Передать баллы Преподавателю
### [PATCH] /api/v1/students/give_points
**BodyRequest:**
```
{
    "toId" : 1,
    "fromId" : 1,
    "points" : 5
}
```
#### toId - Идентификатор Преподавателя
#### fromId - Идентификатор Студента
#### points - Сколько передаем баллов

## Удалить Студента
### [DELETE] /api/v1/students/delete/{studentId}

# Авторизация 
### [POST] /api/v1/login
**BodyRequest:**
```
{
    "mail": "mail",
    "password": "password"
}
```
**Ответ:**
```
{
    "id": 1,
    "name": "name",
    "surname": "surname",
    "patronymic": "patronymic",
    "mail": "mail",
    "phone": "phone",
    "faculty": "faculty",
    "group": "group",
    "role": "TEACHER",
    "password": "password",
    "gender": "MEN",
    "points": 0
}
```