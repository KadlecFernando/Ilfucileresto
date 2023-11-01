-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2023 at 04:25 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ilfucileresto`
--

-- --------------------------------------------------------

--
-- Table structure for table `detallepedido`
--

CREATE TABLE `detallepedido` (
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detallepedido`
--

INSERT INTO `detallepedido` (`idPedido`, `idProducto`, `cantidad`) VALUES
(24, 4, 1),
(24, 5, 1),
(24, 11, 1),
(24, 12, 1),
(25, 6, 1),
(25, 8, 1),
(25, 10, 1),
(25, 12, 1),
(26, 4, 4),
(26, 11, 4);

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `puesto` varchar(30) NOT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `apellido`, `nombre`, `DNI`, `puesto`, `user`, `password`, `estado`) VALUES
(4, 'Rubio', 'Loana', '42622026', 'ENCARGADO', '42622026', 'loana', 1),
(5, 'Kadlec', 'Fernando', '45782654', 'ENCARGADO', '45782654', '45782654', 1),
(6, 'Puche', 'Sebastian', '43784512', 'ENCARGADO', '43784512', '43784512', 1),
(7, 'Perez', 'Juan', '40587451', 'MESERO', '40587451', '40587451', 1),
(8, 'Rodriguez', 'Franco', '41569832', 'MESERO', '41569832', '41569832', 1),
(9, 'Sanchez', 'Marta', '37854125', 'MESERO', '37854125', '37854125', 1),
(10, 'Ramirez', 'Marcela', '36547812', 'MESERO', '36547812', '36547812', 1);

-- --------------------------------------------------------

--
-- Table structure for table `mesa`
--

CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `estadoMesa` tinyint(1) NOT NULL,
  `capacidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mesa`
--

INSERT INTO `mesa` (`idMesa`, `estadoMesa`, `capacidad`) VALUES
(1, 1, 4),
(2, 1, 6),
(3, 1, 4),
(4, 0, 6),
(5, 0, 4),
(6, 0, 4),
(7, 0, 6),
(8, 0, 2),
(9, 0, 4),
(10, 0, 6);

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `importe` double(18,2) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `pago` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idMesa`, `idEmpleado`, `fechaHora`, `importe`, `estado`, `pago`) VALUES
(24, 1, 9, '2023-11-01 00:23:24', 5750.00, 1, 0),
(25, 2, 8, '2023-11-01 00:23:56', 6950.00, 1, 0),
(26, 3, 8, '2023-11-01 00:24:19', 12000.00, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL,
  `precioUnitario` double(18,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precioUnitario`, `stock`, `estado`) VALUES
(4, 'Ravioles', 2500.00, 45, 1),
(5, 'Ñoquis', 2300.00, 49, 1),
(6, 'Papas Fritas', 2000.00, 99, 1),
(7, 'Hamburguesa', 2800.00, 80, 1),
(8, 'Ensalada', 1500.00, 49, 1),
(9, 'Puré', 1500.00, 50, 1),
(10, 'Suprema Simple', 3000.00, 99, 1),
(11, 'Gaseosa', 500.00, 195, 1),
(12, 'Agua', 450.00, 198, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`idPedido`,`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indexes for table `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`idMesa`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idMesa` (`idMesa`),
  ADD KEY `idEmpleado` (`idEmpleado`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `mesa`
--
ALTER TABLE `mesa`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`),
  ADD CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
