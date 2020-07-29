create schema student_cms_plusplus default character set= utf8mb4;

create table student (
id int primary key auto_increment,
name varchar(50)  not null,
mssv int not null,
password int not null,
phone int not null,student_class
address varchar(100),
age int not null,
email varchar(50),
created_timestamp timestamp(6) not null default current_timestamp(6),
last_update_timestamp timestamp(6) not null default current_timestamp(6)
);

create table class (
id int primary key not null auto_increment,
name varchar(100) not null,
major varchar(100) not null,
total_student int not null,
teacher_name varchar(100) not null,
teacher_phone int not null,
created_timestamp timestamp(6) not null default current_timestamp(6),
last_update_timestamp timestamp(6) not null default current_timestamp(6)
);

create table student_class(
student_id int not null,
teacher_id int not null
);

insert into student(name,mssv,password,phone,address,age,email)
values('Phan Nho Hoang','18020562','phanhoang1602','0967000696','Thuận Thành','20','tongtulenhbn');

insert into class(name,major,total_student,teacher_name,teacher_phone)
values('K63K2','Kĩ thuật máy tính','70','Nguyễn Hồng Vân','0955555555');

insert into student_class(student_id,teacher_id)
values('1','3');