-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 03, 2018 at 12:31 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `WebAuction`
--

-- --------------------------------------------------------

--
-- Table structure for table `Auction`
--

CREATE TABLE `Auction` (
  `auctionId` int(11) NOT NULL,
  `itemId` int(11) NOT NULL,
  `startPrice` double NOT NULL,
  `currentBid` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Auction`
--

INSERT INTO `Auction` (`auctionId`, `itemId`, `startPrice`, `currentBid`) VALUES
(2, 2, 76, 76),
(11, 11, 76, 700),
(12, 12, 34534, 34534),
(13, 13, 234, 234),
(14, 14, 123, 300),
(15, 15, 3423423, 12),
(17, 17, 12345, 12345),
(18, 18, 450.5, 35);

-- --------------------------------------------------------

--
-- Table structure for table `Bid`
--

CREATE TABLE `Bid` (
  `bidId` int(11) NOT NULL,
  `auctionId` int(11) NOT NULL,
  `bidderId` int(11) NOT NULL,
  `bidAmount` double NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Bid`
--

INSERT INTO `Bid` (`bidId`, `auctionId`, `bidderId`, `bidAmount`, `time`) VALUES
(4, 11, 1, 56, '25/04/2018 19:39:59'),
(5, 11, 1, 12, '25/04/2018 19:56:37'),
(6, 11, 1, 23, '25/04/2018 19:56:43'),
(7, 11, 1, 12, '25/04/2018 19:56:46'),
(8, 11, 2, 300, '25/04/2018 19:59:51'),
(9, 11, 1, 400, '25/04/2018 20:01:10'),
(10, 11, 1, 500, '25/04/2018 20:03:53'),
(11, 11, 1, 700, '26/04/2018 12:14:31'),
(12, 15, 1, 12, '26/04/2018 13:13:39'),
(13, 15, 1, 32, '26/04/2018 13:13:44'),
(14, 14, 1, 123, '26/04/2018 13:41:13'),
(15, 15, 2, 12, '26/04/2018 13:41:34'),
(16, 14, 1, 300, '26/04/2018 16:00:05'),
(17, 18, 1, 12, '26/04/2018 19:08:39'),
(18, 18, 1, 13, '26/04/2018 19:10:41'),
(19, 18, 1, 9, '26/04/2018 19:50:38'),
(20, 18, 1, 12, '26/04/2018 20:01:47'),
(21, 18, 1, 33, '26/04/2018 20:02:37'),
(22, 18, 1, 34, '26/04/2018 22:44:58'),
(23, 18, 1, 35, '01/05/2018 12:23:06');

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `catid` int(11) NOT NULL,
  `catName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`catid`, `catName`) VALUES
(1, 'Unknown'),
(2, 'Phone'),
(3, 'Vehicle'),
(4, 'Electronics');

-- --------------------------------------------------------

--
-- Table structure for table `Item`
--

CREATE TABLE `Item` (
  `itemid` int(11) NOT NULL,
  `itemname` varchar(50) NOT NULL,
  `catid` varchar(50) NOT NULL,
  `sellerid` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Item`
--

INSERT INTO `Item` (`itemid`, `itemname`, `catid`, `sellerid`) VALUES
(2, 'hkjhk', 'Ugh', '2'),
(11, 'Hi there is', 'kjhk', '1'),
(12, 'dfhgdfh', '', '1'),
(13, 'dfgdfg', '', '1'),
(14, 'Kjhjkhk', '3', '1'),
(15, 'Sdfsd', '2', '1'),
(17, 'Hello', '4', '1'),
(18, 'Iphone', '2', '1');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userid`, `name`, `username`, `password`) VALUES
(1, 'Khalid Mohamed', 'kam1002', 'arsenal'),
(2, 'Jake Smith', 'jak1002', 'fan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auction`
--
ALTER TABLE `Auction`
  ADD PRIMARY KEY (`auctionId`);

--
-- Indexes for table `Bid`
--
ALTER TABLE `Bid`
  ADD PRIMARY KEY (`bidId`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`catid`);

--
-- Indexes for table `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`itemid`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Auction`
--
ALTER TABLE `Auction`
  MODIFY `auctionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `Bid`
--
ALTER TABLE `Bid`
  MODIFY `bidId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `catid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Item`
--
ALTER TABLE `Item`
  MODIFY `itemid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
