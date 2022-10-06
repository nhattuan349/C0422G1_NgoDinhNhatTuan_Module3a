drop database if exists thi_module;
create database thi_module;
use thi_module;


create table thanh_vien(
ma_thanh_vien int primary key,
ten_thanh_vien varchar(45) 
);

create table ho_khau(
stt_ho_khau int auto_increment primary key,
ma_thanh_vien int,
FOREIGN KEY (ma_thanh_vien) REFERENCES thanh_vien(ma_thanh_vien)on delete set null,
ten_chu_ho varchar(45), 
so_luong_thanh_vien int,
ngay_lap_ho_khau  date,
dia_chi_nha varchar(45)
);


insert into thanh_vien(ma_thanh_vien,ten_thanh_vien)
values ('001','HK-001'),
('112','HK-112'),
('223','HK-223'),
('444','HK-444'),
('005','HK-005'),
('006','HK-006');


insert into ho_khau(stt_ho_khau,ma_thanh_vien,ten_chu_ho,so_luong_thanh_vien,ngay_lap_ho_khau,dia_chi_nha)
values  (1,'001','Nguyễn Văn A','3','2016-08-07','K12/123 Nguyễn Tất Thành'),
(2,'112','Nguyễn Văn B','2','2019-08-10','8 Hùng Vương'),
(3,'223','Nguyễn Văn D','5','2020-01-11','10 Lê Duẫn'),
(4,'444','Nguyễn Văn E','1','2017-08-07','K333/2 Ông Ích Khiêm'),
(5,'005','Nguyễn Văn F','1','2020-01-11','K335/2 Ông Ích Khiêm'),
(6,'006','Nguyễn Văn G','5','2017-08-07','K337/2 Ông Ích Khiêm');


