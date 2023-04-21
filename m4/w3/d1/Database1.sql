/*CREATE TABLE Clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome varchar NOT NULL,
	Cognome varchar NOT NULL,
	DataNascita int8 NOT NULL,
	RegioneResidenza varchar NOT NULL
);

CREATE TABLE Fatture (
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia varchar NOT NULL,
	Importo int8 NOT NULL,
	Iva int8 NOT NULL,
	IdCliente int8 NOT NULL,
	DataFattura int8 NOT NULL,
	NumeroFornitore int8 NOT NULL,
	CONSTRAINT IdCliente_fk FOREIGN KEY (IdCLiente) REFERENCES Clienti(NumeroCliente),
	CONSTRAINT NumeroFornitore_fk FOREIGN KEY (NumeroFornitore) REFERENCES Fornitori(NumeroFornitore)
);

CREATE TABLE Prodotti (
	IdProdotto SERIAL PRIMARY KEY,
	Descrizione varchar NOT NULL,
	InProduzione boolean,
	InCommercio boolean,
	DataAttivazione int8 NOT NULL,
	DataDisattivazione int8 NOT NULL
);

CREATE TABLE Fornitori (
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione varchar NOT NULL,
	RegioneResidenza varchar NOT NULL
);*/

/*INSERT INTO Clienti( Nome, Cognome, DataNascita, RegioneResidenza) VALUES ( 'Manuel', 'Gadau', 1996, 'Sardegna');
INSERT INTO Clienti( Nome, Cognome, DataNascita, RegioneResidenza) VALUES ( 'Gabriele', 'Gadau', 2003, 'Sardegna');
INSERT INTO Clienti( Nome, Cognome, DataNascita, RegioneResidenza) VALUES ( 'Giuseppe', 'Gadau', 1965, 'Sardegna');
INSERT INTO Clienti( Nome, Cognome, DataNascita, RegioneResidenza) VALUES ( 'Sabrina', 'Solinas', 1967, 'Sardegna');*/


/*INSERT INTO Fatture( Tipologia, Importo, Iva, IdCLiente, DataFattura, NumeroFornitore) VALUES ( 'Differita', 100, 20, 2, 2023, 1);
INSERT INTO Fatture( Tipologia, Importo, Iva, IdCLiente, DataFattura, NumeroFornitore) VALUES ( 'Differita', 96, 20, 1, 2022, 2);
INSERT INTO Fatture( Tipologia, Importo, Iva, IdCLiente, DataFattura, NumeroFornitore) VALUES ( 'Anticipata', 232, 22, 3, 2023, 1);
INSERT INTO Fatture( Tipologia, Importo, Iva, IdCLiente, DataFattura, NumeroFornitore) VALUES ( 'Anticipata', 12, 23, 3, 2011, 1);*/


/*INSERT INTO Fornitori( Denominazione, RegioneResidenza) VALUES ( 'Samsung', 'Lombardia');
INSERT INTO Fornitori( Denominazione, RegioneResidenza) VALUES ( 'Apple', 'Lazio');*/


/*INSERT INTO Prodotti( Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ( 'S23', TRUE, TRUE, 2023, 2025);
INSERT INTO Prodotti( Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ( 'iPhone13', TRUE, TRUE, 2023, 2025);
INSERT INTO Prodotti( Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ( 'S5', FALSE, FALSE, 2005, 2010);
INSERT INTO Prodotti( Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ( 'iPhone7', FALSE, TRUE, 2007, 2012);*/


--Estrarre nome e cognome degli utenti nati nel 1996
SELECT nome, cognome FROM Clienti WHERE DataNascita = 1996;

--Estrarre il numero delle fatture con iva al 20%
SELECT count(*) FROM Fatture WHERE Iva = 20;

--Riportare il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione
SELECT DataFattura, count(*), SUM(Importo) FROM Fatture GROUP BY DataFattura ORDER BY DataFattura DESC;

--Estrarre i prodotti attivati nel 2023 e che sono in produzione oppure in commercio
SELECT Descrizione FROM Prodotti WHERE (DataAttivazione = 2023 AND (InProduzione = TRUE OR InCommercio = TRUE));

--Considerando soltanto le fatture con iva al 20%, estrarre il numero di fatture per ogni anno
SELECT DataFattura, count(*) FROM Fatture WHERE Iva = 20 GROUP BY DataFattura;

--Estrarre gli anni in cui sono state registrate più di 2 fatture con tipologia 'Anticipata'
SELECT DataFattura FROM Fatture WHERE Tipologia = 'Anticipata' GROUP BY DataFattura HAVING COUNT(*) > 0;

--Riportare l'elenco delle fatture (numero, importo, iva e data) con in aggiunta il nome del fornitore
SELECT Fatture.NumeroFattura, Fatture.Importo, Fatture.Iva, Fatture.DataFattura, Fornitori.Denominazione FROM Fatture INNER JOIN Fornitori ON Fatture.NumeroFornitore = Fornitori.NumeroFornitore;

--Estrarre il totale degli importi delle fatture divisi per residenza dei clienti
SELECT Clienti.RegioneResidenza, SUM(Fatture.Importo) FROM Clienti INNER JOIN Fatture ON Clienti.NumeroCliente = Fatture.NumeroFattura GROUP BY Clienti.RegioneResidenza;

--Estrarre il numero dei clienti nati nel 1965 che hanno almeno una fattura superiore a 50 euro
SELECT count(Clienti.*) FROM Clienti INNER JOIN Fatture ON Clienti.NumeroCliente = Fatture.NumeroFattura WHERE (Clienti.DataNascita = 1965 AND Fatture.Importo > 50);

--Estrarre una colonna di nome "Denominazione" contenente il nome, seguito da un carattere "-", seguito dal cognome, per i soli clienti residenti nella regione Sardegna
SELECT CONCAT(Nome, '-', Cognome) AS Denominazione FROM Clienti WHERE RegioneResidenza = 'Sardegna';









