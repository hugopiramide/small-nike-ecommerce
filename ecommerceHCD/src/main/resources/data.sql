ALTER TABLE product CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE category CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- =============================================================================
-- 1. CATEGORÍAS (40 registros)
-- =============================================================================
INSERT INTO category (id, name, description) VALUES 
(1, 'Running', 'Calzado y ropa técnica para corredores de alto rendimiento.'),
(2, 'Lifestyle', 'Moda urbana y calzado icónico para el día a día.'),
(3, 'Basketball', 'Equipamiento oficial para la cancha y estilo NBA.'),
(4, 'Training', 'Ropa y calzado para gimnasio y entrenamiento funcional.'),
(5, 'Soccer', 'Botas de fútbol y equipaciones de clubes internacionales.'),
(6, 'Tennis', 'Ropa y calzado de alto rendimiento para todas las superficies.'),
(7, 'Skateboarding', 'Línea Nike SB diseñada para patinadores profesionales.'),
(8, 'Yoga', 'Prendas elásticas y cómodas para máxima movilidad.'),
(9, 'Golf', 'Equipamiento elegante y técnico para el campo de golf.'),
(10, 'ACG', 'All Conditions Gear: equipo para exteriores y montaña.'),
(11, 'Jordan', 'La marca mítica inspirada en Michael Jordan.'),
(12, 'Trail Running', 'Calzado con tracción extrema para terrenos difíciles.'),
(13, 'Swimming', 'Bañadores y accesorios de natación de secado rápido.'),
(14, 'Accessories', 'Mochilas, gorras, guantes y calcetines técnicos.'),
(15, 'Kids', 'Productos específicos para atletas infantiles.'),
(16, 'Walking', 'Calzado diseñado para la máxima comodidad al caminar.'),
(17, 'Fleece', 'Prendas térmicas de tejido suave Tech Fleece.'),
(18, 'Sustainable', 'Productos fabricados con al menos un 20% de material reciclado.'),
(19, 'Custom', 'Productos personalizables a través de Nike By You.'),
(20, 'Vaporfly', 'La élite de las zapatillas de competición con placa de carbono.'),
(21, 'Baseball', 'Tacos y equipamiento para el diamante.'),
(22, 'Softball', 'Calzado y ropa específica para jugadoras de softball.'),
(23, 'Lacrosse', 'Equipación técnica para alta velocidad en lacrosse.'),
(24, 'Volleyball', 'Calzado con amortiguación para saltos constantes.'),
(25, 'Boxing', 'Botas de boxeo ligeras y con gran soporte de tobillo.'),
(26, 'Weightlifting', 'Zapatillas de halterofilia con talón rígido.'),
(27, 'Cycling', 'Calzado para ciclismo de interior y exterior.'),
(28, 'Maternity', 'Ropa deportiva diseñada para todas las etapas del embarazo.'),
(29, 'Plus Size', 'Colección de tallas grandes con ajuste deportivo.'),
(30, 'Vintage', 'Modelos retro recuperados de los archivos de Nike.'),
(31, 'Fan Gear', 'Merchandising oficial de selecciones y equipos.'),
(32, 'Rugby', 'Botas con tacos reforzados para máxima tracción.'),
(33, 'Dance', 'Ropa flexible y moderna para coreografías.'),
(34, 'Recovery', 'Calzado y ropa para después de entrenar.'),
(35, 'Sandals', 'Chanclas y sandalias para piscina o descanso.'),
(36, 'Boots', 'Botas de invierno Nike con protección contra el frío.'),
(37, 'Collaboration', 'Ediciones limitadas diseñadas con artistas y marcas.'),
(38, 'High Fashion', 'Línea de lujo que fusiona pasarela y deporte.'),
(39, 'Winter Sports', 'Capas base térmicas para deportes de nieve.'),
(40, 'Gymnastics', 'Mallas y bodies de alta flexibilidad.');

-- =============================================================================
-- 2. PRODUCTOS (40 registros)
-- =============================================================================
INSERT INTO product (id, name, description, base_price, active, image_url, category_id) VALUES 
(1, 'Nike Air Max 270', 'Icónica unidad Air para comodidad urbana.', 150.0, 1, 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=600&q=80', 2),
(2, 'Nike Pegasus 40', 'Amortiguación reactiva para corredores diarios.', 130.0, 1, 'https://images.unsplash.com/photo-1549298916-b41d501d3772?auto=format&fit=crop&w=600&q=80', 1),
(3, 'Nike Dunk Low', 'Estilo clásico de los 80 para la calle.', 110.0, 1, 'https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?auto=format&fit=crop&w=600&q=80', 7),
(4, 'Nike Metcon 9', 'Estabilidad máxima para levantamientos pesados.', 140.0, 1, 'https://images.unsplash.com/photo-1539185441755-769473a23570?auto=format&fit=crop&w=600&q=80', 4),
(5, 'Mercurial Superfly 9', 'Velocidad explosiva para campos de fútbol.', 270.0, 1, 'https://images.unsplash.com/photo-1511886929837-354d827aae26?auto=format&fit=crop&w=600&q=80', 5),
(6, 'Air Force 1 07', 'La leyenda del baloncesto en tus pies.', 120.0, 1, 'https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?auto=format&fit=crop&w=600&q=80', 2),
(7, 'LeBron XXI', 'Protección contra impactos para jugadores potentes.', 200.0, 1, 'https://images.unsplash.com/photo-1579338559194-a162d19bf842?auto=format&fit=crop&w=600&q=80', 3),
(8, 'Vaporfly NEXT% 3', 'Zapatillas para romper récords personales.', 260.0, 1, 'https://images.unsplash.com/photo-1460353581641-37baddab0fa2?auto=format&fit=crop&w=600&q=80', 20),
(9, 'Nike Tech Fleece Hoodie', 'Sudadera ligera de máxima calidez.', 110.0, 1, 'https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=600&q=80', 17),
(10, 'ACG Mountain Fly 2', 'Tracción y protección en cualquier sendero.', 180.0, 1, 'https://images.unsplash.com/photo-1551107696-a4b0c5a0d9a2?auto=format&fit=crop&w=600&q=80', 10),
(11, 'Air Jordan 1 High OG', 'El comienzo de una era en el calzado.', 180.0, 1, 'https://images.unsplash.com/photo-1552346154-21d32810aba3?auto=format&fit=crop&w=600&q=80', 11),
(12, 'Nike Wildhorse 8', 'Resistencia y agarre para el trail running.', 135.0, 1, 'https://images.unsplash.com/photo-1538233412743-917a46c73ee1?auto=format&fit=crop&w=600&q=80', 12),
(13, 'Nike Pro Leggings', 'Capa base de alto rendimiento.', 55.0, 1, 'https://images.unsplash.com/photo-1506152983158-b4a74a01c721?auto=format&fit=crop&w=600&q=80', 8),
(14, 'Zoom Court NXT', 'Velocidad y agilidad en la pista de tenis.', 155.0, 1, 'https://images.unsplash.com/photo-1612450865753-5bb8d79e1c34?auto=format&fit=crop&w=600&q=80', 6),
(15, 'Golf Victory Polo', 'Comodidad transpirable para 18 hoyos.', 45.0, 1, 'https://images.unsplash.com/photo-1587151711096-23c51fcd2d9c?auto=format&fit=crop&w=600&q=80', 9),
(16, 'Nike SB Ishod', 'Diseño moderno para el skate técnico.', 105.0, 1, 'https://images.unsplash.com/photo-1549103684-247dd883d38e?auto=format&fit=crop&w=600&q=80', 7),
(17, 'Nike Swim Briefs', 'Diseño hidrodinámico para competición.', 35.0, 1, 'https://images.unsplash.com/photo-1519046904884-53103b34b206?auto=format&fit=crop&w=600&q=80', 13),
(18, 'Nike Elite Socks', 'Amortiguación estratégica para baloncesto.', 18.0, 1, 'https://images.unsplash.com/photo-1582555172866-f73bb12a2ab3?auto=format&fit=crop&w=600&q=80', 14),
(19, 'Nike Star Runner Kids', 'Fáciles de poner para pequeños atletas.', 45.0, 1, 'https://images.unsplash.com/photo-1514989940723-e8e51635b782?auto=format&fit=crop&w=600&q=80', 15),
(20, 'Nike React Phantom', 'Zapatilla de running sin cordones.', 150.0, 1, 'https://images.unsplash.com/photo-1587563871167-1ee9c731aefb?auto=format&fit=crop&w=600&q=80', 1),
(21, 'Nike Invincible 3', 'Espuma ZoomX para máxima amortiguación.', 190.0, 1, 'https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?auto=format&fit=crop&w=600&q=80', 1),
(22, 'Nike Blazer Mid 77', 'Estilo vintage de baloncesto.', 105.0, 1, 'https://images.unsplash.com/photo-1605348532760-6753d2c41324?auto=format&fit=crop&w=600&q=80', 30),
(23, 'Air Max Plus', 'Estilo Tuned Air agresivo.', 185.0, 1, 'https://images.unsplash.com/photo-1514444917583-e455b51c705c?auto=format&fit=crop&w=600&q=80', 2),
(24, 'Alphafly NEXT% 2', 'La cima de la tecnología de maratón.', 300.0, 1, 'https://images.unsplash.com/photo-1491553895911-0055eca6402d?auto=format&fit=crop&w=600&q=80', 20),
(25, 'Air Jordan 4 Retro', 'Detalles icónicos y soporte premium.', 210.0, 1, 'https://images.unsplash.com/photo-1597043540263-737721849a21?auto=format&fit=crop&w=600&q=80', 11),
(26, 'Nike Free Metcon 5', 'Flexibilidad para saltos y sprints.', 125.0, 1, 'https://images.unsplash.com/photo-1543163521-1bf539c55dd2?auto=format&fit=crop&w=600&q=80', 4),
(27, 'Nike Cortez', 'El diseño que lanzó a Nike a la fama.', 95.0, 1, 'https://images.unsplash.com/photo-1603808033192-082d6919d3e1?auto=format&fit=crop&w=600&q=80', 30),
(28, 'Nike Zegama Trail', 'Reactividad en terrenos técnicos.', 165.0, 1, 'https://images.unsplash.com/photo-1534067783941-51c9c23ecefd?auto=format&fit=crop&w=600&q=80', 12),
(29, 'Nike One Leggings', 'Versatilidad para cualquier entrenamiento.', 60.0, 1, 'https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?auto=format&fit=crop&w=600&q=80', 8),
(30, 'Air Max 90', 'Cojín de aire clásico y durabilidad.', 140.0, 1, 'https://images.unsplash.com/photo-1521903062400-b80a2bb8cb3d?auto=format&fit=crop&w=600&q=80', 2),
(31, 'Kyrie Infinity', 'Control total para cambios de dirección.', 140.0, 1, 'https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?auto=format&fit=crop&w=600&q=80', 3),
(32, 'Nike Phantom Luna', 'Botas diseñadas para el fútbol femenino.', 280.0, 1, 'https://images.unsplash.com/photo-1511886929837-354d827aae26?auto=format&fit=crop&w=600&q=80', 5),
(33, 'Nike Romaleos 4', 'Base ancha para levantamiento olímpico.', 200.0, 1, 'https://images.unsplash.com/photo-1526506118085-60ce8714f8c5?auto=format&fit=crop&w=600&q=80', 26),
(34, 'Nike SB Dunk High', 'Versión alta del clásico del skate.', 125.0, 1, 'https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?auto=format&fit=crop&w=600&q=80', 7),
(35, 'Nike Victori One', 'La chancla esencial para el descanso.', 35.0, 1, 'https://images.unsplash.com/photo-1603487742131-4160ec999306?auto=format&fit=crop&w=600&q=80', 35),
(36, 'Nike Structure 25', 'Soporte estable para sobrepronadores.', 140.0, 1, 'https://images.unsplash.com/photo-1516478177764-9fe5bd7e9717?auto=format&fit=crop&w=600&q=80', 1),
(37, 'Nike Vomero 17', 'Amortiguación premium para largas distancias.', 170.0, 1, 'https://images.unsplash.com/photo-1571008887538-b36bb32f4571?auto=format&fit=crop&w=600&q=80', 1),
(38, 'Nike Air Max Dawn', 'Inspiración en el running vintage.', 115.0, 1, 'https://images.unsplash.com/photo-1605408499391-6368c628ef42?auto=format&fit=crop&w=600&q=80', 30),
(39, 'Air Jordan 11 Retro', 'El equilibrio perfecto entre elegancia y deporte.', 230.0, 1, 'https://images.unsplash.com/photo-1597043540263-737721849a21?auto=format&fit=crop&w=600&q=80', 11),
(40, 'Nike Storm-FIT Jacket', 'Chaqueta resistente al viento y la lluvia.', 120.0, 1, 'https://images.unsplash.com/photo-1591047139829-d91aec96caea?auto=format&fit=crop&w=600&q=80', 14);

-- =============================================================================
-- 3. VARIANTES DE PRODUCTO (40 registros)
-- =============================================================================
INSERT INTO product_variant (id, product_id, size, stock, price_modifier) VALUES 
-- Producto 1: Nike Air Max 270
(1, 1, '41', 20, 0.0), (2, 1, '42', 45, 0.0), (3, 1, '43', 30, 0.0), (4, 1, '44', 15, 0.0),
-- Producto 2: Nike Pegasus 40
(5, 2, '40', 25, 0.0), (6, 2, '41', 120, 0.0), (7, 2, '42', 80, 0.0), (8, 2, '43', 40, 0.0),
-- Producto 3: Nike Dunk Low
(9, 3, '42', 20, 10.0), (10, 3, '43', 15, 10.0), (11, 3, '44', 10, 10.0),
-- Producto 4: Nike Metcon 9
(12, 4, '40', 25, 0.0), (13, 4, '41', 30, 0.0), (14, 4, '42', 20, 0.0),
-- Producto 5: Mercurial Superfly 9
(15, 5, '42', 8, 25.0), (16, 5, '43', 12, 25.0), (17, 5, '44', 10, 25.0),
-- Producto 6: Air Force 1 07
(18, 6, '41', 150, 0.0), (19, 6, '42', 300, 0.0), (20, 6, '43', 200, 0.0),
-- Producto 7: LeBron XXI
(21, 7, '44', 15, 0.0), (22, 7, '45', 20, 0.0), (23, 7, '46', 10, 0.0),
-- Producto 8: Vaporfly NEXT% 3
(24, 8, '41', 5, 40.0), (25, 8, '42', 8, 40.0), (26, 8, '43', 6, 40.0),
-- Producto 9: Nike Tech Fleece Hoodie
(27, 9, 'S', 40, 0.0), (28, 9, 'M', 60, 0.0), (29, 9, 'L', 50, 0.0), (30, 9, 'XL', 20, 0.0),
-- Producto 10: ACG Mountain Fly 2
(31, 10, '42', 12, 0.0), (32, 10, '43', 14, 0.0), (33, 10, '44', 10, 0.0),
-- Producto 11: Air Jordan 1 High OG
(34, 11, '43', 7, 60.0), (35, 11, '44', 5, 60.0), (36, 11, '45', 4, 60.0),
-- Producto 12: Nike Wildhorse 8
(37, 12, '41', 30, 0.0), (38, 12, '42', 25, 0.0), (39, 12, '43', 20, 0.0),
-- Producto 13: Nike Pro Leggings
(40, 13, 'XS', 40, 0.0), (41, 13, 'S', 80, 0.0), (42, 13, 'M', 60, 0.0),
-- Producto 14: Zoom Court NXT
(43, 14, '41', 15, 0.0), (44, 14, '42', 20, 0.0), (45, 14, '43', 12, 0.0),
-- Producto 15: Golf Victory Polo
(46, 15, 'M', 35, 0.0), (47, 15, 'L', 40, 0.0), (48, 15, 'XL', 25, 0.0),
-- Producto 16: Nike SB Ishod
(49, 16, '40', 22, 0.0), (50, 16, '41', 18, 0.0), (51, 16, '42', 15, 0.0),
-- Producto 17: Nike Swim Briefs
(52, 17, 'S', 30, 0.0), (53, 17, 'M', 55, 0.0), (54, 17, 'L', 40, 0.0),
-- Producto 18: Nike Elite Socks
(55, 18, 'M', 300, 0.0), (56, 18, 'L', 500, 0.0), (57, 18, 'XL', 200, 0.0),
-- Producto 19: Nike Star Runner Kids
(58, 19, '30', 40, 0.0), (59, 19, '32', 50, 0.0), (60, 19, '34', 35, 0.0),
-- Producto 20: Nike React Phantom
(61, 20, '41', 15, 0.0), (62, 20, '42', 12, 0.0), (63, 20, '43', 10, 0.0),
-- Producto 21: Nike Invincible 3
(64, 21, '42', 40, 0.0), (65, 21, '43', 35, 0.0), (66, 21, '44', 20, 0.0),
-- Producto 22: Nike Blazer Mid 77
(67, 22, '43', 25, 0.0), (68, 22, '44', 30, 0.0), (69, 22, '45', 15, 0.0),
-- Producto 23: Air Max Plus
(70, 23, '41', 20, 5.0), (71, 23, '42', 18, 5.0), (72, 23, '43', 15, 5.0),
-- Producto 24: Alphafly NEXT% 2
(73, 24, '41', 5, 50.0), (74, 24, '42', 6, 50.0), (75, 24, '43', 4, 50.0),
-- Producto 25: Air Jordan 4 Retro
(76, 25, '44', 12, 70.0), (77, 25, '45', 10, 70.0), (78, 25, '46', 8, 70.0),
-- Producto 26: Nike Free Metcon 5
(79, 26, '40', 25, 0.0), (80, 26, '41', 30, 0.0), (81, 26, '42', 20, 0.0),
-- Producto 27: Nike Cortez
(82, 27, '41', 35, 0.0), (83, 27, '42', 45, 0.0), (84, 27, '43', 30, 0.0),
-- Producto 28: Nike Zegama Trail
(85, 28, '42', 25, 0.0), (86, 28, '43', 20, 0.0), (87, 28, '44', 15, 0.0),
-- Producto 29: Nike One Leggings
(88, 29, 'XS', 70, 0.0), (89, 29, 'S', 90, 0.0), (90, 29, 'M', 80, 0.0),
-- Producto 30: Air Max 90
(91, 30, '40', 30, 0.0), (92, 30, '41', 40, 0.0), (93, 30, '42', 50, 0.0),
-- Producto 31: Kyrie Infinity
(94, 31, '43', 20, 0.0), (95, 31, '44', 25, 0.0), (96, 31, '45', 15, 0.0),
-- Producto 32: Nike Phantom Luna
(97, 32, '39', 12, 20.0), (98, 32, '40', 18, 20.0), (99, 32, '41', 15, 20.0),
-- Producto 33: Nike Romaleos 4
(100, 33, '42', 10, 0.0), (101, 33, '43', 12, 0.0), (102, 33, '44', 8, 0.0),
-- Producto 34: Nike SB Dunk High
(103, 34, '40', 18, 0.0), (104, 34, '41', 22, 0.0), (105, 34, '42', 15, 0.0),
-- Producto 35: Nike Victori One
(106, 35, '41', 100, 0.0), (107, 35, '42', 150, 0.0), (108, 35, '43', 120, 0.0),
-- Producto 36: Nike Structure 25
(109, 36, '41', 28, 0.0), (110, 36, '42', 35, 0.0), (111, 36, '43', 25, 0.0),
-- Producto 37: Nike Vomero 17
(112, 37, '43', 18, 0.0), (113, 37, '44', 22, 0.0), (114, 37, '45', 12, 0.0),
-- Producto 38: Nike Air Max Dawn
(115, 38, '41', 25, 0.0), (116, 38, '42', 35, 0.0), (117, 38, '43', 20, 0.0),
-- Producto 39: Air Jordan 11 Retro
(118, 39, '44', 6, 90.0), (119, 39, '45', 4, 90.0), (120, 39, '46', 3, 90.0),
-- Producto 40: Nike Storm-FIT Jacket
(121, 40, 'M', 25, 0.0), (122, 40, 'L', 30, 0.0), (123, 40, 'XL', 20, 0.0);

-- =============================================================================
-- 4. USUARIOS (40 registros)
-- =============================================================================
INSERT INTO user (id, user_name, email, password, role, create_at, profile_img_url, name, surnames, birthday) VALUES 
(1, 'admin_hcd', 'admin@nike.com', 'admin_hash', 'ROLE_ADMIN', NOW(), 'img1.jpg', 'Admin', 'Hcd', '1980-01-01'),
(2, 'runner_pro', 'marcos@runner.com', 'pass1', 'ROLE_USER', NOW(), 'img2.jpg', 'Marcos', 'Gonzalez', '1990-05-10');

-- =============================================================================
-- 5. CARRITOS (2 registros)
-- =============================================================================
INSERT INTO cart (id, user_id, update_at) VALUES 
(1, 1, NOW()), (2, 2, NOW());

-- =============================================================================
-- 6. ÍTEMS DEL CARRITO (2 registros)
-- =============================================================================
INSERT INTO cart_item (id, cart_id, product_variant_id, quantity) VALUES 
(1, 1, 2, 1), (2, 2, 6, 1);
