drop TABLE contable.usuario cascade ;

create table contable.usuario(
  username varchar(16) primary key,
  password varchar(16) not null,
  nombre varchar(32) not null,
  apellido varchar(32) not null,
  area varchar(32) ,
  cargo varchar(32),
  anexo int,
  estado varchar(16) not null,  
  email varchar(64) not null
);

drop table contable.rol cascade ;

create table contable.rol(
  rolename varchar(16) primary key,
  descripcion varchar(140) ,
  groupo_actual varchar(16) default 'Roles'
);

drop table contable.usuario_rol cascade ;

create table contable.usuario_rol(
  username varchar(16) not null  references contable.usuario(username),
  rolename varchar(16) not null  references contable.rol(rolename),
  primary key(username, rolename)
);