-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2023 at 07:52 PM
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
-- Database: `policlinico`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `dni_doctor` int(8) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `nombre_doc` varchar(100) NOT NULL,
  `apellido_doc` varchar(100) NOT NULL,
  `comentario` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`dni_doctor`, `especialidad`, `nombre_doc`, `apellido_doc`, `comentario`) VALUES
(986234212, 'Medicina General', 'Diego', 'Miera', 'El doctor es impulsivo compulsivo');

-- --------------------------------------------------------

--
-- Table structure for table `historial`
--

CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `numero_historial` varchar(50) DEFAULT NULL,
  `antecedentes_medicos` text DEFAULT NULL,
  `historial_enfermedades` text DEFAULT NULL,
  `notas_visitas` text DEFAULT NULL,
  `plan_tratamiento_actual` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `p_dni` int(8) NOT NULL,
  `p_nombres` varchar(100) NOT NULL,
  `p_apellidos` varchar(100) NOT NULL,
  `p_fecha_nacimiento` date NOT NULL,
  `p_genero` varchar(20) NOT NULL,
  `p_telefono` int(9) NOT NULL,
  `p_emergencia_contacto` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`p_dni`, `p_nombres`, `p_apellidos`, `p_fecha_nacimiento`, `p_genero`, `p_telefono`, `p_emergencia_contacto`) VALUES
(7600576, 'Roger', 'Miera', '1946-03-12', 'Masculino', 997556223, 223112333),
(70931241, 'Miera', 'Miera', '2002-02-26', 'Masculino', 910265145, 941569154),
(70941283, 'Elsa', 'Maria', '1996-02-02', 'Femenino', 97622346, 333333333),
(88899965, 'ddefed', 'defds', '1990-09-12', 'Masculino', 999888777, 222111333);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`dni_doctor`);

--
-- Indexes for table `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`p_dni`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `dni_doctor` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=986234213;

--
-- AUTO_INCREMENT for table `historial`
--
ALTER TABLE `historial`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `p_dni` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88899966;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`p_dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
