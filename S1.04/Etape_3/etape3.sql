/*(a) Nombre de survivants, respectivement de victimes parmi les passagers, selon leur classe (une requête par classe)*/

SELECT sum(Survived) AS nb_survivants, count(*) - sum(Survived) AS nb_victimes
FROM PASSENGER
WHERE Pclass = 1;

SELECT sum(Survived) AS nb_survivants, count(*) - sum(Survived) AS nb_victimes
FROM PASSENGER
WHERE Pclass = 2;

SELECT sum(Survived) AS nb_survivants, count(*) - sum(Survived) AS nb_victimes
FROM PASSENGER
WHERE Pclass = 3;

/*  nb_survivants | nb_victimes 
---------------+-------------
           200 |         123
(1 row)

 nb_survivants | nb_victimes 
---------------+-------------
           119 |         158
(1 row)

 nb_survivants | nb_victimes 
---------------+-------------
           181 |         528
(1 row) */


/*(b) Nombre de survivants, respectivement de victimes parmi les passagers, selon leur catégorie (enfant, femme ou
homme – une requête par catégorie) ?*/


SELECT sum(Survived) AS nb_survivants_enfants, count(*) - sum(Survived) AS nb_victimes_enfants
FROM PASSENGER
WHERE age < 12;

SELECT sum(Survived) AS nb_survivants_femmes, count(*) - sum(Survived) AS nb_victimes_femmes
FROM PASSENGER
WHERE Sex = 'female' AND age >=12;

SELECT sum(Survived) AS nb_survivants_hommes, count(*) - sum(Survived) AS nb_victimes_hommes
FROM PASSENGER
WHERE Sex = 'male' AND age >=12;


/*Résultats avec peuplement.sql*/

/*
 nb_survivants_enfants | nb_victimes_enfants
-----------------------+---------------------
                    51 |                  39
(1 row)

 nb_survivants_femmes | nb_victimes_femmes
----------------------+--------------------
                  267 |                 79
(1 row)

 nb_survivants_hommes | nb_victimes_hommes
----------------------+--------------------
                  109 |                501
(1 row)
 */

/*Résultats avec new_peuplement.sql*/

/*  nb_survivants_enfants | nb_victimes_enfants 
-----------------------+---------------------
                    54 |                  51
(1 row)

 nb_survivants_femmes | nb_victimes_femmes 
----------------------+--------------------
                  314 |                105
(1 row)

 nb_survivants_hommes | nb_victimes_hommes 
----------------------+--------------------
                  132 |                653
(1 row)
 */


/* Ecrivez une requête qui compare le nombre de survivants parmi les passagers au total des survivants enfants,
femmes et hommes résultant des requêtes précédentes*/

SELECT sum(Survived) - 
((SELECT sum(Survived) FROM PASSENGER WHERE age < 12) + (SELECT sum(Survived) FROM PASSENGER WHERE Sex = 'female' AND age >=12) 
+ (SELECT sum(Survived) FROM PASSENGER WHERE Sex = 'male' AND age >=12)) AS nb_survivants_diff
FROM PASSENGER;

/*Résultat avec peuplement.sql*/

/*
 nb_survivants_diff
--------------------
                 73
(1 row)
*/

/*Résultat avec new_peuplement.sql*/

/*  nb_survivants_diff
--------------------
                  0
(1 row) */

/* Ecrivez une autre requête qui compare le nombre de victimes parmi les passagers au total des victimes enfants,
femmes et hommes résultant de ces mêmes requêtes.*/

SELECT count(*) - sum(Survived) - 
((SELECT count(*) - sum(Survived) FROM PASSENGER WHERE age < 12) + (SELECT count(*) - sum(Survived) FROM PASSENGER WHERE Sex = 'female' AND age >= 12) 
+ (SELECT count (*) - sum(Survived) FROM PASSENGER WHERE Sex = 'male' AND age >=12)) AS nb_victimes_diff
FROM PASSENGER;

/*Résultat avec peuplement.sql*/

/*
 nb_victimes_diff
------------------
              190
(1 row)
*/

/*Résultat avec new_peuplement.sql*/

/*  nb_victimes_diff
------------------
                0
(1 row)
 */

/*A3. Taux de survivants dans les différentes catégories de passagers selon leur classe*/

/*(a) Taux de survivants par classe, toutes catégories confondues (enfants, femmes ou hommes)*/

SELECT Pclass, sum(Survived)*100/(SELECT count(*) FROM PASSENGER WHERE Pclass = p.Pclass) AS taux_survivants
FROM PASSENGER p
GROUP BY Pclass
ORDER BY Pclass;

/*  pclass | taux_survivants 
--------+-----------------
      1 |              61
      2 |              42
      3 |              25
(3 rows) */



/*(b) Taux de survivants par classe dans la catégorie enfants*/

SELECT Pclass, sum(Survived)*100/(SELECT count(*) FROM PASSENGER WHERE age < 12 AND Pclass = p.Pclass) AS taux_survivants
FROM PASSENGER p
WHERE age < 12
GROUP BY Pclass
ORDER BY Pclass;

/*  pclass | taux_survivants 
--------+-----------------
      1 |              80
      2 |             100
      3 |              35
(3 rows)
 */



/*(c) Taux de survivants par classe dans la catégorie femmes*/

SELECT Pclass, sum(Survived)*100/(SELECT count(*) FROM PASSENGER WHERE Sex = 'female' AND age >= 12 AND Pclass = p.Pclass) AS taux_survivants
FROM PASSENGER p
WHERE Sex = 'female' AND age >= 12
GROUP BY Pclass
ORDER BY Pclass;

/*  pclass | taux_survivants 
--------+-----------------
      1 |              97
      2 |              87
      3 |              50
(3 rows) */



/*(d) Taux de survivants par classe dans la catégorie hommes*/

SELECT Pclass, sum(Survived)*100/(SELECT count(*) FROM PASSENGER WHERE Sex = 'male' AND age >= 12 AND Pclass = p.Pclass) AS taux_survivants
FROM PASSENGER p
WHERE Sex = 'male' AND age >= 12
GROUP BY Pclass
ORDER BY Pclass;

/*  pclass | taux_survivants 
--------+-----------------
      1 |              32
      2 |               8
      3 |              13
(3 rows)
 */


/*A4. Taux de survivants parmi les rescapés (passagers ayant pu monter dans une embarcation de sauvetage)*/

/*(a) Nombre total d'enfants et nombre d'enfants rescapés*/

SELECT count(*) AS nb_enfants, (SELECT count(r.PassengerId) AS nb_enfants_rescapes
FROM RESCUE r, PASSENGER p
WHERE age < 12 AND r.PassengerId = p.PassengerId)
FROM PASSENGER
WHERE age < 12;

/*  nb_enfants | nb_enfants_rescapes
------------+---------------------
        105 |                  53
(1 row) */

/*(b) Nombre d'enfants qui ont survécu parmi les enfants qui ont été rescapés*/

SELECT sum(Survived) AS nb_enfants_rescapes_survivants
FROM RESCUE r, PASSENGER p WHERE age < 12 AND r.PassengerId = p.PassengerId;

/*  nb_enfants_rescapes_survivants
--------------------------------
                             53
(1 row)
 */


/* (c) Pour chaque classe de passagers : nombre d'enfants qui ont survécu parmi les enfants rescapés */

SELECT Pclass, sum(p.Survived) AS nb_enfants_rescapes_survivants
FROM RESCUE r, PASSENGER p WHERE age < 12 AND r.PassengerId = p.PassengerId 
GROUP BY Pclass
ORDER BY Pclass;

/*  pclass | nb_enfants_rescapes_survivants
--------+--------------------------------
      1 |                              4
      2 |                             22
      3 |                             27
(3 rows)
 */

/*(d) Taux de rescapés parmi les passagers */


SELECT sum(Survived)*100/(SELECT count(*) FROM PASSENGER p) AS taux_rescapes
FROM PASSENGER p, RESCUE r 
WHERE p.PassengerId  = r.PassengerId;

/*  taux_rescapes
---------------
            36
(1 row) */


/*(e) Nombre de rescapés par catégorie de passager (enfant, femme ou homme)*/

SELECT (SELECT count(*) AS nb_enfants_rescapes
FROM RESCUE r, PASSENGER p
WHERE age < 12 AND p.PassengerId = r.PassengerId), (SELECT count(*) AS nb_hommes_rescapes
FROM RESCUE r, PASSENGER p
WHERE Sex = 'male' AND age >=12 AND p.PassengerId = r.PassengerId), (SELECT count(*) AS nb_femmes_rescapees
FROM RESCUE r, PASSENGER p WHERE Sex = 'female' AND age >=12 AND p.PassengerId = r.PassengerId);

/*  nb_enfants_rescapes | nb_hommes_rescapes | nb_femmes_rescapees
---------------------+--------------------+---------------------
                  53 |                143 |                 294
(1 row) */

/*(f) Nombre de survivants par catégorie de rescapés (enfant, femme ou homme)*/

SELECT (SELECT sum(survived) AS nb_enfants_survivants
FROM RESCUE r, PASSENGER p
WHERE age < 12 AND p.PassengerId = r.PassengerId), (SELECT sum(Survived) AS nb_hommes_survivants
FROM RESCUE r, PASSENGER p
WHERE Sex = 'male' AND age >= 12 AND p.PassengerId = r.PassengerId), (SELECT sum(Survived) AS nb_femmes_survivants
FROM RESCUE r, PASSENGER p WHERE Sex = 'female' AND age >=12 AND p.PassengerId = r.PassengerId);

/*  nb_enfants_survivants | nb_hommes_survivants | nb_femmes_survivants
-----------------------+----------------------+----------------------
                    53 |                  128 |                  292
(1 row)
 */

/*(g) Nombre total de rescapés et taux de survivants par embarcation - résultat ordonné sur le code de l'embarcation*/

SELECT LifeBoatId, count(*) AS nb_rescapes_embarcation,
      sum(Survived)*100/count(*) AS taux_survivants_embarcation
FROM PASSENGER p, RESCUE r
WHERE p.PassengerId = r.PassengerId
GROUP BY LifeBoatId
ORDER BY LifeBoatId DESC;

/*  lifeboatid | nb_rescapes_embarcation | taux_survivants_embarcation
------------+-------------------------+-----------------------------
 D          |                      19 |                          94
 C          |                      37 |                         100
 B          |                      10 |                          90
 A          |                      11 |                          63
 9          |                      26 |                          92
 8          |                      23 |                         100
 7          |                      25 |                         100
 6          |                      21 |                          95
 5          |                      28 |                         100
 4          |                      32 |                          93
 3          |                      26 |                          96
 2          |                      14 |                         100
 16         |                      25 |                         100
 15         |                      39 |                         100
 14         |                      35 |                          97
 13         |                      41 |                          97
 12         |                      18 |                          94
 11         |                      25 |                          92
 10         |                      30 |                         100
 1          |                       5 |                         100
(20 rows) */



/*(h) Pour chaque classe de passager, nombre d'enfants, nombre de femmes et nombre d'hommes qui ont survécu parmi les rescapés*/

SELECT ((SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND age < 12 AND Pclass = 1),
(SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'female' AND age >=12 AND Pclass = 1),
(SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'male' AND age >=12 AND Pclass = 1)) AS Passagers_classe1_survivants_rescapes,
((SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND age < 12 AND Pclass = 2),
(SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'female' AND age >=12 AND Pclass = 2),
(SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'male' AND age >=12 AND Pclass = 2))AS Passagers_classe2_survivants_rescapes,
((SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND age < 12 AND Pclass = 3),
(SELECT sum(Survived) FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'female' AND age >=12 AND Pclass = 3),
(SELECT sum(Survived)FROM PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND Sex = 'male' AND age >=12 AND Pclass = 3)) AS Passagers_classe3_survivants_rescapes;

/* 
 passagers_classe1_survivants_rescapes | passagers_classe2_survivants_rescapes | passagers_classe3_survivants_rescapes
---------------------------------------+---------------------------------------+---------------------------------------
 (4,135,56)                            | (22,75,14)                            | (27,82,58)
(1 row) */

/*Nombre de domestiques rescapés*/
SELECT count(PassengerId_Dom) AS nb_domestiques_rescapes
FROM SERVICE s, PASSENGER p, RESCUE r
WHERE p.PassengerId = r.PassengerId AND s.PassengerId_Dom = r.PassengerId; 

/*  nb_domestiques_rescapes
-------------------------
                      29
(1 row)
 */

/*Employeurs rescapés des passagers rescapés*/
SELECT s.PassengerId_Emp, s.PassengerId_Dom, dom_rescapes.LifeBoatId, r.LifeBoatId
FROM (SELECT PassengerId_Dom, LifeBoatId FROM SERVICE s, PASSENGER p, RESCUE r WHERE p.PassengerId = r.PassengerId AND s.PassengerId_Dom = r.PassengerId) AS dom_rescapes
      ,PASSENGER p, RESCUE r, SERVICE s
WHERE p.PassengerId = r.PassengerId AND s.PassengerId_Emp = r.PassengerId AND dom_rescapes.PassengerId_Dom = s.PassengerId_Dom; 

/*  passengerid_emp | passengerid_dom | lifeboatid | lifeboatid
-----------------+-----------------+------------+------------
             830 |              62 | 6          | 6
              32 |             196 | 6          | 6
             940 |             219 | 8          | 8
            1235 |             259 | 3          | 3
            1206 |             270 | 8          | 8
             988 |             291 | 6          | 6
             582 |             307 | 4          | 4
             557 |             310 | 1          | 1
            1088 |             338 | 3          | 3
             701 |             381 | 4          | 4
             760 |             505 | 8          | 8
             821 |             521 | 3          | 3
            1131 |             538 | 2          | 2
             888 |             610 | 3          | 3
             370 |             642 | 9          | 9
             646 |             682 | 3          | 3
             306 |             709 | 11         | 11
             701 |             717 | 4          | 4
             680 |             738 | 3          | 3
             764 |             843 | 4          | 4
             780 |            1216 | 2          | 2
             320 |            1263 | 3          | 3
             956 |            1267 | 4          | 4
             308 |            1306 | 8          | 8
(24 rows) */

/*Influence de l'emplacement des embarcations de sauvetage (position)*/
SELECT(SELECT (sum(Survived)*100/count(*))AS survivants_avant FROM Passenger p,Rescue r, Lifeboat l WHERE p.passengerId=r.passengerId AND r.LifeBoatId=l.LifeboatId AND position='avant'), 
(SELECT (sum(Survived)*100/count(*))AS survivants_arriere FROM Passenger p2,Rescue r2, Lifeboat l2 WHERE p2.passengerId=r2.passengerId AND r2.LifeBoatId=l2.LifeboatId AND position='arriere');

/*
 survivants_avant | survivants_arriere
------------------+--------------------
               96 |                 97
(1 row)
*/

/*Influence de l'emplacement des embarcations de sauvetage (side)*/
SELECT(SELECT (sum(Survived)*100/count(*))AS survivants_babord FROM Passenger p,Rescue r, Lifeboat l WHERE p.passengerId=r.passengerId AND r.LifeBoatId=l.LifeboatId AND side='babord'), 
(SELECT (sum(Survived)*100/count(*))survivants_tribord FROM Passenger p2,Rescue r2, Lifeboat l2 WHERE p2.passengerId=r2.passengerId AND r2.LifeBoatId=l2.LifeboatId AND side='tribord');

/*
 survivants_babord | survivants_tribord
-------------------+--------------------
                96 |                 96
(1 row)
*/

/*Influence de l'heure de mise à l'eau des embarcations de sauvetage sur le taux de survie des passagers qui
y ont pris place ?*/

SELECT l.lifeboatId,launching_time,(sum(Survived)*100/count(*))AS taux
FROM Passenger p,Rescue r, Lifeboat l
WHERE p.passengerId=r.passengerId AND r.LifeBoatId=l.LifeboatId
GROUP BY l.LifeBoatId ORDER BY launching_time;

/*
 lifeboatid | launching_time | taux
------------+----------------+------
 3          | 01:05:00       |   96
 1          | 01:10:00       |  100
 8          | 01:10:00       |  100
 10         | 01:20:00       |  100
 9          | 01:20:00       |   92
 12         | 01:25:00       |   94
 11         | 01:25:00       |   92
 14         | 01:30:00       |   97
 13         | 01:35:00       |   97
 15         | 01:35:00       |  100
 16         | 01:35:00       |  100
 C          | 01:40:00       |  100
 2          | 01:45:00       |  100
 7          | 01:45:00       |  100
 4          | 01:55:00       |   93
 6          | 01:55:00       |   95
 5          | 01:55:00       |  100
 D          | 02:05:00       |   94
 A          | 02:15:00       |   63
 B          | 02:15:00       |   90
(20 rows)*/



/*Influence de l'heure de récupération de ces embarcations par le Carpathia*/

SELECT rec.lifeboatId,recovery_time,(sum(Survived)*100/count(*))AS taux
FROM Passenger p,Rescue r, Recovery rec, Lifeboat l
WHERE p.passengerId=r.passengerId AND r.LifeBoatId=l.LifeboatId AND rec.LifeBoatId=l.LifeboatId
GROUP BY rec.LifeBoatId ORDER BY recovery_time;

/*
 lifeboatid | recovery_time | taux
------------+---------------+------
 2          | 04:10:00      |  100
 C          | 05:45:00      |  100
 5          | 06:00:00      |  100
 9          | 06:15:00      |   92
 7          | 06:15:00      |  100
 13         | 06:30:00      |   97
 16         | 06:45:00      |  100
 11         | 07:00:00      |   92
 14         | 07:15:00      |   97
 D          | 07:15:00      |   94
 3          | 07:30:00      |   96
 15         | 07:30:00      |  100
 8          | 07:30:00      |  100
 10         | 08:00:00      |  100
 4          | 08:00:00      |   93
 6          | 08:00:00      |   95
 12         | 08:15:00      |   94
(17 rows)
*/


/*Taux de survie par tranche d'age > 12 ans*/

SELECT (SELECT sum(Survived)*100/count(*) FROM Passenger p WHERE age>12 AND age<=20)AS taux_survie_12_20ans,
(SELECT sum(Survived)*100/count(*) FROM Passenger p WHERE age>20 AND age<=30)AS taux_survie_20_30ans,
(SELECT sum(Survived)*100/count(*) FROM Passenger p WHERE age>30 AND age<=40)AS taux_survie_30_40ans,
(SELECT sum(Survived)*100/count(*) FROM Passenger p WHERE age>40 AND age<=50)AS taux_survie_40_50ans,
(SELECT sum(Survived)*100/count(*) FROM Passenger p WHERE age>50 AND age<=100)AS taux_survie_50_100ans;

/*  taux_survie_12_20ans | taux_survie_20_30ans | taux_survie_30_40ans | taux_survie_40_50ans | taux_survie_50_100ans
----------------------+----------------------+----------------------+----------------------+-----------------------
                   34 |                   35 |                   41 |                   38 |                    35 */


/*Combien de passagers supplémentaires auraient pu être rescapés (et peut-être survivre) si le taux
maximum de remplissage des embarcations de sauvetage avait été respecté ?*/

SELECT sum(places) - (SELECT count(*) FROM RESCUE r) AS nb_passagers_non_rescapes
FROM CATEGORY c, LIFEBOAT l
WHERE c.LifeBoatCat = l.LifeBoatCat;

/*  nb_passagers_non_rescapes
---------------------------
                       688
(1 row) */
