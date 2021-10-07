drop table if exists users;
drop table if exists user_rights;

create table users
(
    id          long auto_increment primary key,
    name        varchar not null,
    description varchar,
    password    varchar not null
);

create table user_rights
(
    user_id  long    not null,
    right_id int     not null,
    enabled  boolean not null default false
);

