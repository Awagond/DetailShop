# Руководство пользователя
Это информационная система магазина компьютерных комплектующих.

## Перед запуском программы
Нужно подготовить рабочее пространство:

1. Установить OpenServer или MYSQLServer
2. Установить NetBeans 
3. Скачать mysql-connector версии 8.0.17 или 8.0.26
4. Скачать репозиторий
5. Изменить версию mysql-connector в зависимости по надобности
6. Открыть файл sh.mwb и импортировать эту модель к себе в БД
7. Вставить в БД в таблицу роли 2 записи
8. INSERT INTO Userrole VALUES(1, 'admin');
9. INSERT INTO Userrole VALUES(2, 'user');
10. Запустить программу
