drop database phong_tro;
create database phong_tro;
use phong_tro;

CREATE TABLE thanh_toan (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_name VARCHAR(50)
);

CREATE TABLE phong_tro (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    phone_number INT,
    first_date DATE,
    note VARCHAR(255),
    payment_id INT,
    FOREIGN KEY (payment_id)
        REFERENCES thanh_toan (payment_id)
);



insert into thanh_toan(payment_name) values ("Theo tháng"), ("Theo quý"), ("Theo năm");

insert into phong_tro(name,phone_number,first_date, payment_id, note)
values("Minh Phuc",0762760619,"1999-01-01",1,"Nothing"),
("Minh Phuc AA",0762760619,"1999-01-01",1,"Nothing");

