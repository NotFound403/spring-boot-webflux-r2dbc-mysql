
drop table if exists client_user;

create table client_user(
user_id varchar(64) not null primary key,
nick_name varchar(32),
phone_number varchar(16),
gender tinyint default 0) charset = utf8mb4;
