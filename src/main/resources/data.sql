--

INSERT INTO roles (id, nombre) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, nombre) VALUES (2, 'ROLE_USER');

--

INSERT INTO usuarios (id, correo,nombre, apellido, contrasena)
    VALUES (1, 'roberto.quirpa@gmail.com', 'roberto', 'quirpa', '$2a$10$Xr2RNOF4XAH3Z.83egEicOwodxlWUEdBR4FTz9arwhsdgnyG/Sbju');

--

INSERT INTO usuarios_roles (rol_id, usuario_id) values (1, 1);

--

-- DATOS PARA PRUEBAS DEL FRONT. ELIMINAR DE AQUI PARA ABAJO
INSERT INTO FUNCIONES (id, nombre, fecha_inicio, fecha_fin, capacidad_total, capacidad_disponible, costo)
    VALUES (1, 'AA', '2020-10-13 14:00:00', '2020-10-13 16:00:00', 60, 30, 10000);
INSERT INTO FUNCIONES (id, nombre, fecha_inicio, fecha_fin, capacidad_total, capacidad_disponible, costo)
    VALUES (2, 'BB', '2020-10-13 18:00:00', '2020-10-13 20:00:00', 60, 30, 20000);

INSERT INTO FUNCIONES (id, nombre, fecha_inicio, fecha_fin, capacidad_total, capacidad_disponible, costo)
    VALUES (3, 'CC', '2020-10-14 14:00:00', '2020-10-14 16:00:00', 60, 30, 10000);
INSERT INTO FUNCIONES (id, nombre, fecha_inicio, fecha_fin, capacidad_total, capacidad_disponible, costo)
    VALUES (4, 'DD', '2020-10-14 18:00:00', '2020-10-14 20:00:00', 60, 30, 20000);

--

INSERT INTO usuarios (id, correo, nombre, apellido, contrasena)
    VALUES (2, 'maria.dolores@gmail.com', 'Maria', 'Dolores', '$2a$10$Xr2RNOF4XAH3Z.83egEicOwodxlWUEdBR4FTz9arwhsdgnyG/Sbju');
INSERT INTO usuarios (id, correo, nombre, apellido, contrasena)
    VALUES (3, 'pedro.perez@gmail.com', 'Pedro', 'Perez', '$2a$10$Xr2RNOF4XAH3Z.83egEicOwodxlWUEdBR4FTz9arwhsdgnyG/Sbju');

INSERT INTO usuarios_roles (rol_id, usuario_id) values (2, 2);
INSERT INTO usuarios_roles (rol_id, usuario_id) values (2, 3);

INSERT INTO vehiculos (id, placa, id_usuario, ecologico) values (1, 'ABC-123', 2, true);
INSERT INTO vehiculos (id, placa, id_usuario, ecologico) values (2, 'ABC-124', 2, false);
INSERT INTO vehiculos (id, placa, id_usuario, ecologico) values (3, 'BCD-123', 3, false);