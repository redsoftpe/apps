drop table contable.departamento cascade;
drop sequence contable.sqdepartamento;
create sequence contable.sqdepartamento;

create table contable.departamento(
   id int primary key,
   nombre varchar(64) not null,
   pais varchar(64)
);

drop table contable.provincia cascade;
drop sequence contable.sqprovincia;
create sequence contable.sqprovincia;

create table contable.provincia(
   id int primary key,
   nombre varchar(64) not null,
   iddepartamento int references departamento(id)
);

drop table contable.distrito cascade;
drop sequence contable.sqdistrito;
create sequence contable.sqdistrito;

create table distrito(
   id int primary key,
   nombre varchar(64) not null,
   idprovincia int references provincia(id)
);

drop table contable personaJuridica cascade;

create table contable.personaJuridica(
   ruc bigint primary  key,
   razon_social varchar(128) not null,
   direccion varchar(128) not null,
   telefono varchar(32),
   email varchar(64),
   iddistrito int references distrito(id) 
);



