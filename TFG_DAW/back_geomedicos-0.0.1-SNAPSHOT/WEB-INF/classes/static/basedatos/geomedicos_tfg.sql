create database geomedicos_tfg;
use geomedicos_tfg;
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    APELLIDOS VARCHAR(200) NOT NULL,
    genero enum('H','M'),
    CORREO VARCHAR(100) UNIQUE NOT NULL,
    telefono varchar(15),
    fecha_nacimiento date,
    FECHA_ALTA DATE,
    password VARCHAR(255) NOT NULL,
    ENABLED INT NOT NULL DEFAULT 1,
    ROLE ENUM('PACIENTE', 'DOCTOR', 'ADMON') NOT NULL
);
CREATE TABLE especialidades (
    id_especialidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE medicos (
    COLEGIADO VARCHAR(15) PRIMARY KEY,
    imagen VARCHAR(45),
    TARIFA DOUBLE,
    ID_USUARIO INT NOT NULL,
    id_especialidad int,
    FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO),
    FOREIGN KEY(ID_especialidad) REFERENCES especialidades(ID_especialidad)
);





CREATE TABLE tratamientos (
    id_tratamiento INT PRIMARY KEY AUTO_INCREMENT,
    id_especialidad INT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_especialidad) REFERENCES especialidades(id_especialidad) ON DELETE CASCADE
);
create table medico_tratamientos
( colegiado varchar(15) not null,
id_tratamiento int not null,
	
primary key(colegiado, id_tratamiento),
foreign key(colegiado) references medicos(colegiado),
foreign key(id_tratamiento) references tratamientos(id_tratamiento)
);

CREATE TABLE clinicas (
    id_clinica INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL, 
    codigo_postal char(5) not null,
    ciudad varchar(45) not null
);

CREATE TABLE clinica_especialidad (
    id_clinica INT,
    id_especialidad INT,
    PRIMARY KEY (id_clinica, id_especialidad),
    FOREIGN KEY (id_clinica) REFERENCES clinicas(id_clinica) ON DELETE CASCADE,
    FOREIGN KEY (id_especialidad) REFERENCES especialidades(id_especialidad) ON DELETE CASCADE
);

CREATE TABLE horarios_medicos (
    id_horario INT PRIMARY KEY AUTO_INCREMENT,
     COLEGIADO VARCHAR(15) NOT NULL,
    fecha_cita date not null,
    hora_inicio TIME NOT NULL,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL DEFAULT 'PENDIENTE',
    id_clinica INT NULL,
    FOREIGN KEY (COLEGIADO) REFERENCES medicos(COLEGIADO),
    FOREIGN KEY (id_clinica) REFERENCES clinicas(id_clinica)
);

CREATE TABLE citas (
    id_cita INT PRIMARY KEY AUTO_INCREMENT,
    id_paciente INT,
    id_horario INT,
    fecha DATE NOT NULL,
    FOREIGN KEY (id_paciente) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_horario) REFERENCES horarios_medicos(id_horario)
    
);

create table enfermedades
( id_enfermedad int auto_increment primary key,
nombre varchar(100),
id_tratamiento int,
foreign key(id_tratamiento) references tratamientos(id_tratamiento)
);