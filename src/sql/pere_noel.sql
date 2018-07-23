-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 13 Février 2016 à 15:07
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `pere_noel`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `admin` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `cp`, `ville`, `tel`, `email`, `login`, `pass`, `admin`) VALUES
(1, 'Mullet', 'Valentin', '44 place du gal de gaulle', '62780', 'Trepied', '012345678', 'valentin.mullet@gmail.com', 'vmullet', 'toto', '1'),
(2, 'toto', 'nono', 'adresse toto', '62000', 'Ville_toto', '0123456789', 'email@toto.com', 'toto', 'toto', '0');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `id_paiement` int(11) NOT NULL,
  `total` float NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`),
  KEY `id_paiement` (`id_paiement`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `id_client`, `id_paiement`, `total`, `date`) VALUES
(5, 1, 3, 266, '2016-02-07 03:45:12'),
(6, 1, 1, 196, '2016-02-07 16:58:09'),
(7, 1, 3, 11, '2016-02-07 19:12:31'),
(8, 1, 1, 27, '2016-02-07 19:13:49'),
(9, 1, 3, 39, '2016-02-07 19:24:38'),
(10, 1, 1, 11, '2016-02-07 19:26:07'),
(11, 1, 3, 17, '2016-02-07 19:28:23'),
(12, 1, 3, 11, '2016-02-07 19:49:18');

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE IF NOT EXISTS `contenir` (
  `id_commande` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id_commande`,`id_produit`),
  KEY `id_produit` (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenir`
--

INSERT INTO `contenir` (`id_commande`, `id_produit`, `quantite`) VALUES
(5, 9, 2),
(5, 10, 3),
(5, 12, 1),
(6, 7, 2),
(6, 9, 3),
(6, 11, 3),
(6, 14, 3),
(7, 7, 1),
(8, 7, 2),
(8, 10, 1),
(9, 7, 2),
(9, 9, 1),
(9, 10, 1),
(10, 7, 1),
(11, 9, 1),
(11, 10, 1),
(12, 7, 1);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`id`, `libelle`) VALUES
(1, 'CB'),
(2, 'Chèque'),
(3, 'Paypal');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `description` varchar(250) NOT NULL,
  `stock` int(11) NOT NULL,
  `prix` varchar(50) NOT NULL,
  `lien_image` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `description`, `stock`, `prix`, `lien_image`) VALUES
(7, 'Produit1', 'Description Produit 1', 4, '11', 'img/produits/1.jpg'),
(8, 'Produit2', 'Description Produit 2', 7, '11', 'img/produits/2.jpg'),
(9, 'Produit3', 'Description Produit 3', 3, '12', 'img/produits/3.jpg'),
(10, 'Produit4', 'Description Produit 4', 4, '5', 'img/produits/4.jpg'),
(11, 'Produit5', 'Description Produit 5', 11, '40', 'img/produits/5.jpg'),
(12, 'Produit6', 'Description Produit 6', 11, '41', 'img/produits/6.jpg'),
(13, 'Produit7', 'Description Produit 7', 17, '8', 'img/produits/7.jpg'),
(14, 'Produit8', 'Description Produit 8', 15, '6', 'img/produits/8.jpg'),
(15, 'Produit9', 'Description Produit 9', 19, '3', 'img/produits/9.jpg'),
(16, 'Produit10', 'Description Produit 10', 20, '25', 'img/produits/10.jpg'),
(17, 'Produit11', 'Description Produit 11', 21, '14', 'img/produits/11.jpg'),
(18, 'Produit12', 'Description Produit 12', 22, '6', 'img/produits/12.jpg'),
(19, 'Produit13', 'Description Produit 13', 23, '50', 'img/produits/13.jpg'),
(20, 'Produit14', 'Description Produit 14', 24, '12', 'img/produits/14.jpg'),
(21, 'Produit15', 'Description Produit 15', 25, '42', 'img/produits/15.jpg');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD CONSTRAINT `contenir_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contenir_ibfk_2` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
