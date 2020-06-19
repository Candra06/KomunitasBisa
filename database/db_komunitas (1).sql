-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 19, 2020 at 09:34 PM
-- Server version: 5.7.30-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_komunitas`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `level` enum('admin_sistem','admin_komunitas','user') DEFAULT NULL,
  `status` enum('aktif','banned') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `email`, `password`, `level`, `status`, `create_at`) VALUES
(3, 'sadfasdf', '1', 'user', 'aktif', '2020-06-17 00:15:49'),
(4, 'admin@gmail', '1', 'admin_sistem', 'aktif', '2020-06-17 00:17:59'),
(5, 'komunitas@gmail', '1', 'admin_komunitas', 'aktif', '2020-06-17 00:25:20'),
(6, 'user@gmail', '1', 'user', 'aktif', '2020-06-17 00:28:04'),
(7, 'abiyu@gmail', '1', 'user', 'aktif', '2020-06-17 00:31:13'),
(8, '123', '123', 'user', 'aktif', '2020-06-17 00:34:00'),
(9, '123', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:17:17'),
(10, '456', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:17:17'),
(11, '789', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:17:17'),
(12, '012', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:17:17'),
(13, '123', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:26:46'),
(14, '456', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:26:46'),
(15, '789', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:26:46'),
(16, '012', 'adminkomunitasbisa123', 'user', 'aktif', '2020-06-17 14:26:47');

-- --------------------------------------------------------

--
-- Table structure for table `donasi`
--

CREATE TABLE `donasi` (
  `id` int(11) NOT NULL,
  `id_event` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `jumlah_donasi` int(8) DEFAULT NULL,
  `bukti_donasi` varchar(30) DEFAULT NULL,
  `status` enum('terima','tolak','diteruskan') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `id_komunitas` int(11) DEFAULT NULL,
  `judul_event` varchar(35) DEFAULT NULL,
  `tanggal` datetime DEFAULT NULL,
  `poster` varchar(50) DEFAULT NULL,
  `deskripsi` text,
  `jmlh_donasi` int(8) DEFAULT NULL,
  `jmlh_volunteer` int(2) DEFAULT NULL,
  `status` enum('selesai','on_going','cancel') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `id_komunitas`, `judul_event`, `tanggal`, `poster`, `deskripsi`, `jmlh_donasi`, `jmlh_volunteer`, `status`, `create_at`, `update_at`) VALUES
(6, 2, 'ashdhs', '2020-06-12 00:00:00', 'Screenshot from 2020-06-17 22-36-51.png', 'sdhfdh', 333, 33, 'on_going', '2020-06-18 12:35:54', '2020-06-18 12:35:54'),
(7, 2, 'Event', '2020-06-25 00:00:00', 'Screenshot from 2020-06-18 13-42-43.png', 'Tesjjjdjn', 100000, 12, 'on_going', '2020-06-18 16:33:15', '2020-06-18 16:33:15');

-- --------------------------------------------------------

--
-- Table structure for table `komunitas`
--

CREATE TABLE `komunitas` (
  `id` int(11) NOT NULL,
  `nama_komunitas` varchar(35) DEFAULT NULL,
  `visi` text,
  `misi` text,
  `deskripsi` text,
  `logo` varchar(30) DEFAULT NULL,
  `rating` int(1) DEFAULT NULL,
  `no_rekening` varchar(25) DEFAULT NULL,
  `status` enum('aktif','banned') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `komunitas`
--

INSERT INTO `komunitas` (`id`, `nama_komunitas`, `visi`, `misi`, `deskripsi`, `logo`, `rating`, `no_rekening`, `status`, `create_at`, `update_at`) VALUES
(1, 'Komunitas Ku', 'Mensejahterakan lingkungan', 'Kopdar tiap minggu', 'Komunitas swag lingkungan', 'Logo.png', NULL, NULL, NULL, '2020-06-17 14:17:16', '2020-06-17 14:17:16'),
(2, 'Komunitas Mju Jaya', 'Maju terus', 'Pokok tatak', 'Komunitas Aselole', 'Logo.png', NULL, NULL, NULL, '2020-06-17 14:26:45', '2020-06-17 14:26:45');

-- --------------------------------------------------------

--
-- Table structure for table `pengurus`
--

CREATE TABLE `pengurus` (
  `id` int(11) NOT NULL,
  `id_akun` int(11) DEFAULT NULL,
  `id_komunitas` int(11) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `telepon` varchar(13) DEFAULT NULL,
  `jabatan` enum('ketua','wakil','sekertaris','bendahara') DEFAULT NULL,
  `status` enum('aktif','banned') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengurus`
--

INSERT INTO `pengurus` (`id`, `id_akun`, `id_komunitas`, `nama`, `telepon`, `jabatan`, `status`, `create_at`, `update_at`) VALUES
(1, 9, 1, 'Abiyu', '123', 'ketua', 'aktif', '2020-06-17 14:17:17', '2020-06-17 14:17:17'),
(2, 10, 1, 'Abiyu', '123', 'ketua', 'aktif', '2020-06-17 14:17:17', '2020-06-17 14:17:17'),
(3, 11, 1, 'Abiyu', '123', 'ketua', 'aktif', '2020-06-17 14:17:17', '2020-06-17 14:17:17'),
(4, 12, 1, 'Abiyu', '123', 'ketua', 'aktif', '2020-06-17 14:17:18', '2020-06-17 14:17:18'),
(5, 5, 2, 'Ketua Nama', '123', 'ketua', 'aktif', '2020-06-17 14:26:46', '2020-06-17 14:26:46'),
(6, 14, 2, 'Wakil Nama', '456', 'wakil', 'aktif', '2020-06-17 14:26:46', '2020-06-17 14:26:46'),
(7, 15, 2, 'Sekertaris Nama', '789', 'sekertaris', 'aktif', '2020-06-17 14:26:46', '2020-06-17 14:26:46'),
(8, 16, 2, 'Bendahara Nama', '012', 'bendahara', 'aktif', '2020-06-17 14:26:47', '2020-06-17 14:26:47');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `id_akun` int(11) DEFAULT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `gender` enum('Laki-laki','Perempuan') DEFAULT 'Laki-laki',
  `telepon` varchar(13) DEFAULT NULL,
  `pekerjaan` varchar(20) DEFAULT NULL,
  `alamat` text,
  `status` enum('aktif','banned') DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `id_akun`, `nama`, `gender`, `telepon`, `pekerjaan`, `alamat`, `status`, `create_at`, `update_at`) VALUES
(1, NULL, 'Abiyu Candra', 'Laki-laki', '087757883733', 'Mahasiswa', 'Jl. Mastrip No.32', 'aktif', NULL, NULL),
(2, NULL, 'Abiyu', 'Laki-laki', '08983368286', 'Mahasiswa', 'Kembang', 'aktif', '2020-06-16 23:00:30', '2020-06-16 23:00:30'),
(3, NULL, 'Abiyu', 'Laki-laki', '08983368286', 'Mahasiswa', 'Kembang', 'aktif', '2020-06-16 23:00:39', '2020-06-16 23:00:39'),
(4, 6, 'Andrean ', 'Laki-laki', '087654321123', 'Mahasiswa', 'Tamansari', 'aktif', '2020-06-17 00:28:05', '2020-06-17 00:28:05'),
(5, 7, 'Abiyu', 'Laki-laki', '09876543211', 'Mahasiswa', 'Kembang', 'aktif', '2020-06-17 00:31:14', '2020-06-17 00:31:14'),
(6, 8, 'tes', 'Laki-laki', '123', '123', '123', 'aktif', '2020-06-17 00:34:01', '2020-06-17 00:34:01');

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

CREATE TABLE `volunteer` (
  `id` int(11) NOT NULL,
  `id_event` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `kriteria` enum('memenuhi','kurang_memenuhi') DEFAULT NULL,
  `ketererangan` text,
  `status` enum('terima','tolak') DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donasi`
--
ALTER TABLE `donasi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_event` (`id_event`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `event_ibfk_1` (`id_komunitas`);

--
-- Indexes for table `komunitas`
--
ALTER TABLE `komunitas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengurus`
--
ALTER TABLE `pengurus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_komunitas` (`id_komunitas`),
  ADD KEY `id_akun` (`id_akun`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_akun` (`id_akun`);

--
-- Indexes for table `volunteer`
--
ALTER TABLE `volunteer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_event` (`id_event`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `donasi`
--
ALTER TABLE `donasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `komunitas`
--
ALTER TABLE `komunitas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pengurus`
--
ALTER TABLE `pengurus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `volunteer`
--
ALTER TABLE `volunteer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `donasi`
--
ALTER TABLE `donasi`
  ADD CONSTRAINT `donasi_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`id_komunitas`) REFERENCES `komunitas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pengurus`
--
ALTER TABLE `pengurus`
  ADD CONSTRAINT `pengurus_ibfk_1` FOREIGN KEY (`id_komunitas`) REFERENCES `komunitas` (`id`),
  ADD CONSTRAINT `pengurus_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id`);

--
-- Constraints for table `volunteer`
--
ALTER TABLE `volunteer`
  ADD CONSTRAINT `volunteer_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
