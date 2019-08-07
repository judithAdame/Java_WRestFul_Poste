-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 02, 2019 at 03:40 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `postesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `poste`
--

CREATE TABLE `poste` (
  `id` int(5) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `langages` varchar(100) NOT NULL,
  `courriel` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poste`
--

INSERT INTO `poste` (`id`, `nom`, `langages`, `courriel`) VALUES
(2, 'Devellopeur Java', 'Java, J2EE', 'java@gmail.com'),
(3, 'Dev Front-end', 'pascal, cobol', 'dev@gmail.com'),
(4, 'Dev Back-end', 'CSS, HTML, BOOTSCRAP', 'java@gmail.com'),
(5, 'Devellopeur Java', 'JaVa, CsHarp,   js', 'abc@gmail.com'),
(6, 'Devellopeur Java', 'JaVa,   Nodejs, js', 'abc@gmail.com'),
(7, 'Devellopeur Java', 'JaVa, CsHarp,   Nodejs', 'abc@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `poste`
--
ALTER TABLE `poste`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
