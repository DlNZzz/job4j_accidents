CREATE TABLE types (
  id serial primary key,
  name varchar(2000)
);

CREATE TABLE rules (
  id serial primary key,
  name varchar(2000)
);

CREATE TABLE accidents (
  id serial primary key,
  name varchar(2000),
  text varchar(2000),
  address varchar(2000),
  types_id int references types(id)
);

CREATE TABLE accidents_rules (
    id serial primary key,
    accidents_id int references accidents(id),
    rules_id int references rules(id)
);