--------------------------------------------------------------------------------
        -- INFORMATIONS SUR LES DONNÉES DE L'INSTANCE DE LA BD --
--------------------------------------------------------------------------------
SET DATESTYLE TO EUROPEAN;

/*______________________________________________________________________________
BESOIN N°1.
Affichage de toutes les représentations futures
______________________________________________________________________________*/

SELECT *
FROM REPRESENTATION
WHERE date > current_date;


/*______________________________________________________________________________
BESOIN N°2.
Affichage du jour, de l'heure de début, du lieu et du nombre de numéros
présentés, pour chacune des représentations futures.
Résultat ordonné sur la date, puis l'heure des représentations
______________________________________________________________________________*/

SELECT r.CodeRep, Date, HeureDebut, r.idLieu, count(*) AS nb_numeros 
FROM REPRESENTATION r, PRESENTE p 
WHERE r.codeRep = p.codeRep
AND date > current_date
GROUP BY r.codeRep, Date, HeureDebut, r.idLieu
ORDER BY Date, HeureDebut;



/*______________________________________________________________________________
BESOIN N°3.
Nombre de représentations  passées ou à venir où est présenté un numéro sous la
responsabilité de Etoile, mais aucun numéro sous la responsabilité de Bozzo
CONTRAINTE : utiliser EXISTS / NOT EXISTS pour coder ce BESOIN
______________________________________________________________________________*/

SELECT count(*) AS nb_rep_etoile_pas_bozzo
FROM REPRESENTATION r
WHERE EXISTS(
    SELECT n.titre FROM NUMERO n, PRESENTE p
    WHERE n.titre = p.titre AND r.CodeRep = p.codeRep 
    AND responsable = 'Etoile'
)AND NOT EXISTS (
    SELECT n.titre FROM NUMERO n, PRESENTE p
    WHERE n.titre = p.titre AND r.CodeRep = p.codeRep 
    AND responsable = 'Bozzo'
);

SELECT count(*) AS nb_rep_etoile_pas_bozzo
FROM REPRESENTATION r
WHERE codeRep IN 
(SELECT CodeRep FROM PRESENTE p, NUMERO n
WHERE n.titre = p.titre AND r.CodeRep = p.codeRep 
AND responsable = 'Etoile'
EXCEPT 
SELECT CodeRep FROM PRESENTE p, NUMERO n
WHERE n.titre = p.titre AND r.CodeRep = p.codeRep 
AND responsable = 'Bozzo'
);


/*______________________________________________________________________________
BESOIN N°4.
Date, heure de début et adresse des représentations dans lesquelles
au moins 5 numéros sont présentés - Résultat ordonné par date, puis heure début
______________________________________________________________________________*/

SELECT Date, HeureDebut, adresse 
FROM REPRESENTATION r, PRESENTE p, LIEU l
WHERE r.codeRep = p.codeRep AND r.idLieu = l.idLieu
GROUP BY Date, HeureDebut, adresse
HAVING count(*) >= 5
ORDER BY date, HeureDebut;



/*______________________________________________________________________________
BESOIN N°5.
Date, heure de début et adresse des représentations dans lesquelles
tous les numéros sont présentés
______________________________________________________________________________*/

SELECT DISTINCT Date, heureDebut, adresse 
FROM REPRESENTATION r, PRESENTE p, LIEU l
WHERE r.codeRep = p.codeRep AND r.idLieu = l.idLieu
AND (SELECT titre FROM NUMERO) IN (SELECT DISTINCT titre FROM PRESENTE);



/*______________________________________________________________________________
BESOIN N°6.
Un entracte de 30 à 45 minutes doit être respecté lors de chaque représentation
(valeur par défaut 30 mn).
______________________________________________________________________________*/
-- (1) Faites le nécessaire sans modifier le fichier create.sql




-- (2) Affichez les n-uplets de REPRESENTATION

SELECT *
FROM REPRESENTATION;


-- Que remarquez-vous ?


/*______________________________________________________________________________
BESOIN N°7.
Durée de la représenation de code 'R1ANN', entracte non comprise
______________________________________________________________________________*/

SELECT Duree AS duree_rep_hors_entracte
FROM NUMERO n, REPRESENTATION r, PRESENTE p
WHERE r.codeRep = p.codeRep AND n.titre = p.titre
AND r.codeRep = 'R1ANN';


/*______________________________________________________________________________
BESOIN N°8.
Faites en sorte que l'entracte des représentations qui présentent
plus de 5 numéros soit de 40 mn
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°9.
Code, Date, Heure début, Durée (entracte comprise) de chaque représentation
passée ou à venir
Résultat ordonné par date, puis par heure début
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°10.
Selon la RG8. énoncée dans le TD6, il doit y avoir au moins 5h d'écart entre
l'heure de début d'une représentation et l'heure de fin de la précédente.

------------------------------
(1) À quelle heure maximale devrait commencer une représentation qui présenterait
    tous les numéros, avec une entracte de 40 mn et qui serait programmée
    avant la représentation de code R1ANN ?

    INDICATIONS
    Procédez par étape pour constuire le résultat...
    (a) Requête donnant la durée nécessaire à la présentation de tous les
        numéros à laquelle s'ajouterait un entracte de 40 mn
    (b) Requête donnant l'heure de fin maximale d'une représentation qui serait
        donnée avant la représentation de code R1ANN (cf. RG8)
    (c) Production du résultat attendu...*/
-------------------------------

-- (a) Durée totale de présentation de tous les numéros + 40mn d'entracte




-- (b) Heure de fin maximale d'une représentation commençant avant celle
--     de code R1ANN



-- (c) Heure de début maximale d'une représentation de tous les numéros....



/*-----------------------------
(2) Si l'heure trouvée est supérieure à 10h, créez une représentation
    de code R2ANN dans le même lieu et le même jour que la réservation R1ANN
    et débutant à cette heure.
	NOTE : l'insertion dans PRESENCE de tous les numéros pour cette représentation
         n'est pas demandée
-----------------------------*/





--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
