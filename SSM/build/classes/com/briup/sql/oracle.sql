create table t_user(
	id number primary key,
	name varchar2(50) not null,
	age number,
	dob date
);

create sequence my_seq;