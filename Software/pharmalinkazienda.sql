-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 25, 2022 alle 15:35
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
  `nome` varchar(300) NOT NULL,
  `principio` varchar(1000) NOT NULL,
  `scadenza` date NOT NULL,
  `quantita` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `periodoProduzione` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `farmaco`
--

INSERT INTO `farmaco` (`idFarmaco`, `nome`, `principio`, `scadenza`, `quantita`, `periodoProduzione`) VALUES
(1, 'TACHIPIRINA \"500 MG COMPRESSE\" 30 COMPRESSE', 'PARACETAMOLO', '2024-06-20', 9990, 14),
(2, 'TACHIPIRINA \"500 MG COMPRESSE\" 20 COMPRESSE', 'PARACETAMOLO', '2023-08-17', 7200, 14),
(3, 'RINAZINA \"100 MG/100 ML SPRAY NASALE, SOLUZIONE\" FLACONE 15ML', 'NAFAZOLINA NITRATO 1 MG, PARI A NAFAZOLINA 0,77 MG. ECCIPIENTI: SODIO CLORURO, DISODIO EDETATO, SODI', '2025-09-15', 3150, 30),
(4, 'ASPIRINA \"400 MG COMPRESSE EFFERVESCENTI CON VITAMINA C\" 20 COMPRESSE IN STRIP AL/PE/CARTA-PE/AL/SURLYN', 'ACIDO ACETILSALICILICO', '2022-06-12', 2220, 7),
(5, 'OKITASK \"40 MG GRANULATO\" 10 BUSTINE ', 'KETOPROFENE', '2024-04-28', 1200, 14),
(6, 'OKITASK \"40 MG GRANULATO\" 20 BUSTINE', 'KETOPROFENE', '2023-03-19', 1800, 14),
(7, 'ENTEROGERMINA \"4 MILIARDI / 5 ML SOSPENSIONE ORALE\" 5 FLACONCINI', 'BACILLUS CLAUSII POLIANTIBIOTICO', '2022-11-21', 700, 10),
(8, 'ENTEROGERMINA \"4 MILIARDI / 5 ML SOSPENSIONE ORALE\" 10 FLACONCINI', 'BACILLUS CLAUSII POLIANTIBIOTICO', '2023-06-19', 4150, 14),
(9, 'MOMENT \"200 MG COMPRESSE RIVESTITE\" 12 COMPRESSE', 'IBUPROFENE', '2022-10-10', 3660, 10),
(10, 'TACHIFLUDEC \"POLVERE PER SOLUZIONE ORALE\" 10 BUSTINE GUSTO LIMONE E MIELE', 'PARACETAMOLO, ACIDO ASCORBICO, FENILEFRINA CLORIDRATO', '2023-02-06', 6200, 14),
(11, 'ASPIRINA DOLORE E INFIAMMAZIONE \"500 MG COMPRESSE RIVESTITE\" 20\r\nCOMPRESSE IN BLISTER AL/PE/CART', 'ACIDO ACETILSALICILICO', '2022-06-21', 2220, 10),
(12, 'BENAGOL \"PASTIGLIE CON VITAMINA C GUSTO ARANCIA\" 16 PASTIGLIE', 'DICLOROBENZIL ALCOOL, AMILMETACRESOLO', '2022-06-25', 2650, 20),
(13, 'BENACTIV GOLA \"8,75 MG PASTIGLIE SENZA ZUCCHERO GUSTO ARANCIA\" 16 PASTIGLIE', 'FLURBIPROFENE', '2023-06-19', 1900, 14),
(14, 'BRONCHENOLO SEDATIVO E FLUIDIFICANTE \"1,5 MG/ML + 10 MG/ML SCIROPPO\" FLACONE 150 ML', 'DESTROMETORFANO BROMIDRATO, GUAIFENESINA', '2023-10-15', 1560, 14),
(15, 'MAALOX \"PLUS 200 MG + 200 MG + 25 MG COMPRESSE MASTICABILI\" 30\r\nCOMPRESSE', 'CHINIDINA', '2024-04-14', 2100, 10),
(16, 'VIVIN C \"330 MG + 200 MG COMPRESSE EFFERVESCENTI\" 20 COMPRESSE ', 'ACIDO ACETILSALICILICO', '2022-08-22', 200, 15);

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
(2, 5, 500, 14, 6),
(1, 13, 100, 10, 7),
(2, 12, 50, 7, 8),
(2, 6, 1000, 30, 9),
(1, 11, 1500, 28, 10);

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
(1, 1, 600, 1),
(1, 9, 40, 2),
(2, 14, 40, 3),
(3, 1, 300, 4),
(3, 6, 200, 5),
(4, 1, 1000, 6),
(5, 1, 10, 7);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `idOrdine` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `dataConsegna` date NOT NULL,
  `stato` varchar(30) NOT NULL,
  `note` varchar(300) NOT NULL,
  `dataOrdine` varchar(30) NOT NULL,
  `fattorino` int(11) DEFAULT NULL,
  `ordineCaricato` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`idOrdine`, `idUtente`, `dataConsegna`, `stato`, `note`, `dataOrdine`, `fattorino`, `ordineCaricato`) VALUES
(1, 3, '2022-06-23', 'Consegnato', 'Risolte problematiche inerenti all\'ordine', '2022-06-23 16:40:54', 1, 'Si'),
(2, 3, '2022-06-23', 'Consegnato', 'I seguenti farmaci non sono arrivati correttamente: \nBRONCHENOLO SEDATIVO E FLUIDIFICANTE \"1,5 MG/ML + 10 MG/ML SCIROPPO\" FLACONE 150 ML', '2022-06-23 19:12:22', 1, 'Si'),
(3, 3, '2022-06-23', 'Consegnato', 'I seguenti farmaci non sono arrivati correttamente: \nTACHIPIRINA \"500 MG COMPRESSE\" 30 COMPRESSE', '2022-06-23 19:12:53', 1, 'Si'),
(4, 3, '2022-07-02', 'Consegnato', 'Risolte problematiche inerenti all\'ordine', '2022-06-25 14:46:36', 1, 'Si'),
(5, 3, '2022-07-02', 'Consegnato', 'Risolte problematiche inerenti all\'ordine', '2022-06-25 15:01:27', 1, 'Si');

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
('Davide', 'Sgroi', '', 'd', 's', 'fattorino', 1, 0),
('Francesco Paolo', 'Rosone', 'Via pagliaccio 11', 'fp', 'r', 'farmacista', 2, 0),
('Salvatore', 'Viganò', 'Via bonagia 22', 's', 'v', 'farmacista', 3, 0),
('Andrea', 'Riggio', '', 'a', 'r', 'magazziniere', 4, 0);

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
  MODIFY `idFarmaco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT per la tabella `farmacocontratto`
--
ALTER TABLE `farmacocontratto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `farmacoordine`
--
ALTER TABLE `farmacoordine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `idOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  ADD CONSTRAINT `ordine_ibfk_1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`),
  ADD CONSTRAINT `ordine_ibfk_2` FOREIGN KEY (`fattorino`) REFERENCES `utente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
