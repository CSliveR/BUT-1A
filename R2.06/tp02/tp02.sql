 
/*================================================================*/
/* NOM Prénom - TP02 : SQL avancé : objets définis par requête    */
/*================================================================*/

/*=============================*/
/* Section 1 : Morts multiples */
/*=============================*/
/***********************************************************/
/* 1 - Changement de contrainte sur meurt_dans             */
/***********************************************************/

/*1.Nous souhaitons ajouter la possibilité à un personnage de pouvoir mourir dans plusieurs films. Une première solution, simple, consiste à modifier une contrainte de la table meurt_dans: laquelle? La mettre en œuvre. Indications:

Consulter la page https://www.postgresql.org/docs/15/ddl-alter.html#DDL-ALTER-REMOVING-A-CONSTRAINT
PostgreSQL nomme meurt_dans_pkey la contrainte de clé primaire de la table meurt_dans*/

ALTER TABLE meurt_dans DROP CONSTRAINT meurt_dans_pkey;

ALTER TABLE meurt_dans ADD PRIMARY KEY (numero, nom);

/*2.Une deuxième solution permet de supprimer la table meurt_dans en ajoutant un attribut booléen à la relation apparait_dans. Pour cela,

ajouter une colonne y_meurt à la table apparait_dans de type boolean avec FALSE comme valeur par défaut.
mettre à jour les lignes de apparait_dans pour mettre cette nouvelle colonne à TRUE dans les lignes où le personnage meurt dans le film concerné. Indications : utiliser une sous-requête.
supprimer la table meurt_dans.*/

ALTER TABLE apparait_dans ADD COLUMN y_meurt BOOLEAN DEFAULT false;

UPDATE apparait_dans SET y_meurt = true WHERE (nom, numero) IN 
(SELECT nom, numero
FROM meurt_dans);


DROP TABLE IF EXISTS meurt_dans;

/*3.Si une application tiers utilisait la table meurt_dans il convient de créer une vue qui la reproduise. Quel nom doit avoir cette vue? Pourquoi une vue et pas une table (temporaire)? 
Créer cette vue et en afficher le contenu.*/

/*Si une table temporaire est utilsée, elle sera détruite à la
fermeture de l'application et l'application deviendra inutilisable si 
on la réouvre donc l'utilisation d'une vue est plus adaptée.*/

CREATE VIEW meurt_dans AS 
    SELECT numero, nom
    FROM apparait_dans
    WHERE y_meurt = true;

/*4.Enregistrer, dans apparait_dans, la mort du Soldat de l'hiver dans le film 5, et celle de Nick Fury dans le film 9*/

UPDATE apparait_dans SET y_meurt = true 
WHERE nom = 'Soldat de l''hiver' AND numero = 5; 

UPDATE apparait_dans SET y_meurt = true 
WHERE nom = 'Nick Fury' AND numero = 9; 


/*5. Le Soldat de l'hiver et Nick Fury sont enregistrés dans la vue meurt_dans*/


UPDATE apparait_dans SET y_meurt = true 
WHERE nom = 'Nick Fury' AND numero = 9;

/*drouichi=> select * from meurt_dans;
 numero |         nom         
--------+---------------------
      5 | Soldat de l'hiver
      9 | Nick Fury
     19 | Loki
     19 | Faucon
     19 | Soldat de l'hiver
     19 | Sorcière rouge
     19 | Star-Lord
     19 | Groot
     19 | Drax le Destructeur
     19 | Gamora
     19 | Mantis
     19 | Vision
     19 | Spider-Man
     19 | Doctor Strange
     19 | Black Panther
     22 | Thanos
     22 | Iron Man
     22 | Black Widow
     19 | Nick Fury
     19 | Commandant Hill
(20 rows)*/

/*=============================*/
/* Section 2 : Ajout d'une fan base*/
/*=============================*/

/*6.La table fan_base doit elle être une table permanente ou temporaire? La créer de façon classique (sans requête) avec trois attributs:

    login de type varchar
    nom de type varchar
    annee de type int*/

/*La table doit ếtre permanante car il est souhaitable de conserver
de maintenir la fan base dans le temps en la mettant à jour et en 
sauvegardant les mises à jour*/


CREATE TEMP TABLE fan_base(
    login varchar,
    nom varchar,
    annee int
);


/*7.Alimenter cette table avec les données contenues dans le fichier /users/info/pub/1a/R2.06/bases/avengers/fan_base.csv grâce à la commande postgreSQL \copy. Indications:

Consulter la page https://www.postgresql.org/docs/13/app-psql.html#APP-PSQL-META-COMMANDS-COPY
utiliser les options suivantes : (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8')
*/

/*meilleure doc: https://docs.aws.amazon.com/fr_fr/AmazonRDS/latest/UserGuide/PostgreSQL.Procedural.Importing.Copy.html*/

\copy fan_base from '/users/info/pub/1a/R2.06/bases/avengers/fan_base.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');


/*8.Créer les deux tables fan et favoris grâce à deux requêtes, puis en ajoutant les contraintes de clé primaire et étrangère.*/

CREATE TABLE fan(login, annee) AS 
(SELECT DISTINCT login, annee
FROM fan_base);

ALTER TABLE fan ADD PRIMARY KEY (login);

CREATE TABLE favoris(login, perso) AS 
(SELECT login, nom
FROM fan_base
WHERE nom IS NOT NULL)
;

ALTER TABLE favoris ADD PRIMARY KEY (login, perso);
ALTER TABLE favoris ADD FOREIGN KEY (login) REFERENCES fan(login);
ALTER TABLE favoris ADD FOREIGN KEY (perso) REFERENCES Personnage(nom);

/*9.On souhaite à présent donner un accès spécifique à chaque fan.
Pour cela, créer une vue mes_favoris donnant le nom des personnages favoris de l'utilisateur postgreSQL connecté.*/

CREATE VIEW mes_favoris AS 
    SELECT (SELECT current_user AS login),
    (SELECT perso FROM favoris 
    WHERE login = current_user);

/*=============================*/
/* Section 3 : Publication de la distance entre personnages*/
/*=============================*/
SELECT DISTINCT (SELECT a1.nom) AS nom1,
(SELECT a2.nom) AS nom2
FROM apparait_dans a1, apparait_dans a2
WHERE a1.numero IN (SELECT numero FROM apparait_dans WHERE nom=a2.nom)
AND a1.nom = 'Black Panther';
