Ingegneria dell&#39;innovazione per le imprese digitali - A.A. 21/22

# **PHARMALINK**

# Requirements Analysis Document

# Team RSRV

_Andrea Riggio_

_Davide Sgroi_

_Francesco Paolo Rosone_

_Salvatore Viganò_

# **Obiettivo del sistema**

L&#39;obiettivo del sistema è di gestire le informazioni, la produzione, lo stoccaggio e la distribuzione di farmaci di un&#39;azienda farmaceutica per una o più catene di farmacie. Gli utenti che utilizzeranno questo sistema sono di tre tipologie:

- Farmacista, ossia colui che può ordinare sia farmaci da banco sia farmaci particolari, oltre ad effettuare il carico e scarico dei farmaci.
- Fattorino, ossia colui che si occupa di consegnare i lotti alle farmacie e di far firmare le avvenute consegne.
- Magazziniere, ossia colui che si occupa di correggere quegli ordini che risultato in stato di errore (che sia ordine effettivo o consegna) e di poter aggiungere nuovi farmaci prodotti dall&#39;azienda.

## **Sistema attuale**

Si suppone che non ci sia nessun sistema informatico preesistente, che le attività di raccolta delle informazioni sugli utenti e sugli ordini effettuati vengano effettuati manualmente dall&#39;azienda farmaceutica e che esso debba interagire direttamente con il cliente per la gestione delle ordinazioni farmaci.

## **Requisiti funzionali**

Il sistema deve prevedere tre tipologie diverse di utenti che possono interfacciarsi con esso tramite una serie di funzionalità elencate di seguito:

### **Utente**

- Autenticazione: l&#39;Utente deve poter accedere al suo account tramite le proprie credenziali, assegnatogli dall&#39;Azienda stessa.
- Recupero credenziali: l&#39;Utente deve poter recuperare la propria password inserendo la propria e-mail e, successivamente, verrà inviata un&#39;e-mail con la password recuperata.

### **Farmacista**

- Ordina Farmaco: il Farmacista deve poter richiedere all&#39;azienda uno o più farmaci a lui necessari.
- Visualizza Catalogo: il Farmacista deve poter visualizzare un elenco di farmaci presenti nel database dell&#39;azienda, in modo tale da poterli successivamente ordinare.
- Visualizza Ordini: il Farmacista deve poter visualizzare tutti gli ordini da lui effettuati (sia quelli ancora in corso, sia quelli già conclusi).
- Modifica Ordine: il Farmacista deve poter annullare o modificare la quantità e/o la data di consegna di un ordine, entro tre giorni prima della data di consegna prevista.
- Modifica Parametri: il Farmacista deve poter modificare sia la quantità dei farmaci da banco, sia il periodo in cui devono arrivare in Farmacia.
- Carica Ordini: il Farmacista deve poter confermare l&#39;avvenuta ricezione dei lotti e di caricarli nel proprio sistema entro le ore venti della data di consegna. In caso non dovesse succedere, verrà aperta automaticamente una segnalazione da parte dell&#39;Azienda e un addetto contatterà la farmacia per risolvere il problema.

### **Magazziniere**

- Aggiungi Farmaco: il Magazziniere deve poter aggiungere nuovi farmaci (che siano da banco o meno) nel database dell&#39;Azienda.
- Supervisiona Ordini: il Magazziniere deve poter verificare e correggere un ordine per cui è stato segnalato un problema.

### **Fattorino**

- Firma consegna: il Corriere deve poter far firmare al Farmacista l&#39;effettivo ordine consegnato, facendogli inserire le proprie credenziali di accesso come firma digitale.

## **Requisiti non funzionali**

- Il sistema venga distribuito su tre dispositivi differenti:
  - PC posizionato nelle farmacie;
  - PC posizionato nell&#39;azienda;
  - Tablet a disposizione per il corriere.

I tre dispositivi non comunicano direttamente tra di loro, ma solo tramite un mezzo comune: DBMS.

- Il sistema deve essere realizzato in linguaggio di programmazione Java.
- Solamente i farmaci da banco possono essere ordinati periodicamente, mentre i farmaci non da banco sono ordinabili solo su richiesta.
- Il controllo del sistema sul carico delle merci viene effettuato alle ore 20:00 ogni giorno.
- Il sistema deve permettere l&#39;annullamento degli ordini non periodici da parte del farmacista, solo se intercorrono due o più giorni tra la data odierna e quella di consegna prevista.
- Quando il farmacista effettua un ordine, esso verrà avvisato se tra i farmaci ordinati ce ne siano alcuni in scadenza o già scaduti. Questo avviso avviene quando la scadenza è inferiore a due mesi rispetto alla data odierna.
- Quando il farmacista deve caricare i farmaci ordinati, esso dovrà farlo entro le ore 20:00 dello stesso giorno di consegna. Se così non dovesse accadere, allora verrebbe aperta un&#39;avvertenza e l&#39;ordine passerà in stato di errore. Il giorno successivo, un addetto all&#39;azienda contatterà il farmacista per risolvere questo errore.

## **Requisiti di sistema**

Il sistema deve garantire il servizio in ogni momento, oltre a garantire la sicurezza agli utenti.

# **Modelli di sistema**

Nella maggior parte dei casi d&#39;uso presenti, in ogni interfaccia è presente il tasto &quot;Torna indietro&quot; (chiamato anche &quot;Indietro&quot; oppure &quot;Esci&quot; oppure &quot;Torna al menù principale&quot;) che permette all&#39;utente di tornare alla finestra precedente o di effettuare il logout. Inoltre, si suppone che per ogni interrogazione al DBMS corrisponda sempre una risposta dallo stesso: se così non sarà, allora verrà invocato il caso d&#39;uso &quot;Caduta connessione&quot;.