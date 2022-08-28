drop database if exists student;
CREATE DATABASE student;
USE student;


create table lop_hoc (
 ma_lop_hoc int auto_increment primary key,
ten_lop_hoc varchar(45)
);

create table hoc_sinh (
 id_hoc_sinh int auto_increment primary key,
 ten_hoc_sinh varchar(45),
 tuoi_hoc_sinh int,
 dia_chi varchar(45),
 ma_lop_hoc int,
 FOREIGN KEY (ma_lop_hoc) REFERENCES lop_hoc(ma_lop_hoc),
 status_delete int
);


insert into lop_hoc(ma_lop_hoc, ten_lop_hoc) 
values ('1','C0122G1'),
('2','C0222G1'),
('3','C0322G1'),
('4','C0422G1'),
('5','C0522G1'),
('6','C0622G1');

insert into hoc_sinh(id_hoc_sinh, ten_hoc_sinh, tuoi_hoc_sinh,dia_chi,ma_lop_hoc,status_delete) 
values('1','Tuấn','27','Đại Lộc','5','1'),
('2','Khánh','35','Điện Bàn','4','1'),
('3','Hưng','35','Đại Lộc','2','1'),
('4','Vinh','52','Đà Nẵng','4','0'),
('5','Phong','33','Đại Lộc','3','0'),
('6','Mỹ','32','Hội An','1','1')

















