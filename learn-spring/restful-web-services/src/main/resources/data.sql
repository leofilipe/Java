insert into user_details(id, birth_date, name) values (10001, current_date(), 'Leo');

insert into user_details(id, birth_date, name) values (10002, current_date(), 'Cris');

insert into user_details(id, birth_date, name) values (10003, current_date(), 'Cassio');

insert into post (id, user_id, description) values (20001, 10001, 'Testing post 1');
insert into post (id, user_id, description) values (20002, 10001, 'Testing post 2');
insert into post (id, user_id, description) values (20003, 10002, 'Testing post 3');
insert into post (id, user_id, description) values (20004, 10003, 'Testing post 4');