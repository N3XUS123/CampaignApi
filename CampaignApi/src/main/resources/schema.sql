drop table APORTACION if exists
drop table AUTHORITIES if exists
drop table CAMPANYA if exists
drop table DATOS_MAESTROS if exists
drop table USUARIO if exists
drop table USUARIO_campanyas if exists
create table APORTACION (id bigint generated by default as identity, CANTIDAD double not null, DATO varchar(255) not null, FECHA timestamp not null, CAMPANYA bigint not null, DATO_MAESTRO bigint not null, USUARIO bigint not null, primary key (id))
create table AUTHORITIES (id bigint generated by default as identity, AUTHORITY varchar(255), USER_ID bigint, primary key (id))
create table CAMPANYA (id bigint generated by default as identity, CODIGO varchar(255) not null, NOMBRE_CAMPANYA varchar(255) not null, primary key (id))
create table DATOS_MAESTROS (id bigint generated by default as identity, TIPO varchar(255) not null, campanya_id bigint, primary key (id))
create table USUARIO (id bigint generated by default as identity, CONTRASENYA varchar(255) not null, EMAIL varchar(255) not null, ENABLED boolean not null, GRUPO varchar(255) not null, NOMBRE_USUARIO varchar(255) not null, primary key (id))
create table USUARIO_campanyas (usuario_id bigint not null, campanyas_id bigint not null)
alter table CAMPANYA add constraint UK_45ub8wurv5kwj0yecso3a2o4x unique (CODIGO)
alter table APORTACION add constraint FKm04bgwp7urkdwq9lpuydptdcb foreign key (CAMPANYA) references CAMPANYA
alter table APORTACION add constraint FKj2btxrkt3rrjym4wgjwnl53x9 foreign key (DATO_MAESTRO) references DATOS_MAESTROS
alter table APORTACION add constraint FK4glepsg8bsay4iewrv7p3o1eb foreign key (USUARIO) references USUARIO
alter table AUTHORITIES add constraint FK9qa0aornwpgw2s5dbtj33ihw0 foreign key (USER_ID) references USUARIO
alter table DATOS_MAESTROS add constraint FK3f47mpo2w9c6qjlr9nrmsoos3 foreign key (campanya_id) references CAMPANYA
alter table USUARIO_campanyas add constraint FK1bkgfrr2fux2dgxej3e1w64rc foreign key (campanyas_id) references CAMPANYA
alter table USUARIO_campanyas add constraint FKh240tsubyf9s58ymmvkgn5iv8 foreign key (usuario_id) references USUARIO