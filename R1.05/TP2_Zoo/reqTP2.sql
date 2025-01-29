/*
_________________________________________________________
--  
--          Requêtes TP2 (fichier à compléter)
--
_________________________________________________________
*/

/*------------------------------------------------------------------------------
(a) Nom et numéro des 3 premiers gardiens selon l'ordre alphabétique
------------------------------------------------------------------------------*/
SELECT nomGard, numGard 
FROM GARDIEN 
ORDER BY nomGard
LIMIT 3;

/*------------------------------------------------------------------------------
(b)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin ou Milou
    (résultat ordonné sur le nom d'animal)
------------------------------------------------------------------------------*/

SELECT NomAni, Espece, a.Numcage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE a.numcage = s.numcage AND s.numgard = g.numgard
AND NomGard = 'Milou'
UNION
SELECT NomAni, Espece, a.Numcage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE a.numcage = s.numcage AND s.numgard = g.numgard
AND NomGard = 'Tintin'
GROUP BY NomAni
ORDER BY Nomani;


/*------------------------------------------------------------------------------
(c)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin et Milou
------------------------------------------------------------------------------*/

SELECT NomAni, Espece, a.Numcage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE a.numcage = s.numcage AND s.numgard = g.numgard
AND NomGard = 'Milou'
INTERSECT
SELECT NomAni, Espece, a.Numcage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE a.numcage = s.numcage AND s.numgard = g.numgard
AND NomGard = 'Tintin';


/*------------------------------------------------------------------------------
(d)	Nom des gardiens qui ne s'occupent d'aucune cage
Une version avec opérateur ensembliste + une version avec sous-requête(s)
------------------------------------------------------------------------------*/

SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s
EXCEPT 
SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s
WHERE g.numgard = s.numgard;

SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s 
WHERE NomGard NOT IN 
(SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s
WHERE g.numgard = s.numgard);


/*------------------------------------------------------------------------------
(e)	Nom des gardiens qui s'occupent d'éléphants
------------------------------------------------------------------------------*/

SELECT DISTINCT NomGard
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numgard = s.numgard AND a.numcage = s.numcage
AND Espece = 'éléphant';
 

/*------------------------------------------------------------------------------
(f)	Nom des gardiens qui ne s'occupent pas d'éléphants
		(mais qui s'occupent d'au moins une cage)
------------------------------------------------------------------------------*/

SELECT DISTINCT NomGard
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE NomGard NOT IN 
(SELECT DISTINCT NomGard
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numgard = s.numgard AND a.numcage = s.numcage
AND Espece = 'éléphant')
EXCEPT 
SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s 
WHERE NomGard NOT IN 
(SELECT DISTINCT NomGard 
FROM GARDIEN g, SOCCUPE s
WHERE g.numgard = s.numgard);

 
/*------------------------------------------------------------------------------
(g)	Nombre d'animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/

SELECT count(*) - 1 AS colloc_dumbo
FROM ANIMAL
WHERE Numcage = 
(SELECT Numcage FROM animal WHERE NomAni = 'dumbo');


/*------------------------------------------------------------------------------
(h)	Nom et espèce des animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/

SELECT Nomani, Espece
FROM ANIMAL
WHERE Numcage = 
(SELECT Numcage FROM animal WHERE NomAni = 'dumbo')
AND Nomani != 'dumbo';


/*------------------------------------------------------------------------------
(i) Nom et adresse des gardiens nés en 1980
------------------------------------------------------------------------------*/

SELECT Nomgard, Adresse
FROM GARDIEN
WHERE EXTRACT(year FROM DateNaissGard) = 1980;

/*------------------------------------------------------------------------------
(j) Âge qu'a atteint aujourd'hui le gardien Gaston Lagaffe
------------------------------------------------------------------------------*/

SELECT current_date AS datecalcul, age(DateNaissGard) AS age_lagaffe
FROM GARDIEN
WHERE nomGard = 'Gaston Lagaffe';


/*------------------------------------------------------------------------------
(k)	Par ordre chronologique, date du diagnostic, nom de la maladie
    et nom de l'animal malade, pour chaque cas de maladie enregistré en 2022
------------------------------------------------------------------------------*/

SELECT DateDebutMal, Maladie, Nomani
FROM SUIVI_MAL
WHERE EXTRACT(year FROM DateDebutMal) = 2022
ORDER BY DateDebutMal;


/*------------------------------------------------------------------------------
(l)	Nombre d'éléphants qui ont eu au moins une fois le typhus
------------------------------------------------------------------------------*/

SELECT count(DISTINCT a.nomani) AS atteints_typhus
FROM SUIVI_MAL sm, ANIMAL a
WHERE sm.nomani = a.nomani
AND Maladie = 'typhus' AND espece = 'éléphant';

/*morale à en tirer sur ce type de question*/

/*------------------------------------------------------------------------------
(m)	Nom et espèce des animaux qui sont encore malades aujourd'hui
------------------------------------------------------------------------------*/

SELECT DISTINCT sm.nomani, espece 
FROM SUIVI_MAL sm, ANIMAL a
WHERE sm.nomani = a.nomani 
AND DateFinMal IS NULL;


/*------------------------------------------------------------------------------
(n)	Nom des animaux qui ont contracté au moins deux maladies différentes
------------------------------------------------------------------------------*/

SELECT nomani
FROM SUIVI_MAL
GROUP BY nomani
HAVING count(DISTINCT maladie) >= 2;


/*------------------------------------------------------------------------------
(o)	Numéro des cages où sont gardés des animaux qui ont déjà contracté
    le typhus et la gale
------------------------------------------------------------------------------*/

SELECT numcage 
FROM SUIVI_MAL sm, ANIMAL a
WHERE sm.nomani = a.nomani
AND maladie = 'typhus'
INTERSECT
SELECT numcage 
FROM SUIVI_MAL sm, ANIMAL a
WHERE sm.nomani = a.nomani
AND maladie = 'gale';

/*PAS BON*/


/*------------------------------------------------------------------------------
(p)	Nom et numéro de cage des animaux qui ont été ou sont malades et dont
    le gardient Gaston Lagaffe a la charge
		(résultat ordonné sur le numéro de cage puis sur le nom d'animal)
------------------------------------------------------------------------------*/

SELECT a.nomani, a.numcage
FROM SUIVI_MAL sm, SOCCUPE s, ANIMAL a, GARDIEN g
WHERE a.nomani = sm.nomani AND a.numcage = s.numcage AND g.numgard = s.numgard 
AND Nomgard = 'Gaston Lagaffe'
AND DateDebutMal IS NOT NULL
GROUP BY a.nomani, a.numcage 
ORDER BY a.numcage, a.nomani;


/*------------------------------------------------------------------------------
(q)	Nombre de jours minimum qu'un animal a mis pour guérir d'une maladie
		qu'il avait contractée
------------------------------------------------------------------------------*/

SELECT min(DateFinMal - DateDebutMal) AS min_nbjoursmal
FROM SUIVI_MAL;



/*------------------------------------------------------------------------------
(r)	Nombre de jours minimum qu'un animal a mis pour guérir de la gale et
		Nombre de jours minimum qu'un animal a mis pour guérir du typhus
INDICATION : utliser des sous-requêtes pour déterminer chacun des nombres de
jours à afficher
------------------------------------------------------------------------------*/

SELECT min(DateFinMal - DateDebutMal) AS min_nbj_gale,
(SELECT min(DateFinMal - DateDebutMal) AS min_nbj_typhus
FROM SUIVI_MAL
WHERE maladie = 'typhus')
FROM SUIVI_MAL
WHERE maladie = 'gale';


/*------------------------------------------------------------------------------
(s)	Pour chaque animal du zoo, nombre de maladies différentes
    qu'il a contractées (résultat ordonné par nombre de maladies décroissant)
ATTENTION, certains animaux n'ont encore jamais été malades !
------------------------------------------------------------------------------*/

SELECT nomani,
(SELECT count(DISTINCT maladie) AS nb_maladie_diff 
FROM SUIVI_MAL
ORDER BY nb_maladie_diff DESC)
FROM SUIVI_MAL
GROUP BY nomani;




/*------------------------------------------------------------------------------
(t)	Nombre d'animaux par cage du zoo – le numéro et le type de chaque cage
    sera affiché (résultat ordonné par nombre d'animaux décroissant)
ATTENTION - il peut y avoir des cages vides
------------------------------------------------------------------------------*/

SELECT c.numcage, typecage,
    (SELECT count(*) AS nb_ani 
    FROM CAGE c, ANIMAL a
    WHERE c.numcage = a.numcage)
FROM CAGE c;

/*------------------------------------------------------------------------------
(u)	Nombre de cages affectées à chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre de cages décroissant)
------------------------------------------------------------------------------*/


/*------------------------------------------------------------------------------
(v)	Nombre d'animaux dont s'occupe chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre d'animaux décroissant)
------------------------------------------------------------------------------*/


/*------------------------------------------------------------------------------
(w)	Nom, âge (en années) et adresse des gardiens qui s'occupent
    d'au moins 7 animaux
------------------------------------------------------------------------------*/

SELECT nomgard, EXTRACT (year FROM current_date) - EXTRACT(year FROM DateNaissGard) AS age, adresse
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numGard = s.numgard and a.numcage = s.numcage
GROUP BY nomgard, age, adresse
HAVING count(*) >= 7;


/*------------------------------------------------------------------------------
(x)	Titeuf s'occupe de beaucoup d'animaux ! On voudrait en savoir plus…
    1.	Combien de cages dont il s'occupe abritent des éléphants ?
    2.	Quel est l'âge en années du plus vieil animal (ou des plus vieux animaux)
        dont il s'occupe ?
    3.	Pour chaque espèce d'animal, combien a-t-il d'animaux en charge ?
------------------------------------------------------------------------------*/

SELECT count(DISTINCT a.numcage) AS nb_cages_elephant 
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numGard = s.numgard and a.numcage = s.numcage
AND nomgard = 'Titeuf'
AND espece = 'éléphant';

SELECT min(EXTRACT(year FROM DateNaissAni)) AS age_plus_vieux_ani
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numGard = s.numgard and a.numcage = s.numcage
AND nomgard = 'Titeuf';

SELECT espece, count(*) AS nb_animaux
FROM GARDIEN g, SOCCUPE s, ANIMAL a
WHERE g.numGard = s.numgard and a.numcage = s.numcage
AND nomgard = 'Titeuf'
GROUP BY espece; 


--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
---------------------
