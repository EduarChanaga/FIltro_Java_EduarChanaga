
use ninja;

create table Ninja(
id int primary key auto_increment,
nombre varchar(50),
descripcion varchar(200),
rango enum("genin", "chunin", "tokubetsu","jonin"),
aldea varchar(20)
);

create table Mision(
id int primary key auto_increment,
nombre varchar(50),
descripcion varchar(300),
rango enum("genin", "chunin", "tokubetsu","jonin"),
recompensa decimal(10,2)
);

create table Habilidad(
id int primary key auto_increment,
id_ninja int,
foreign key (id_ninja) references Ninja(id),
nombre varchar(50),
descripcion varchar(60)
);

create table Mision_Ninja(
id_ninja int,
id_mision int,
primary key (id_ninja,id_mision),
fecha_inicio date,
fecha_fin date
);





