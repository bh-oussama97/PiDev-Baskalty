-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 31 mai 2020 à 14:54
-- Version du serveur :  5.7.26
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `baskaltyy`
--

-- --------------------------------------------------------

--
-- Structure de la table `association`
--

DROP TABLE IF EXISTS `association`;
CREATE TABLE IF NOT EXISTS `association` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `activite` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Localisation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Tel` int(11) NOT NULL,
  `Mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Responsable` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_FD8521CC59F022DF` (`Iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `association`
--

INSERT INTO `association` (`id`, `nom`, `activite`, `Localisation`, `Tel`, `Mail`, `Responsable`, `Iduser`) VALUES
(1, 'kkk', 'k', 'k', 55555, 'k', 'dfssd', 2),
(2, 'dfhbd', '??', '?', 24485, '?', '?', 5),
(3, 'h', 'h', 'h', 58587474, 'h', 'h', 9),
(4, 'ùmm²m', 'eem', 'mme', 325, 'smsms@dm.com', 'slsldl', 10),
(5, 'bike', 'mamma', 'marsa', 22188, 'mama@zzm.com', 'zlzl', 12),
(6, 'amam', 'mamam', 'mamm', 555, 'mamamm@dmmd.cp!ù', 'slsl', 17),
(7, 'harba', 'biking', 'tunis', 21885045, 'mali@esprit.tn', 'sadek selmi', 22),
(8, 'yry', 'rtytyt', 'tyetye', 77, 'eryre@tyet.com', 'yerye', 21);

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `nom`) VALUES
(1, 'equipements'),
(2, 'accessoires'),
(3, 'Vélos de route'),
(4, 'Vélos de triathlon'),
(5, 'Vélos de piste'),
(6, 'Vélos électriques'),
(7, 'Vélos Cross'),
(8, 'Vélo de montagne');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `publishdate` datetime NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Events` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_9474526C8D93D649` (`user`),
  KEY `IDX_9474526C542B527C` (`Events`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `user`, `publishdate`, `content`, `Events`) VALUES
(3, 3, '2020-02-19 22:30:09', 'marhbbe bikom nes el kol ', 3),
(9, 17, '2020-02-24 20:22:08', 'heya', 9),
(13, 22, '2020-02-25 17:31:39', 'hey hey', 3),
(14, 3, '2020-02-28 09:24:12', 'ùùee', 3);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `contenu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Publication` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_67F068BC8D93D649` (`user`),
  KEY `IDX_67F068BC29A0E8AE` (`Publication`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `user`, `contenu`, `Publication`) VALUES
(1, 21, 'ddd', NULL),
(2, 26, 'marh e\r\n', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `name`, `date`, `email`, `phone`, `subject`, `message`) VALUES
(1, 'heyahdd', '2020-02-19 21:04:23', 'cyrine@esprit.tn', 'hh', 'h', 'h'),
(2, 'heyahdd', '2020-02-19 21:04:34', 'cyrine@esprit.tn', '218888', 'h', 'h'),
(3, 'heyahdd', '2020-02-19 21:04:44', 'cyrine@esprit.tn', '218888', 'hdfqdfqd', 'h'),
(4, 'heyahdd', '2020-02-19 21:04:49', 'cyrine@esprit.tn', '2188885555', 'hdfqdfqd', 'h'),
(5, 'heyahdd', '2020-02-19 21:04:56', 'cyrine@esprit.tn', '21888855', 'hdfqdfqd', 'h'),
(6, 'heyahdd', '2020-02-19 21:05:07', 'cyrine@esprit.tn', '21888855', 'hdfqdfqd', 'h'),
(7, 'oooo', '2020-02-19 21:17:54', 'zkzkz@gù.com', '458', 'eel', 'llz'),
(8, 'wess', '2020-05-26 19:02:43', 'ouss@gmail.com', '94813880', 'moshkla', 'aandi moshkla flogin'),
(9, 'oussama', '2020-05-27 18:43:44', 'aaaa@gmail.com', '94813880', 'aaaa', 'azzar'),
(10, 'wess', '2020-05-28 01:51:55', 'wess@gmail.com', '55184756', 'moshkla', 'aaandi moshkla'),
(11, 'ahmed', '2020-05-28 01:54:39', 'ahmed@esprit.tn', '55123478', 'moshkla o5ra', 'moshkla o5ra kbira yeser'),
(12, 'oussama', '2020-05-28 15:10:46', 'oussama.benhassen@esprit.tn', '94813880', 'probleme', 'probleme convernant le wifi'),
(13, 'oussama', '2020-05-31 15:46:38', 'oussama@gmail.com', '97321220', 'message', 'azezaeaze');

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `association` int(11) DEFAULT NULL,
  `Participernumber` bigint(20) DEFAULT NULL,
  `Interstednumber` bigint(20) DEFAULT NULL,
  `commenternumber` bigint(20) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `location` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `start` datetime DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `end` datetime NOT NULL,
  `prix` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `themeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5387574AFD8521CC` (`association`),
  KEY `IDX_5387574A498E0DF6` (`themeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`id`, `association`, `Participernumber`, `Interstednumber`, `commenternumber`, `name`, `location`, `description`, `start`, `image`, `end`, `prix`, `quantity`, `themeid`) VALUES
(2, 28, 0, 0, 0, 'hakefbk', 'ezjkbgkjeab', 'zlkenglkeazng', '2020-05-15 00:00:00', 'uOgBXD5U.jpg', '2020-06-05 00:00:00', 50, 66, NULL),
(3, 28, 0, 0, 0, 'event', 'kaiouan', 'ajaaaja', '2020-05-22 00:00:00', 'tDHHa7Tj.jpg', '2020-05-22 00:00:00', 50, 10, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `image_file` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `image_file`) VALUES
(26, 'sadek', 'sadek', 'sadek.selmi@gmail.com', 'sadek.selmi@gmail.com', 1, NULL, '97321220', '2020-05-23 22:52:42', NULL, NULL, 'a:0:{}', 'temp1875153015549349234..jpg'),
(27, 'oussama', 'oussama', 'oussama.benhassen@esprit.tn', 'oussama.benhassen@esprit.tn', 1, NULL, '94813880', '2020-05-16 00:12:54', NULL, NULL, 'a:0:{}', 'temp1875153015549349234..jpg'),
(28, 'yahya', 'yahya', 'yahyafdhila@esprit.tn', 'yahyafdhila@esprit.tn', 0, NULL, '123456789', '2020-05-16 00:14:17', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_MECHANICIEN\";}', 'temp1875153015549349234..jpg'),
(33, 'cyrine', 'cyrine', 'cyrine@esprit.tn', 'cyrine@esprit.tn', 0, NULL, 'esprit2020', '2020-05-16 00:19:26', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_VENDEUR\";}', 'temp1875153015549349234..jpg'),
(34, 'fayez ', 'fayez ', 'fayezfrikha@esprit.tn', 'fayezfrikha@esprit.tn', 1, NULL, '123', '2020-05-16 03:03:54', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_MECHANICIEN\";}', 'temp1875153015549349234..jpg'),
(36, 'sadekkkkk', 'sadekkkkk', 'sadekkkkk@esprit.tn', 'sadekkkkk@esprit.tn', 1, NULL, '96258500', '2020-05-18 02:17:59', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', 'a6c2ef4434588a45eca1dc1cd3d7ad97.jpeg'),
(37, 'ahmedmrabet', 'ahmedmrabet', 'ahmed97@esprit.tn', 'ahmed97@esprit.tn', 1, NULL, '123456', '2020-05-16 04:46:46', NULL, NULL, 'a:0:{}', 'temp1875153015549349234..jpg'),
(38, 'hhhhh', 'hhhhh', 'hhhhhhh@esprit.tn', 'hhhhhhh@esprit.tn', 0, NULL, '000', '2020-05-16 08:34:36', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_VENDEUR\";}', 'temp1875153015549349234..jpg'),
(39, 'ouss', 'ouss', 'ouss@gmail.com', 'ouss@gmail.com', 0, NULL, '123', '2020-05-16 08:38:45', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_VENDEUR\";}', 'temp1875153015549349234..jpg'),
(40, 'ahmmed', 'ahmmed', 'ahmed@gmail.com', 'ahmed@gmail.com', 0, NULL, '123456', '2020-05-17 02:53:06', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_ASSOCIATION\";}', 'temp1875153015549349234..jpg'),
(44, 'hhhh', 'hhhh', 'hhhhh@gmail.com', 'hhhhh@gmail.com', 1, NULL, '123', '2020-05-17 03:43:27', NULL, NULL, 'a:0:{}', 'temp1875153015549349234..jpg'),
(45, 'ahmedmornag', 'ahmedmornag', 'ahmedmornag@esprit.tn', 'ahmedmornag@esprit.tn', 1, NULL, '123456', '2020-05-18 01:10:33', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_ASSOCIATION\";}', 'temp5326141117571060602..jpg'),
(48, 'oussammaaaa', 'oussammaaaa', 'ousssssama@gmail.com', 'ousssssama@gmail.com', 0, NULL, '123', '2020-05-18 02:15:38', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_VENDEUR\";}', 'temp4937672892847875819..png');

-- --------------------------------------------------------

--
-- Structure de la table `interested`
--

DROP TABLE IF EXISTS `interested`;
CREATE TABLE IF NOT EXISTS `interested` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `events_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_C45240789D6A1065` (`events_id`),
  KEY `IDX_C4524078A76ED395` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `interested`
--

INSERT INTO `interested` (`id`, `events_id`, `user_id`) VALUES
(4, 5, 9),
(6, 7, 3),
(7, 7, 11),
(8, 9, 3),
(16, 9, 17),
(19, 3, 2),
(20, 9, 27);

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_user` double NOT NULL,
  `position_mechanicien` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `mechanicien`
--

DROP TABLE IF EXISTS `mechanicien`;
CREATE TABLE IF NOT EXISTS `mechanicien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `num_tel` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `experience` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `region` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adomicile` tinyint(1) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `actif` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_F6E1E430E19D9AD2` (`service`),
  KEY `IDX_F6E1E430F132696E` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `mechanicien`
--

INSERT INTO `mechanicien` (`id`, `service`, `nom`, `prenom`, `mail`, `image`, `prix`, `num_tel`, `description`, `experience`, `region`, `city`, `adomicile`, `userid`, `actif`) VALUES
(3, NULL, 'mmm', 'm', 'm', 'event-slider1.png', 222, 84888, 'm', 'qmsmms', 'tunis', 'tunis', 1, 2, 1),
(4, NULL, 'slfgql', 'ppezpfp', 'pfepe@em.com', 'event2.png', 22, 21555, '2edfefl', 'sdd', 'tunis', 'tunis', 1, 2, 1),
(5, NULL, 'qslqsl', 'lzlldl', 'llflz@meme.com', 'event.png', 21, 25555, 'eflf', 'ddk', 'tunis', 'tunis', 1, 2, 1),
(6, NULL, 'aaaa', 'aaaaa', 'aaa', '81371281_651457505394061_735895766601564160_n.jpg', 55, 555, '555', '55', 'tunis', 'tunis', 1, 3, 1),
(7, NULL, 'zzz', 'zzz', 'zz@drgsg.com', 'event2.png', 50, 4275758, 'ryzryzr', 'k', 'tunis', 'tunis', 1, 21, 0),
(8, NULL, 'cyrine', 'chebii', 'chebii.cyrine@gmail.com', 'comment1.png', 5, 54226875, 'my name is cyrine', 'pro', 'bardo', 'bardo', 1, 27, 0);

-- --------------------------------------------------------

--
-- Structure de la table `nblike`
--

DROP TABLE IF EXISTS `nblike`;
CREATE TABLE IF NOT EXISTS `nblike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `publication` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_EDE9740B8D93D649` (`user`),
  KEY `IDX_EDE9740BAF3C6779` (`publication`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `phonenumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `total` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_E52FFDEEA76ED395` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `phonenumber`, `email`, `city`, `adresse`, `total`, `nom`) VALUES
(3, NULL, '94813880', 'benhassenoussama1@gmail.com', 'monastir', 'rue abdallah ayed bouhjar', 10000, 'oussama'),
(4, NULL, '8489498', 'sadke.selmi@esprit.tn', 'ariana', 'kairouan rue rmada', 60200, 'sadek'),
(5, NULL, '59845984', 'sadek.selmi@gmail.com', 'tunis', 'kairouan', 24000, 'sadek'),
(6, NULL, '89198', 'cyrine@gmail.com', 'lkanzlk', 'rue k,nkl', 3600, 'cyrine'),
(7, NULL, '55697321', 'yahya.fdhila@gmail.com', 'Bardo', 'rue milaha', 5400, 'yahya'),
(8, NULL, '498494', 'yahya@gmail.com', 'anlkeanl', 'aleknl', 59195, 'hh'),
(9, NULL, '96258500', 'yahya@gmail.com', 'bardo', 'rue milala', 50, 'yahya'),
(10, NULL, '96258500', 'yahya@gmail.com', 'bardo', 'rue milala', 50, 'yahya'),
(11, NULL, '97321220', 'yahya.fdila@gmail.com', 'bardo', 'rue haj sala7', 1600, 'yahya fdhila'),
(12, NULL, '96258500', 'yahya.fdila@esprit.tn', 'bardo', 'rue milaha', 2400, 'yahya fdhila'),
(13, NULL, '51651', 'yahya@gmail.com', 'noneo', 'aenoa', 59195, 'hyay'),
(14, NULL, '9584270', 'yahya@gmail.com', 'zeeee', 'ajejkearhajker', 600, 'lll'),
(15, NULL, '8498', 'ouss@gmail.com', 'oapkrpoaz', 'akpakr', 1600, 'usso'),
(16, NULL, '948465', 'hhhh@gmail.com', 'znlkenglze', 'zenglkezn', 600, 'ggg'),
(17, NULL, '94813880', 'marwen.souissi@gmail.com', 'mestir', 'rue sayada ', 5400, 'marwen'),
(18, NULL, '94813880', 'marwen.souissi@gmail.com', 'mestir', 'rue sayada ', 5400, 'marwen'),
(19, NULL, '4894', 'kkkk@gmail.com', 'nzong', 'zenoa', 500, 'kkk'),
(20, NULL, '4988', 'oussama@gmail.com', 'ak,efalkf,', 'alkef,lkae', 500, 'ussamao'),
(21, NULL, '4984', 'jkjk', 'zk,fklzf', 'z,pz', 500, 'jkjk'),
(22, NULL, 'lze,lka', 'ek,fklae,fkla,aelk,glke', 'ze,zelk,', ',alkef,kl', 500, 'lk,kllk'),
(23, NULL, '54984', 'ajkznjkazn', 'alek,flka', 'e,kl,', 500, 'jkj'),
(24, NULL, '5984598', 'lez,lk,', 'aerae', 'aepo,', 500, 'lk,k'),
(25, NULL, '94984', 'aaa', 'aaa', 'lzlz', 500, 'aaa'),
(26, NULL, 'akz,ale', 'akz,kla,', 'alk,akl,', 'alzkela', 500, ',kklk,'),
(27, NULL, 'zaokno', 'almaz;@gmail.com', ',apo,r', '8az,ra', 500, 'hhh'),
(28, NULL, '4984984', 'uoussama@gmail.cm', 'a,erlka', 'ze,rlkae,r', 500, 'oussama'),
(29, NULL, '94813880', 'oussama@gmail.com', 'bouhjar', 'rue abdallah ayed', 500, 'oussama'),
(30, NULL, '96312584', 'sadek.selmi@gmail.com', 'kairouan', 'rue rmdada', 500, 'sadek'),
(31, NULL, '555', 'hh', 'oijo', 'ijoioj', 500, 'hhjhh');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `date_p` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `produit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_24CC0DF2A76ED395` (`user_id`),
  KEY `IDX_24CC0DF2F347EFB` (`produit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `events_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `Number` int(11) NOT NULL,
  `confirmation` tinyint(1) NOT NULL,
  `champsConfirmation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_EDBE16F89D6A1065` (`events_id`),
  KEY `IDX_EDBE16F8A76ED395` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `participer`
--

INSERT INTO `participer` (`id`, `events_id`, `user_id`, `Number`, `confirmation`, `champsConfirmation`) VALUES
(93, 5, 24, 0, 1, 'J6eLRLPbL402A4OK'),
(94, 3, 27, 0, 1, 'eeAyLQEJ5jiRpsX8');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantite` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Reference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Price` int(11) NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `Iduser` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_D34A04AD59F022DF` (`Iduser`),
  KEY `IDX_D34A04AD64C19C1` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `quantite`, `date`, `Name`, `Reference`, `Price`, `Description`, `image`, `updated_at`, `Iduser`, `category`) VALUES
(45, 13, '2020-04-10 20:17:00', 'Casquette Brook', 'RPL02086', 600, 'casquette mizelt jdida !!! ', 'UwMmGolL.jpg', '2020-05-27 18:51:51', 36, 2),
(46, 15, '2020-04-10 20:18:10', 'GANTS', 'RPL02069', 80, 'GANTS Vélo route pour les hommes', 'Ww97xPGT.jpg', '2020-05-28 01:26:06', 33, 1),
(47, 0, '2020-04-10 20:29:00', 'Maillot', 'RPL02096', 300, 'MAILLOT MANCHES LONGUES VELO ROUTE TRIBAN RC500 NOIR', 'L1AVQeiV.jpg', '2020-05-05 00:00:00', 40, 1),
(48, 0, '2020-04-10 20:33:29', 'Cuissard Vélo', 'RPL02048', 90, 'CUISSARD VELO ROUTE SANS BRETELLES', 'fOrWt7vU.jpg', '2020-05-10 00:00:00', 39, 1),
(49, 12, '2020-04-10 20:42:02', 'KeyChain', 'RPL02596', 15, 'accessoire pour s\'habiller', 'jxiN9CGN.jpg', '2020-05-03 00:00:00', 39, 2),
(50, 2, '2020-04-10 20:44:44', 'Lunettes', 'RPL02087', 180, 'LUNETTES DE VÉLO ADULTE ROADR 900 PHOTOCROMIC GRISES', 'Ipi6gw2m.jpg', '2020-05-22 00:00:00', 28, 1),
(51, 7, '2020-04-10 20:54:10', 'Bandeau', 'RPL02036', 60, 'BANDEAU VELO 500 SANS COUTURE NOIR', 'rF4oQOgR.jpg', '2020-05-04 00:00:00', 36, 1),
(52, 16, '2020-04-10 21:06:47', 'Boucle de remplacement', 'RPL02069', 250, 'BOUCLE DE REMPLACEMENT ATOP', 'vVXu62Sp.jpg', '2020-04-14 00:00:00', 27, 2),
(53, 35, '2020-04-10 21:08:05', 'Chaussures ', 'RPL09785', 350, 'CHAUSSURES DE VÉLO CYCLO-SPORT VAN RYSEL ROADR 520 NOIR', 'eJbfZ5fE.jpg', '2020-04-07 00:00:00', 26, 1),
(54, 25, '2020-04-10 21:10:07', 'Corsaire', 'RPL05867', 250, 'CORSAIRE SANS BRETELLES FEMME VAN RYSEL RACER', 'b1bapvOx.jpg', '2020-03-10 00:00:00', 33, 1),
(55, 0, '2020-04-10 21:17:39', 'Vélo de route verte', 'RPL06987', 450, 'Vélos de route ', 'FKKNCFe3.jpg', '2020-04-21 00:00:00', 34, 3),
(56, 0, '2020-04-10 21:20:32', 'Vélo triathlon rouge', 'RPL06974', 2000, 'Un bon vélo de triathlon pour débutant', '28dZouzn.jpg', '2020-04-09 00:00:00', 34, 4),
(58, 6, '2020-04-10 21:23:04', 'Vélo de piste Madison jaune', 'RPL06987', 5000, 'VÉLO DE PISTE LOOK 875 MADISON TRACK 2020', 'CJtrEMhp.jpg', '2020-04-14 00:00:00', 39, 5),
(59, 0, '2020-04-10 21:24:55', 'Vélo de course ', 'RPL05687', 5000, 'VÉLO DE PISTE LOOK 875 MADISON TRACK 2020', 'mwUmAAxM.jpg', '2020-04-21 00:00:00', 33, 7),
(60, 0, '2020-04-10 21:27:42', 'Harley Davidson', 'RPL06987', 6000, 'vélos électriques Harley-Davidson', 'ttZEjzHh.jpg', '2020-04-07 00:00:00', 33, 7),
(61, 0, '2020-04-10 21:28:58', 'vélo électrique', 'RPL06973', 5000, 'Vélos électriques : non pas une, mais différentes variétés', '6JD3TTzb.jpg', '2020-04-22 00:00:00', 28, 6),
(62, 0, '2020-04-10 21:43:02', 'Vélo Montagne Remedy', 'RPL0587', 2000, 'Remedy8275 ', 'XjCB9wqE.jpg', '2020-04-15 00:00:00', 27, 8);

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contenu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datecreation` date NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user` int(11) DEFAULT NULL,
  `accept` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_AF3C67798D93D649` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `contenu`, `datecreation`, `image`, `user`, `accept`) VALUES
(1, 'post', '2020-05-14', 'image.jpg', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `rent`
--

DROP TABLE IF EXISTS `rent`;
CREATE TABLE IF NOT EXISTS `rent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `localisation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_2784DCC59F022DF` (`Iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rentprod`
--

DROP TABLE IF EXISTS `rentprod`;
CREATE TABLE IF NOT EXISTS `rentprod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `renter` int(11) DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `marke` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `localisation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Reference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Price` double NOT NULL,
  `stars` double DEFAULT NULL,
  `Rentdays` int(11) NOT NULL,
  `dispo` tinyint(1) NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_F885CC688D93D649` (`user`),
  KEY `IDX_F885CC68887A3A1A` (`renter`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `rentprod`
--

INSERT INTO `rentprod` (`id`, `user`, `renter`, `model`, `quantity`, `marke`, `localisation`, `Reference`, `Price`, `stars`, `Rentdays`, `dispo`, `Description`, `image`) VALUES
(15, NULL, NULL, 'Vélo de piste Madison jaune', 6, 'bike', 'sfax', 'RPL06987', 30000, 3, 6, 1, 'VÉLO DE PISTE LOOK 875 MADISON TRACK 2020', 'CJtrEMhp.jpg'),
(16, NULL, NULL, 'GANTS', 4, 'bike', 'sfax', 'RPL02069', 320, 5, 9, 1, 'GANTS Vélo route pour les hommes', 'Ww97xPGT.jpg'),
(17, NULL, NULL, 'Casque Rose', 5, 'bike', 'sfax', 'RPL02075', 4000, 1, 6, 1, 'accessoire de protection	rose', 'F3ZtHmEW.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  `document` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datestart` date NOT NULL,
  `dateend` date NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `confirmation` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_42C84955A76ED395` (`user_id`),
  KEY `IDX_42C8495529A5EC27` (`produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `produit_id` int(11) DEFAULT NULL,
  `stars` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_6970EB0FA76ED395` (`user_id`),
  KEY `IDX_6970EB0FF347EFB` (`produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `seller`
--

DROP TABLE IF EXISTS `seller`;
CREATE TABLE IF NOT EXISTS `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `localisation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_FCB6D6CA59F022DF` (`Iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_service` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `association`
--
ALTER TABLE `association`
  ADD CONSTRAINT `FK_FD8521CC59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_9474526C542B527C` FOREIGN KEY (`Events`) REFERENCES `events` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_9474526C8D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_67F068BC29A0E8AE` FOREIGN KEY (`Publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_67F068BC8D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FK_5387574A498E0DF6` FOREIGN KEY (`themeid`) REFERENCES `theme` (`id`),
  ADD CONSTRAINT `FK_5387574AFD8521CC` FOREIGN KEY (`association`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `interested`
--
ALTER TABLE `interested`
  ADD CONSTRAINT `FK_C45240789D6A1065` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_C4524078A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `mechanicien`
--
ALTER TABLE `mechanicien`
  ADD CONSTRAINT `FK_F6E1E430E19D9AD2` FOREIGN KEY (`service`) REFERENCES `service` (`id`),
  ADD CONSTRAINT `FK_F6E1E430F132696E` FOREIGN KEY (`userid`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `nblike`
--
ALTER TABLE `nblike`
  ADD CONSTRAINT `FK_EDE9740B8D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_EDE9740BAF3C6779` FOREIGN KEY (`publication`) REFERENCES `publication` (`id`);

--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_E52FFDEEA76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `FK_24CC0DF2A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_24CC0DF2F347EFB` FOREIGN KEY (`produit_id`) REFERENCES `product` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `FK_EDBE16F89D6A1065` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_EDBE16F8A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_D34A04AD59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_D34A04AD64C19C1` FOREIGN KEY (`category`) REFERENCES `category` (`id`);

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `FK_AF3C67798D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `FK_2784DCC59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `rentprod`
--
ALTER TABLE `rentprod`
  ADD CONSTRAINT `FK_F885CC68887A3A1A` FOREIGN KEY (`renter`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_F885CC688D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_42C8495529A5EC27` FOREIGN KEY (`produit`) REFERENCES `rentprod` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_42C84955A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK_6970EB0FA76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_6970EB0FF347EFB` FOREIGN KEY (`produit_id`) REFERENCES `rentprod` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `seller`
--
ALTER TABLE `seller`
  ADD CONSTRAINT `FK_FCB6D6CA59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
