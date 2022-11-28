create database agenda;

use agenda;

create table contatos(
 
id int not null auto_increment primary key,
nome varchar(40),
idade int,
dataCadastro date);