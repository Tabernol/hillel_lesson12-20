
CREATE TABLE my_user (
user_id integer primary key,
name varchar2(30),
surname varchar2(30) not null,
date_of_registration date DEFAULT SYSDATE
);

CREATE TABLE wallet(
wallet_id integer primary key,
currency varchar2(2),
amount number,
created date DEFAULT SYSDATE,
user_id integer constraint fk_user_id references my_user(user_id)
);

insert into my_user values (101, 'John', 'Galt','12-SEP-2000');
insert into wallet values(1,'$', 1000, '12-SEP-2000',101);
insert into wallet values(2,'$', 888, '13-SEP-2000',101);

select name, surname, currency, amount 
from my_user JOIN wallet ON(my_user.user_id = wallet.user_id);

select sum(amount) from my_user JOIN wallet USING(user_id) where user_id = 101;

