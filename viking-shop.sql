-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2021 at 02:56 PM
-- Server version: 8.0.25
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `viking-shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`username`, `email`, `fullname`, `password`, `photo`) VALUES
('customer', 'wolza@gmail.com', 'Zbyszek Piestrzeniewicz', '123', 'user.png'),
('director', 'wolza@gmail.com', 'Zbyszek Piestrzeniewicz', '123', 'user.png'),
('staff', 'nopt@gmail.com', 'Phạm Thị Nở', '123', 'user.png');

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `id` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `roleid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id`, `username`, `roleid`) VALUES
(7103, 'customer', 'CUST'),
(98, 'director', 'DIRE'),
(7107, 'director', 'STAF'),
(7113, 'staff', 'DIRE'),
(100, 'staff', 'STAF');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
('1000', 'Đồng hồ đeo tay'),
('1001', 'Máy tính xách tay'),
('1002', 'Máy ảnh'),
('1003', 'Điện thoại'),
('1004', 'Nước hoa'),
('1005', 'Nữ trang'),
('1006', 'Nón thời trang'),
('1007', 'Túi xách du lịch');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id` bigint NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `orderid` bigint DEFAULT NULL,
  `productid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`id`, `price`, `quantity`, `orderid`, `productid`) VALUES
(1, 19, 4, 1, 1002),
(2, 10, 1, 1, 1003),
(3, 190, 1, 1, 1001),
(4, 19, 4, 2, 1002),
(5, 10, 1, 2, 1003),
(6, 190, 1, 2, 1001),
(7, 10, 1, 3, 1003),
(8, 19, 1, 3, 1002),
(9, 190, 1, 3, 1001),
(10, 10, 4, 4, 1003),
(11, 10, 1, 5, 1003),
(12, 19, 1, 5, 1002),
(13, 190, 1, 5, 1001);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `address`, `createdate`, `username`) VALUES
(1, 'aaaaa', '2021-08-07', 'customer'),
(2, 'aaaa', '2021-08-07', 'customer'),
(3, 'Cổ đô', '2021-08-07', 'staff'),
(4, 'Ba vì', '2021-08-07', 'staff'),
(5, 'assdasda', '2021-08-07', 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `categoryid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `available`, `createdate`, `image`, `name`, `price`, `categoryid`) VALUES
(1001, b'1', '2021-07-18', '1001.jpg', 'Aniseed Syrup', 190, '1000'),
(1002, b'1', '2021-07-18', '1002.jpg', 'Change', 19, '1000'),
(1003, b'1', '2021-07-18', '1003.jpg', 'Aniseed Syrup', 10, '1001'),
(1004, b'1', '2021-07-18', '1004.jpg', 'Chef Anton\'\'s Cajun Seasoning', 22, '1001'),
(1005, b'1', '2021-07-18', '1005.jpg', 'Chef Anton\'\'s Gumbo Mix', 21.35, '1002'),
(1006, b'1', '2021-07-18', '1006.jpg', 'Grandma\'\'s Boysenberry Spread', 25, '1001'),
(1007, b'1', '2021-07-18', '1007.jpg', 'Uncle Bob\'\'s Organic Dried Pears', 30, '1006'),
(1009, b'1', '2021-07-20', '1008.jpg', 'Northwoods Cranberry Sauce', 60, '1001'),
(1040, b'1', '2021-07-25', '1014.jpg', 'Mũ lưỡi chai cực đẹp', 23, '1006'),
(1041, b'1', '2021-07-31', '1019.jpg', 'Máy ảnh canon', 100, '1002'),
(1045, b'1', '2021-08-21', '5bf61592.jpg', 'qêqewewq', 22, '1003');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
('CUST', 'CUSTOMER'),
('DIRE', 'DIRECT'),
('STAF', 'STAFF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKhtk0tjw6uf67w0vkhy5n3j1oq` (`username`,`roleid`),
  ADD KEY `FKevi9708lm1k06pa4dugc91k7v` (`roleid`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj4gc2ja2otvwemf4rho2lp3s8` (`orderid`),
  ADD KEY `FKaltatpxipsjtcih4d1h6bn0xr` (`productid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk3cjfcgb621qhahps1tre43e4` (`username`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1krrsjgcawsfg8k8u4hm5gi8q` (`categoryid`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7114;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1046;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `FKevi9708lm1k06pa4dugc91k7v` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKlw0sapcjvuxfa1kvyjw7jml88` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`);

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `FKaltatpxipsjtcih4d1h6bn0xr` FOREIGN KEY (`productid`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKj4gc2ja2otvwemf4rho2lp3s8` FOREIGN KEY (`orderid`) REFERENCES `orders` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKk3cjfcgb621qhahps1tre43e4` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK1krrsjgcawsfg8k8u4hm5gi8q` FOREIGN KEY (`categoryid`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
