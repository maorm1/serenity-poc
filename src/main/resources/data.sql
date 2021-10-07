insert into users (id, name, description, password)
values (0, 'Alan', 'System administrator', '123456'),
       (1, 'Bob', 'feature user', 'Pa$$w0rd'),
       (2, 'Carl', 'nobody knows what this guy does, really...', 'foobar');

insert into user_rights (user_id, right_id, enabled)
values (0, 1, true),
       (1, 1, false),
       (1, 2, true);