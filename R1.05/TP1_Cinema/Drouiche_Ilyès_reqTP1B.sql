
/*______________________________________________________________________________

            Requêtes TP1 - PArtie B (FICHIER À COMPLÉTER)

     Étapes à suivre pour chaque question :
     (1)  Écrire le code de la requête
     (2)  Copier la requête (ctrl C), puis le coller (ctrl + Shift + V)
          dans le terminal où vous êtes connectés à PostGreSQL
     (3)  Vérifier le résultat obtenu par comparaison à celui attendu
          (cf. TP1B_Résultats sur Chamilo)
     (4)  Si le résultat attendu n'est pas le bon, reprendre à l'étape 1

______________________________________________________________________________*/


/*------------------------------------------------------------------------------
(a) Réécrivez en utilisant une ou plusieurs sous-requêtes, les requêtes
    répondant aux questions (h) et (i) de la partie A
------------------------------------------------------------------------------*/

-- 1. Réécriture requête (h)
--    Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
--    et aussi dans The Virgin Suicides

SELECT nomact
FROM ACTEUR
WHERE titre = 'Eternal Sunshine of the Spotless Mind'
AND nomact IN (
SELECT nomact 
FROM ACTEUR
WHERE titre = 'The Virgin Suicides');

-- 2. Réécriture requête (i)
--    Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
--    mais pas dans The Virgin Suicides

SELECT nomact
FROM ACTEUR
WHERE titre = 'Eternal Sunshine of the Spotless Mind'
AND nomact NOT IN(
SELECT nomact 
FROM ACTEUR
WHERE titre = 'The Virgin Suicides');


/*------------------------------------------------------------------------------
(b)	Nombre d'acteurs par films
    (1 version avec GROUP BY + 1 version avec sous-requêtes)
    résultat ordonné par nombre d'acteurs décroissant, puis par titre
------------------------------------------------------------------------------*/

-- 1. Version avec GROUP BY

SELECT titre, count(*) AS nb_acteurs
FROM ACTEUR 
GROUP BY titre
ORDER BY nb_acteurs DESC, titre;


-- 2. Version avec sous-requête

SELECT titre, count(*) AS nb_acteurs
FROM ACTEUR 
WHERE titre IN 
    (SELECT titre
    FROM ACTEUR)
GROUP BY titre
ORDER BY nb_acteurs DESC, titre;

/*------------------------------------------------------------------------------
(c) Programmation en cours : pour chaque cinéma, sachant que chaque cinéma
    projetette au moins un film
    résultat ordonné par par nombre de films décroissant, puis par nom de cinéma
------------------------------------------------------------------------------*/

SELECT nomcine, count(DISTINCT titre) AS nb_films_projetés
FROM SALLE sa
GROUP BY nomcine
ORDER BY nb_films_projetés DESC, nomcine;


/*------------------------------------------------------------------------------
(d) Nom des cinémas projetant au moins 2 films Star Wars différents
    mis en scène par George Lucas (leur titre commence par Star Wars)
------------------------------------------------------------------------------*/

SELECT nomcine, count(sa.titre) 
FROM SALLE sa ,FILM f
WHERE sa.titre = f.titre
AND sa.titre LIKE 'Star Wars%' 
AND metteurscene = 'George Lucas' 
GROUP BY nomcine
HAVING count(sa.titre) >= 2; 



/*------------------------------------------------------------------------------
(e) Prix maximum, prix minimum et prix moyen arrondi à 2 décimales,
    des projections programmées par chaque cinéma
    résultat ordonné par nom de cinéma
------------------------------------------------------------------------------*/

SELECT nomcine, round(min(prix),2) AS prix_min, round(max(prix),2) AS prix_max, round(avg(prix),2) AS prix_moy
FROM SALLE
GROUP BY nomcine
ORDER BY nomcine;



/*------------------------------------------------------------------------------
(f) Titre et nom du metteur en scène des films qui ne sont pas programmés
    pour la journée en cours
    une version sans sous-requête et une version avec sous-requête
------------------------------------------------------------------------------*/
-- 1. version sans sous-requête

SELECT *
FROM FILM
EXCEPT 
SELECT f.titre, metteurscene
FROM FILM f, SALLE sa, SEANCE se
WHERE f.titre = sa.titre AND se.nomcine = sa.nomcine AND se.numsalle = sa.numsalle;


-- 2. version avec sous-requête

SELECT *
FROM FILM 
WHERE (titre, metteurscene) 
NOT IN(SELECT f.titre, metteurscene
        FROM FILM f, SALLE sa, SEANCE se
        WHERE f.titre = sa.titre AND se.nomcine = sa.nomcine AND se.numsalle = sa.numsalle
);



/*------------------------------------------------------------------------------
(g) Pour afficher le nombre de séances débutant après 20h dans chaque cinéma,
    la requête suivante a été proposée...
------------------------------------------------------------------------------*/
SELECT NomCine, count(*) AS Nb_Seances_Soir
FROM SEANCE
WHERE Heure > 20
GROUP BY NomCine
ORDER BY NomCine;

-- 1. Exécutez-la
/*
  nomcine  | nb_seances_soir
-----------+-----------------
 La Nef    |               7
 Le Meliès |               2
 Pathé     |               6
(3 rows)
*/

-- 2. Justifiez pourquoi son résultat n'est pas satisfaisant

/*La requête n'affiche pas les cinémas qui n'ont pas de séances prévus le soir.
Les lignes où nb_seances_soir est égal à 0*/


--3. Proposez une solution recevable

SELECT Nomcine, (SELECT count(*) FROM SEANCE se WHERE heure > 20) AS nb_seances_soir
FROM SEANCE 
GROUP BY NomCine
ORDER BY NomCine;

/*DIFFICULTES AVEC LES SOUS REQUETES DANS UNE CLAUSE SELECT*/

/*------------------------------------------------------------------------------
(h) Pour chaque cinéma, Nombre de salles qui projettent un film interprété par
    Gérard Depardieu ou par Catherine Deneuve
------------------------------------------------------------------------------*/
SELECT DISTINCT sa.nomcine, (SELECT count(*) FROM ACTEUR WHERE titre = a.titre AND (nomact = 'Gérard Depardieu' OR nomact = 'Catherine Deneuve')) AS nbfilms_depardieu_ou_deneuve
FROM SALLE sa, ACTEUR a 
WHERE sa.titre = a.titre
AND nomact = 'Gérard Depardieu' OR nomact = 'Catherine Deneuve';


/*PAS LE BON RESULTAT*/


/*------------------------------------------------------------------------------
(i)	Des usagers ont fait part de leur besoin de connaître les détails
    des séances de projection proposées après 18h à un prix inférieur
    à la moyenne des prix pratiqués : heure de séance, prix à payer, titre
    du film projeté, nom du cinéma et numéro de la salle
------------------------------------------------------------------------------*/

-- 1. Écrire une requête affichant la moyenne des prix pratiqués
--   (moyenne arrondie à 2 décimales)

SELECT round(avg(Prix),2) AS prix_moy
FROM SALLE;


-- 2. En utilisant la requête précédente, affichez les informations désirées
--    résultat ordonné par heure, prix, puis par nom de cinéma

SELECT heure, prix, titre, sa.nomcine, sa.numsalle
FROM SALLE sa ,SEANCE se
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle
AND heure > 18 AND prix < (SELECT round(avg(Prix),2) FROM SALLE)
GROUP BY heure, prix, titre, sa.nomcine, sa.numsalle
ORDER BY heure, prix, sa.nomcine;




/*------------------------------------------------------------------------------
(j)	On s'intéresse aux films inteprétés par Fabrice Luchini.
	  Écrivez les requêtes affichant les informations suivantes :
------------------------------------------------------------------------------*/

-- 1. Nombre de séances où est projeté un film inteprété par Fabrice Luchini

SELECT count(*) AS nb_films_luchini
FROM SEANCE se, SALLE sa, ACTEUR a
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle AND sa.titre = a.titre 
AND Nomact = 'Fabrice Luchini';


-- 2. Répartition de ces séances par cinéma
--    Résultat ordonné sur le nom des cinémas

SELECT DISTINCT nomcine, (SELECT count(*) FROM ACTEUR a WHERE titre = a.titre AND nomact = 'Fabrice Luchini')
FROM SALLE sa, ACTEUR a 
WHERE sa.titre = a.titre
AND nomact = 'Fabrice Luchini'
GROUP BY nomcine
ORDER BY nomcine;


-- 3. Pour chaque cinéma où est projeté un film inteprété par Fabrice Luchini,
--    son nom,le nombre de salles qui proposent ce film et la fourchette de
--    prix pratiquée par ces salles (prix minimum, prix maximum)

SELECT sa.nomcine, count(*) AS nb_salles_luchini, min(Prix) AS prix_min, max(Prix) AS prix_max
FROM SALLE sa, ACTEUR a
WHERE sa.titre = a.titre
AND Nomact = 'Fabrice Luchini'
GROUP BY nomcine;


--4.  Nombre de projections pour chaque film inteprété par Fabrice Luchini

SELECT sa.titre AS film_luchini, count(*) AS nb_projections
FROM SEANCE se, SALLE sa, ACTEUR a
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle AND sa.titre = a.titre 
AND Nomact = 'Fabrice Luchini'
GROUP BY film_luchini;



--5.  Pour chaque film inteprété par Fabrice Luchini, nombre de projections
--    par cinéma passant ce film
--    Résultat ordonné par nombre de projections décroissant puis par titre

SELECT sa.titre AS film_luchini, sa.nomcine, count(*) AS nb_projections
FROM SEANCE se, SALLE sa, ACTEUR a
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle AND sa.titre = a.titre
AND Nomact = 'Fabrice Luchini' 
GROUP BY sa.titre, sa.nomcine
ORDER BY nb_projections DESC, film_luchini;



/*------------------------------------------------------------------------------
(k) Nom et adresse des cinémas qui projettent plus de 6 films différents
------------------------------------------------------------------------------*/
SELECT c.Nomcine, Adresse
FROM CINE c, SALLE sa
WHERE c.nomcine = sa.nomcine 
GROUP BY c.Nomcine 
HAVING count(DISTINCT titre) > 6;



/*------------------------------------------------------------------------------
(l) Nom et adresse des cinémas qui projettent le plus de films différents
------------------------------------------------------------------------------*/
SELECT c.Nomcine, Adresse
FROM CINE c, SALLE sa
WHERE c.nomcine = sa.nomcine 
GROUP BY c.Nomcine 
HAVING count(DISTINCT titre) >= ALL (SELECT count(DISTINCT titre) FROM SALLE);


/*Je n'y arrive pas*/




--------------------------------------------------------------------------------
-- FIN PARTIE B
--------------------------------------------------------------------------------
