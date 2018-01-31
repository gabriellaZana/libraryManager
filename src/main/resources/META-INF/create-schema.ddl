create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
create sequence hibernate_sequence start 1 increment 1
create table books (id int4 not null, author varchar(255) not null, currentDate timestamp, daysForRent int4 not null, description varchar(255) not null, dueDate timestamp, genre varchar(255) not null, isAvailable boolean not null, isbn varchar(255) not null, location int4 not null, picture varchar(255), publisher varchar(255) not null, title varchar(255) not null, year int4 not null, rentedByMember_id int8, reservedByMember_id int8, primary key (id))
create table Fine (id  bigserial not null, amount float8 not null, dueDate timestamp, occurrence timestamp, status boolean not null, member_id int8, primary key (id))
create table Users (USER_TYPE varchar(31) not null, id  bigserial not null, address varchar(255) not null, dateOfBirth date not null, email varchar(255) not null, firstName varchar(255) not null, lastName varchar(255) not null, password varchar(255) not null, phoneNumber varchar(255), userName varchar(255) not null, primary key (id))
alter table Users add constraint UK_ncoa9bfasrql0x4nhmh1plxxy unique (email)
alter table books add constraint FK4s1gv38pjhyj7rp1luqj3wr8f foreign key (rentedByMember_id) references Users
alter table books add constraint FKe69c0yj9ppu6fncjlpdwirgyk foreign key (reservedByMember_id) references Users
alter table Fine add constraint FKqtjnl9wdo2s7nerbpbonyefue foreign key (member_id) references Users
