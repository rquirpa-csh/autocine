--

INSERT INTO tipo_documento (id, nombre) VALUES (1, 'Cedula cuidadania');
INSERT INTO tipo_documento (id, nombre) VALUES (2, 'Cedula extranjeria');
INSERT INTO tipo_documento (id, nombre) VALUES (3, 'Pasaporte');

--

INSERT INTO roles (id, nombre) VALUES (1, 'Administrador');
INSERT INTO roles (id, nombre) VALUES (2, 'Usuario');

--

INSERT INTO usuarios (id, nombre, apellido, id_tipo_documento, numero_documento, contrasena)
    VALUES (1, 'roberto', 'quirpa', 1, 1234, '1234');

--

INSERT INTO usuarios_roles (rol_id, usuario_id) values (1, 1);

--
