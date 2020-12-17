-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2020 a las 21:25:14
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `delivery2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articuloinsumo`
--

CREATE TABLE `articuloinsumo` (
  `id_articuloInsumo` int(11) NOT NULL,
  `descripcion_articuloInsumo` varchar(255) DEFAULT NULL,
  `eliminado_articuloInsumo` bit(1) DEFAULT NULL,
  `esInsumo_articuloInsumo` bit(1) DEFAULT NULL,
  `nombre_articuloInsumo` varchar(255) DEFAULT NULL,
  `precioCompra_articuloInsumo` double DEFAULT NULL,
  `precioVta_articuloInsumo` double DEFAULT NULL,
  `stockActual_articuloInsumo` double DEFAULT NULL,
  `stockMax_articuloInsumo` double DEFAULT NULL,
  `stockMin_articuloInsumo` double DEFAULT NULL,
  `fk_id_categoriaInsumo` int(11) DEFAULT NULL,
  `fk_id_imagen` int(11) DEFAULT NULL,
  `fk_id_unidadDeMedida` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articuloinsumo`
--

INSERT INTO `articuloinsumo` (`id_articuloInsumo`, `descripcion_articuloInsumo`, `eliminado_articuloInsumo`, `esInsumo_articuloInsumo`, `nombre_articuloInsumo`, `precioCompra_articuloInsumo`, `precioVta_articuloInsumo`, `stockActual_articuloInsumo`, `stockMax_articuloInsumo`, `stockMin_articuloInsumo`, `fk_id_categoriaInsumo`, `fk_id_imagen`, `fk_id_unidadDeMedida`) VALUES
(1, 'Bebida sabor cola por 1,5L', b'0', b'0', 'Coca Cola', 77, 120, 29, 50, 20, 1, 3, 5),
(2, 'Harina común 000', b'0', b'1', 'Harina común', 20, 0, 16600, 40000, 10000, 2, 26, 1),
(3, 'Salsa de tomate triturado', b'0', b'1', 'Salsa de tomate', 30, 0, 27700, 40000, 25000, 3, 27, 3),
(4, 'asdasd', b'1', b'0', 'asdasd', 1212, 1212, 1212, 121, 1212, 1, 6, 3),
(5, 'dasda', b'1', b'0', 'asdas', 12312, 12312, 31231, 12312, 31231, 1, 5, 1),
(6, 'Jamón cocido', b'0', b'1', 'Jamón cocido', 30, 0, 1200, 10000, 2000, 8, 7, 1),
(7, 'Queso cremoso', b'0', b'1', 'Queso cremoso', 28, 0, 5800, 20000, 10000, 4, 8, 1),
(8, 'Bebida sabor naranja por 1,5L', b'0', b'0', 'Fanta', 80, 120, 18, 50, 20, 1, 17, 5),
(9, 'Bebida sabor lima limón por 1,5L', b'0', b'0', 'Sprite', 80, 120, 33, 50, 20, 1, 18, 5),
(10, 'Agua por 500ml', b'0', b'0', 'Villavicencio', 60, 90, 42, 20, 50, 6, 19, 5),
(11, 'Agua saborizada sabor naranja por 1,5L', b'0', b'0', 'Aquarius', 70, 100, 33, 50, 20, 6, 20, 5),
(12, 'Cerveza lata por 350ml', b'0', b'0', 'Cerveza Brahma Lata', 60, 80, 19, 60, 20, 5, 21, 5),
(13, 'Cerveza Botella por 1L', b'0', b'0', 'Cerveza Brahma', 90, 140, 14, 60, 20, 5, 22, 5),
(14, 'Sal de mesa', b'0', b'1', 'Sal Fina', 40, 0, 2991, 6000, 2000, 13, 23, 1),
(15, 'Aceitunas Naturales', b'0', b'1', 'Aceitunas Verdes', 30, 0, 1000, 7000, 2000, 10, 24, 1),
(16, 'Carne Molida', b'0', b'1', 'Carne Molida', 350, 0, 9500, 20000, 5000, 7, 29, 1),
(17, 'Huevos', b'0', b'1', 'Huevos', 6, 0, 98, 300, 60, 15, 30, 5),
(18, 'Cebolla', b'0', b'1', 'Cebolla', 15, 0, 19000, 40000, 10000, 10, 31, 1),
(19, 'Grasa Vacuna', b'0', b'1', 'Grasa Vacuna', 100, 0, 4900, 10000, 3000, 7, 32, 1),
(20, 'Pan de Miga', b'0', b'1', 'Pan de Miga  ', 250, 0, 494, 1000, 300, 2, 33, 5),
(21, 'Mayonesa de limón', b'0', b'1', 'Mayonesa', 300, 0, 4700, 10000, 3000, 3, 34, 1),
(22, 'Lechuga', b'0', b'1', 'Lechuga', 30, 0, 4700, 7000, 3000, 10, 35, 1),
(23, 'Tomate', b'0', b'1', 'Tomate', 70, 0, 4400, 7000, 3000, 10, 36, 1),
(24, 'Bifes de filet', b'0', b'1', 'Bifes', 400, 0, 10000, 20000, 5000, 7, 37, 1),
(25, 'Nalga para Milanesas', b'0', b'1', 'Nalga', 400, 0, 7000, 15000, 5000, 7, 38, 1),
(26, 'Papas', b'0', b'1', 'Papas', 25, 0, 15000, 20000, 7000, 10, 39, 1),
(27, 'Queso en fetas', b'0', b'1', 'Queso en fetas', 30, 0, 4400, 10000, 3000, 4, 41, 1),
(28, 'Pan de Hamburguesa', b'0', b'1', 'Pan de Hamburguesa', 20, 0, 5000, 7000, 3000, 2, 42, 5),
(29, 'Levadura', b'0', b'1', 'Levadura', 50, 0, 4970, 7000, 1000, 3, 43, 1),
(30, 'Aceite', b'0', b'1', 'Aceite', 10, 0, 9970, 15000, 5000, 11, 44, 3),
(31, 'Morrones', b'0', b'1', 'Morrones', 10, 0, 4900, 7000, 3000, 10, 45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulomanufacturado`
--

CREATE TABLE `articulomanufacturado` (
  `id_articuloManufacturado` int(11) NOT NULL,
  `eliminado_articuloManufacturado` bit(1) DEFAULT NULL,
  `nombre_articuloManufacturado` varchar(255) DEFAULT NULL,
  `precio_articuloManufacturado` double DEFAULT NULL,
  `tiempoPreparacion_articuloManufacturado` int(11) DEFAULT NULL,
  `fk_id_categoriaGeneral` int(11) DEFAULT NULL,
  `fk_id_imagen` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulomanufacturado`
--

INSERT INTO `articulomanufacturado` (`id_articuloManufacturado`, `eliminado_articuloManufacturado`, `nombre_articuloManufacturado`, `precio_articuloManufacturado`, `tiempoPreparacion_articuloManufacturado`, `fk_id_categoriaGeneral`, `fk_id_imagen`) VALUES
(1, b'0', 'Pizza Muzarella', 250, 20, 1, 2),
(5, b'1', 'asd', 123, 123, NULL, 9),
(6, b'1', 'asda', 123, 123, NULL, 10),
(7, b'1', '12312', 312, 123, NULL, 11),
(8, b'1', 'fdhgf', 123, 123, 1, 12),
(12, b'0', 'Pizza Especial', 320, 25, 1, 16),
(13, b'0', 'Empanadas de Carne 1/2 doc', 200, 20, 4, 25),
(14, b'0', 'Empanadas de Carne 1 doc', 380, 30, 4, 28),
(15, b'0', 'Sandwiches de Miga 1 doc', 300, 30, 9, 40),
(16, b'0', 'Hamburguesa Común', 300, 10, 10, 46);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulomanufacturadodetalle`
--

CREATE TABLE `articulomanufacturadodetalle` (
  `id_articuloManufacturadoDetalle` int(11) NOT NULL,
  `cantidad_articuloManufacturadoDetalle` double DEFAULT NULL,
  `fk_id_articuloInsumo` int(11) DEFAULT NULL,
  `fk_id_articuloManufacturado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulomanufacturadodetalle`
--

INSERT INTO `articulomanufacturadodetalle` (`id_articuloManufacturadoDetalle`, `cantidad_articuloManufacturadoDetalle`, `fk_id_articuloInsumo`, `fk_id_articuloManufacturado`) VALUES
(1, 250, 2, 1),
(2, 150, 3, 1),
(3, 200, 7, 1),
(33, 123, 2, 5),
(34, 123, 2, NULL),
(35, 123, 3, NULL),
(36, 123, 2, 6),
(37, 123, 3, 6),
(38, 12312, 2, NULL),
(39, 12, 2, NULL),
(40, 12312, 2, 7),
(41, 12, 2, 8),
(42, 200, 2, NULL),
(43, 150, 3, NULL),
(44, 200, 7, NULL),
(45, 200, 6, NULL),
(46, 200, 2, NULL),
(47, 150, 3, NULL),
(48, 200, 2, NULL),
(49, 200, 2, NULL),
(50, 12, 3, NULL),
(51, 12, 2, NULL),
(52, 200, 2, NULL),
(53, 200, 6, NULL),
(55, 200, 2, 12),
(56, 200, 3, 12),
(57, 200, 7, 12),
(58, 200, 6, 12),
(59, 50, 15, 13),
(60, 200, 2, 13),
(61, 400, 2, 14),
(62, 100, 15, 14),
(63, 200, 6, 15),
(64, 100, 21, 15),
(65, 100, 22, 15),
(66, 200, 23, 15),
(67, 200, 27, 15),
(68, 1, 17, 13),
(69, 250, 16, 13),
(70, 500, 18, 13),
(71, 50, 19, 13),
(72, 500, 16, 14),
(73, 1000, 18, 14),
(74, 2, 17, 14),
(75, 100, 19, 14),
(76, 10, 29, 1),
(77, 10, 30, 1),
(78, 3, 14, 1),
(79, 10, 29, 12),
(80, 10, 30, 12),
(81, 3, 14, 12),
(82, 100, 31, 12),
(83, 1, 28, 16),
(84, 100, 16, 16),
(85, 100, 6, 16),
(86, 100, 27, 16),
(87, 3, 20, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id_carrito` int(11) NOT NULL,
  `fecha_carrito` datetime DEFAULT NULL,
  `montoDescuento_carrito` double DEFAULT NULL,
  `tipoEnvio_carrito` varchar(255) DEFAULT NULL,
  `total_carrito` double DEFAULT NULL,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_domicilioCliente` int(11) DEFAULT NULL,
  `formaPago_carrito` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carritodetalle`
--

CREATE TABLE `carritodetalle` (
  `id_carritoDetalle` int(11) NOT NULL,
  `cantidad_carritoDetalle` int(11) DEFAULT NULL,
  `subtotal_carritoDetalle` double DEFAULT NULL,
  `fk_id_carrito` int(11) DEFAULT NULL,
  `fk_id_insumo` int(11) DEFAULT NULL,
  `fk_id_manufacturado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriageneral`
--

CREATE TABLE `categoriageneral` (
  `id_categoriaGeneral` int(11) NOT NULL,
  `denominacion_categoriaGeneral` varchar(255) DEFAULT NULL,
  `eliminado_categoriaGeneral` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoriageneral`
--

INSERT INTO `categoriageneral` (`id_categoriaGeneral`, `denominacion_categoriaGeneral`, `eliminado_categoriaGeneral`) VALUES
(1, 'Pizzas', b'0'),
(2, 'Milanesas', b'0'),
(3, 'Pastas', b'0'),
(4, 'Empanadas', b'0'),
(5, 'Tartas', b'0'),
(6, 'Sushi', b'0'),
(7, 'Helados', b'0'),
(8, 'Papas', b'0'),
(9, 'Sandwiches', b'0'),
(10, 'Hamburguesas', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriainsumo`
--

CREATE TABLE `categoriainsumo` (
  `id_categoriaInsumo` int(11) NOT NULL,
  `denominacion_categoriaInsumo` varchar(255) DEFAULT NULL,
  `eliminado_categoriaInsumo` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoriainsumo`
--

INSERT INTO `categoriainsumo` (`id_categoriaInsumo`, `denominacion_categoriaInsumo`, `eliminado_categoriaInsumo`) VALUES
(1, 'Gaseosas', b'0'),
(2, 'Panificación', b'0'),
(3, 'Condimentos', b'0'),
(4, 'Lacteos', b'0'),
(5, 'Bebidas con alcohol', b'0'),
(6, 'Aguas Saborizadas', b'0'),
(7, 'Carnes', b'0'),
(8, 'Fiambres', b'0'),
(9, 'Frutas', b'0'),
(10, 'Verduras y Hortalizas', b'0'),
(11, 'Aceites', b'0'),
(12, 'Cereales', b'0'),
(13, 'Mineral', b'0'),
(14, 'Repostería', b'0'),
(15, 'Avícola', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
  `id_configuracion` int(11) NOT NULL,
  `cantidadCocineros_configuracion` int(11) DEFAULT NULL,
  `cuit_configuracion` bigint(20) DEFAULT NULL,
  `eliminado_configuracion` bit(1) DEFAULT NULL,
  `emailEmpresa_configuracion` varchar(255) DEFAULT NULL,
  `horarioApertura_configuracion` date DEFAULT NULL,
  `horarioCierre_configuracion` date DEFAULT NULL,
  `nombreEmpresa_configuracion` varchar(255) DEFAULT NULL,
  `numeroFiscal_configuracion` bigint(20) DEFAULT NULL,
  `paginaWeb_configuracion` varchar(255) DEFAULT NULL,
  `sociedad_configuracion` varchar(255) DEFAULT NULL,
  `telefono_configuracion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio`
--

CREATE TABLE `domicilio` (
  `id_domicilio` int(11) NOT NULL,
  `cp_domicilio` int(11) DEFAULT NULL,
  `calle_domicilio` varchar(255) DEFAULT NULL,
  `dpto_domicilio` int(11) DEFAULT NULL,
  `nro_domicilio` int(11) DEFAULT NULL,
  `piso_domicilio` int(11) DEFAULT NULL,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_empleado` int(11) DEFAULT NULL,
  `fk_id_localidad` int(11) DEFAULT NULL,
  `clase_domicilio` varchar(255) DEFAULT NULL,
  `alias_domicilio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `domicilio`
--

INSERT INTO `domicilio` (`id_domicilio`, `cp_domicilio`, `calle_domicilio`, `dpto_domicilio`, `nro_domicilio`, `piso_domicilio`, `fk_id_cliente`, `fk_id_empleado`, `fk_id_localidad`, `clase_domicilio`, `alias_domicilio`) VALUES
(9, 0, 'sobremonte', 132, 12312, 3123, 1, NULL, 1, NULL, NULL),
(11, 0, 'guiraldes', 0, 537, 0, 1, NULL, 1, NULL, NULL),
(12, 0, 'san martin', 1, 1, 1, 1, NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `nombre_estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_estado`, `nombre_estado`) VALUES
(1, 'En cocina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL,
  `eliminado_factura` bit(1) DEFAULT NULL,
  `fecha_factura` varchar(100) DEFAULT NULL,
  `montoDescuento_factura` double DEFAULT NULL,
  `nro_factura` int(11) DEFAULT NULL,
  `nroTarjeta_factura` bigint(20) DEFAULT NULL,
  `tipoPago_factura` varchar(255) DEFAULT NULL,
  `total_factura` double DEFAULT NULL,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_pedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `eliminado_factura`, `fecha_factura`, `montoDescuento_factura`, `nro_factura`, `nroTarjeta_factura`, `tipoPago_factura`, `total_factura`, `fk_id_cliente`, `fk_id_pedido`) VALUES
(1, b'0', '9/10/2020 22:25:37', 0, 0, 0, 'Efectivo', 370, 1, 8),
(5, b'0', '09/10/2020 19:23:08', 37, 0, 0, NULL, 333, 1, 7),
(16, b'0', '04/10/2020 0:17:11', 0, 0, 0, NULL, 620, 1, 6),
(17, b'0', '23/11/2020 14:45:21', 0, 0, 0, NULL, 560, 1, 10),
(18, b'0', '26/11/2020 18:14:49', 0, 0, 0, 'Contado', 370, 1, 12),
(19, b'0', '26/11/2020 14:45:19', 72, 0, 0, NULL, 648, 1, 11),
(20, b'0', '04/10/2020 02:00:03', 0, 0, 0, NULL, 370, 1, 4),
(21, b'0', '04/10/2020 02:45:58', 0, 0, 0, NULL, 370, 1, 5),
(22, b'0', '29/11/2020 18:40:36', 73, 0, 0, 'Débito', 917, 1, 13),
(23, b'0', '20/11/2020 23:14:29', 44, 0, 0, NULL, 596, 1, 9),
(24, b'0', '29/11/2020 19:21:31', 66, 0, 0, 'Débito', 854, 1, 14),
(25, b'0', '29/11/2020 19:38:08', 44, 0, 0, 'Contado', 516, 1, 15),
(26, b'0', '29/11/2020 19:50:59', 57, 0, 0, 'Débito', 513, 1, 16),
(27, b'0', '29/11/2020 20:04:28', 64, 0, 0, 'Débito', 816, 1, 17),
(28, b'0', '30/11/2020 20:35:50', 32, 0, 0, 'Contado', 728, 1, 19),
(29, b'0', '30/11/2020 20:38:23', 0, 0, 0, 'Contado', 440, 1, 20),
(30, b'0', '30/11/2020 20:50:13', 0, 0, 0, 'Contado', 690, 1, 22),
(31, b'0', '30/11/2020 20:44:16', 0, 0, 0, 'Contado', 370, 1, 21),
(32, b'0', '30/11/2020 21:28:20', 0, 0, 0, 'Contado', 440, 1, 23),
(33, b'0', '30/11/2020 21:30:53', 44, 0, 0, 'Contado', 716, 1, 24),
(34, b'0', '1/12/2020 23:03:57', 97, 0, 0, 'Contado', 873, 1, 25),
(35, b'0', '14/12/2020 20:05:11', 70, 0, 0, 'Contado', 630, 1, 26),
(36, b'0', '14/12/2020 23:24:45', 94, 0, 0, 'Contado', 846, 1, 27),
(37, b'0', '14/12/2020 23:44:11', 36, 0, 0, 'Contado', 324, 1, 28),
(38, b'0', '14/12/2020 23:49:05', 66, 0, 0, 'Contado', 594, 1, 29),
(39, b'0', '15/12/2020 0:27:23', 65, 0, 0, 'Contado', 585, 1, 30),
(40, b'0', '15/12/2020 15:07:09', 70, 0, 0, 'Contado', 630, 1, 31),
(41, b'0', '15/12/2020 15:13:36', 62, 0, 0, 'Contado', 558, 1, 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id_imagen` int(11) NOT NULL,
  `url_imagen` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id_imagen`, `url_imagen`) VALUES
(1, 'https://thumbs.dreamstime.com/z/icono-ejecutivo-joven-del-perfil-de-la-mujer-81933333.jpg'),
(2, 'https://media-cdn.tripadvisor.com/media/photo-s/11/14/fb/b1/pizza-muzzarella.jpg'),
(3, 'data:image/jpeg;base64,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'),
(4, 'asdasd'),
(5, 'adssasd'),
(6, '1'),
(7, 'https://http2.mlstatic.com/D_NQ_NP_2X_985410-MLA42316737177_062020-F.webp'),
(8, 'https://masnaturalshop.pe/wp-content/uploads/2020/07/MNH354_0.jpg'),
(9, 'https://www.region20.com.ar/images/451610_0.jpg'),
(10, 'https://www.region20.com.ar/images/451610_0.jpg'),
(11, 'https://www.region20.com.ar/images/451610_0.jpg'),
(12, 'https://www.region20.com.ar/images/451610_0.jpg'),
(16, 'https://www.region20.com.ar/images/451610_0.jpg'),
(17, 'https://www.casa-segal.com/wp-content/uploads/2020/03/fanta-naranja-15L-almacen-gaseosas-casa-segal-mendoza-600x600.jpg'),
(18, 'https://www.valelapeñabebidas.com.ar/wp-content/uploads/2020/04/SPRITE-CERO-15.png'),
(19, 'https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3040004_f.jpg'),
(20, 'https://d26lpennugtm8s.cloudfront.net/stores/861/458/products/340161-a0681ffa095a7c632415680461691646-640-0.jpg'),
(21, 'https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7792798005871_02.jpg'),
(22, 'https://d26lpennugtm8s.cloudfront.net/stores/798/865/products/32998144-27ee00dd88ee0fb10215592719941608-640-0.jpg'),
(23, 'https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/2300001_f.jpg'),
(24, 'https://www.fincasquillahue.com.ar/images/virtuemart/product/Aceitunas%20verdes%20500gr%20dorso.jpg'),
(25, 'https://comidasparaguayas.com/wp-content/uploads/2019/11/empanada-de-carne-paraguaya_700x465.jpg'),
(26, 'https://rotiseriaeliale.com.ar/wp-content/uploads/2020/05/harina-fav-000.png'),
(27, 'https://http2.mlstatic.com/salsa-de-tomate-de-la-torre-mendoza-botella-900-grs-pack-x8-D_NQ_NP_986777-MLA31628361710_072019-Q.jpg'),
(28, 'https://scm-assets.constant.co/scm/unilever/2bb5223be0548fcc55c230aa5f951219/6e483ef7-91e6-442a-8cf8-6cbbb35ddc2b.png'),
(29, 'https://abasto.com/wp-content/uploads/2018/05/ground-beef-carne-molida.jpg'),
(30, 'https://s1.eestatic.com/2019/07/03/ciencia/nutricion/Alimentacion-Huevo-Nutricion_410970417_127186275_1024x576.jpg'),
(31, 'https://static4.abc.es/media/bienestar/2020/10/08/cebolla-kfXH--1200x630@abc.jpg'),
(32, 'https://walmartar.vteximg.com.br/arquivos/ids/828737-1000-1000/Grasa-Faty-500-Gr-1-34759.jpg?v=636685091623530000'),
(33, 'https://cdn.cienradios.com/wp-content/uploads/sites/2/2020/10/pan-de-miga-casero.jpg-3.jpg'),
(34, 'https://www.hellmanns.com/content/dam/unilever/hellmann_s_world/spain/pack_design/3d/dressings/mayonnaise/hlmns_mayo_66_12x225ml_gla_eb_es/10504802-hellmanns-mayonesa-225ml-1171071.png'),
(35, 'https://www.65ymas.com/uploads/s1/38/42/11/bigstock-fresh-baby-cos-frillice-iceb-302911864.jpeg'),
(36, 'https://www.lavanguardia.com/files/og_thumbnail/uploads/2019/07/16/5e9981f0d5bba.jpeg'),
(37, 'https://c8.alamy.com/compes/c91ymd/dos-filetes-de-filet-mignon-corte-de-bife-de-lomo-con-una-sombra-de-luz-c91ymd.jpg'),
(38, 'https://d26lpennugtm8s.cloudfront.net/stores/968/248/products/nalga-para-milanesas1-44cd347a11ee81938515929213272606-1024-1024.png'),
(39, 'https://www.ngenespanol.com/wp-content/uploads/2018/08/%C2%BFEn-qu%C3%A9-pa%C3%ADs-de-Europa-la-papa-es-un-ingrediente-esencial.jpg'),
(40, 'https://placeralplato.com/files/2015/05/Receta-de-sndwiches-de-miga.jpg'),
(41, 'https://st.depositphotos.com/1799455/1376/i/600/depositphotos_13767777-stock-photo-cheddar-cheese-slices-on-white.jpg'),
(42, 'https://lh3.googleusercontent.com/proxy/Vr5jEgCHfAFznpR8TxhvvUM95R3kvxlGM2_HMCROCbb0iFXfmeF3wwM77HJs97RBNgrvMyj6xOVFCTIb2mAW8dFyLzzJ7TaPIrQp9m-cpKbY5saFIf_6PnBN'),
(43, 'https://cocinatis.com/media/photologue/photos/cache/tipos-levadura-3_large_16x9.jpg'),
(44, 'https://mercanet.com.ar/server/Portal_0019782/img/products/aceite-de-girasol-natura-900-ml_9308413.jpg'),
(45, 'https://www.solocarnes.com/wp-content/uploads/2019/02/como-pelar-un-pimiento.jpg'),
(46, 'https://arc-anglerfish-arc2-prod-infobae.s3.amazonaws.com/public/FJKXKQKMMJBV7KQ7XQ3YNFO7LU.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE `localidad` (
  `id_localidad` int(11) NOT NULL,
  `eliminado_localidad` bit(1) DEFAULT NULL,
  `nombre_localidad` varchar(255) DEFAULT NULL,
  `fk_id_provincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `localidad`
--

INSERT INTO `localidad` (`id_localidad`, `eliminado_localidad`, `nombre_localidad`, `fk_id_provincia`) VALUES
(1, b'0', 'Guaymallen', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL,
  `eliminado_pais` bit(1) DEFAULT NULL,
  `nombre_pais` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `eliminado_pais`, `nombre_pais`) VALUES
(1, b'0', 'Argentina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `eliminado_pedido` bit(1) DEFAULT NULL,
  `estado_pedido` varchar(255) DEFAULT NULL,
  `fecha_pedido` varchar(100) DEFAULT NULL,
  `horaEstimadaFin_pedido` varchar(255) DEFAULT NULL,
  `montoDescuento_pedido` double DEFAULT NULL,
  `nro_pedido` int(11) DEFAULT NULL,
  `tipoEnvio_pedido` varchar(255) DEFAULT NULL,
  `total_pedido` double DEFAULT NULL,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_domicilioCliente` int(11) DEFAULT NULL,
  `formaPago_pedido` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `eliminado_pedido`, `estado_pedido`, `fecha_pedido`, `horaEstimadaFin_pedido`, `montoDescuento_pedido`, `nro_pedido`, `tipoEnvio_pedido`, `total_pedido`, `fk_id_cliente`, `fk_id_domicilioCliente`, `formaPago_pedido`) VALUES
(4, b'0', 'Facturado', '04/10/2020 02:00:03', NULL, 0, 0, 'Delivery', 370, 1, 9, NULL),
(5, b'0', 'Facturado', '04/10/2020 02:45:58', NULL, 0, 0, 'Retiro en local', 370, 1, NULL, NULL),
(6, b'0', 'Facturado', '04/10/2020 0:17:11', '4/10/2020 1:12:11', 0, 0, 'Delivery', 620, 1, 11, NULL),
(7, b'0', 'Facturado', '09/10/2020 19:23:08', '09/10/2020 20:55:00', 37, 0, 'Retiro en local', 333, 1, NULL, NULL),
(8, b'0', 'Facturado', '09/10/2020 22:25:37', '9/10/2020 23:20:37', 0, 0, 'Delivery', 370, 1, 11, NULL),
(9, b'0', 'Facturado', '20/11/2020 23:14:29', '20/11/2020 23:54:29', 44, 0, 'Retiro en local', 396, 1, NULL, NULL),
(10, b'0', 'Facturado', '23/11/2020 14:45:21', '23/11/2020 21:10:00', 0, 0, 'Delivery', 560, 1, 11, NULL),
(11, b'0', 'Facturado', '26/11/2020 14:45:19', '26/11/2020 21:00:00', 72, 0, 'Retiro en local', 648, 1, NULL, NULL),
(12, b'0', 'Facturado', '26/11/2020 18:14:49', '26/11/2020 20:55:00', 0, 0, 'Delivery', 370, 1, 11, 'Contado'),
(13, b'0', 'Facturado', '29/11/2020 18:40:36', '29/11/2020 20:45:00', 73, 0, 'Retiro en local', 657, 1, NULL, 'Débito'),
(14, b'0', 'Facturado', '29/11/2020 19:21:31', '29/11/2020 21:00:00', 66, 0, 'Retiro en local', 594, 1, NULL, 'Débito'),
(15, b'0', 'Facturado', '29/11/2020 19:38:08', '29/11/2020 20:40:00', 44, 0, 'Retiro en local', 396, 1, 11, 'Contado'),
(16, b'0', 'Facturado', '29/11/2020 19:50:59', '29/11/2020 20:35:00', 57, 0, 'Retiro en local', 513, 1, NULL, 'Débito'),
(17, b'0', 'Facturado', '29/11/2020 20:04:28', '29/11/2020 20:44:28', 64, 0, 'Retiro en local', 576, 1, NULL, 'Débito'),
(18, b'0', 'Rechazado', '29/11/2020 20:44:15', '29/11/2020 21:24:15', 84, 0, 'Retiro en local', 756, 1, NULL, 'Contado'),
(19, b'0', 'Facturado', '30/11/2020 20:35:50', '30/11/2020 20:55:50', 32, 0, 'Retiro en local', 288, 1, NULL, 'Contado'),
(20, b'0', 'Facturado', '30/11/2020 20:38:23', '30/11/2020 21:33:23', 0, 0, 'Delivery', 440, 1, 11, 'Contado'),
(21, b'0', 'Facturado', '30/11/2020 20:44:16', '30/11/2020 21:34:16', 0, 0, 'Delivery', 370, 1, 9, 'Contado'),
(22, b'0', 'Facturado', '30/11/2020 20:50:13', '30/11/2020 20:52:13', 0, 0, 'Delivery', 690, 1, 11, 'Contado'),
(23, b'0', 'Facturado', '30/11/2020 21:28:20', '30/11/2020 23:53:20', 0, 0, 'Delivery', 440, 1, 11, 'Contado'),
(24, b'0', 'Facturado', '30/11/2020 21:30:53', '30/11/2020 23:45:53', 44, 0, 'Retiro en local', 396, 1, NULL, 'Contado'),
(25, b'0', 'Facturado', '1/12/2020 23:03:57', '01/12/2020 23:43:57', 73, 0, 'Retiro en local', 657, 1, NULL, 'Contado'),
(26, b'0', 'Facturado', '14/12/2020 20:05:11', '14/12/2020 20:55:11', 70, 0, 'Retiro en local', 630, 1, NULL, 'Contado'),
(27, b'0', 'Facturado', '14/12/2020 23:24:45', '15/12/2020 00:29:45', 82, 0, 'Retiro en local', 738, 1, NULL, 'Contado'),
(28, b'0', 'Facturado', '14/12/2020 23:44:11', '14/12/2020 23:44:11', 12, 0, 'Retiro en local', 108, 1, NULL, 'Contado'),
(29, b'0', 'Facturado', '14/12/2020 23:49:05', '14/12/2020 23:49:05', 12, 0, 'Retiro en local', 108, 1, NULL, 'Contado'),
(30, b'0', 'Facturado', '15/12/2020 0:27:23', '15/12/2020 00:27:23', 12, 0, 'Retiro en local', 108, 1, NULL, 'Contado'),
(31, b'0', 'Facturado', '15/12/2020 15:07:09', '15/12/2020 15:57:09', 70, 0, 'Retiro en local', 630, 1, 11, 'Contado'),
(32, b'0', 'Facturado', '15/12/2020 15:13:36', '15/12/2020 15:33:36', 62, 0, 'Retiro en local', 558, 1, NULL, 'Contado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidodetalle`
--

CREATE TABLE `pedidodetalle` (
  `id_pedidoDetalle` int(11) NOT NULL,
  `cantidad_pedidoDetalle` int(11) DEFAULT NULL,
  `subtotal_pedidoDetalle` double DEFAULT NULL,
  `fk_id_factura` int(11) DEFAULT NULL,
  `fk_id_insumo` int(11) DEFAULT NULL,
  `fk_id_manufacturado` int(11) DEFAULT NULL,
  `fk_id_pedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedidodetalle`
--

INSERT INTO `pedidodetalle` (`id_pedidoDetalle`, `cantidad_pedidoDetalle`, `subtotal_pedidoDetalle`, `fk_id_factura`, `fk_id_insumo`, `fk_id_manufacturado`, `fk_id_pedido`) VALUES
(1, 1, 0, 20, 1, NULL, 4),
(2, 1, 120, 21, 1, NULL, 5),
(3, 2, 500, 16, NULL, 1, 6),
(4, 1, 120, 16, 1, NULL, 6),
(5, 1, 0, 5, NULL, 12, 7),
(6, 1, 0, 5, 1, NULL, 7),
(7, 1, 0, 1, NULL, 1, 8),
(8, 1, 0, 1, 1, NULL, 8),
(29, 1, 0, 1, NULL, 12, 8),
(30, 1, 320, 23, NULL, 12, 9),
(31, 1, 120, 23, 1, NULL, 9),
(32, 1, 0, 17, NULL, 12, 10),
(33, 2, 0, 17, 1, NULL, 10),
(34, 1, 0, 19, NULL, 13, 11),
(35, 1, 0, 19, NULL, 12, 11),
(36, 1, 0, 19, 1, NULL, 11),
(37, 1, 0, 19, 12, NULL, 11),
(38, 1, 0, 18, NULL, 1, 12),
(39, 1, 0, 18, 1, NULL, 12),
(40, 1, 250, 22, NULL, 1, 13),
(41, 1, 200, 22, NULL, 13, 13),
(42, 2, 280, 22, 13, NULL, 13),
(43, 2, 240, 22, 1, NULL, 13),
(44, 2, 160, 23, 12, NULL, 9),
(45, 1, 200, 24, NULL, 13, 14),
(46, 1, 320, 24, NULL, 12, 14),
(47, 1, 140, 24, 13, NULL, 14),
(48, 2, 240, 24, 1, NULL, 14),
(49, 1, 320, 25, NULL, 12, 15),
(50, 1, 120, 25, 8, NULL, 15),
(51, 1, 120, 5, 1, NULL, 15),
(52, 1, 250, 26, NULL, 1, 16),
(53, 1, 200, 26, NULL, 13, 16),
(54, 1, 120, 26, 1, NULL, 16),
(55, 1, 320, 27, NULL, 12, 17),
(56, 1, 200, 27, NULL, 13, 17),
(57, 1, 120, 27, 8, NULL, 17),
(58, 2, 240, 27, 1, NULL, 17),
(59, 2, 640, NULL, NULL, 12, 18),
(60, 1, 120, NULL, 8, NULL, 18),
(61, 1, 80, NULL, 12, NULL, 18),
(62, 1, 200, 28, NULL, 13, 19),
(63, 1, 120, 28, 8, NULL, 19),
(64, 1, 320, 29, NULL, 12, 20),
(65, 1, 120, 29, 8, NULL, 20),
(66, 1, 250, 31, NULL, 1, 21),
(67, 1, 120, 31, 8, NULL, 21),
(68, 1, 320, 30, NULL, 12, 22),
(69, 1, 120, 30, 1, NULL, 22),
(70, 1, 250, 30, NULL, 1, 22),
(71, 1, 320, 32, NULL, 12, 23),
(72, 1, 120, 32, 9, NULL, 23),
(73, 1, 320, 33, NULL, 12, 24),
(74, 1, 120, 33, 9, NULL, 24),
(75, 2, 240, 28, 1, NULL, 19),
(76, 2, 240, 28, 1, NULL, 19),
(77, 2, 160, 28, 12, NULL, 19),
(78, 1, 120, 33, 8, NULL, 24),
(79, 1, 120, 33, 8, NULL, 24),
(80, 1, 200, 33, NULL, 13, 24),
(81, 1, 200, 34, NULL, 13, 25),
(82, 1, 250, 34, NULL, 1, 25),
(83, 2, 160, 34, 12, NULL, 25),
(84, 2, 240, 34, 8, NULL, 25),
(92, 1, 120, 34, 1, NULL, 25),
(93, 1, 200, 35, NULL, 13, 26),
(94, 1, 300, 35, NULL, 15, 26),
(95, 1, 120, 35, 8, NULL, 26),
(96, 1, 80, 35, 12, NULL, 26),
(97, 1, 320, 36, NULL, 12, 27),
(98, 1, 300, 36, NULL, 15, 27),
(99, 2, 240, 36, 8, NULL, 27),
(100, 1, 80, 36, 12, NULL, 27),
(101, 2, 240, 37, 8, NULL, 28),
(102, 1, 240, 37, 9, NULL, 28),
(103, 3, 360, 38, 9, NULL, 29),
(104, 1, 180, 38, 10, NULL, 29),
(105, 2, 200, 38, 11, NULL, 29),
(106, 3, 360, 39, 9, NULL, 30),
(107, 2, 180, 39, 10, NULL, 30),
(108, 1, 80, 39, 12, NULL, 30),
(109, 1, 200, 40, NULL, 13, 31),
(110, 1, 300, 40, NULL, 15, 31),
(111, 1, 120, 40, 9, NULL, 31),
(112, 1, 80, 40, 12, NULL, 31),
(113, 2, 500, 41, NULL, 1, 32),
(114, 1, 120, 41, 1, NULL, 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `discriminator` varchar(31) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `apellido_persona` varchar(255) DEFAULT NULL,
  `dni_persona` bigint(20) DEFAULT NULL,
  `eliminado_persona` bit(1) DEFAULT NULL,
  `email_persona` varchar(255) DEFAULT NULL,
  `fechaAlta_persona` varchar(255) DEFAULT NULL,
  `fechaNac_persona` varchar(255) DEFAULT NULL,
  `nombre_persona` varchar(255) DEFAULT NULL,
  `pass_persona` varchar(255) DEFAULT NULL,
  `telefono_persona` varchar(255) DEFAULT NULL,
  `fk_id_imagen` int(11) DEFAULT NULL,
  `fk_id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`discriminator`, `id_persona`, `apellido_persona`, `dni_persona`, `eliminado_persona`, `email_persona`, `fechaAlta_persona`, `fechaNac_persona`, `nombre_persona`, `pass_persona`, `telefono_persona`, `fk_id_imagen`, `fk_id_rol`) VALUES
('cliente', 1, 'Duran', 38757903, b'0', 'andretatiduran@gmail.com', '24/08/2020', '1994-12-11', 'Tatiana', 'tati38757903', '2615551370', 1, NULL),
('cliente', 2, 'Duran', 0, b'1', 'tatisduran94@gmail.com', '24/08/2020', NULL, 'Andrea', NULL, NULL, 1, NULL),
('empleado', 3, 'Perez', 1111111, b'0', 'admin@elbuensabor.com', '25/10/2020', NULL, 'Raul', 'admin1234', NULL, NULL, 1),
('empleado', 4, 'Gomez', 1111111, b'0', 'cajero@elbuensabor.com', '26/10/2020', NULL, 'Mariana', 'cajero1234', NULL, NULL, 3),
('empleado', 5, 'Lopez', 1111111, b'0', 'cocinero@elbuensabor.com', '26/10/2020', NULL, 'Lucas', 'cocinero1234', NULL, NULL, 2),
('empleado', 6, 'Vargas', 12312123, b'1', 'dasdasd@asdasd', NULL, '2020-10-02', 'Jose', 'aasdasdas', NULL, NULL, 1),
('empleado', 7, 'Ruiz', 123124123, b'1', 'afasdfdf@afsdf', NULL, '2020-10-02', 'Marcos', 'asdfsadfsad', '123124124', NULL, 3),
('empleado', 8, 'Lopez', 123456789, b'1', 'cocineroAdj@elbuensabor.com', '27/10/2020', '2020-10-01', 'Gabriel', 'cocineroAdj', '123456789', NULL, 2),
('empleado', 9, 'Lopez', 123123123, b'1', 'cajeroSupl@elbuensabor.com', '27/10/2020', '2020-10-10', 'Mauro', 'cajeroSupl', '1223123123', NULL, 3),
('cliente', 10, 'Duran', 38757903, b'0', 'cliente@gmail.com', '25/11/2020', '1994-12-11', 'Andrea', 'cliente1234', '2614320714', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL,
  `eliminado_provincia` bit(1) DEFAULT NULL,
  `nombre_provincia` varchar(255) DEFAULT NULL,
  `fk_id_pais` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id_provincia`, `eliminado_provincia`, `nombre_provincia`, `fk_id_pais`) VALUES
(1, b'0', 'Mendoza', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `eliminado_rol` bit(1) DEFAULT NULL,
  `nombre_rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `eliminado_rol`, `nombre_rol`) VALUES
(1, b'0', 'administrador'),
(2, b'0', 'cocinero'),
(3, b'0', 'cajero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidaddemedida`
--

CREATE TABLE `unidaddemedida` (
  `id_unidadDeMedida` int(11) NOT NULL,
  `abreviatura_unidadDeMedida` varchar(255) DEFAULT NULL,
  `eliminado_unidadDeMedida` bit(1) DEFAULT NULL,
  `nombre_unidadDeMedida` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `unidaddemedida`
--

INSERT INTO `unidaddemedida` (`id_unidadDeMedida`, `abreviatura_unidadDeMedida`, `eliminado_unidadDeMedida`, `nombre_unidadDeMedida`) VALUES
(1, 'g', b'0', 'gramos'),
(2, 'Kg', b'0', 'kilogramos'),
(3, 'ml', b'0', 'mililitros'),
(4, 'L', b'0', 'litros'),
(5, 'u', b'0', 'unidad');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articuloinsumo`
--
ALTER TABLE `articuloinsumo`
  ADD PRIMARY KEY (`id_articuloInsumo`),
  ADD KEY `FKdkpd7cj4hlool8t6daulx387x` (`fk_id_categoriaInsumo`),
  ADD KEY `FK2pde1ltlho834afsildioat6r` (`fk_id_imagen`),
  ADD KEY `FK7p04lww63l7phey7n4ybb5onw` (`fk_id_unidadDeMedida`);

--
-- Indices de la tabla `articulomanufacturado`
--
ALTER TABLE `articulomanufacturado`
  ADD PRIMARY KEY (`id_articuloManufacturado`),
  ADD KEY `FKk0u42x65mjmfgvvah2okx3k7g` (`fk_id_categoriaGeneral`),
  ADD KEY `FK9hplahox25lqc0yrhmrjnqepk` (`fk_id_imagen`);

--
-- Indices de la tabla `articulomanufacturadodetalle`
--
ALTER TABLE `articulomanufacturadodetalle`
  ADD PRIMARY KEY (`id_articuloManufacturadoDetalle`),
  ADD KEY `FK1vw2j28r4epoj78jpn8okbgmd` (`fk_id_articuloInsumo`),
  ADD KEY `FK2eq4dsa0i2k8ljwd9u6el2rh` (`fk_id_articuloManufacturado`);

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id_carrito`),
  ADD KEY `FK3ejxjygf86wcb9atqh0n1ca30` (`fk_id_cliente`),
  ADD KEY `FKegdhyrubavtd9vaxrqwnatmyq` (`fk_id_domicilioCliente`);

--
-- Indices de la tabla `carritodetalle`
--
ALTER TABLE `carritodetalle`
  ADD PRIMARY KEY (`id_carritoDetalle`),
  ADD KEY `FK9kxa2ckmxr9xhrxaa9iyv0j73` (`fk_id_carrito`),
  ADD KEY `FKj1qrg0t6t26prn4lf859xrp43` (`fk_id_insumo`),
  ADD KEY `FKivpxt2amp46xxpydupu7lald0` (`fk_id_manufacturado`);

--
-- Indices de la tabla `categoriageneral`
--
ALTER TABLE `categoriageneral`
  ADD PRIMARY KEY (`id_categoriaGeneral`);

--
-- Indices de la tabla `categoriainsumo`
--
ALTER TABLE `categoriainsumo`
  ADD PRIMARY KEY (`id_categoriaInsumo`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`id_configuracion`);

--
-- Indices de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD PRIMARY KEY (`id_domicilio`),
  ADD KEY `FKjrhvrlejkldg9hyn9o34e579r` (`fk_id_cliente`),
  ADD KEY `FKds6ntjad4aojgusexwaag0f3f` (`fk_id_empleado`),
  ADD KEY `FKo2py7eoshjjdhb1362rx6lytr` (`fk_id_localidad`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `FK84wyrq94pp5n8m8xpl44c5cmv` (`fk_id_cliente`),
  ADD KEY `FKpoax3l34m9yfqqygdmmt1r33u` (`fk_id_pedido`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id_imagen`);

--
-- Indices de la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD PRIMARY KEY (`id_localidad`),
  ADD KEY `FKpk02xjkuf20ty1o15f88feeo6` (`fk_id_provincia`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FKr8k130p6m8feb9qnyhl0ee9l7` (`fk_id_cliente`),
  ADD KEY `FK15l0paqj76nvmce3mlaehmy4m` (`fk_id_domicilioCliente`);

--
-- Indices de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  ADD PRIMARY KEY (`id_pedidoDetalle`),
  ADD KEY `FKsv7ih4nxux0qir4aat5sx5cgg` (`fk_id_factura`),
  ADD KEY `FK9r5866fa9bceb8ss0gw8n73hp` (`fk_id_insumo`),
  ADD KEY `FKafeefylu20jsf8ws5tfn9t3me` (`fk_id_manufacturado`),
  ADD KEY `FKa91cuen933rcf8wnciopi81yx` (`fk_id_pedido`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD UNIQUE KEY `UK_kis38vq9wd0tatylrk56h5i8v` (`email_persona`),
  ADD KEY `FKjyql4w2q62mgcp1q8ld0omf9g` (`fk_id_imagen`),
  ADD KEY `FKigqfqsmm259mcianf3gw11yc8` (`fk_id_rol`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id_provincia`),
  ADD KEY `FKh66g7aco8j48kkcytadmcsq3j` (`fk_id_pais`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `unidaddemedida`
--
ALTER TABLE `unidaddemedida`
  ADD PRIMARY KEY (`id_unidadDeMedida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articuloinsumo`
--
ALTER TABLE `articuloinsumo`
  MODIFY `id_articuloInsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `articulomanufacturado`
--
ALTER TABLE `articulomanufacturado`
  MODIFY `id_articuloManufacturado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `articulomanufacturadodetalle`
--
ALTER TABLE `articulomanufacturadodetalle`
  MODIFY `id_articuloManufacturadoDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT de la tabla `carrito`
--
ALTER TABLE `carrito`
  MODIFY `id_carrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT de la tabla `carritodetalle`
--
ALTER TABLE `carritodetalle`
  MODIFY `id_carritoDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;

--
-- AUTO_INCREMENT de la tabla `categoriageneral`
--
ALTER TABLE `categoriageneral`
  MODIFY `id_categoriaGeneral` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `categoriainsumo`
--
ALTER TABLE `categoriainsumo`
  MODIFY `id_categoriaInsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `id_configuracion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  MODIFY `id_domicilio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id_imagen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `localidad`
--
ALTER TABLE `localidad`
  MODIFY `id_localidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id_pais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  MODIFY `id_pedidoDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id_provincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `unidaddemedida`
--
ALTER TABLE `unidaddemedida`
  MODIFY `id_unidadDeMedida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articuloinsumo`
--
ALTER TABLE `articuloinsumo`
  ADD CONSTRAINT `FK2pde1ltlho834afsildioat6r` FOREIGN KEY (`fk_id_imagen`) REFERENCES `imagen` (`id_imagen`),
  ADD CONSTRAINT `FK7p04lww63l7phey7n4ybb5onw` FOREIGN KEY (`fk_id_unidadDeMedida`) REFERENCES `unidaddemedida` (`id_unidadDeMedida`),
  ADD CONSTRAINT `FKdkpd7cj4hlool8t6daulx387x` FOREIGN KEY (`fk_id_categoriaInsumo`) REFERENCES `categoriainsumo` (`id_categoriaInsumo`);

--
-- Filtros para la tabla `articulomanufacturado`
--
ALTER TABLE `articulomanufacturado`
  ADD CONSTRAINT `FK9hplahox25lqc0yrhmrjnqepk` FOREIGN KEY (`fk_id_imagen`) REFERENCES `imagen` (`id_imagen`),
  ADD CONSTRAINT `FKk0u42x65mjmfgvvah2okx3k7g` FOREIGN KEY (`fk_id_categoriaGeneral`) REFERENCES `categoriageneral` (`id_categoriaGeneral`);

--
-- Filtros para la tabla `articulomanufacturadodetalle`
--
ALTER TABLE `articulomanufacturadodetalle`
  ADD CONSTRAINT `FK1vw2j28r4epoj78jpn8okbgmd` FOREIGN KEY (`fk_id_articuloInsumo`) REFERENCES `articuloinsumo` (`id_articuloInsumo`),
  ADD CONSTRAINT `FK2eq4dsa0i2k8ljwd9u6el2rh` FOREIGN KEY (`fk_id_articuloManufacturado`) REFERENCES `articulomanufacturado` (`id_articuloManufacturado`);

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `FK3ejxjygf86wcb9atqh0n1ca30` FOREIGN KEY (`fk_id_cliente`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `FKegdhyrubavtd9vaxrqwnatmyq` FOREIGN KEY (`fk_id_domicilioCliente`) REFERENCES `domicilio` (`id_domicilio`);

--
-- Filtros para la tabla `carritodetalle`
--
ALTER TABLE `carritodetalle`
  ADD CONSTRAINT `FK9kxa2ckmxr9xhrxaa9iyv0j73` FOREIGN KEY (`fk_id_carrito`) REFERENCES `carrito` (`id_carrito`),
  ADD CONSTRAINT `FKivpxt2amp46xxpydupu7lald0` FOREIGN KEY (`fk_id_manufacturado`) REFERENCES `articulomanufacturado` (`id_articuloManufacturado`),
  ADD CONSTRAINT `FKj1qrg0t6t26prn4lf859xrp43` FOREIGN KEY (`fk_id_insumo`) REFERENCES `articuloinsumo` (`id_articuloInsumo`);

--
-- Filtros para la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD CONSTRAINT `FKds6ntjad4aojgusexwaag0f3f` FOREIGN KEY (`fk_id_empleado`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `FKjrhvrlejkldg9hyn9o34e579r` FOREIGN KEY (`fk_id_cliente`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `FKo2py7eoshjjdhb1362rx6lytr` FOREIGN KEY (`fk_id_localidad`) REFERENCES `localidad` (`id_localidad`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `FK84wyrq94pp5n8m8xpl44c5cmv` FOREIGN KEY (`fk_id_cliente`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `FKpoax3l34m9yfqqygdmmt1r33u` FOREIGN KEY (`fk_id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Filtros para la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD CONSTRAINT `FKpk02xjkuf20ty1o15f88feeo6` FOREIGN KEY (`fk_id_provincia`) REFERENCES `provincia` (`id_provincia`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK15l0paqj76nvmce3mlaehmy4m` FOREIGN KEY (`fk_id_domicilioCliente`) REFERENCES `domicilio` (`id_domicilio`),
  ADD CONSTRAINT `FKr8k130p6m8feb9qnyhl0ee9l7` FOREIGN KEY (`fk_id_cliente`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `pedidodetalle`
--
ALTER TABLE `pedidodetalle`
  ADD CONSTRAINT `FK9r5866fa9bceb8ss0gw8n73hp` FOREIGN KEY (`fk_id_insumo`) REFERENCES `articuloinsumo` (`id_articuloInsumo`),
  ADD CONSTRAINT `FKa91cuen933rcf8wnciopi81yx` FOREIGN KEY (`fk_id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `FKafeefylu20jsf8ws5tfn9t3me` FOREIGN KEY (`fk_id_manufacturado`) REFERENCES `articulomanufacturado` (`id_articuloManufacturado`),
  ADD CONSTRAINT `FKsv7ih4nxux0qir4aat5sx5cgg` FOREIGN KEY (`fk_id_factura`) REFERENCES `factura` (`id_factura`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `FKigqfqsmm259mcianf3gw11yc8` FOREIGN KEY (`fk_id_rol`) REFERENCES `rol` (`id_rol`),
  ADD CONSTRAINT `FKjyql4w2q62mgcp1q8ld0omf9g` FOREIGN KEY (`fk_id_imagen`) REFERENCES `imagen` (`id_imagen`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `FKh66g7aco8j48kkcytadmcsq3j` FOREIGN KEY (`fk_id_pais`) REFERENCES `pais` (`id_pais`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
