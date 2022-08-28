drop database if exists exam;
CREATE DATABASE exam;
USE exam;

create table loai_bai_hoc (
 ma_loai_bai_hoc  int auto_increment primary key,
ten_loai_bai_hoc varchar(45)
);

create table do_kho (
 ma_do_kho  int auto_increment primary key,
ten_do_kho varchar(45)
);

create table module (
 ma_module int auto_increment primary key,
ten_module varchar(45)
);

create table bai_hoc (
 id_bai_hoc  int auto_increment primary key,
 tieu_de varchar(45),
 ma_loai_bai_hoc int,
 FOREIGN KEY (ma_loai_bai_hoc) REFERENCES loai_bai_hoc(ma_loai_bai_hoc),
 ma_do_kho int,
 FOREIGN KEY (ma_do_kho) REFERENCES do_kho(ma_do_kho),
 ma_module int,
 FOREIGN KEY (ma_module) REFERENCES module(ma_module),
 status_delete int,
 link_bai_hoc varchar(45)
);


insert into loai_bai_hoc(ma_loai_bai_hoc, ten_loai_bai_hoc) 
values('1','Bài Giảng'),
('2','Bài Đọc'),
('3','Thực Hành'),
('4','Quiz'),
('5','Bài Tập');

insert into do_kho(ma_do_kho, ten_do_kho) 
values('1','Level 1'),
('2','Level 2'),
('3','Level 3'),
('4','Level 4'),
('5','Level 5'),
('6','Level 6');

insert into module(ma_module, ten_module) 
values('1','Bootcamp Preparation 2.0'),
('2','Advanced Programming with Java 2.0'),
('3','Java Web Back-end Development 2.0');


insert into bai_hoc(id_bai_hoc, tieu_de, ma_loai_bai_hoc,ma_do_kho,ma_module,status_delete,link_bai_hoc) 
values('1','Câu điều kiện','1','1','1','1','http://levunguyen.com/caudieukien'),
('2','Vòng lặp','1','2','1','1','http://levunguyen.com/vonglap'),
('3','Spring Over','1','1','3','0','http://levunguyen.com/spring'),
('4','SOLID','1','1','2','0','http://levunguyen.com/solid'),
('5','Câu điều kiện','1','1','1','0','http://levunguyen.com/caudieukien'),
('6','Câu điều kiện','1','1','1','0','http://levunguyen.com/caudieukien');
