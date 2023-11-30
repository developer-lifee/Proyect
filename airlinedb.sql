-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2023 a las 07:25:15
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `airlinedb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airlines`
--

CREATE TABLE `airlines` (
  `AirlineID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Code` varchar(10) NOT NULL,
  `CountryOfOrigin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `airlines`
--

INSERT INTO `airlines` (`AirlineID`, `Name`, `Code`, `CountryOfOrigin`) VALUES
(1, 'Wingo', 'WGO', 'Colombia'),
(2, 'Avianca', 'AV', 'Colombia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flights`
--

CREATE TABLE `flights` (
  `FlightID` int(11) NOT NULL,
  `AirlineID` int(11) DEFAULT NULL,
  `FlightCode` varchar(10) NOT NULL,
  `DepartureAirport` varchar(100) NOT NULL,
  `ArrivalAirport` varchar(100) NOT NULL,
  `DepartureTime` datetime NOT NULL,
  `ArrivalTime` datetime NOT NULL,
  `Price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flights`
--

INSERT INTO `flights` (`FlightID`, `AirlineID`, `FlightCode`, `DepartureAirport`, `ArrivalAirport`, `DepartureTime`, `ArrivalTime`, `Price`) VALUES
(1, 1, 'WGO123', 'Bogotá', 'Miami', '2023-11-01 08:00:00', '2023-11-01 12:00:00', 300.00),
(2, 2, 'AV456', 'Bogotá', 'New York', '2023-11-02 09:00:00', '2023-11-02 13:00:00', 400.00),
(4, 1, 'WG101', 'Medellín', 'Bogotá', '2023-11-01 09:00:00', '2023-11-01 10:30:00', 180.00),
(5, 1, 'WG102', 'Cali', 'Medellín', '2023-11-01 12:00:00', '2023-11-01 13:30:00', 190.00),
(6, 2, 'AV200', 'Bogotá', 'Cali', '2023-11-01 08:00:00', '2023-11-01 09:20:00', 250.00),
(7, 2, 'AV201', 'Bogotá', 'Pereira', '2023-11-01 11:00:00', '2023-11-01 12:15:00', 220.00),
(8, 1, 'WG103', 'Cartagena', 'Santa Marta', '2023-11-01 14:00:00', '2023-11-01 14:45:00', 150.00),
(9, 2, 'AV202', 'Pereira', 'Bucaramanga', '2023-11-01 16:00:00', '2023-11-01 17:20:00', 230.00),
(10, 2, 'AV203', 'Medellín', 'Barranquilla', '2023-11-01 18:00:00', '2023-11-01 19:30:00', 260.00),
(11, 1, 'WG104', 'Bucaramanga', 'Cali', '2023-11-02 06:00:00', '2023-11-02 07:40:00', 210.00),
(12, 1, 'WG105', 'Santa Marta', 'Medellín', '2023-11-02 08:00:00', '2023-11-02 09:30:00', 180.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservations`
--

CREATE TABLE `reservations` (
  `ReservationID` int(11) NOT NULL,
  `FlightID` int(11) DEFAULT NULL,
  `ReservationDate` datetime DEFAULT NULL,
  `SeatNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservations`
--

INSERT INTO `reservations` (`ReservationID`, `FlightID`, `ReservationDate`, `SeatNumber`) VALUES
(13, 1, '2023-11-29 23:53:09', ''),
(14, 1, '2023-11-29 23:53:09', ''),
(38, 4, '2023-11-30 01:02:02', ''),
(53, 1, NULL, '1H'),
(54, 1, NULL, '1I'),
(55, 3, NULL, '3H'),
(56, 3, NULL, '3I'),
(57, 3, NULL, '3J'),
(58, 4, NULL, '4H'),
(59, 4, NULL, '4I'),
(60, 4, NULL, '4J'),
(61, 5, NULL, '5H'),
(62, 5, NULL, '5I'),
(63, 5, NULL, '5J'),
(64, 6, NULL, '6H'),
(65, 6, NULL, '6I'),
(66, 6, NULL, '6J'),
(67, 7, NULL, '7H'),
(68, 7, NULL, '7I'),
(69, 7, NULL, '7K'),
(70, 8, NULL, '8H'),
(71, 8, NULL, '8I'),
(72, 9, NULL, '9H'),
(73, 9, NULL, '9I'),
(74, 10, NULL, '10H'),
(75, 10, NULL, '10I'),
(76, 11, NULL, '11H'),
(77, 11, NULL, '11I'),
(78, 11, '2023-11-30 01:18:19', '11A'),
(79, 11, '2023-11-30 01:18:19', '11B'),
(80, 11, '2023-11-30 01:18:19', '11C'),
(81, 11, NULL, '11D'),
(82, 11, NULL, '11E'),
(83, 11, NULL, '11F'),
(84, 11, NULL, '11G'),
(85, 12, '2023-11-30 01:18:19', '12A'),
(86, 12, '2023-11-30 01:18:19', '12B'),
(87, 12, '2023-11-30 01:18:19', '12C'),
(88, 12, NULL, '12D'),
(89, 12, NULL, '12E'),
(90, 12, NULL, '12F'),
(91, 12, NULL, '12G');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `airlines`
--
ALTER TABLE `airlines`
  ADD PRIMARY KEY (`AirlineID`),
  ADD UNIQUE KEY `Code` (`Code`);

--
-- Indices de la tabla `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`FlightID`),
  ADD KEY `AirlineID` (`AirlineID`);

--
-- Indices de la tabla `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`ReservationID`),
  ADD KEY `FlightID` (`FlightID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `airlines`
--
ALTER TABLE `airlines`
  MODIFY `AirlineID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `flights`
--
ALTER TABLE `flights`
  MODIFY `FlightID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `reservations`
--
ALTER TABLE `reservations`
  MODIFY `ReservationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`AirlineID`) REFERENCES `airlines` (`AirlineID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
