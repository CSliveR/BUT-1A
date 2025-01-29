/*================================================================*/
/* Drouiche Ilyès - TP01 : Révisions - BD relationnelle et SQL simple */
/*================================================================*/

/***********************************************************/
/* 1 -nom des personnages des films de l'univers Marvel-Avengers dans l'ordre alphabétique  */
/***********************************************************/
SELECT nom
FROM personnage
ORDER BY nom; 

/***********************************************************/
/* 2- A quelle question répond la requête SQL suivante :

 SELECT count(*) as nbf      
  FROM apparait_dans                
  WHERE nom='Iron Man';  */

/***********************************************************/

/*Cette requête affiche le nombre de films dans lequels Iron Man apparait.*/



/***********************************************************/
/* 3- Afficher le nombre de films sortis chaque année.
    Ne considérer que les années où au moins un film est sorti.
    Le nombre de films doit apparaître sous le nom d'attribut nf.
    Les résultats doivent être affichés dans l'ordre chronologique.*/
 /***********************************************************/

SELECT annee, count(*) AS nbf
FROM Film
GROUP BY annee
ORDER BY annee;

/***********************************************************/
/* 4- Donner le nom des personnages jouant dans un film dont le titre contient son nom.
Les personnages ne doivent apparaître qu'une seule fois, dans l'ordre alphabétique de leur nom. */
/***********************************************************/

SELECT DISTINCT nom
FROM Personnage NATURAL JOIN Apparait_dans
WHERE nom LIKE '%'||nom||'%'
ORDER BY nom;


/***********************************************************/
/*5- Donner le nom des personnages dont l'état civil indique qu'ils sont nés dans l'état de New York. */
/***********************************************************/

SELECT p.nom 
FROM Etat_civil e LEFT JOIN Personnage p ON e.nom = p.alias 
WHERE etat = 'New York';



/***********************************************************/
/* 6- A quelle question répond la requête SQL suivante :

 SELECT titre             
 FROM film NATURAL JOIN realise 
 GROUP BY titre                 
 HAVING COUNT(*) > 1            
 ORDER BY titre;  */
/***********************************************************/


/*Cette requête affiche les titres des films qui ont au moins 2 réalisateurs dans l'ordre alphabétique*/



/***********************************************************/
/* 7 -Donner le titre des films n'ayant qu'un seul réalisateur, dans l'ordre alphabétique de leur titre.*/
/***********************************************************/
 
SELECT titre             
FROM film NATURAL JOIN Realise 
GROUP BY titre                 
HAVING count(*) = 1            
ORDER BY titre;


/***********************************************************/
/*8- Donner la liste des informations des personnages, complétées par leur état civil, s'ils en ont un.

    Une seule colonne doit contenir l'alias d'un personnage.
    La liste doit être ordonnée par ordre alphabétique du nom des personnages.*/
/***********************************************************/

SELECT p.*, annee, etat
FROM Personnage p LEFT JOIN Etat_civil e ON e.nom = p.alias
ORDER BY p.nom;


/***********************************************************/
/*9- Pour chaque film dont le titre commence par Avengers, donner le nombre de personnage qui y meurent.

    Ce nombre doit apparaître sous le nom d'attribut nbm
    Il doit être égal à zéro si aucun personnage ne meurt dans le film. */
/***********************************************************/

SELECT titre, count(nom) AS nbm
FROM Meurt_dans NATURAL RIGHT JOIN Film 
WHERE titre LIKE 'Avengers%'
GROUP BY titre
ORDER BY nbm DESC;

/***********************************************************/
/*10- Donner le titre des films où apparaît un personnage né dans l'état de Pennsylvanie.

    Chaque titre doit apparaître autant de fois que de personnages concernés, accompagné du nom d'état civil du personnage.
    La liste doit être ordonnée par ordre alphabétique du titre, puis du nom civil. */

/***********************************************************/

SELECT titre, e.nom
FROM Film NATURAL RIGHT JOIN Apparait_dans NATURAL JOIN Personnage p JOIN Etat_civil e ON e.nom = p.alias
WHERE etat = 'Pennsylvanie'
ORDER BY titre, e.nom;

/***********************************************************/
/*11- Pour chaque film où au moins un personnage apparaît en post-générique, donner son titre suivi du nombre de personnages avec alias qui apparaissent en post-générique.
    Le nombre de personnages doit apparaître sous le nom d'attribut nap.
    Il doit être égal à zéro si aucun personnage apparaissant en post-générique n'a un alias.
    Les résultats doivent être affichés dans l'ordre décroissant de nap puis par ordre alphabétique du titre du film en cas d'ex-aequo. */
/***********************************************************/

SELECT titre, count(alias) AS nap
FROM Film NATURAL JOIN Apparait_dans NATURAL JOIN Personnage 
WHERE post_generique = true
GROUP BY titre
ORDER BY nap DESC, titre;

/***********************************************************/
/*12 -Pour chaque paire de personnages, afficher leurs noms suivis du nombre de films dans lesquels ils apparaissent ensemble, si ce nombre est au moins égal à 5.
    Les résultats doivent être affichés par des attributs nommés nom1, nom2 et ne.
    Chaque paire de personnages ne doit apparaître qu'une seule fois.
    Les résultats doivent être affichés dans l'ordre décroissant de ne.*/
/***********************************************************/

SELECT 
FROM 





/***********************************************************/
/*13- Pour chaque réalisateur, donner son nom suivi de l'année de son premier film, celle de son dernier film, puis le nombre d'années participant 
à cet intervalle de temps.
    Ce nombre d'années doit apparaître sous le nom d'attribut intervalle.
    Les résultats sont affichés par ordre décroissant de intervalle. */

/***********************************************************/

SELECT realisateur, min(annee), max(annee), max(annee) - min(annee) AS intervalle
FROM Realise NATURAL JOIN film 
GROUP BY realisateur
ORDER BY intervalle DESC;
