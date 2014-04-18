-- phpMyAdmin SQL Dump
-- version 2.11.0
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Ven 18 Avril 2014 à 09:07
-- Version du serveur: 4.1.22
-- Version de PHP: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `evolappli`
--

-- --------------------------------------------------------

--
-- Structure de la table `application`
--

CREATE TABLE IF NOT EXISTS `application` (
  `idApplication` int(11) NOT NULL auto_increment,
  `nomApplication` varchar(50) character set utf8 NOT NULL default '',
  `visibiliteApplication` varchar(8) character set utf8 NOT NULL default '0',
  PRIMARY KEY  (`idApplication`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `application`
--

INSERT INTO `application` (`idApplication`, `nomApplication`, `visibiliteApplication`) VALUES
(1, 'Ulis CS', ''),
(2, 'Ulis Web', ''),
(3, 'Kristina', ''),
(4, 'Ulis Thot', ''),
(5, 'futee', ''),
(6, 'e-rh', ''),
(7, 'Ulis VM', 'Archivée');

-- --------------------------------------------------------

--
-- Structure de la table `cellule`
--

CREATE TABLE IF NOT EXISTS `cellule` (
  `idCellule` int(11) NOT NULL auto_increment,
  `nomCellule` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idCellule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cellule`
--

INSERT INTO `cellule` (`idCellule`, `nomCellule`) VALUES
(1, 'Maladies'),
(2, 'Congés'),
(3, 'SPMT');

-- --------------------------------------------------------

--
-- Structure de la table `compocellule`
--

CREATE TABLE IF NOT EXISTS `compocellule` (
  `idCellule` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  `dateDebutCellule` date default NULL,
  `dateFinCellule` date default NULL,
  PRIMARY KEY  (`idCellule`,`idUtilisateur`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compocellule`
--

INSERT INTO `compocellule` (`idCellule`, `idUtilisateur`, `dateDebutCellule`, `dateFinCellule`) VALUES
(1, 1, '2014-01-17', '2099-12-31'),
(1, 2, '2014-01-01', '2099-12-31'),
(1, 10, '2014-01-01', '2014-01-31'),
(2, 2, '2013-12-31', '2099-12-31'),
(3, 2, '2014-01-23', '2099-12-31'),
(3, 5, '2014-01-17', '2099-12-31'),
(3, 10, '2014-01-17', '2099-12-31'),
(3, 11, '2014-01-17', '2014-01-31');

-- --------------------------------------------------------

--
-- Structure de la table `compoprofil`
--

CREATE TABLE IF NOT EXISTS `compoprofil` (
  `idProfil` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  `dateDebutCompoProf` date NOT NULL default '0000-00-00',
  `dateFinCompoProf` date default NULL,
  PRIMARY KEY  (`idProfil`,`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compoprofil`
--


-- --------------------------------------------------------

--
-- Structure de la table `criteresucces`
--

CREATE TABLE IF NOT EXISTS `criteresucces` (
  `idCritere` int(11) NOT NULL auto_increment COMMENT 'n° de l''enregistrement',
  `nomCritere` varchar(128) NOT NULL default '',
  `dateDebutCritere` date NOT NULL default '0000-00-00',
  `dateFinCritere` date NOT NULL default '0000-00-00',
  `numCritere` varchar(5) NOT NULL default '' COMMENT 'code affiché à l''écran et choisi par l''utilisateur',
  `codeCritere` int(11) NOT NULL default '0' COMMENT 'numéro de l''exigence = n° record création',
  `dateDebutCSRecord` date NOT NULL default '0000-00-00',
  `dateFinCSRecord` date NOT NULL default '0000-00-00',
  `fkExigence` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idCritere`),
  KEY `fkExigenc` (`fkExigence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `criteresucces`
--


-- --------------------------------------------------------

--
-- Structure de la table `demandeur`
--

CREATE TABLE IF NOT EXISTS `demandeur` (
  `idPoint` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idUtilisateur`),
  KEY `idPoint` (`idPoint`),
  KEY `demandeur` (`idPoint`,`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `demandeur`
--


-- --------------------------------------------------------

--
-- Structure de la table `direction`
--

CREATE TABLE IF NOT EXISTS `direction` (
  `idDirection` int(11) NOT NULL auto_increment,
  `nomDirection` varchar(50) NOT NULL default '',
  `idDG` int(11) NOT NULL default '0',
  `visibiliteDirection` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`idDirection`),
  KEY `idDG` (`idDG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `direction`
--

INSERT INTO `direction` (`idDirection`, `nomDirection`, `idDG`, `visibiliteDirection`) VALUES
(1, 'Administration du Personnel', 1, 'Archivée'),
(2, 'Gestion Pécuniaire', 2, ''),
(3, 'Fonctionnelle et Appui du SG', 4, ''),
(4, 'Fonction publique', 1, 'Archivée');

-- --------------------------------------------------------

--
-- Structure de la table `directiongeneral`
--

CREATE TABLE IF NOT EXISTS `directiongeneral` (
  `idDG` int(11) NOT NULL auto_increment,
  `nomDG` varchar(50) NOT NULL default '',
  `visibiliteDG` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`idDG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `directiongeneral`
--

INSERT INTO `directiongeneral` (`idDG`, `nomDG`, `visibiliteDG`) VALUES
(1, 'SG', 'Archivée'),
(2, 'DGO1', ''),
(3, 'DGO2', ''),
(4, 'DGO3', '');

-- --------------------------------------------------------

--
-- Structure de la table `exigencefonctionnelle`
--

CREATE TABLE IF NOT EXISTS `exigencefonctionnelle` (
  `idExigence` int(11) NOT NULL auto_increment COMMENT 'n° de l''enregistrement',
  `nomExigence` varchar(50) NOT NULL default '',
  `descriptionExigence` longtext NOT NULL,
  `raisonExigence` longtext NOT NULL,
  `prioriteExigence` int(11) NOT NULL default '0',
  `dateDebutExi` date NOT NULL default '0000-00-00',
  `dateFinExi` date default NULL,
  `numExi` varchar(5) NOT NULL default '' COMMENT 'code affiché à l''écran et choisi par l''utilisateur',
  `codeExigence` int(11) NOT NULL default '0' COMMENT 'numéro de l''exigence = n° record création',
  `dateDebutEFRecord` date NOT NULL default '0000-00-00',
  `dateFinEFRecord` date default NULL,
  `fkSFonct` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idExigence`),
  KEY `fkSFonct` (`fkSFonct`),
  KEY `prioriteExigence` (`prioriteExigence`),
  KEY `codeExigence` (`codeExigence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `exigencefonctionnelle`
--

INSERT INTO `exigencefonctionnelle` (`idExigence`, `nomExigence`, `descriptionExigence`, `raisonExigence`, `prioriteExigence`, `dateDebutExi`, `dateFinExi`, `numExi`, `codeExigence`, `dateDebutEFRecord`, `dateFinEFRecord`, `fkSFonct`) VALUES
(1, 'Créer une nouvelle personne physique', 'Le système permet à un gestionnaire de la DAP ou de la DGP de créer une nouvelle personne physique, avec ses coordonnées, qu’il s’agisse d’un nouvel agent du SPW ou de toute personne en relation avec un agent du SPW et d’y apporter par la suite tout ajout ou modification qu’il souhaite.', 'Créer dans le système le signalétique d’une personne physique recrutée, engagée ou transférée au SPW, ou toute personne en lien avec un agent du SPW (relations).', 2, '2014-04-01', '2099-12-31', '051', 1, '2014-04-01', '2099-12-31', 3),
(2, 'Encoder une personne morale', 'Le système permet d’encoder une nouvelle personne morale ainsi que ses coordonnées.', 'Les personnes morales correspondent à des services ou organismes divers avec 		lesquels le SPW est en contact et dont certaines données lui sont indispensables pour 		la gestion des dossiers des quelque 12.000 personnes rémunérées par le SPW.\r\n		Il peut s’agir de Services publics fédéraux, de para-régionaux, d’entreprises du 			secteur privé, de caisses d’allocations familiales, de personnes ayant le statut 			d’indépendant, etc.\r\n', 1, '2014-04-11', '2099-12-31', '059', 2, '2014-04-11', '2099-12-31', 4),
(3, 'Gérer les adresses électroniques d’un agent', 'Le système doit permettre de gérer une ou plusieurs adresses électroniques pour un agent, notamment l’adresse électronique professionnelle générée par le LDAP, et de définir dans quels cas une éventuelle adresse privée doit prendre le pas sur l’adresse professionnelle.', 'S’assurer de la bonne distribution des courriers électroniques.', 1, '2014-04-11', '2099-12-31', '088', 3, '2014-04-11', '2099-12-31', 3),
(4, 'Encoder une relation familiale d’un agent', 'Le système permet d’associer une personne physique (externe ou interne au SPW) à un agent du SPW par la définition d’une « relation familiale ».', 'Identifier toute personne faisant partie du ménage de l’agent (conjoint, enfant, enfant placé, neveu, ascendant, …).\nCes relations interviennent dans :\n•	La détermination du précompte professionnel (Cf. EFxxx) ;\n•	La détermination du droit éventuel à l’allocation foyer/résidence (Cf. EFxxx) ;\n•	 L’octroi de certains congés (Cf.EFXXX ).\n•	Le calcul des abattements fiscaux (Cf. EF057)\n', 2, '2014-04-11', '2099-12-31', '055', 4, '2014-04-11', '2099-12-31', 3),
(5, 'Encoder une relation fiscale d’un agent', 'Le système permet d’associer une personne physique (externe ou interne au SPW) à un agent du SPW par la définition d’une « relation fiscale ».', 'Identifier toute relation qui impact le précompte professionnel de l’agent. Ces relations interviennent dans la détermination du précompte professionnel.', 2, '2014-04-16', '2099-12-31', '056', 5, '2014-04-16', '2099-12-31', 3),
(6, 'Déterminer automatiquement les abattements fiscaux', 'Le système calculera automatiquement les abattements fiscaux d’un agent, sur base des données connues du système et de la législation en vigueur.', 'Conformément aux dispositions prévues à l’AR/CIR 1992', 2, '2014-04-16', '2099-12-31', '057', 6, '2014-04-16', '2099-12-31', 3),
(7, 'Encoder les diplômes d’un membre du personnel', 'Le système doit permettre au gestionnaire de la DAP d’encoder le ou les diplôme(s) en possession d’un membre du personnel.', 'Les diplômes des membres du personnel constituent une donnée importante en termes de carrière ou de contrat : certaines conditions de diplômes doivent en effet être remplies pour que l’agent soit engagé.  De plus, le calcul de la pension se base également, le cas échéant, sur ces diplômes.', 1, '2014-04-16', '2099-12-31', '058', 7, '2014-04-16', '2099-12-31', 12);

-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `idFichier` int(11) NOT NULL auto_increment,
  `nomFichier` varchar(50) NOT NULL default '',
  `cheminFichier` text NOT NULL,
  PRIMARY KEY  (`idFichier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fichier`
--


-- --------------------------------------------------------

--
-- Structure de la table `fonctionnalite`
--

CREATE TABLE IF NOT EXISTS `fonctionnalite` (
  `idFonctionnalite` int(11) NOT NULL auto_increment,
  `nomFonctionnalite` varchar(50) NOT NULL default '',
  `descriptionFonctionnalite` longtext NOT NULL,
  `dateDebutFonct` date NOT NULL default '0000-00-00',
  `dateFinFonct` date default NULL,
  `numFonct` varchar(5) NOT NULL default '',
  `fkAppli` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idFonctionnalite`),
  UNIQUE KEY `idFonctionnalite` (`idFonctionnalite`),
  UNIQUE KEY `nomFonctionnalite` (`nomFonctionnalite`),
  KEY `fkAppli` (`fkAppli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `fonctionnalite`
--

INSERT INTO `fonctionnalite` (`idFonctionnalite`, `nomFonctionnalite`, `descriptionFonctionnalite`, `dateDebutFonct`, `dateFinFonct`, `numFonct`, `fkAppli`) VALUES
(1, 'Gérer les signalétiques ad', 'Cette fonctionnalité permet à la fois définir les besoins en matière \nde personnes physique que de personnes morales', '2014-03-26', '2014-03-28', '1', 1),
(2, 'Gérer les relations de travail', 'Cette fonctionnalité va reprendre ensemble des éléments liés aux contrats et arrêtés des agents', '2014-03-26', '2014-03-28', '2', 1),
(3, 'Gérer les formations', 'OK', '2014-03-28', '2014-03-28', '1', 3),
(4, 'Gérer les formateurs', 'null', '2014-03-28', '2015-03-01', '2', 3),
(5, 'Gérer les salles de formations', 'oko', '2014-03-28', '2099-12-31', '3', 3),
(6, 'Gérer les évaluation des formations', 'OK', '2014-03-28', '2099-12-31', '4', 3),
(7, 'Gérer les publications', 'Permet de gérer les publications', '2014-03-29', '2014-03-29', '1', 6),
(8, 'Gérer les groupes', 'OK', '2014-03-29', '2014-03-29', '2', 6);

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

CREATE TABLE IF NOT EXISTS `lot` (
  `idLot` int(11) NOT NULL auto_increment,
  `nomLot` varchar(50) character set utf8 NOT NULL default '',
  `dateDebutLot` date NOT NULL default '0000-00-00',
  `dureeLot` int(2) NOT NULL default '0',
  `dureeAd1` int(1) default NULL,
  `dureeAd2` int(11) default NULL,
  `fkMarche` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idLot`),
  UNIQUE KEY `fkMarche` (`fkMarche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `lot`
--


-- --------------------------------------------------------

--
-- Structure de la table `marche`
--

CREATE TABLE IF NOT EXISTS `marche` (
  `idMarche` int(11) NOT NULL auto_increment,
  `nomMarche` varchar(50) character set utf8 NOT NULL default '',
  PRIMARY KEY  (`idMarche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `marche`
--

INSERT INTO `marche` (`idMarche`, `nomMarche`) VALUES
(1, 'Gestion administrative et pécuniaire');

-- --------------------------------------------------------

--
-- Structure de la table `msieajour`
--

CREATE TABLE IF NOT EXISTS `msieajour` (
  `idMiseAJour` int(11) NOT NULL auto_increment,
  `dateProposition` date NOT NULL default '0000-00-00',
  `dateValidation` date default NULL,
  `numCallBmc` varchar(20) default NULL,
  `dateMiseProd` date default NULL,
  PRIMARY KEY  (`idMiseAJour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `msieajour`
--


-- --------------------------------------------------------

--
-- Structure de la table `origineexigence`
--

CREATE TABLE IF NOT EXISTS `origineexigence` (
  `fkExigence` int(11) NOT NULL default '0',
  `fkUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`fkExigence`,`fkUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `origineexigence`
--


-- --------------------------------------------------------

--
-- Structure de la table `pointmaj`
--

CREATE TABLE IF NOT EXISTS `pointmaj` (
  `idPoint` int(11) NOT NULL auto_increment,
  `nom` varchar(50) NOT NULL default '',
  `descriptionPoint` longtext NOT NULL,
  `solutionPoint` longtext,
  `fkOrigine` int(11) NOT NULL default '0',
  `fkTest` int(11) default NULL,
  `fkRisque` int(11) default NULL,
  PRIMARY KEY  (`idPoint`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `pointmaj`
--


-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE IF NOT EXISTS `poste` (
  `idPoste` int(11) NOT NULL auto_increment,
  `nomPoste` varchar(50) NOT NULL default '',
  `descriptionPoste` longtext NOT NULL,
  `optionnelPoste` tinyint(1) NOT NULL default '0',
  `activationPoste` tinyint(1) NOT NULL default '0',
  `dateActivation` date default NULL,
  `idLot` int(11) NOT NULL default '0',
  `idApplication` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idPoste`),
  KEY `idLot` (`idLot`),
  KEY `idApplication` (`idApplication`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `poste`
--


-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE IF NOT EXISTS `priorite` (
  `idPriorite` int(11) NOT NULL auto_increment,
  `nomPriorite` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idPriorite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `priorite`
--

INSERT INTO `priorite` (`idPriorite`, `nomPriorite`) VALUES
(1, 'Important'),
(2, 'Nécessaire');

-- --------------------------------------------------------

--
-- Structure de la table `probabiliterisque`
--

CREATE TABLE IF NOT EXISTS `probabiliterisque` (
  `idProbabilite` int(11) NOT NULL auto_increment,
  `probabilite` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idProbabilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `probabiliterisque`
--


-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `idProfil` int(11) NOT NULL auto_increment,
  `nomProfil` varchar(50) NOT NULL default '',
  `dateDebutProfil` date NOT NULL default '0000-00-00',
  `dateFinProfil` date default NULL,
  PRIMARY KEY  (`idProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `profil`
--


-- --------------------------------------------------------

--
-- Structure de la table `raison`
--

CREATE TABLE IF NOT EXISTS `raison` (
  `idRaison` int(11) NOT NULL auto_increment,
  `resume` varchar(50) NOT NULL default '',
  `description` longtext NOT NULL,
  `dateDebutRaison` date NOT NULL default '0000-00-00',
  `dateFinRaison` date NOT NULL default '0000-00-00',
  `numRaison` varchar(5) NOT NULL default '',
  `fkExigence` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idRaison`),
  KEY `fkExigence` (`fkExigence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `raison`
--


-- --------------------------------------------------------

--
-- Structure de la table `risque`
--

CREATE TABLE IF NOT EXISTS `risque` (
  `idRisque` int(11) NOT NULL auto_increment,
  `nomRisque` varchar(50) NOT NULL default '',
  `descriptionRisque` longtext NOT NULL,
  `fkType` int(11) NOT NULL default '0',
  `fkProbabilite` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idRisque`),
  KEY `fkType` (`fkType`),
  KEY `fkProbabilite` (`fkProbabilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `risque`
--


-- --------------------------------------------------------

--
-- Structure de la table `sousfonctionnalite`
--

CREATE TABLE IF NOT EXISTS `sousfonctionnalite` (
  `idSousFonct` int(11) NOT NULL auto_increment COMMENT 'n° de l''enregistrement',
  `nomSFonct` varchar(128) character set utf8 NOT NULL default '',
  `dateDebutSFonct` date NOT NULL default '0000-00-00',
  `dateFinSFonct` date default NULL,
  `numSFonct` varchar(5) character set utf8 NOT NULL default '' COMMENT 'code affiché à l''écran et choisi par l''utilisateur',
  `codeSFonct` int(11) NOT NULL default '0' COMMENT 'numéro de la SFonctionnalité = n° record création',
  `dateDebutSFRecord` date NOT NULL default '0000-00-00',
  `dateFinSFRecord` date default NULL,
  `fkFonct` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idSousFonct`),
  KEY `fkFonct` (`fkFonct`),
  KEY `codeSFonct` (`codeSFonct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Contenu de la table `sousfonctionnalite`
--

INSERT INTO `sousfonctionnalite` (`idSousFonct`, `nomSFonct`, `dateDebutSFonct`, `dateFinSFonct`, `numSFonct`, `codeSFonct`, `dateDebutSFRecord`, `dateFinSFRecord`, `fkFonct`) VALUES
(1, 'Gérer', '2014-04-01', '2099-12-31', '1', 1, '2014-04-01', '2014-04-04', 1),
(2, 'Gestion', '2014-04-01', '2099-12-31', '2', 2, '2014-04-01', '2014-04-04', 1),
(3, 'horaer', '2014-04-01', '2099-12-31', '3', 3, '2014-04-01', '2014-04-04', 1),
(4, 'test', '2014-04-01', '2099-12-31', '4', 4, '2014-04-01', '2014-04-04', 1),
(5, 'bouh', '2014-04-01', '2099-12-31', '5', 5, '2014-04-01', '2014-04-16', 1),
(6, 'fdqsf', '2014-04-06', '2099-12-31', '46', 6, '2014-04-06', '2099-12-31', 1),
(7, '45646', '2014-04-02', '2099-12-31', '565', 7, '2014-04-02', '2099-12-31', 1),
(8, '87', '2014-04-01', '2099-12-31', '4', 8, '2014-04-01', '2014-04-04', 1),
(9, 'blabla', '2014-04-01', '2099-12-31', '56', 9, '2014-04-01', '2099-12-31', 1),
(10, 'hello', '2014-04-05', '2099-12-31', '87', 10, '2014-04-05', '2099-12-31', 1),
(11, 'Modifier', '2014-04-03', '2099-12-31', '109', 11, '2014-04-03', '2014-04-04', 1),
(12, 'Elo', '2014-04-04', '2099-12-31', '17', 12, '2014-04-04', '2014-04-04', 1),
(13, 'Rien à déclarer', '2014-04-05', '2099-12-31', '4', 13, '2014-04-05', '2014-04-04', 2),
(14, 'horaire', '2014-04-01', '2099-12-31', '3', 3, '2014-04-04', '2014-04-04', 1),
(15, 'Potter', '2014-04-01', '2099-12-31', '4', 12, '2014-04-04', '2014-04-04', 1),
(16, 'Harry', '2014-04-01', '2099-12-31', '4', 12, '2014-04-04', '2014-04-04', 1),
(17, 'Potter', '2014-04-01', '2099-12-31', '4', 12, '2014-04-04', '2014-04-04', 1),
(18, 'Gérer les personnes physiques', '2014-04-01', '2099-12-31', '3', 3, '2014-04-04', '2014-04-11', 1),
(19, 'Gérer les personnes morales', '2014-04-01', '2099-12-31', '4', 4, '2014-04-04', '2014-04-04', 1),
(20, 'Potter', '2014-04-01', '2099-12-31', '12', 12, '2014-04-04', '2014-04-04', 1),
(21, 'Gérer les dîplomes', '2014-04-01', '2099-12-31', '12', 12, '2014-04-04', '2014-04-04', 1),
(22, 'Gérer les dîplomes', '2014-04-01', '2099-12-31', '1', 12, '2014-04-04', '2014-04-04', 1),
(23, 'Gérer les dîplomes', '2014-04-01', '2014-04-04', '1', 12, '2014-04-04', '2014-04-04', 1),
(24, 'Gérer les dîplomes', '2014-04-01', '2099-12-31', '1', 12, '2014-04-04', '2099-12-31', 1),
(25, 'Gérer les personnes morales', '2014-04-01', '2014-04-04', '4', 4, '2014-04-04', '2014-04-12', 1),
(26, 'Gérer les personnes physique', '2014-04-01', '2099-12-31', '3', 3, '2014-04-11', '2014-04-11', 1),
(27, 'Gérer les personnes physiques', '2014-04-01', '2099-12-31', '3', 3, '2014-04-11', '2014-04-11', 1),
(28, 'Gestion des adresses', '2014-04-05', '2099-12-31', '02', 3, '2014-04-11', '2014-04-11', 1),
(29, 'Gestion des personnes physiques', '2014-04-05', '2099-12-31', '3', 3, '2014-04-11', '2014-04-11', 1),
(30, 'Gestion des adresses', '2014-04-01', '2099-12-31', '5', 3, '2014-04-11', '2014-04-11', 1),
(31, 'Gestion des personnes physiques', '2014-04-01', '2099-12-31', '5', 3, '2014-04-11', '2014-04-11', 1),
(33, 'Gestion des personnes physique', '2014-04-01', '2014-04-04', '5', 4, '2014-04-12', '2014-04-12', 1),
(34, 'Gestion des personnes morales', '2014-04-01', '2014-04-04', '5', 4, '2014-04-12', '2099-12-31', 1),
(35, 'Gestion des personnes physique', '2014-04-01', '2014-04-04', '03', 3, '2014-04-12', '2014-04-12', 1),
(36, 'Gestion des personnes physique', '2014-04-01', '2099-12-31', '03', 3, '2014-04-12', '2014-04-16', 1),
(37, 'bouh', '2014-04-01', '2099-12-31', '54', 5, '2014-04-16', '2099-12-31', 1),
(39, 'bouh56', '2014-04-01', '2099-12-31', '100', 5, '2014-04-16', '2014-04-16', 1),
(40, 'bouh5', '2014-04-01', '2099-12-31', '5', 5, '2014-04-16', '2014-04-16', 1),
(41, 'Gestion des personnes physiques', '2014-04-01', '2099-12-31', '03', 3, '2014-04-16', '2014-04-18', 1),
(42, 'Gestion', '2014-04-01', '2099-12-31', '5', 5, '2014-04-16', '2099-12-31', 1),
(43, 'Hello world', '2014-04-16', '2099-12-31', '45', 43, '2014-04-16', '2014-04-16', 1),
(44, 'Hello world', '2014-04-16', '2014-04-16', '45', 43, '2014-04-16', '2099-12-31', 1),
(45, 'Gestion des adresses', '2014-04-16', '2099-12-31', '3', 45, '2014-04-16', '2099-12-31', 1),
(46, 'Confrontation avec les données provenant du Registre National', '2014-04-16', '2099-12-31', '23', 46, '2014-04-16', '2099-12-31', 1),
(47, 'Gestion du volontariat fiscal', '2014-04-16', '2099-12-31', '23', 47, '2014-04-16', '2099-12-31', 1),
(48, 'Edition de rapport sur les signalétiques', '2014-04-16', '2099-12-31', '45', 48, '2014-04-16', '2099-12-31', 1),
(49, 'Gestion des personnes physique', '2014-04-01', '2099-12-31', '03', 3, '2014-04-18', '2014-04-18', 1),
(50, 'Gestion des personnes physiques', '2014-04-01', '2099-12-31', '03', 3, '2014-04-18', '2099-12-31', 1);

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `idTest` int(11) NOT NULL auto_increment,
  `descriptionTest` longtext NOT NULL,
  `dateTest` date NOT NULL default '0000-00-00',
  `fkResulTest` int(11) NOT NULL default '0',
  `fkFichier` int(11) default NULL,
  `fkTesteur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idTest`),
  KEY `fkResulTest` (`fkResulTest`),
  KEY `fkFichier` (`fkFichier`),
  KEY `fkTesteur` (`fkTesteur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `test`
--


-- --------------------------------------------------------

--
-- Structure de la table `typeresultat`
--

CREATE TABLE IF NOT EXISTS `typeresultat` (
  `idTypeResultat` int(11) NOT NULL auto_increment,
  `resultat` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idTypeResultat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typeresultat`
--


-- --------------------------------------------------------

--
-- Structure de la table `typerisque`
--

CREATE TABLE IF NOT EXISTS `typerisque` (
  `idType` int(11) NOT NULL auto_increment,
  `nomType` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typerisque`
--


-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL auto_increment,
  `nomUtilisateur` varchar(50) NOT NULL default '',
  `prenomUtilisateur` varchar(50) NOT NULL default '',
  `numUlis` varchar(6) NOT NULL default '',
  `mailUtilisateur` varchar(60) NOT NULL default '',
  `utilisateurActif` varchar(8) NOT NULL default '',
  `directionUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idUtilisateur`),
  UNIQUE KEY `numUlis` (`numUlis`),
  KEY `directionUtilisateur` (`directionUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `numUlis`, `mailUtilisateur`, `utilisateurActif`, `directionUtilisateur`) VALUES
(1, 'Dauphin', 'Rudi', '103223', 'rudi.dauphin@spw.wallonie.be', '', 1),
(2, 'Deceuleneer', 'Cédric', '34744', 'cedric.deceuleneer@spw.wallonie.be', '', 3),
(3, 'Yans', 'Elodie', '38183', 'elodie.yans@spw.wallonie.be', '', 1),
(4, 'Stassin', 'Nathalie', '124950', 'nathalie.stassin@spw.wallonie.be', '', 2),
(5, 'Dussart', 'Isabelle', '103257', 'isabelle.dussart@spw.wallonie.be', '', 3),
(6, 'Jaupart', 'Alexandra', '37183', 'alexandra.jaupart@spw.wallonie.be', '', 3),
(7, 'Hamès', 'Anne-Marie', '102583', 'annemarie.hames@spw.wallonie.be', 'Inactif', 2),
(8, 'Hérion', 'Christelle', '2542', 'christelle.herion@spw.wallonie.be', '', 3),
(9, 'Maeck', 'Isabelle', '123465', 'isabelle.maeck@spw.wallonie.be', '', 3),
(10, 'Anzalone', 'Sandra', '123456', 'sandra.anzalone@spw.wallonie.be', 'Inactif', 1),
(11, 'Pauly', 'Béatrice', '1564', 'beatrice.pauly@spw.wallonie.be', '', 1),
(12, 'Pierrard', 'Agnès', '102811', 'agnes.pierrard@spw.wallonie.be', '', 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compocellule`
--
ALTER TABLE `compocellule`
  ADD CONSTRAINT `compocellule_ibfk_4` FOREIGN KEY (`idCellule`) REFERENCES `cellule` (`idCellule`),
  ADD CONSTRAINT `compocellule_ibfk_5` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `criteresucces`
--
ALTER TABLE `criteresucces`
  ADD CONSTRAINT `criteresucces_ibfk_1` FOREIGN KEY (`fkExigence`) REFERENCES `exigencefonctionnelle` (`codeExigence`);

--
-- Contraintes pour la table `direction`
--
ALTER TABLE `direction`
  ADD CONSTRAINT `direction_ibfk_1` FOREIGN KEY (`idDG`) REFERENCES `directiongeneral` (`idDG`);

--
-- Contraintes pour la table `exigencefonctionnelle`
--
ALTER TABLE `exigencefonctionnelle`
  ADD CONSTRAINT `exigencefonctionnelle_ibfk_1` FOREIGN KEY (`prioriteExigence`) REFERENCES `priorite` (`idPriorite`),
  ADD CONSTRAINT `exigencefonctionnelle_ibfk_2` FOREIGN KEY (`fkSFonct`) REFERENCES `sousfonctionnalite` (`codeSFonct`);

--
-- Contraintes pour la table `fonctionnalite`
--
ALTER TABLE `fonctionnalite`
  ADD CONSTRAINT `fonctionnalite_ibfk_1` FOREIGN KEY (`fkAppli`) REFERENCES `application` (`idApplication`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`fkMarche`) REFERENCES `marche` (`idMarche`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`idLot`) REFERENCES `lot` (`idLot`),
  ADD CONSTRAINT `poste_ibfk_2` FOREIGN KEY (`idApplication`) REFERENCES `application` (`idApplication`);

--
-- Contraintes pour la table `raison`
--
ALTER TABLE `raison`
  ADD CONSTRAINT `raison_ibfk_1` FOREIGN KEY (`fkExigence`) REFERENCES `exigencefonctionnelle` (`idExigence`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `risque`
--
ALTER TABLE `risque`
  ADD CONSTRAINT `risque_ibfk_1` FOREIGN KEY (`fkType`) REFERENCES `typerisque` (`idType`) ON UPDATE CASCADE,
  ADD CONSTRAINT `risque_ibfk_2` FOREIGN KEY (`fkProbabilite`) REFERENCES `probabiliterisque` (`idProbabilite`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `sousfonctionnalite`
--
ALTER TABLE `sousfonctionnalite`
  ADD CONSTRAINT `sousfonctionnalite_ibfk_1` FOREIGN KEY (`fkFonct`) REFERENCES `fonctionnalite` (`idFonctionnalite`);

--
-- Contraintes pour la table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_3` FOREIGN KEY (`fkResulTest`) REFERENCES `typeresultat` (`idTypeResultat`) ON UPDATE CASCADE,
  ADD CONSTRAINT `test_ibfk_4` FOREIGN KEY (`fkFichier`) REFERENCES `fichier` (`idFichier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `test_ibfk_5` FOREIGN KEY (`fkTesteur`) REFERENCES `utilisateur` (`idUtilisateur`) ON UPDATE CASCADE;
