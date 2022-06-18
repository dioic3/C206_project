drop database if exists DBConnection;
create database if not exists DBConnection;

use DBConnection;
create table jogador(
id int auto_increment primary key,
nick varchar(20) not null
);

create table Ranking(

tempo long not null,
id int auto_increment primary key,
idjogador int not null,
    constraint fk1
        foreign key(idjogador)
        references jogador(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

select *from jogador;
select *from Ranking;