-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 13, 2022 alle 14:38
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmalinkazienda`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `contratto`
--

CREATE TABLE `contratto` (
  `idContratto` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contratto`
--

INSERT INTO `contratto` (`idContratto`, `idUtente`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmaco`
--

CREATE TABLE `farmaco` (
  `idFarmaco` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `principio` varchar(30) NOT NULL,
  `scadenza` date NOT NULL,
  `quantita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmaco`
--

INSERT INTO `farmaco` (`idFarmaco`, `nome`, `principio`, `scadenza`, `quantita`) VALUES
(1, 'Tachipirina', 'Prova', '2022-05-16', 50),
(2, 'Oki', 'Prova', '2022-06-05', 130);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmacocontratto`
--

CREATE TABLE `farmacocontratto` (
  `idContratto` int(11) NOT NULL,
  `idFarmaco` int(11) NOT NULL,
  `quantita` int(11) NOT NULL,
  `periodo` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmacocontratto`
--

INSERT INTO `farmacocontratto` (`idContratto`, `idFarmaco`, `quantita`, `periodo`, `id`) VALUES
(1, 1, 20, 50, 1),
(2, 2, 50, 20, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmacoordine`
--

CREATE TABLE `farmacoordine` (
  `idFarmaco` int(11) NOT NULL,
  `idOrdine` int(11) NOT NULL,
  `quantita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmacoordine`
--

INSERT INTO `farmacoordine` (`idFarmaco`, `idOrdine`, `quantita`) VALUES
(1, 1, 50);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `idOrdine` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `dataConsegna` date NOT NULL,
  `stato` varchar(50) NOT NULL,
  `note` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`idOrdine`, `idUtente`, `dataConsegna`, `stato`, `note`) VALUES
(1, 1, '2022-06-20', 'In preparazione', NULL),
(2, 2, '2022-06-30', 'In preparazione', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `lavoro` varchar(30) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`nome`, `cognome`, `email`, `password`, `lavoro`, `id`) VALUES
('Salvatore', 'Vigano\'', 'salvatore.vigano06@gmail.com', 'prova', 'farmacista', 1),
('Francesco Paolo', 'Rosone', 'cicciopaoloros@gmail.com', 'prova', 'farmacista', 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `contratto`
--
ALTER TABLE `contratto`
  ADD PRIMARY KEY (`idContratto`),
  ADD KEY `idUtente` (`idUtente`);

--
-- Indici per le tabelle `farmaco`
--
ALTER TABLE `farmaco`
  ADD PRIMARY KEY (`idFarmaco`);

--
-- Indici per le tabelle `farmacocontratto`
--
ALTER TABLE `farmacocontratto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idContratto` (`idContratto`),
  ADD KEY `idFarmaco` (`idFarmaco`);

--
-- Indici per le tabelle `farmacoordine`
--
ALTER TABLE `farmacoordine`
  ADD KEY `idOrdine` (`idOrdine`),
  ADD KEY `idFarmaco` (`idFarmaco`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`idOrdine`),
  ADD KEY `idUtente` (`idUtente`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `contratto`
--
ALTER TABLE `contratto`
  MODIFY `idContratto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `farmaco`
--
ALTER TABLE `farmaco`
  MODIFY `idFarmaco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `farmacocontratto`
--
ALTER TABLE `farmacocontratto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `contratto`
--
ALTER TABLE `contratto`
  ADD CONSTRAINT `contratto_ibfk_1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`);

--
-- Limiti per la tabella `farmacocontratto`
--
ALTER TABLE `farmacocontratto`
  ADD CONSTRAINT `farmacocontratto_ibfk_1` FOREIGN KEY (`idContratto`) REFERENCES `contratto` (`idContratto`),
  ADD CONSTRAINT `farmacocontratto_ibfk_2` FOREIGN KEY (`idFarmaco`) REFERENCES `farmaco` (`idFarmaco`);

--
-- Limiti per la tabella `farmacoordine`
--
ALTER TABLE `farmacoordine`
  ADD CONSTRAINT `farmacoordine_ibfk_1` FOREIGN KEY (`idOrdine`) REFERENCES `ordine` (`idOrdine`),
  ADD CONSTRAINT `farmacoordine_ibfk_2` FOREIGN KEY (`idFarmaco`) REFERENCES `farmaco` (`idFarmaco`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `ordine_ibfk_1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
