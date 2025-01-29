/*les informations relatives au passager n°916 : son nom, son âge, sa classe, sa ou ses cabines, le nom du port où il a
embarqué, numéro et catégorie de l'embarcation de sauvetage qui l'a éventuellement secouru*/

SELECT Name, Age, Pclass, CabinCode, PortName, l.LifeBoatId, l.LifeBoatCat
FROM PASSENGER pa, OCCUPATION o, PORT po, LIFEBOAT l, CATEGORY c, RESCUE r
WHERE pa.PassengerId = 916
AND o.PassengerId = pa.PassengerId AND po.PortID = pa.PortID AND l.LifeBoatCat = c.LifeBoatCat 
AND r.PassengerId = pa.PassengerId AND r.LifeBoatId = l.LifeBoatId;

/*Résultat*/

/*                   name                       | age | pclass | cabincode | portname  | lifeboatid | lifeboatcat 
-------------------------------------------------+-----+--------+-----------+-----------+------------+-------------
Ryerson, Mrs. Arthur Larned (Emily Maria Borie) |  48 |      1 | B57       | Cherbourg | 4          | standard
Ryerson, Mrs. Arthur Larned (Emily Maria Borie) |  48 |      1 | B59       | Cherbourg | 4          | standard
Ryerson, Mrs. Arthur Larned (Emily Maria Borie) |  48 |      1 | B63       | Cherbourg | 4          | standard
Ryerson, Mrs. Arthur Larned (Emily Maria Borie) |  48 |      1 | B66       | Cherbourg | 4          | standard
(4 rows)
*/

/*nom et le rôle des domestiques du passager n°1264 est exact*/

SELECT Name, Role
FROM SERVICE, PASSENGER
WHERE PassengerId_Emp = 1264
AND PassengerId_Dom = PassengerId;

/*Résultat*/

/* 
         name          |    role    
-----------------------+------------
 Fry, Mr. Richard      | valet
 Harrison, Mr. William | secretaire
(2 rows) */


/*liste des passagers ayant été secourus par le canot n°7 est exacte*/

SELECT Name
FROM RESCUE r, PASSENGER p
WHERE LifeBoatId = '7'
AND r.PassengerId = p.PassengerId;

/*Résultat*/

/*                             name                            
------------------------------------------------------------
 Bishop, Mr. Dickinson H
 Bishop, Mrs. Dickinson H (Helen Walton)
 Blank, Mr. Henry
 Chevre, Mr. Paul Romain
 Crosby, Miss. Harriet R
 Crosby, Mrs. Edward Gifford (Catherine Elizabeth Halstead)
 Earnshaw, Mrs. Boulton (Olive Potter)
 Flegenheimer, Mrs. Alfred (Antoinette)
 Gibson, Miss. Dorothy Winifred
 Gibson, Mrs. Leonard (Pauline C Boeson)
 Greenfield, Mr. William Bertram
 Greenfield, Mrs. Leo David (Blanche Strouse)
 Hays, Miss. Margaret Bechstein
 Marechal, Mr. Pierre
 McGough, Mr. James Robert
 Nourney, Mr. Alfred (Baron von Drachstedt")"
 Omont, Mr. Alfred Fernand
 Potter, Mrs. Thomas Jr (Lily Alexenia Wilson)
 Seward, Mr. Frederic Kimber
 Sloper, Mr. William Thompson
 Snyder, Mr. John Pillsbury
 Snyder, Mrs. John Pillsbury (Nelle Stevenson)
 Taylor, Mr. Elmer Zebley
 Taylor, Mrs. Elmer Zebley (Juliet Cummins Wright)
 Tucker, Mr. Gilbert Milligan Jr
(25 rows)
 */



