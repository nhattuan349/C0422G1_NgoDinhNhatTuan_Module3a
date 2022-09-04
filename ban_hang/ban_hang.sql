drop database if exists ban_hang;
create database ban_hang;
use ban_hang;

create table khuyen_mai(
ma_khuyen_mai int auto_increment primary key,
ten_khuyen_mai varchar(45) 
);

create table khach_hang(
ma_khach_hang int auto_increment primary key,
ten_khach_hang varchar(45), 
so_dien_thoai int, 
thoi_gian_giao_dich date,
ma_khuyen_mai int, 
FOREIGN KEY (ma_khuyen_mai) REFERENCES khuyen_mai(ma_khuyen_mai)on delete set null,
status_delete int
);

insert into khuyen_mai(ma_khuyen_mai,ten_khuyen_mai)
values ('1','500'),
('2','300'),
('3','50');

insert into khach_hang(ma_khach_hang,ten_khach_hang,so_dien_thoai,thoi_gian_giao_dich,ma_khuyen_mai,status_delete)
values  ('1','Phong','09789456','2016-12-12','1','1'),
('2','Khánh','09789456','2016-12-12','1','1'),
('3','Hưng','09789456','2016-12-12','1','1');
