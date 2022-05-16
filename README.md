# Pharmalink
Progetto A.A. 21/22 Progettazione del Software
## Tema di Progetto 
Si richiede la progettazione di un software per il supporto ad un’azienda farmaceutica.

### Descrizione generale del sistema
Si richiede di progettare e sviluppare un software di gestione integrata della produzione,
stoccaggio e vendita di farmaci di un’azienda farmaceutica.

Il sistema gestisce tutte le informazioni riguardanti i farmaci prodotti che possono essere venduti a
una catena di farmacie a cui l’azienda è affiliata.  Il sistema supporta anche la prenotazione dei farmaci.

Un farmaco ha un nome, un principio attivo ed una scadenza, il sistema deve gestire queste
informazioni durante tutto il processo produttivo.

Una farmacia fa un contratto di acquisto periodico dei farmaci (o simili) da banco. Il sistema
contemporaneamente gestisce il carico, lo scarico e gli ordini in modo che la farmacia non sia mai
sprovvista per ogni categoria di farmaci. Farmaci particolari, non da banco, vengono ordinati periodicamente dalla farmacia ed anche per questi il sistema gestisce carico e scarico.

In fase di prenotazione di un farmaco da parte di una farmacia, il sistema verifica che la/le scadenze
dei farmaci nel magazzino dell’azienda non siano inferiori a due mesi dalla data di prenotazione ed
in tal caso deve essere emesso un avviso e attesa la conferma del farmacista prima che la
prenotazione sia registrata.

Un farmaco (o un lotto) ha una data di consegna e l’ordine non può essere annullato o modificato
nei due giorni precedenti la consegna. Un corriere consegna i farmaci alla data prevista ed è
provvisto di un dispositivo portatile sul quale il farmacista firma l’avvenuta consegna. A consegna
avvenuta il farmacista carica i prodotti nel sistema che effettua quindi il carico merci.
Alle ore 20:00 del giorno della consegna merce, se il farmacista non ha caricato i farmaci previsti in
consegna per quel giorno, il sistema  mostra a video un avviso.

Il farmacista può confermare la  consegna di tutto o parte dell’ordine ed in quest’ultimo caso l’azienda farmaceutica viene allertata.
Il giorno dopo un addetto dell’azienda chiamerà la farmacia per accordarsi sulla procedura da
mettere in atto e la attuerà tramite il sistema.

## Cosa è stato realizzato

## Strumenti utilizzati

## Più informazioni dai documenti
- RAD (Requirements Analysis Document) 
- ODD (Object Design Document)
- SDD (System Design Document)