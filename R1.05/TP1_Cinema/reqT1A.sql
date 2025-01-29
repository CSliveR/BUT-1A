-- connection à la base cinema : psql -h postgres-info -U invite cinema
-- mdp : invite


/*______________________________________________________________________________

            Requêtes TP1 - PArtie A (FICHIER À COMPLÉTER)

     Étapes à suivre pour chaque question :
     (1)  Écrire le code de la requête
     (2)  Copier la requête (ctrl C), puis le coller (ctrl + Shift + V)
          dans le terminal où vous êtes connectés à PostGreSQL
     (3)  Vérifier le résultat obtenu par comparaison à celui attendu
          (cf. TP1B_Résultats sur Chamilo)
     (4)  Si le résultat attendu n'est pas le bon, reprendre à l'étape 1

______________________________________________________________________________*/

/*------------------------------------------------------------------------------
(a)	Numéro des salles et heure des séances du cinéma La Nef
------------------------------------------------------------------------------*/

SELECT Numsalle, Heure
FROM SEANCE
WHERE Nomcine = 'La Nef';


/*------------------------------------------------------------------------------
(b)	Pour chaque salle du cinéma Pathé : numéro de la salle, titre du film
    projeté et prix à payer
------------------------------------------------------------------------------*/

SELECT Numsalle, Titre, Prix
FROM SALLE
WHERE Nomcine = 'Pathé';




/*------------------------------------------------------------------------------
(c)	Nom des acteurs qui jouent dans des films mis en scène par Peter Jackson
------------------------------------------------------------------------------*/

SELECT DISTINCT Nomact
FROM ACTEUR a, FILM f
WHERE a.titre = f.titre
AND MetteurScene = 'Peter Jackson';




/*------------------------------------------------------------------------------
(d)	Nom et adresse des cinémas qui passent des films mis en scène
    par George Lucas
------------------------------------------------------------------------------*/

SELECT DISTINCT c.Nomcine, Adresse 
FROM CINE c,  SALLE s, FILM f
WHERE c.nomcine = s.nomcine AND s.titre = f.titre
AND MetteurScene = 'George Lucas'; 





/*------------------------------------------------------------------------------
(e) Par ordre alphabétique, nom des acteurs qui jouent dans
    au moins un des films Star Wars (le titre de ces films doit commencer
    par Star Wars)
------------------------------------------------------------------------------*/

SELECT DISTINCT Nomact
FROM ACTEUR
WHERE Titre LIKE 'Star Wars%'
ORDER BY Nomact;





/*------------------------------------------------------------------------------
(f) Nom des cinémas où passe un film mis en scène par un réalisateur
    dont le nom contient Porum
------------------------------------------------------------------------------*/

SELECT Nomcine
FROM SALLE s, FILM f
WHERE s.titre = f.titre 
AND MetteurScene LIKE '%Porum%';



/*------------------------------------------------------------------------------
(g)	Heure, numéro de la salle et prix à payer pour chaque salle du cinéma La Nef
    où est projeté le film Molière - résultat ordonné chronologiquement
------------------------------------------------------------------------------*/

SELECT Heure, sa.Numsalle, Prix
FROM SALLE sa, SEANCE se
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle
AND se.Nomcine = 'La Nef' 
AND titre = 'Molière'
ORDER BY Heure;  





/*------------------------------------------------------------------------------
(h)	Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
    et aussi dans The Virgin Suicides
    Une version avec opérateur ensembliste et une version sans opérateur
    ensembliste
------------------------------------------------------------------------------*/

-- version avec opérateur ensembliste

SELECT Nomact
FROM ACTEUR
WHERE Titre = 'Eternal Sunshine of the Spotless Mind' 
INTERSECT
SELECT Nomact
FROM ACTEUR
WHERE Titre = 'The Virgin Suicides';



-- version sans opérateur ensembliste

SELECT DISTINCT a1.Nomact
FROM ACTEUR a1, ACTEUR a2
WHERE a1.titre = a2.titre
AND a1.titre = 'Eternal Sunshine of the Spotless Mind' 
AND a2.titre = 'The Virgin Suicides';

/*pas le bon resultat*/


/*------------------------------------------------------------------------------
(i)	Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
    mais pas dans The Virgin Suicides
------------------------------------------------------------------------------*/

SELECT Nomact
FROM ACTEUR
WHERE Titre = 'Eternal Sunshine of the Spotless Mind' 
EXCEPT
SELECT Nomact
FROM ACTEUR
WHERE Titre = 'The Virgin Suicides';




/*------------------------------------------------------------------------------
(j) Nom des acteurs qui jouent dans The Virgin Suicides mais pas
    dans Eternal Sunshine of the Spotless Mind
------------------------------------------------------------------------------*/

SELECT Nomact
FROM ACTEUR
WHERE Titre = 'The Virgin Suicides' 
EXCEPT
SELECT Nomact
FROM ACTEUR
WHERE Titre = 'Eternal Sunshine of the Spotless Mind';



/*------------------------------------------------------------------------------
(k)	Titre des films interprétés par Romain Duris ou par Fabrice Luchini
    Une version avec opérateur ensembliste et une version sans opérateur
    ensembliste
------------------------------------------------------------------------------*/

-- version avec opérateur ensembliste

SELECT f.titre 
FROM FILM f, ACTEUR A
WHERE f.titre = a.titre
AND Nomact = 'Romain Duris'
UNION 
SELECT f.titre 
FROM FILM f, ACTEUR A
WHERE f.titre = a.titre
AND Nomact = 'Fabrice Luchini';


-- version sans opérateur ensembliste

SELECT DISTINCT f.titre 
FROM FILM f, ACTEUR a1, ACTEUR a2
WHERE f.titre = a1.titre AND f.titre = a2.titre AND a1.titre = a2.titre
AND (a1.Nomact = 'Romain Duris' OR a2.Nomact = 'Fabrice Luchini');


/*------------------------------------------------------------------------------
(l) Nombre de séances où est projeté un film interprété par Romain Duris ou
    par Fabrice Luchini
------------------------------------------------------------------------------*/
/*RESULTAT: 19 ET PAS 30 ERREUR SUR LE SUJET DE TP*/

SELECT count(*) AS nb_seances_duris_ou_luchini
FROM SALLE sa, ACTEUR a
WHERE sa.titre = a.titre 
AND (Nomact = 'Romain Duris' OR Nomact = 'Fabrice Luchini');

/*A voir*/

/*------------------------------------------------------------------------------
(m) Pour toutes les projections d'un film interprété par Romain Duris ou par
    Fabrice Luchini : titre du film, nom du cinéma, numéro de la salle,
    heure de la projection et prix à payer
    résultat ordonné par cinéma, puis par heure de projection
------------------------------------------------------------------------------*/

SELECT sa.titre, sa.nomcine, sa.numsalle, Heure, Prix 
FROM SALLE sa, SEANCE se, ACTEUR a
WHERE sa.nomcine = se.nomcine AND sa.numsalle = se.numsalle AND sa.titre = a.titre
AND (Nomact = 'Romain Duris' OR Nomact = 'Fabrice Luchini')
ORDER BY sa.Nomcine, Heure;


/*------------------------------------------------------------------------------
(n)	Écrivez une requête qui affiche les informations suivantes :

        titre     |      nomact       |        titre        |   metteurscene
    --------------+-------------------+---------------------+-------------------
     Les Climats  | Nuri Bilge Ceylan | Les Climats         | Nuri Bilge Ceylan
     Mystic River | Sean Penn         | Crossing Guard      | Sean Penn
     CQ           | Sofia Coppola     | The Virgin Suicides | Sofia Coppola
     CQ           | Sofia Coppola     | Lost in Translation | Sofia Coppola
    (4 rows)
------------------------------------------------------------------------------*/

SELECT f.titre, nomact, f.titre, metteurscene
FROM ACTEUR a, FILM f
WHERE a.titre = f.titre 
AND nomact = metteurscene; 

/*A voir*/

/*------------------------------------------------------------------------------
(o)	Inspirez-vous de la requête produite en (n) pour écrire des requêtes
    affichant :                                                               */

-- 1.	le nombre de films dans lesquels joue un metteur en scène

SELECT DISTINCT count(*) AS nbfilms_acteur_aussi_realisateur
FROM ACTEUR a, FILM f
WHERE f.titre = a.titre 
AND nomact = metteurscene;

/*A voir*/

-- 2. le titre des films où le metteur en scène fait partie des interprètes
SELECT f.titre
FROM ACTEUR a, FILM f 
WHERE f.titre = a.titre 
AND metteurscene = nomact;




--------------------------------------------------------------------------------
-- FIN PARTIE A
--------------------------------------------------------------------------------
