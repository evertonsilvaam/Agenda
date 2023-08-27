create database dbagenda;

show databases;

use dbagenda;

create table contatos(
	idcontato int primary key auto_increment,
    idusuario int not null,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50),
    foreign key(idusuario) references usuarios(idusuario)
);

create table usuarios(
	idusuario int primary key auto_increment,
    usuario varchar(20) not null,
    senha varchar(30) not null
);

/*CRUD Create*/
insert into usuarios(usuario, senha) values('kali', '12345aA@');

insert into contatos(nome, fone, email, idusuario)
values('Bill Gates', '99999-1111', 'bill@mail.com', 1);

/*CRUD Read*/
select * from contatos;
select * from usuarios;

select * from contatos 
where idusuario = 1 
order by nome desc;

select * from usuarios 
where usuario = 'kali';

select * from contatos where idusuario = 1 order by nome desc;