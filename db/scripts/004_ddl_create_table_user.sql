CREATE TABLE authorities (
  id serial primary key,
  authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users (
  id serial primary key,
  username VARCHAR(50) NOT NULL unique,
  password VARCHAR(100) NOT NULL,
  enabled boolean default true,
  authority_id int not null references authorities(id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W',
(select id from authorities where authority = 'ROLE_ADMIN'));



select id from authorities where authority = 'ROLE_ADMIN';

select username, password, enabled from users where username = 'root';

select u.username, a.authority
from authorities as a, users as u
where u.username = 'root' and u.authority_id = a.id;

select username, authority from users u join authorities a on u.authority_id = a.id;

select * from users;
select * from authorities;

select * from authorities where authority = 'ROLE_USER';