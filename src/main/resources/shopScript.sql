drop schema shop;
create schema shop;

use shop;

create table groups (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    parent_id int
);

insert into groups values (1, 'root_group', null);

insert into groups values (2, 'Phones', 1);
insert into groups values (3, 'Notebooks', 1);
insert into groups values (4, 'Accessories', 1);

insert into groups values (5, 'Samsung', 2);
insert into groups values (6, 'Google', 2);
insert into groups values (7, 'Iphone', 2);

insert into groups values (8, 'Asus', 3);
insert into groups values (9, 'Acer', 3);
insert into groups values (10, 'Samsung', 3);

insert into groups values (11, 'Videocards', 4);
insert into groups values (12, 'Batteries', 4);
insert into groups values (13, 'Keyboards', 4);

create table goods (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(40),
    description text,
    price int,
    group_id int
);

insert into goods values (1, 'Galaxy S7', 'Good phone!', 20000, 5);
insert into goods values (2, 'Galaxy S3', 'Best phone!', 4000, 5);
insert into goods values (3, 'Nexus 6p', 'Clean android - the best!', 18000, 6);
insert into goods values (4, 'Nexus 5x', 'Good price!!', 15000, 6);
insert into goods values (5, 'Iphone 5', 'Old, classic, small(very small)',20000, 7);
insert into goods values (6, 'Iphone 7', 'Big price - YES!',99999, 7);

insert into goods values (7, 'Asus K53SV', 'Medium lvl, good',5000, 8);
insert into goods values (8, 'Asus G53', 'Games, games games!',10000, 8);
insert into goods values (9, 'Aser chine shit sv32', 'Good price! That all ))',4500, 9);
insert into goods values (10, 'Aser TM76', 'High lvl - big price, but this aser )',6000, 9);
insert into goods values (11, 'Samsung V75', 'lvl',7000, 10);
insert into goods values (12, 'Samsung G55', 'Gamers lvl, go go go',10000, 10);

insert into goods values (13, 'Nvidia gt9300', '512mb video rem',1000, 11);
insert into goods values (14, 'Radeon Pice of shit 38', 'Very hot, good price',500, 11);
insert into goods values (15, 'Asus k53', '3500w',1500, 12);
insert into goods values (16, 'Aser t32', '4000w',1000, 12);
insert into goods values (17, 'Samsung G55', 'keyboard  - that all.',10000, 13);
insert into goods values (18, 'Samsung G58', 'keyboard - that all.',10000, 13);