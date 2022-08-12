-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 12, 2022 alle 12:28
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
(2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmaco`
--

CREATE TABLE `farmaco` (
  `idFarmaco` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `principio` varchar(1000) NOT NULL,
  `scadenza` date NOT NULL,
  `quantita` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `periodoProduzione` int(11) NOT NULL DEFAULT 1,
  `da_banco` tinyint(1) NOT NULL,
  `Ricaricato` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmaco`
--

INSERT INTO `farmaco` (`idFarmaco`, `nome`, `principio`, `scadenza`, `quantita`, `periodoProduzione`, `da_banco`, `Ricaricato`) VALUES
(1, 'TACHIPIRINA 500 MG COMPRESSE 30 COMPRESSE', 'PARACETAMOLO', '2024-06-20', 2000, 14, 1, 0),
(2, 'TACHIPIRINA 500 MG COMPRESSE 20 COMPRESSE', 'PARACETAMOLO', '2023-08-17', 2000, 14, 1, 0),
(3, 'RINAZINA 100 MG/100 ML SPRAY NASALE', 'NAFAZOLINA NITRATO 1 MG, PARI A NAFAZOLINA 0,77 MG. ECCIPIENTI: SODIO CLORURO, DISODIO EDETATO, SODI', '2025-09-15', 2000, 30, 1, 0),
(5, 'OKITASK 40 MG GRANULATO 10 BUSTINE ', 'KETOPROFENE', '2024-04-28', 2000, 14, 1, 0),
(6, 'OKITASK 40 MG GRANULATO 20 BUSTINE', 'KETOPROFENE', '2023-03-19', 2000, 14, 1, 0),
(7, 'ENTEROGERMINA 5 ML SOSPENSIONE ORALE 5 FLACONCINI', 'BACILLUS CLAUSII POLIANTIBIOTICO', '2022-09-14', 0, 10, 1, 0),
(8, 'ENTEROGERMINA 5 ML SOSPENSIONE ORALE 10 FLACONCINI', 'BACILLUS CLAUSII POLIANTIBIOTICO', '2023-06-19', 2000, 14, 1, 0),
(10, 'TACHIFLUDEC 10 BUSTINE', 'PARACETAMOLO, ACIDO ASCORBICO, FENILEFRINA CLORIDRATO', '2023-02-06', 2000, 14, 1, 0),
(13, 'BENACTIV GOLA 16 PASTIGLIE', 'FLURBIPROFENE', '2023-06-19', 2000, 14, 1, 0),
(14, 'BRONCHENOLO SCIROPPO FLACONE 150 ML', 'DESTROMETORFANO BROMIDRATO, GUAIFENESINA', '2023-10-15', 2000, 14, 1, 0),
(15, 'MAALOX PLUS 30\nCOMPRESSE', 'CHINIDINA', '2024-04-14', 2000, 11, 1, 0),
(19, 'MAALOX 30 COMPRESSE', 'CHINIDINA', '2025-07-08', 2000, 11, 1, 0),
(22, 'MAALOX PLUS 30\nCOMPRESSE', 'CHINIDINA', '2025-07-08', 2000, 11, 1, 0),
(23, 'MAALOX 30 COMPRESSE', 'CHINIDINA', '2026-10-01', 2000, 11, 1, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmacocontratto`
--

CREATE TABLE `farmacocontratto` (
  `idContratto` int(11) NOT NULL,
  `idFarmaco` int(11) NOT NULL,
  `quantita` int(11) NOT NULL,
  `periodo` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `spedito` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmacocontratto`
--

INSERT INTO `farmacocontratto` (`idContratto`, `idFarmaco`, `quantita`, `periodo`, `id`, `spedito`) VALUES
(2, 1, 20, 4, 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `farmacoordine`
--

CREATE TABLE `farmacoordine` (
  `idOrdine` int(11) NOT NULL,
  `idFarmaco` int(11) NOT NULL,
  `quantita` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmacoordine`
--

INSERT INTO `farmacoordine` (`idOrdine`, `idFarmaco`, `quantita`, `id`) VALUES
(23, 1, 10, 31),
(23, 13, 10, 32),
(24, 1, 20, 33);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `idOrdine` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `dataConsegna` date NOT NULL,
  `stato` varchar(30) NOT NULL,
  `note` varchar(5000) NOT NULL,
  `dataOrdine` varchar(30) NOT NULL,
  `fattorino` int(11) DEFAULT NULL,
  `ordineCaricato` varchar(2) DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`idOrdine`, `idUtente`, `dataConsegna`, `stato`, `note`, `dataOrdine`, `fattorino`, `ordineCaricato`) VALUES
(23, 2, '2022-08-12', 'Consegnato', 'Risolte problematiche inerenti all\'ordine', '2022-08-05 12:12:11', 1, 'Si'),
(24, 2, '2022-08-19', 'In preparazione', 'Ordine periodico', '2022-08-12 12:23:16', NULL, 'No');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `indirizzo` varchar(100) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `lavoro` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `flag` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`nome`, `cognome`, `indirizzo`, `email`, `password`, `lavoro`, `id`, `flag`) VALUES
('Francesco Paolo', 'Rosone', 'Via Uditore 12', 'cicciopaoloros@gmail.com', 'rosone', 'fattorino', 1, 0),
('Farmacia', 'Bonagia', 'Via libertà 171', 'davidesgroi99@gmail.com', 'sgroi', 'farmacista', 2, 0),
('Salvatore', 'Viganò', 'Via bonagia 22', 'salvatore.vigano06@gmail.com', 'salvo', 'magazziniere', 3, 0);

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
  ADD KEY `idFarmaco_farmacocontratto` (`idFarmaco`);

--
-- Indici per le tabelle `farmacoordine`
--
ALTER TABLE `farmacoordine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idOrdine` (`idOrdine`),
  ADD KEY `idFarmaco` (`idFarmaco`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`idOrdine`),
  ADD KEY `idUtente` (`idUtente`),
  ADD KEY `fattorino` (`fattorino`);

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
  MODIFY `idFarmaco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT per la tabella `farmacocontratto`
--
ALTER TABLE `farmacocontratto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `farmacoordine`
--
ALTER TABLE `farmacoordine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  ADD CONSTRAINT `idContratto_farmacocontratto` FOREIGN KEY (`idContratto`) REFERENCES `contratto` (`idContratto`),
  ADD CONSTRAINT `idFarmaco_farmacocontratto` FOREIGN KEY (`idFarmaco`) REFERENCES `farmaco` (`idFarmaco`);

--
-- Limiti per la tabella `farmacoordine`
--
ALTER TABLE `farmacoordine`
  ADD CONSTRAINT `idFarmaco_farmacoordine` FOREIGN KEY (`idFarmaco`) REFERENCES `farmaco` (`idFarmaco`),
  ADD CONSTRAINT `idOrdine_farmacoordine` FOREIGN KEY (`idOrdine`) REFERENCES `ordine` (`idOrdine`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `ordine_ibfk_1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`),
  ADD CONSTRAINT `ordine_ibfk_2` FOREIGN KEY (`fattorino`) REFERENCES `utente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
