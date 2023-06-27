drop table if exists board;

create table board (
bno bigint not null auto_increment,
title varchar(200) not null,
content text not null,
writer varchar(100) not null,
reg_at datetime default now(),
mod_at datetime default now(),
read_count int(10) default 0,
primary key (bno)
);

drop table if exists b_comment;

create table b_comment (
cno bigint auto_increment,
bno bigint not null,
writer varchar(100) not null,
content text not null,
reg_at datetime default now(),
mod_at datetime default now(),
primary key (cno)
);

drop table if exists b_file;

create table b_file (
uuid varchar(256) primary key,
save_dir varchar(256) not null,
file_name varchar(512) not null,
file_type tinyint(1) default 0,
bno bigint(11),
file_size bigint,
reg_at datetime default now()
);

update board set cmt_qty = (
select count(cno) from b_comment
where b_comment.bno = board.bno
);

drop table member cascade;

CREATE TABLE `member` (
  `email` varchar(100) NOT NULL,
  `pwd` varchar(1000) NOT NULL,
  `nick_name` varchar(100) NOT NULL,
  `reg_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_login` datetime DEFAULT NULL,
  `grade` tinyint DEFAULT '10',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table auth_member cascade;

CREATE TABLE `auth_member` (
  `email` varchar(100) NOT NULL,
  `auth` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table auth_member add constraint fk_auth 
foreign key (email) references member(email);

create table product(
pno bigint not null auto_increment,
category varchar(200),
pname varchar(200),
price int,
writer varchar(100),
description varchar(200),
made_by varchar(200),
reg_at datetime default now(),
mod_at datetime default now(),
read_count int default 0,
cmt_qty int default 0,
primary key(pno));

create table comment (
cno bigint auto_increment,
pno bigint not null,
writer varchar(100) not null,
content text not null,
reg_at datetime default now(),
mod_at datetime default now(),
primary key (cno));