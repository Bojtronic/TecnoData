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





INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url, cantidad_ventas, categoria_id) VALUES
('Producto 1', 'Descripción del producto 1', 19.99, 50, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 10, 1),
('Producto 2', 'Descripción del producto 2', 29.99, 30, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 20, 1),
('Producto 3', 'Descripción del producto 3', 39.99, 40, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 15, 2),
('Producto 4', 'Descripción del producto 4', 49.99, 25, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 5, 2),
('Producto 5', 'Descripción del producto 5', 59.99, 10, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 8, 3),
('Producto 6', 'Descripción del producto 6', 69.99, 15, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 50, 3),
('Producto 7', 'Descripción del producto 7', 79.99, 20, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 35, 4),
('Producto 8', 'Descripción del producto 8', 89.99, 12, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 18, 4),
('Producto 9', 'Descripción del producto 9', 99.99, 8, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 22, 5),
('Producto 10', 'Descripción del producto 10', 109.99, 5, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 7, 5),
('Producto 11', 'Descripción del producto 11', 119.99, 18, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 40, 6),
('Producto 12', 'Descripción del producto 12', 129.99, 22, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 12, 6),
('Producto 13', 'Descripción del producto 13', 139.99, 19, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 27, 7),
('Producto 14', 'Descripción del producto 14', 149.99, 13, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 30, 7),
('Producto 15', 'Descripción del producto 15', 159.99, 25, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 45, 8),
('Producto 16', 'Descripción del producto 16', 169.99, 20, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 33, 8),
('Producto 17', 'Descripción del producto 17', 179.99, 10, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 50, 9),
('Producto 18', 'Descripción del producto 18', 189.99, 7, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 25, 9),
('Producto 19', 'Descripción del producto 19', 199.99, 30, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 60, 10),
('Producto 20', 'Descripción del producto 20', 209.99, 50, 'https://e7.pngegg.com/pngimages/576/719/png-clipart-new-product-development-marketing-product-innovation-sales-product-stamp-emblem-text-thumbnail.png', 42, 10);

















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


