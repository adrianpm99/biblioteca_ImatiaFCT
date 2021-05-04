CREATE TABLE IF NOT EXISTS  book ( 

    id INTEGER PRIMARY KEY AUTOINCREMENT, 

    title VARCHAR(50) NOT NULL, 

    description VARCHAR(200), 

    author VARCHAR(50) NOT NULL, 

    pageNumber INT, 

    ISBN VARCHAR(13) NOT NULL, 

    editorial VARCHAR(50), 

    edition INT, 

    bookPublicationYear YEAR   

); 

CREATE TABLE IF NOT EXISTS copy ( 

    copyId INTEGER PRIMARY KEY AUTOINCREMENT, 

    bookId INT NOT NULL REFERENCES book(id), 

    CopyNotes VARCHAR(50) NOT NULL 

); 

CREATE TABLE IF NOT EXISTS user ( 

    userId INTEGER PRIMARY KEY AUTOINCREMENT, 

    userName VARCHAR (50), 

    userSurname VARCHAR (50) 

);  

 CREATE TABLE IF NOT EXISTS reservation ( 

    reservationId INTEGER PRiMARY KEY AUTOINCREMENT, 

    bookId INT NOT NULL REFERENCES  book(bookId), 

    userId INT NOT NULL REFERENCES  user(userId) 

);   

CREATE TABLE IF NOT EXISTS lending (  

    lendingId INTEGER PRIMARY KEY AUTOINCREMENT, 

    userId INT NOT NULL REFERENCES user(userId), 

    lendingDate DATE NOT NULL, 

    lendingDeadLine DATE NOT NULL, 

    lendingReturnDate DATE, 

    lendingNotes  VARCHAR (200) 

);  

CREATE TABLE IF NOT EXISTS copyLending( 

    copyLendingId INTEGER PRIMARY KEY AUTOINCREMENT, 

    copyId INT NOT NULL REFERENCES copy(copyId), 

    lendingId INT NOT NULL REFERENCES lending(lendingId) 

);  

CREATE TABLE IF NOT EXISTS shelving( 

   shelvingId INTEGER PRIMARY KEY AUTOINCREMENT, 

   shelvingPublicNumber INT NOT NULL 

); 

CREATE TABLE IF NOT EXISTS copyShelving( 

   copyShelvingId INTEGER PRIMARY KEY AUTOINCREMENT, 

   shelvingId INT NOT NULL REFERENCES shelving(shelvingId), 

   copyId INT NOT NULL REFERENCES copy(copyId) 

); 

 

REPLACE INTO book VALUES   

    (1,'Delparaíso','Delparaíso es un lugar seguro, vigilado las 24 horas, lujoso e inexpugnable. Sin embargo, sus muros no protegen del miedo, del amor, de la tristeza, del deseo y de la muerte.','Juan del Val',312,'9788467061130','Espasa',1,'2021'),   

    (2,'Los ojos cerrados','Los ojos cerrados es una novela de un solo lugar, un pueblo que podría tener cualquier nombre y que por eso se llama Pueblo Chico. Pueblo Chico está anclado en una sierra agreste…','Edurne Portela',208,'9788418526206','Galaxia Gutenberg ',1,'2021'),   

    (3,'Exi. Bienvenidos a Glitch City','¡Soy Exi! Puede que me conozcas por mi canal de YouTube, donde hago muchas cosas locas, hay salseo, nos reímos un montón y… ¡Eh! ¡No! Espera, deja el móvil…','Exi',176,'9788408240389','Destino Infantil & Juvenil', 1,'2021'),   

    (4,'El Evangelio','Mundo maldito, llévame a mí si quieres que ya estoy podrida de todas formas pero no me chafes a Alberto, a Alberto déjamelo tranquilo dando saltos en su casa vestido de gato…','Elisa Victoria',312,'9788418187803','Blackie Books',1,'2021'),   

    (5,'¡Es la microbiota, idiota!','Descubre cómo tu salud depende de los billones de microorganismos que habitan en tu cuerpo','Sari Arponen',368,'9788413440682','Alienta Editorial',1,'2021'), 

    (6,'SIRA','La Segunda Gran Guerra llega a su fin y el mundo emprende una tortuosa reconstrucción. Concluidas sus funciones como colaboradora de los Servicios Secretos británicos...','Maria Dueñas',648,'9788408241911','Planeta',1,'2021'), 

    (7,'El Invencible','El Invencible es el nombre de la enorme nave interestelar que parte hacia el rescate de su gemela, la impresionante y guerrera El Cóndor, que se haya varada en Regis III.','Stanislaw Lem',264,'9788417553937','Impedimenta',2,'2021'), 

    (8,'Las Medallas de Mercurio','El mercurio es uno de esos escasos metales que se encuentran en estado líquido a temperatura ambiente. Contradice nuestras ideas habituales, y utilizarlo para fabricar medallas sería absurdo.','Pablo Escudero Abenza',178,'9788466937153','Complutense Ediciones',3,'2020'); 

   

REPLACE INTO copy VALUES  

    (1,1, 'Buen estado'),  

    (2,1, 'Buen estado'), 

    (3,2, 'Buen estado'), 

    (4,2, 'Buen estado'), 

    (5,3, 'Buen estado'), 

    (6,4, 'Mal estado(Mojado)'),   

    (7,5, 'Buen estado'),   

    (8,5, 'Buen estado'), 

    (9,5, 'Buen estado'), 

    (10,5, 'Buen estado'), 

    (11,6, 'Buen estado'), 

    (12,7, 'Buen estado'), 

    (13,7, 'Buen estado'), 

    (14,8, 'Buen estado'), 

    (15,8, 'Buen estado'), 

    (16,8, 'Buen estado'), 

    (17,8, 'Buen estado'), 

    (18,8, 'Buen estado'); 

 

REPLACE INTO user VALUES  

    (1,'Manolo','Rodriguez Lopez'), 

    (2,'Francisco','Martinez Gomez'), 

    (3,'Lucia','Estevez Morales'), 

    (4,'Maria','Iglesias Seoane'), 

    (5,'Mario','Fernandez Rodriguez'), 

    (6,'Fernando','Perez Gonzalez'), 

    (7,'Antonio','Rodriguez De La Torre'), 

    (8,'Pedro','Vazquez Romero'), 

    (9,'Azucena','Ibañez Pedrido'), 

    (10,'Encarnacion','Lopez Regueiro');   

 

REPLACE INTO lending VALUES   

    (1,2,1619647200000,1620943200000,NULL,NULL),  

    (2,3,1619647200000,1620943200000,NULL,NULL),  

    (3,1,1617235200000,1618444800000,1618358400000, 'Entregado en buen estado'),  

    (4,6,1607558400000,1608854400000,1608681600000, 'Entregado en mal estado(mojado)'),  

    (5,1,1618444800000,1619740800000,NULL,NULL),  

    (6,5,1614038400000,1615334400000,1615161600000, 'Entregado en buen estado'), 

    (7,4,1619568000000,1620864000000,NULL,NULL); 

 

REPLACE INTO copyLending VALUES 

    (1,1,1),  

    (2,3,1),  

    (3,5,1),  

    (4,2,2),  

    (5,5,3), 

    (6,6,4),  

    (7,11,5),  

    (8,14,6),  

    (9,14,7),  

    (10,10,7); 

 

REPLACE INTO reservation VALUES 

    (1,1,5), 

    (2,6,7); 

 

 