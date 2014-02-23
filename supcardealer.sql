-- phpMyAdmin SQL Dump
-- version 4.0.6
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 18 Janvier 2014 à 02:16
-- Version du serveur: 5.5.33
-- Version de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données: `supcardealer`
--

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

CREATE TABLE `cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `seats` int(10) DEFAULT NULL,
  `baggage` int(10) DEFAULT NULL,
  `doors` int(10) DEFAULT NULL,
  `gear_box` varchar(255) DEFAULT NULL,
  `conditional_air` tinyint(1) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `car_cat_fk` bigint(20) DEFAULT NULL,
  `car_user_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC42BD16421D9CE0C` (`car_cat_fk`),
  KEY `FK2E7B1FE2212CD4` (`car_user_fk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Small'),
(2, 'Midsize'),
(3, 'Large'),
(4, 'Luxury'),
(5, 'Sports');

-- --------------------------------------------------------

--
-- Structure de la table `rents`
--

CREATE TABLE `rents` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_start` date DEFAULT NULL,
  `date_stop` date DEFAULT NULL,
  `kilometer` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `rent_car_fk` bigint(20) DEFAULT NULL,
  `rent_user_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC42BD17221D1CE8C` (`rent_car_fk`),
  KEY `FKC42BD45678D1CE8C` (`rent_user_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `FK2E7B1FE2212CD4` FOREIGN KEY (`car_user_fk`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKC42BD16421D9CE0C` FOREIGN KEY (`car_cat_fk`) REFERENCES `categories` (`id`);

--
-- Contraintes pour la table `rents`
--
ALTER TABLE `rents`
  ADD CONSTRAINT `FKC42BD17221D1CE8C` FOREIGN KEY (`rent_car_fk`) REFERENCES `cars` (`id`),
  ADD CONSTRAINT `FKC42BD45678D1CE8C` FOREIGN KEY (`rent_user_fk`) REFERENCES `users` (`id`);

