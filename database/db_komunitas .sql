CREATE TABLE `user` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_akun` int,
  `nama` varchar(30),
  `gender` ENUM ('pria', 'wanita'),
  `telepon` varchar(13),
  `pekerjaan` varchar(20),
  `alamat` text,
  `status` ENUM ('aktif', 'banned'),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `komunitas` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `nama_komunitas` varchar(35),
  `visi` text,
  `misi` text,
  `deskripsi` text,
  `logo` varchar(30),
  `rating` int(1),
  `no_rekening` varchar(25),
  `status` ENUM ('aktif', 'banned'),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `pengurus` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_akun` int,
  `id_komunitas` int,
  `nama` varchar(25),
  `telepon` varchar(13),
  `jabatan` ENUM ('ketua', 'wakil', 'sekertaris', 'bendahara'),
  `status` ENUM ('aktif', 'banned'),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `akun` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `email` varchar(20),
  `password` varchar(32),
  `level` ENUM ('admin_sistem', 'admin_komunitas', 'user'),
  `status` ENUM ('aktif', 'banned'),
  `create_at` datetime
);

CREATE TABLE `event` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_komunitas` int,
  `judul_event` varchar(35),
  `tanggal` datetime,
  `poster` varchar(30),
  `deskripsi` text,
  `jmlh_donasi` int(8),
  `jmlh_volunteer` int(2),
  `status` ENUM ('selesai', 'on_going', 'cancel'),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `volunteer` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_event` int,
  `id_user` int,
  `kriteria` ENUM ('memenuhi', 'kurang_memenuhi'),
  `ketererangan` text,
  `status` ENUM ('terima', 'tolak'),
  `create_at` datetime,
  `update_at` datetime
);

CREATE TABLE `donasi` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_event` int,
  `id_user` int,
  `jumlah_donasi` int(8),
  `bukti_donasi` varchar(30),
  `status` ENUM ('terima', 'tolak', 'diteruskan'),
  `create_at` datetime,
  `update_at` datetime
);

ALTER TABLE `event` ADD FOREIGN KEY (`id_komunitas`) REFERENCES `komunitas` (`id`);

ALTER TABLE `donasi` ADD FOREIGN KEY (`id_event`) REFERENCES `event` (`id`);

ALTER TABLE `volunteer` ADD FOREIGN KEY (`id_event`) REFERENCES `event` (`id`);

ALTER TABLE `pengurus` ADD FOREIGN KEY (`id_komunitas`) REFERENCES `komunitas` (`id`);

ALTER TABLE `pengurus` ADD FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id`);
