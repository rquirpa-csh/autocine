--

INSERT INTO tipo_documento (id, nombre) VALUES (1, 'Cedula cuidadania');
INSERT INTO tipo_documento (id, nombre) VALUES (2, 'Cedula extranjeria');
INSERT INTO tipo_documento (id, nombre) VALUES (3, 'Pasaporte');

--

INSERT INTO roles (id, nombre) VALUES (1, 'Administrador');
INSERT INTO roles (id, nombre) VALUES (2, 'Usuario');

--

INSERT INTO usuarios (id, nombre, apellido, id_tipo_documento, numero_documento, contrasena)
    VALUES (1, 'Roberto', 'Quirpa', 1, 1234, '1234');
INSERT INTO usuarios (id, nombre, apellido, id_tipo_documento, numero_documento, contrasena)
    VALUES (2, 'Maria', 'Dolores', 2, 2345, '2345');
INSERT INTO usuarios (id, nombre, apellido, id_tipo_documento, numero_documento, contrasena)
    VALUES (3, 'Pedro', 'Perez', 2, 3456, '3456');

--

INSERT INTO usuarios_roles (rol_id, usuario_id) values (1, 1);
INSERT INTO usuarios_roles (rol_id, usuario_id) values (2, 2);
INSERT INTO usuarios_roles (rol_id, usuario_id) values (2, 3);

--

INSERT INTO vehiculos (id, placa, id_usuario) values (1, 'ABC-123', 2);
INSERT INTO vehiculos (id, placa, id_usuario) values (2, 'BCD-123', 2);
INSERT INTO vehiculos (id, placa, id_usuario) values (3, 'CDE-123', 3);
