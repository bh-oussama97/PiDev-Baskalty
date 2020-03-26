-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 26 mars 2020 à 01:20
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
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_cat`, `nom`) VALUES
(1, 'equipements'),
(2, 'accessoires');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `Idproduit` int(11) DEFAULT NULL,
  `Iduser` int(11) DEFAULT NULL,
  `num_telephone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `instructions_livraison` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix_total` double NOT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `IDX_E52FFDEEF347EFB` (`Idproduit`),
  KEY `IDX_E52FFDEEA76ED395` (`Iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `user`, `contenu`, `Publication`) VALUES
(1, 21, 'ddd', 1),
(2, 26, 'marh e\r\n', 7),
(3, 3, 'azemmer bleu gg', 7);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(7, 'oooo', '2020-02-19 21:17:54', 'zkzkz@gù.com', '458', 'eel', 'llz');

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `themeid` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`id`),
  KEY `IDX_5387574A498E0DF6` (`themeid`),
  KEY `IDX_5387574AFD8521CC` (`association`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`id`, `themeid`, `association`, `Participernumber`, `Interstednumber`, `commenternumber`, `name`, `location`, `description`, `start`, `image`, `end`, `prix`, `quantity`) VALUES
(3, 1, 3, 6, 1, 3, 'mamam', 'sfax', 'mfmemzmmzmdmfzmdmfsdm', '2020-02-23 00:00:00', 'event-slider1.png', '2020-03-01 00:00:00', 0, 0),
(5, 2, 9, 6, 1, NULL, 'hama', 'marsa', 'fjfjjdjj', '2020-02-21 10:30:23', 'event.png', '2020-02-25 10:30:23', 17, 1),
(7, 1, 3, 6, 2, NULL, 'zelrl', 'marsa', 'zmzmmzm', '2020-02-26 00:00:00', 'event3.png', '2020-03-02 00:00:00', 15, 4),
(9, 2, 3, 2, 3, 1, 'Mm', 'sfax', 'zmzmmzmz', '2020-02-21 00:00:00', 'event.png', '2020-02-23 00:00:00', 0, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `image_file`) VALUES
(1, 'oussama', 'oussama', 'oussama@gmail.com', 'oussama@gmail.com', 1, NULL, '$2y$13$C3tjmxRvpZ/JMGoUqUwwhOyZtbwi0V0.HwhOOdwAq8I4lOO764uda', '2020-02-28 01:37:58', NULL, NULL, '', '19193afe1ddfd1eced9ade8701aef4d6.jpeg'),
(2, 'yahya', 'yahya', 'yahya@gmail.com', 'yahya@gmail.com', 1, NULL, '$2y$13$iCfYGvXgnth03U6E9Q0UwuBleRxN12IH0i.x/0Lc3/coGRRcZm9/y', '2020-02-28 05:57:25', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', '3af79e7bac72c3dd51799d1ede3604de.jpeg'),
(3, 'sadek', 'sadek', 'sadek@gmail.com', 'sadek@gmail.com', 1, NULL, '$2y$13$yREuFd0cjDgkdM9ThUFDJeFMtJsbuIWatZciP8oRJkMi6CzMbrcEC', '2020-02-28 06:35:39', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_VENDER\";}\r\n', 'eac2e626476ff3ccc0e01809d57f81de.jpeg');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `nblike`
--

INSERT INTO `nblike` (`id`, `user`, `publication`) VALUES
(1, 3, 7);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `date_p` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `produit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_24CC0DF2A76ED395` (`user_id`),
  KEY `IDX_24CC0DF2F347EFB` (`produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` int(11) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `date_ajout` timestamp NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `reference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` float NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `modifiee_le` timestamp NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_prod`),
  KEY `IDX_29A5EC2759F022DF` (`iduser`),
  KEY `IDX_29A5EC2712469DE2` (`categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_prod`, `categorie`, `quantite`, `date_ajout`, `nom`, `reference`, `prix`, `description`, `image`, `modifiee_le`, `iduser`) VALUES
(1, 2, 11, '2020-03-22 23:00:00', 'ajfnajk', 'nzkjenfkj', 2560, 'zkjenfjkzen', 'zkjengjzkeng', '2020-03-17 23:00:00', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `contenu`, `datecreation`, `image`, `user`, `accept`) VALUES
(1, '<p>zqrqerrq</p>', '2020-02-27', 'c26be9d5f0290675846b3b0bde35a993.jpeg', 21, 1),
(7, '<p>my events</p>', '2020-02-28', '0ca28554dc5b8143870ce447b908dda5.jpeg', 26, 1),
(8, '<p><span style=\"color:#27ae60\"><span style=\"font-size:22px\"><u><em><strong>heu heu heu heu&nbsp;</strong></em></u></span></span></p>', '2020-02-28', '944cce38cd4434ab36aa002f2d321f79.jpeg', 3, 1),
(9, '<p>***** ***** ***** aaaa*****ggg</p>', '2020-02-28', 'af24b100be7cf860b0140b6b782be9a2.jpeg', 3, 1),
(10, '<p>estmzemmqs blue ***** sksks&nbsp;</p>', '2020-03-07', '87bcc2f3b8dc0760deb407752f34c0f3.png', 3, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `rent`
--

INSERT INTO `rent` (`id`, `nom`, `prenom`, `localisation`, `phone`, `mail`, `Type`, `Iduser`) VALUES
(7, 'ett', 'ryyzryr', 'zyryzry', 576754, 'fggr@drgsh.com', 'ethety', 21),
(9, 'tzetz', 'j', 'jj', 555, 'j', 'hgtt', 26),
(10, 'qfe', 'pzpzp', 'eer', 95555, 'zzz@zm.com', 'dddd', 27);

-- --------------------------------------------------------

--
-- Structure de la table `rentprod`
--

DROP TABLE IF EXISTS `rentprod`;
CREATE TABLE IF NOT EXISTS `rentprod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `marke` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `localisation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Reference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Price` double NOT NULL,
  `Rentdays` int(11) NOT NULL,
  `dispo` tinyint(1) NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stars` double DEFAULT NULL,
  `renter` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_F885CC688D93D649` (`user`),
  KEY `IDX_F885CC68887A3A1A` (`renter`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `rentprod`
--

INSERT INTO `rentprod` (`id`, `user`, `model`, `quantity`, `marke`, `localisation`, `Reference`, `Price`, `Rentdays`, `dispo`, `Description`, `image`, `stars`, `renter`) VALUES
(2, 2, 'mezyna', 500, 'bike', 'sfax', 'zeer5', 50, 2, 1, 'eelelele', 'item5.png', 3, 21),
(3, 2, 'azr', 45, 'bike', 'sfax', 'zrllr222', 50, 5, 1, 'eelelele', 'item6.png', 2.5, 21),
(4, 2, 'mzmzmzm', 29, 'mamam', 'sfax', 'zlrl', 88, 5, 1, 'erzlmgslmgmlsd', 'item2.png', NULL, 21),
(5, 21, 'ZRGZRG', 1, 'bike', 'TZZT', 'TZETETZ', 50, 3, 0, '<p>ZFAEAEARARA</p>', 'event2.png', 0, 2),
(6, 21, 'bmx', 1, 'bike', 'tunis', 'dmdm222', 3000, 2, 0, '<p>yreyzrz</p>', 'event2.png', 0, 26),
(7, 26, 'mzmz', 5, 'bike', 'tunis', 'zmzm', 50, 5, 0, '<p>eyeryer</p>', 'event2.png', 2, NULL),
(8, 27, 'bmx', 1, 'bike', 'MARSA', 'XD53', 50, 2, 0, '<p><u><em><strong><span style=\"font-family:Arial,Helvetica,sans-serif\"><span style=\"color:#2ecc71\">FAYEZZ&nbsp;</span></span></strong></em></u></p>', 'image-item1.png', 4, 27);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `document` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datestart` date NOT NULL,
  `dateend` date NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  `confirmation` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_42C84955A76ED395` (`user_id`),
  KEY `IDX_42C8495529A5EC27` (`produit`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `document`, `datestart`, `dateend`, `quantity`, `price`, `user_id`, `produit`, `confirmation`) VALUES
(17, 'eeqrz', '2015-01-01', '2015-01-01', 2, 100, 3, 3, 1),
(18, 'C:\\wamp64\\tmp\\phpDD9A.tmp', '2015-01-04', '2015-01-10', 5, 250, 21, 2, 1),
(19, 'C:\\wamp64\\tmp\\phpC93.tmp', '2020-02-05', '2020-02-12', 2, 100, 21, 3, 0),
(20, 'C:\\wamp64\\tmp\\php8A2B.tmp', '2020-02-12', '2020-02-13', 5, 250, 21, 3, 0),
(21, 'c1ee5bada84d97225a832260dc9ddd03.jpeg', '2020-02-20', '2020-02-22', 10, 500, 21, 3, 0),
(22, '7e995072750237b154e4d313c7304452.jpeg', '2020-02-14', '2020-02-15', 5, 250, 21, 3, 1),
(23, '8e56938f4e3079abf34a501068aaffc0.jpeg', '2020-04-21', '2021-05-21', 1, 88, 21, 4, 1),
(24, 'ac5f750cc1071e2886fca8bdcc1577fb.jpeg', '2020-02-08', '2020-02-21', 2, 100, 2, 5, 1),
(25, '74d855ccb434e7708f19fbed2f2acef9.jpeg', '2020-02-07', '2020-02-05', 5, 15000, 26, 6, 1),
(26, '20ccbc0fdff7a3195e2c0fc41143d6f0.jpeg', '2020-02-28', '2020-02-29', 2, 100, 27, 8, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reviews`
--

INSERT INTO `reviews` (`id`, `user_id`, `produit_id`, `stars`, `title`, `description`) VALUES
(2, 25, 3, '3', 'zaezae', 'zezaezaeze'),
(3, 25, 3, '3', 'sadek', 'mercii'),
(4, 3, 3, '2', 'fayez', 'jawek behy'),
(5, 21, 3, '2', 'qsdqsdqsdsq', 'fayezfayez'),
(6, 21, 2, '3', 'yahay', 'marhbe'),
(7, 26, 7, '2', 'mohamed', 'ezrltg'),
(8, 27, 8, '4', 'MOHAMED', 'HELLO');

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
  `Phone` int(11) NOT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_FCB6D6CA59F022DF` (`Iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `seller`
--

INSERT INTO `seller` (`id`, `nom`, `prenom`, `localisation`, `Phone`, `mail`, `Type`, `Iduser`) VALUES
(1, 'oussama', 'benhassen', 'marsa', 21850455, 'oussamabenhassen@esprit.tn', 'bike', 20),
(2, 'JJ', 'J', 'JJ', 4444, 'J', 'J', 25),
(3, 'zllzl', 'zllzlz', 'zlzlz', 555, 'zlzlzlz@lzlz.com', 'zzzz', 2),
(4, '4TZTZ', 'ZETZ', 'ZERZETZ', 88, 'ZTZE', 'ZTTEZZ', 21),
(5, 'oussama', 'benhassen', 'tunis', 21885045, 'ouss@esprit.tn', 'bike', 28);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `theme`
--

INSERT INTO `theme` (`id`, `nom`) VALUES
(1, 'Culturel'),
(2, 'Aventure');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `association`
--
ALTER TABLE `association`
  ADD CONSTRAINT `FK_FD8521CC59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_E52FFDEEA76ED395` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_E52FFDEEF347EFB` FOREIGN KEY (`Idproduit`) REFERENCES `produit` (`id_prod`) ON DELETE CASCADE;

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
  ADD CONSTRAINT `FK_67F068BC29A0E8AE` FOREIGN KEY (`Publication`) REFERENCES `publication` (`id`),
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
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `FK_EDBE16F89D6A1065` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_EDBE16F8A76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_29A5EC2712469DE2` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id_cat`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_29A5EC2759F022DF` FOREIGN KEY (`iduser`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE;

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
  ADD CONSTRAINT `FK_FB1AD3FC59F022DF` FOREIGN KEY (`Iduser`) REFERENCES `fos_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
