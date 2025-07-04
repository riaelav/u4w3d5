Per la gestione dell’ereditarietà tra le entità Book e Magazine, ho scelto la strategia JOINED.
Ho preferito questa strategia rispetto a SINGLE_TABLE perché:

Mi garantisce una struttura ordinata nel database e non ho dei campi
null nelle mie tabella.

I campi comuni sono definiti in una tabella base (catalog_element) ,
mentre quelli specifici (es. autore o periodicità)
sono salvati solo nelle relative tabelle (book, magazine).

In questo modo ogni elemento ha un ID univoco,
utile per collegarlo facilmente alla tabella dei prestiti,
tramite una relazione @ManyToOne verso la superclasse CatalogElement.