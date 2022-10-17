DELETE FROM accidents_rules;
DELETE FROM accidents;
DELETE FROM types;
DELETE FROM rules;

INSERT INTO rules (id, name) values (1, 'Статья. 1');
INSERT INTO rules (id, name) values (2, 'Статья. 2');
INSERT INTO rules (id, name) values (3, 'Статья. 3');

INSERT INTO types (id, name) values (1, 'Две машины');
INSERT INTO types (id, name) values (2, 'Машина и человек');
INSERT INTO types (id, name) values (3, 'Машина и велосипед');

INSERT INTO accidents (id, name, text, address, types_id) values (1, 'qew', 'text', 'addr', 1);

INSERT INTO accidents_rules (id, accidents_id, rules_id) values (1, 1, 2);

