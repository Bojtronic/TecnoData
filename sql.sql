DROP DATABASE tecnosmart_db;


CREATE DATABASE tecnosmart_db;


use tecnosmart_db

SHOW TABLES;

DESCRIBE categorias;
DESCRIBE detalles_orden;
DESCRIBE ordenes;
DESCRIBE productos;
DESCRIBE usuarios;

SHOW CREATE TABLE categorias;
SHOW CREATE TABLE detalles_orden;
SHOW CREATE TABLE ordenes;
SHOW CREATE TABLE productos;
SHOW CREATE TABLE usuarios;
SHOW CREATE TABLE usuario;


INSERT INTO categoria (nombre, imagen_url, cantidad_ventas) VALUES
('Electrónicos', '/img/electronicos.jpg', 10),
('Herramientas', '/img/herramientas.jpeg', 20),
('Juguetes', '/img/juguetes.jpg', 30),
('Libros', '/img/libros.jpg', 40),
('Deportes', '/img/deportes.jpg', 45),
('Hogar', '/img/hogar.jpg', 60),
('Jardinería', '/img/jardineria.jpg', 70),
('Ropa', '/img/ropa.jpg', 80),
('Calzado', '/img/calzado.jpg', 90),
('Automóviles', '/img/automoviles.jpg', 100);












INSERT INTO productos (descripcion, imagen_url, nombre, precio, stock, categoria_id)
VALUES ('Smartphone con pantalla de 6.5 pulgadas, cámara de 12MP y procesador Octa-core', 'https://w7.pngwing.com/pngs/78/447/png-transparent-iphone-logo-show-smartphone-android-cell-phone-gadget-electronics-rectangle-thumbnail.png', 'Smartphone XYZ', 300.00, 50, 1);

INSERT INTO productos (descripcion, imagen_url, nombre, precio, stock, categoria_id)
VALUES ('Zapatos deportivos de hombre, talla 42, color negro', 'https://e7.pngegg.com/pngimages/804/706/png-clipart-footwear-shoe-clothing-valco-plast-sneakers-others-miscellaneous-logo.png', 'Zapatos deportivos', 75.00, 100, 2);

INSERT INTO productos (descripcion, imagen_url, nombre, precio, stock, categoria_id)
VALUES ('Libro de programación en C++, cubriendo desde lo básico hasta temas avanzados', 'https://thumbs.dreamstime.com/z/icono-de-libros-acerca-la-programaci%C3%B3n-un-libro-en-el-lenguaje-c-121634497.jpg', 'Libro de C++ avanzado', 40.00, 200, 3);


INSERT INTO usuarios (apellido, email, nombre, password, rol)
VALUES ('Pérez', 'juan.perez@example.com', 'Juan', 'securepassword1', 'admin');

INSERT INTO usuarios (apellido, email, nombre, password, rol)
VALUES ('Gómez', 'ana.gomez@example.com', 'Ana', 'securepassword2', 'user');

INSERT INTO usuarios (apellido, email, nombre, password, rol)
VALUES ('López', 'carlos.lopez@example.com', 'Carlos', 'securepassword3', 'moderator');


INSERT INTO usuario (apellido, email, nombre, password, rol)
VALUES ('Pérez', 'juan.perez@example.com', 'Juan', 'securepassword1', 'admin');

INSERT INTO usuario (apellido, email, nombre, password, rol)
VALUES ('Gómez', 'ana.gomez@example.com', 'Ana', 'securepassword2', 'user');

INSERT INTO usuario (apellido, email, nombre, password, rol)
VALUES ('López', 'carlos.lopez@example.com', 'Carlos', 'securepassword3', 'moderator');



INSERT INTO ordenes (fecha, total, usuario_id)
VALUES ('2024-12-01 10:00:00', 1500.00, 1);

INSERT INTO ordenes (fecha, total, usuario_id)
VALUES ('2024-12-02 15:30:00', 850.00, 2);

INSERT INTO ordenes (fecha, total, usuario_id)
VALUES ('2024-12-03 09:45:00', 1200.00, 3);


INSERT INTO detalles_orden (cantidad, precio, subtotal, orden_id, producto_id)
VALUES (2, 500.00, 1000.00, 1, 1);

INSERT INTO detalles_orden (cantidad, precio, subtotal, orden_id, producto_id)
VALUES (1, 250.00, 250.00, 2, 2);

INSERT INTO detalles_orden (cantidad, precio, subtotal, orden_id, producto_id)
VALUES (5, 120.00, 600.00, 3, 3);



SELECT * FROM categorias;

SELECT * FROM detalles_orden;

SELECT * FROM ordenes;

SELECT * FROM productos;

SELECT * FROM usuarios;

SELECT * FROM usuario;


