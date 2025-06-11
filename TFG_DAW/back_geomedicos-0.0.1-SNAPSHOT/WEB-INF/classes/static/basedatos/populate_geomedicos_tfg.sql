/*
-- Query: SELECT * FROM geomedicos_tfg.usuarios
LIMIT 0, 400

-- Date: 2025-03-30 13:55
*/
use geomedicos_tfg;
-- USUARIOS ADMON SOLO 1
INSERT INTO `usuarios` (`id_usuario`,`nombre`,`APELLIDOS`,`genero`,`correo`,`telefono`,`fecha_nacimiento`,`FECHA_ALTA`,`password`,`ENABLED`,`ROLE`) 
VALUES (1,'Antonio','García Ortiz','H','agarcia@top.com','654321987','1980-03-21','2019-01-15','12345',1,'ADMON');

-- USUARIOS DOCTORES

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `APELLIDOS`, `genero`, `correo`, `telefono`, `fecha_nacimiento`, `FECHA_ALTA`, `password`, `ENABLED`, `ROLE`) 
VALUES 
(2,'Carlos','Ortuño Pérez','H','cortuño@gmail.com','698365365','1975-04-15','2024-12-07','12345',1,'DOCTOR'),
(3, 'Carlos', 'Martínez López', 'H', 'cmartinez@gmail.com', '612345678', '1975-05-14', '2023-08-01', '12345', 1, 'DOCTOR'),
(4, 'Elena', 'Gómez Ruiz', 'M', 'egomez@gmail.com', '623456789', '1982-03-09', '2023-08-02', '12345', 1, 'DOCTOR'),
(5, 'Luis', 'Fernández Soto', 'H', 'lfernandez@gmail.com', '634567890', '1990-12-25', '2023-08-03', '12345', 1, 'DOCTOR'),
(6, 'María', 'Torres Díaz', 'M', 'mtorres@gmail.com', '645678901', '1987-07-30', '2023-08-04', '12345', 1, 'DOCTOR'),
(7, 'Javier', 'Ramírez Cano', 'H', 'jramirez@gmail.com', '656789012', '1978-10-18', '2023-08-05', '12345', 1, 'DOCTOR'),
(8,'Almudena','Sarmiento Parra','M','asarmiento@gmail.com','642642642','1968-11-22','2023-07-07','12345',1,'DOCTOR');

-- USUARIOS PACIENTES

INSERT INTO `usuarios` (`id_usuario`,`nombre`,`APELLIDOS`,`genero`,`correo`,`telefono`,`fecha_nacimiento`,`FECHA_ALTA`,`password`,`ENABLED`,`ROLE`) 
VALUES (9,'Eva','Barrena Pariente','M','ebarrena@gmail.com','611235658','1965-06-25','2024-12-23','12345',1,'PACIENTE');
INSERT INTO `usuarios` (`id_usuario`,`nombre`,`APELLIDOS`,`genero`,`correo`,`telefono`,`fecha_nacimiento`,`FECHA_ALTA`,`password`,`ENABLED`,`ROLE`) 
VALUES (10,'Almudena','Rodriguez Esteban','M','arodriguez@gmail.com','642642642','1968-11-22','2023-07-07','12345',1,'DOCTOR');
INSERT INTO `usuarios` (`id_usuario`,`nombre`,`APELLIDOS`,`genero`,`correo`,`telefono`,`fecha_nacimiento`,`FECHA_ALTA`,`password`,`ENABLED`,`ROLE`) 
VALUES (11,'Andrés','Ortega Santos','H','aortega@gmail.com','684684684','1955-10-14','2024-11-19','12345',1,'PACIENTE');




-- ESPECIALIDADES
INSERT INTO especialidades (id_especialidad, nombre) VALUES
(1, 'Cardiología'),
(2, 'Neurología'),
(3, 'Dermatología'),
(4, 'Ginecología y Obstetricia'),
(5, 'Pediatría'),
(6, 'Alergología'),
(7, 'Anestesiología'),
(8, 'Cirugía General'),
(9, 'Cirugía Plástica'),
(10, 'Endocrinología'),
(11, 'Gastroenterología'),
(12, 'Geriatría'),
(13, 'Hematología'),
(14, 'Infectología'),
(15, 'Medicina Interna'),
(16, 'Nefrología'),
(17, 'Nutriología'),
(18, 'Oftalmología'),
(19, 'Oncología'),
(20, 'Ortopedia y Traumatología'),
(21, 'Otorrinolaringología'),
(23, 'Psiquiatría'),
(24, 'Radiología'),
(25, 'Reumatología'),
(26, 'Urología'),
(27, 'Medicina Familiar'),
(28, 'Medicina del Deporte'),
(29, 'Medicina del Trabajo'),
(30, 'Patología Clínica');


-- MEDICOS

INSERT INTO `medicos` (`COLEGIADO`,`imagEN`,`TARIFA`,`ID_USUARIO`, id_especialidad) VALUES ('11111111A','default.png',35,2,1);
INSERT INTO `medicos` (`COLEGIADO`,`imagen`,`TARIFA`,`ID_USUARIO`, id_especialidad) VALUES ('11111112A','default.png',40,4,3);

INSERT INTO `medicos` (`COLEGIADO`, `imagEN`, `TARIFA`, `ID_USUARIO`, `id_especialidad`) VALUES
('COL1001', 'default.jpg', 60.00, 2, 1),
('COL1002', 'default.jpg', 55.00, 3, 1),
('COL1003', 'default.jpg', 65.00, 4, 1),
('COL1004', 'default.jpg', 50.00, 5, 1),
('COL1005', 'default.jpg', 70.00, 6, 3),
('COL1006', 'default.jpg', 60.00, 7, 3),
('COL1007', 'default.jpg', 75.00, 8, 3);

-- TRATAMIENTOS
INSERT INTO tratamientos (id_tratamiento, id_especialidad, nombre, descripcion) VALUES
(1, 1, 'ECG', 'Electrocardiograma para medir la actividad eléctrica del corazón.'),
(2, 1, 'Cateterismo', 'Procedimiento para examinar y tratar problemas cardíacos.'),
(3, 1, 'Bypass', 'Cirugía para restaurar el flujo sanguíneo al corazón.'),
(4, 1, 'Holter', 'Monitoreo continuo del ritmo cardíaco.'),
(5, 1, 'Eco Doppler', 'Ultrasonido para evaluar el flujo sanguíneo.'),
(6, 2, 'Resonancia', 'Imagenología avanzada para diagnóstico neurológico.'),
(7, 2, 'Electroencefalograma', 'Registra la actividad eléctrica cerebral.'),
(8, 2, 'Punción lumbar', 'Extracción de líquido cefalorraquídeo para análisis.'),
(9, 2, 'Terapia ocupacional', 'Rehabilitación funcional para mejorar habilidades diarias.'),
(10, 2, 'Estimulación cerebral', 'Terapia neurológica con estimulación eléctrica.'),
(11, 3, 'Cremas tópicas', 'Tratamientos dermatológicos aplicados sobre la piel.'),
(12, 3, 'Fototerapia', 'Uso de luz para tratar afecciones cutáneas.'),
(13, 3, 'Biopsia de piel', 'Extracción de tejido para diagnóstico dermatológico.'),
(14, 3, 'Crioterapia', 'Aplicación de frío para eliminar lesiones cutáneas.'),
(15, 3, 'Láser dermatológico', 'Uso de láser para tratar problemas de piel.'),
(16, 4, 'Papanicolau', 'Prueba de detección de cáncer cervical.'),
(17, 4, 'Ecografía transvaginal', 'Ultrasonido ginecológico de alta resolución.'),
(18, 4, 'Colposcopia', 'Inspección detallada del cuello uterino.'),
(19, 4, 'Inserción DIU', 'Colocación de dispositivo intrauterino.'),
(20, 4, 'Revisión ginecológica', 'Chequeo general del aparato reproductor femenino.'),
(21, 5, 'Vacunas', 'Prevención de enfermedades infecciosas mediante inmunización.'),
(22, 5, 'Controles de crecimiento', 'Monitoreo del desarrollo infantil.'),
(23, 5, 'Tratamiento bronquiolitis', 'Terapia respiratoria para lactantes.'),
(24, 5, 'Rehidratación oral', 'Reposición de líquidos y electrolitos.'),
(25, 5, 'Detección temprana', 'Evaluaciones para diagnóstico precoz en niños.');


-- CLINICAS

INSERT INTO clinicas (nombre, direccion, codigo_postal, ciudad) VALUES
('Hospital Pinos', 'Calle Real 71', '28251', 'Madrid'),
('Hospital Monte', 'Calle Libertad 64', '28352', 'Madrid'),
('Centro Médico Monte', 'Calle Libertad 73', '28467', 'Madrid'),

('Clínica Bienestar', 'Calle Paz 103', '08042', 'Barcelona'),
('Hospital Esperanza', 'Calle Real 45', '08400', 'Barcelona'),
('Clínica Integral', 'Calle Real 175', '08163', 'Barcelona'),

('Centro Médico Monte', 'Calle Sol 53', '41470', 'Sevilla'),
('Hospital Esperanza', 'Calle Luna 122', '41621', 'Sevilla'),
('Clínica Armonía', 'Calle Real 111', '41442', 'Sevilla'),

('Centro Médico Pinos', 'Calle Real 37', '46108', 'Valencia'),
('Clínica Luz', 'Calle Sol 140', '46910', 'Valencia'),
('Hospital Salud', 'Calle Paz 3', '46762', 'Valencia'),

('Centro Médico Esperanza', 'Calle Paz 139', '50859', 'Zaragoza'),
('Hospital Luz', 'Calle Paz 178', '50688', 'Zaragoza'),
('Clínica Salud', 'Calle Paz 121', '50283', 'Zaragoza'),

('Clínica Vida', 'Calle Sol 104', '03482', 'Alicante'),
('Centro Médico Monte', 'Calle Sol 137', '03976', 'Alicante'),
('Hospital Monte', 'Calle Luna 39', '03255', 'Alicante'),

('Centro Médico Pinos', 'Calle Real 25', '15298', 'A Coruña'),
('Hospital Bienestar', 'Calle Real 186', '15567', 'A Coruña'),
('Clínica Horizonte', 'Calle Paz 91', '15345', 'A Coruña'),

('Hospital Integral', 'Calle Real 139', '39029', 'Santander'),
('Centro Médico Armonía', 'Calle Libertad 168', '39609', 'Santander'),
('Clínica Luz', 'Calle Real 39', '39371', 'Santander'),

('Clínica Pinos', 'Calle Real 142', '29574', 'Málaga'),
('Hospital Horizonte', 'Calle Libertad 5', '29666', 'Málaga'),
('Centro Médico Vida', 'Calle Real 15', '29540', 'Málaga'),

('Centro Médico Vida', 'Calle Libertad 163', '35118', 'Las Palmas'),
('Clínica Salud', 'Calle Sol 177', '35291', 'Las Palmas'),
('Hospital Esperanza', 'Calle Sol 28', '35751', 'Las Palmas');

-- CLINICAS_ESPECIALIDADES

INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (1,1);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,1);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (1,2);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (1,3);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,3);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (3,3);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (1,4);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (1,5);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,5);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (4,5);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (3,6);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,7);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,9);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (3,9);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (4,10);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (2,11);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (3,12);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (4,15);
INSERT INTO `clinica_especialidad` (`id_clinica`,`id_especialidad`) VALUES (4,20);

-- MEDICOS_TRATAMIENTOS
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1001',1);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1001',2);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1001',3);

INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1002',1);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1002',2);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1002',4);

INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1003',1);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1003',2);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1003',5);


INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1004',1);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1004',2);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1004',4);

INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1005',11);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1005',12);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1005',13);

INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1006',11);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1006',12);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1006',14);

INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1007',11);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1007',12);
INSERT INTO `medico_tratamientos` (`colegiado`,`id_tratamiento`) VALUES ('COL1007',15);


-- HORARIOS_MEDICOS
INSERT INTO `geomedicos_tfg`.`horarios_medicos` (`COLEGIADO`, `fecha_cita`, `hora_inicio`, `estado`, `id_clinica`) VALUES
('COL1001', '2025-07-01', '09:00:00', 'CONFIRMADA', 1),
('COL1001', '2025-07-01', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-01', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-01', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-02', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-02', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-02', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-02', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-03', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-03', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-03', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-03', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-04', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-04', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-04', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-04', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-08', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-08', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-08', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-08', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-09', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-09', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-09', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-09', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-10', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-10', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-10', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-10', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-11', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-11', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-11', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-11', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-15', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-15', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-15', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-15', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-16', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-16', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-16', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-16', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-17', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-17', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-17', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-17', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-18', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-18', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-18', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-18', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-22', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-22', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-22', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-22', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-23', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-23', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-23', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-23', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-24', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-24', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-24', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-24', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-25', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-25', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-25', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-25', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-29', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-29', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-29', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-29', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-30', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-30', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-30', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-30', '12:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-31', '09:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-31', '10:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-31', '11:00:00', 'PENDIENTE', 1),
('COL1001', '2025-07-31', '12:00:00', 'PENDIENTE', 1);

INSERT INTO `geomedicos_tfg`.`horarios_medicos` (`COLEGIADO`, `fecha_cita`, `hora_inicio`, `estado`, `id_clinica`) VALUES
('COL1002', '2025-07-01', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-01', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-01', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-01', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-02', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-02', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-02', '11:00:00', 'CONFIRMADA', 1),
('COL1002', '2025-07-02', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-03', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-03', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-03', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-03', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-04', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-04', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-04', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-04', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-08', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-08', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-08', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-08', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-09', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-09', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-09', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-09', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-10', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-10', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-10', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-10', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-11', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-11', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-11', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-11', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-15', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-15', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-15', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-15', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-16', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-16', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-16', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-16', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-17', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-17', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-17', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-17', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-18', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-18', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-18', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-18', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-22', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-22', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-22', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-22', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-23', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-23', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-23', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-23', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-24', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-24', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-24', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-24', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-25', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-25', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-25', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-25', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-29', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-29', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-29', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-29', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-30', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-30', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-30', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-30', '12:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-31', '09:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-31', '10:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-31', '11:00:00', 'PENDIENTE', 1),
('COL1002', '2025-07-31', '12:00:00', 'PENDIENTE', 1);

INSERT INTO `geomedicos_tfg`.`horarios_medicos` (`COLEGIADO`, `fecha_cita`, `hora_inicio`, `estado`, `id_clinica`) VALUES
('COL1003', '2025-07-01', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-01', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-01', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-01', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-02', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-02', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-02', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-02', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-03', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-03', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-03', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-03', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-04', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-04', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-04', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-04', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-08', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-08', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-08', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-08', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-09', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-09', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-09', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-09', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-10', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-10', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-10', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-10', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-11', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-11', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-11', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-11', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-15', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-15', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-15', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-15', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-16', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-16', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-16', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-16', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-17', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-17', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-17', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-17', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-18', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-18', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-18', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-18', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-22', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-22', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-22', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-22', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-23', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-23', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-23', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-23', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-24', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-24', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-24', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-24', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-25', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-25', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-25', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-25', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-29', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-29', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-29', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-29', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-30', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-30', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-30', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-30', '12:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-31', '09:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-31', '10:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-31', '11:00:00', 'PENDIENTE', 1),
('COL1003', '2025-07-31', '12:00:00', 'PENDIENTE', 1);

-- CITAS
INSERT INTO `geomedicos_tfg`.`citas` (`id_cita`, `id_paciente`, `id_horario`, `fecha`) VALUES (1, '9', '1', '2025-05-15');
INSERT INTO `geomedicos_tfg`.`citas` (`id_cita`, `id_paciente`, `id_horario`, `fecha`) VALUES (2, '9', '83', '2025-04-05');


-- enfermedades
INSERT INTO enfermedades (nombre, id_tratamiento) VALUES
('Arritmia', 1),
('Infarto agudo de miocardio', 1),
('Bloqueo cardíaco', 1),
('Enfermedad coronaria', 2),
('Cardiopatía isquémica', 2),
('Aneurisma', 2),
('Arteriosclerosis', 3),
('Angina de pecho', 3),
('Infarto', 3),
('Bradicardia', 4),
('Taquicardia', 4),
('Fibrilación auricular', 4),
('Insuficiencia venosa', 5),
('Trombosis', 5),
('Varices', 5),
('Esclerosis múltiple', 6),
('Tumor cerebral', 6),
('Traumatismo craneal', 6),
('Epilepsia', 7),
('Convulsiones', 7),
('Encefalitis', 7),
('Meningitis', 8),
('Hemorragia subaracnoidea', 8),
('Esclerosis múltiple', 8),
('Parálisis cerebral', 9),
('Autismo', 9),
('Accidente cerebrovascular', 9),
('Parkinson', 10),
('Depresión resistente', 10),
('Trastorno obsesivo-compulsivo', 10),
('Dermatitis', 11),
('Psoriasis', 11),
('Eczema', 11),
('Ictericia neonatal', 12),
('Psoriasis', 12),
('Vitiligo', 12),
('Cáncer de piel', 13),
('Lupus', 13),
('Melanoma', 13),
('Verrugas', 14),
('Queratosis actínica', 14),
('Cáncer de piel', 14),
('Rosácea', 15),
('Manchas solares', 15),
('Acné severo', 15),
('Virus del papiloma humano', 16),
('Cáncer de cuello uterino', 16),
('Displasia cervical', 16),
('Endometriosis', 17),
('Miomas', 17),
('Quistes ováricos', 17),
('Lesión intraepitelial', 18),
('Cervicitis', 18),
('VPH', 18),
('Endometriosis', 19),
('Menorragia', 19),
('Dismenorrea', 19),
('Candidiasis', 20),
('Vaginosis bacteriana', 20),
('Tricomoniasis', 20),
('Sarampión', 21),
('Poliomielitis', 21),
('Hepatitis B', 21),
('Retraso del crecimiento', 22),
('Hipotiroidismo', 22),
('Desnutrición', 22),
('Bronquiolitis', 23),
('Asma infantil', 23),
('Neumonía', 23),
('Gastroenteritis', 24),
('Deshidratación', 24),
('Diarrea aguda', 24),
('Autismo', 25),
('Hipoacusia', 25),
('Trastornos visuales', 25);
