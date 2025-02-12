--------------------------------------------------------------------------------
        -- INFORMATIONS SUR LES DONNÉES DE L'INSTANCE DE LA BD --
--------------------------------------------------------------------------------

/*______________________________________________________________________________
  INFO N°1
  Nombre de numéros dont Bozzo est responsable.
______________________________________________________________________________*/

SELECT count(titre) AS resp_Bozzo
FROM NUMERO
WHERE responsable = 'Bozzo';

/*______________________________________________________________________________
  INFO N°2
  Pour chaque numéro proposé au public, son titre et le nombre d'artistes qui
  l'interprètent.
  NOTE : un numéro proposé au public a au moins un interprète...
______________________________________________________________________________*/

SELECT n.titre, count(*) AS nb_artistes 
FROM NUMERO n, INTERPRETE i
WHERE n.titre = i.titre
GROUP BY n.titre
ORDER BY nb_artistes DESC;


/*______________________________________________________________________________
  INFO N°3
  Pour chaque numéro proposé au public, son titre et le nombre d'accessoires
  différents utilisés (la différence portant sur le code des accessoires).
  NOTE : dans certains numéros proposés au public, aucun accessoire n'est utilisé
______________________________________________________________________________*/

SELECT titre FROM UTILISATION,(SELECT count(*)) AS nb_accessoires
GROUP BY titre,nb_accessoires;

/*pas résolu*/

/*______________________________________________________________________________
  INFO N°4
  Immatriculation des camions où sont rangés au moins 6 accessoires.
______________________________________________________________________________*/

SELECT immatcamion
FROM ACCESSOIRE
GROUP BY immatcamion
HAVING count(*) >= 6;


/*______________________________________________________________________________
  INFO N°5
  INFO N°5.	Surnom et spécialité des artistes qui n'interprètent aucun numéro
  (2 solutions).
______________________________________________________________________________*/

SELECT Surnom, Specialite 
FROM ARTISTE 
WHERE Surnom NOT IN (SELECT Surnom FROM INTERPRETE);

SELECT Surnom, Specialite 
FROM ARTISTE 
EXCEPT 
SELECT a.Surnom, Specialite
FROM INTERPRETE i, ARTISTE a
WHERE i.surnom = a.surnom;



/*______________________________________________________________________________
  INFO N°6
  Nombre d'accessoires qui ne sont jamais utilisés.
  (essayer de trouver 2 solutions)
______________________________________________________________________________*/

SELECT count(*) AS acc_pas_utilisés
FROM ACCESSOIRE
WHERE CodeAcc NOT IN (SELECT CodeAcc FROM UTILISATION);




SELECT count(*)
FROM ACCESSOIRE
EXCEPT
SELECT count(*) 
FROM ACCESSOIRE a, UTILISATION u
WHERE a.CodeAcc = u.CodeAcc;






/*______________________________________________________________________________
  INFO N°7
  Plus grand nombre de ballons différents utilisés dans un numéro
  (la différence portant sur leur code).
______________________________________________________________________________*/



/*______________________________________________________________________________
  INFO N°8
  Pour chaque numéro, nombre de ballons différents et nombre d'autres
  accessoires de code différents qui sont utilisés.
______________________________________________________________________________*/



/*______________________________________________________________________________
  INFO N°9
  Pour chaque numéro : titre, surnom de l'artiste et nombre d'accessoires
  différents qu'il utilise (résultat ordonné sur le titre puis sur le surnom)
  ATTENTION :  certains artistes n'utilisent pas d'accessoire
______________________________________________________________________________*/




/*--------------------------------------------------------------------------------
  Résultat d'une requête qui fait état de l'utilisation de certains accessoires
  par chaque artiste qui interprète un numéro dont Bozzo est responsable

      titre     |   surnom    | nb_ballons | nb_quilles | nb_autres_acc
  --------------+-------------+------------+------------+---------------
   Les Zappatas | Blanc       |          1 |          1 |             0
   Les Zappatas | Bozzo       |          4 |          2 |             0
   Les Zappatas | Jules       |          0 |          1 |             3
   Les Zappatas | Milledoigts |          1 |          1 |             0
   Millequilles | Bozzo       |          0 |          0 |             0
   Millequilles | Gary        |          0 |          1 |             1
   Millequilles | Milledoigts |          0 |          1 |             0
   Rigolo       | Blanc       |          0 |          0 |             0
   Rigolo       | Bozzo       |          0 |          0 |             0
   Rigolo       | Raoul       |          0 |          0 |             0
  (10 rows)

  Ce résultat montre qu'un artiste interprétant un numéro dont Bozzo est
  responsable peut :
  - ne pas utiliser d'accessoires
  - utiliser plusieurs accessoires parmi lesquels des quille, ou des ballons,
    ou d'autres accessoires
  - n'utiliser aucun ballon mais éventuellement d'autres accessoires
  - n'utiliser que des quilles
------------------------------------------------------------------------------*/
/*______________________________________________________________________________
  INFO N°10
  Surnom des artistes qui n'utilisent jamis de ballon dans un numéro dont Bozzo
  est responsable.
______________________________________________________________________________*/



/*______________________________________________________________________________
  INFO N°11.
  Surnom des artistes qui n'utilisent que des quilles dans au moins un numéro
  dont Bozzo est responsable.
______________________________________________________________________________*/




/*______________________________________________________________________________
  INFO N°12.	BONUS
  Proposez une requête dont le résultat serait identique au tableau présenté
  avant l'INFO N°10.
______________________________________________________________________________*/




--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
