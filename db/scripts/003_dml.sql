select * from accidents;
select * from accidents where types_id=1;

select * from accidents as a join types as t ON a.types_id = t.id;
select * from accidents as a FULL join types as t ON a.types_id = t.id;

select * from accidents as a
join accidents_rules as a_r ON a.id = a_r.accidents_id
join rules as r ON a_r.rules_id = r.id;

SELECT * FROM books
INNER JOIN books_authors ON books.id = books_authors.booksid
INNER JOIN authors ON books_authors.authorid = authors.id


select * from accidents_rules as a_r
join accidents as a ON a.id = a_r.accidents_id
join rules as r ON r.id = a_r.rules_id;


select * from types right join accidents on accidents.types_id = types.id;

select * from accidents as a
join accidents_rules as a_r on a.id = a_r.accidents_id
join rules as r on r.id = a_r.rules_id;

