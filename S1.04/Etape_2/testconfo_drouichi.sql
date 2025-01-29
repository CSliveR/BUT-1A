INSERT INTO PORT VALUES ('S');
/*ERROR:  null value in column "portname" of relation "port" violates not-null constraint
DETAIL:  Failing row contains (S, null, null).
*/

/*L'attribut portname doit etre renseigné*/

INSERT INTO PORT VALUES ('S','Soupthamton');

/*ERROR:  null value in column "country" of relation "port" violates not-null constraint
DETAIL:  Failing row contains (S, Soupthamton, null).
*/

/*L'attribut country doit être renseigné*/


INSERT INTO PORT VALUES ('R','Soupthamton','Angleterre');
/*ERROR:  new row for relation "port" violates check constraint "port_portid_check"
DETAIL:  Failing row contains (R, Soupthamton, Angleterre).
*/

/*L'identifiant du port est une lettre parmi 'C', 'Q' ou 'S' uniquement*/


INSERT INTO PASSENGER VALUES (2212, null, 'female', null, 1, 2, 'Q');
/*ERROR:  null value in column "name" of relation "passenger" violates not-null constraint
DETAIL:  Failing row contains (2212, null, female, null, 1, 2, Q).
*/

/*L'attribut name doit être renseigné*/

INSERT INTO PASSENGER VALUES (2212, 'Passager1', null, null, 1, 2, 'Q');
/*ERROR:  null value in column "sex" of relation "passenger" violates not-null constraint
DETAIL:  Failing row contains (2212, Passager1, null, null, 1, 2, Q).*/

/*L'attribut sex doit être renseigné*/

INSERT INTO PASSENGER VALUES (2212, 'Passager1', 'female' , null, 1, 2, 'R');
/*ERROR:  insert or update on table "passenger" violates foreign key constraint "passenger_portid_fkey"
DETAIL:  Key (portid)=(s) is not present in table "port".
*/

/*L'attribut PortId qui est une clé étrangère de port peut être renseigné uniquement par une lettre parmi 'C','Q' ou 'S' */


INSERT INTO PASSENGER VALUES (2212, 'Passenger1', 'female', 25, 3, 3, 'S');
/*ERROR:  new row for relation "passenger" violates check constraint "passenger_survived_check"
DETAIL:  Failing row contains (2212, Passenger1, female, 25, 3, 3, S).
*/

/*L'attribut survived doit être compris entre 0 et 1*/


INSERT INTO PASSENGER VALUES (2212, 'Passenger1', 'female', 25, 1, 4, 'S');
/*ERROR:  new row for relation "passenger" violates check constraint "passenger_pclass_check"
DETAIL:  Failing row contains (2212, Passenger1, female, 25, 1, 4, S).
*/

/*L'attribut Pclass doit être compris entre 1 et 3*/


INSERT INTO OCCUPATION VALUES (null, 'K205');
/*ERROR:  null value in column "passengerid" of relation "occupation" violates not-null constraint
DETAIL:  Failing row contains (null, K205).
*/

/*L'attribut passengerid doit être renseigné*/

INSERT INTO OCCUPATION VALUES (2212, null);
/*ERROR:  null value in column "cabincode" of relation "occupation" violates not-null constraint
DETAIL:  Failing row contains (2212, null).
*/

/*L'attribut cabincode doit être renseigné*/


INSERT INTO SERVICE VALUES (1507, null, 'valet');
/*ERROR:  null value in column "passengerid_emp" of relation "service" violates not-null constraint
DETAIL:  Failing row contains (1507, null, valet).
*/

/*L'attribut passengerid_emp doit être renseigné*/

INSERT INTO SERVICE VALUES (1507, 2212);
/*ERROR:  null value in column "role" of relation "service" violates not-null constraint
DETAIL:  Failing row contains (1507, 2212, null).
*/

/*L'attribut role doit être renseigné*/


INSERT INTO CATEGORY VALUES ('voile', 'bois', 55);
/*ERROR:  new row for relation "category" violates check constraint "category_lifeboatcat_check"
DETAIL:  Failing row contains (voile, bois, 55).
*/

/*
L'attribut LifeBoatCat ne peut pas avoir voile comme valeur, sa valeur doit être 'standard', 'secours' ou 'radeau'.
*/

INSERT INTO CATEGORY VALUES ('standard', 'béton', 55);
/*ERROR:  new row for relation "category" violates check constraint "category_structure_check"
DETAIL:  Failing row contains (standard, béton, 55).

/*
L'attribut Structure ne peut pas avoir béton comme valeur, sa valeur doit être 'bois' ou 'bois ou toile'.
*/
*/

INSERT INTO CATEGORY VALUES ('standard','bois');
/*ERROR:  null value in column "places" of relation "category" violates not-null constraint
DETAIL:  Failing row contains (standard, bois, null).
*/

/*
L'attribut Category n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/

INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Side, Position, Lauching_Time) VALUES ('E', 'voile', 'babord', 'arriere', '03:05:00');
/*ERROR:  insert or update on table "lifeboat" violates foreign key constraint "lifeboat_lifeboatcat_fkey"
DETAIL:  Key (lifeboatcat)=(voile) is not present in table "category".*/

/*L'attribut lifebotcat qui est une clé étrangère de category peut être renseigné uniquement par 'standard', 'secours' ou 'radeau'' */



INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Side, Position, Lauching_Time) VALUES ('E', 'bois', 'bebord', 'avant', '03:10:00');
/*ERROR:  new row for relation "lifeboat" violates check constraint "lifeboat_side_check"
DETAIL:  Failing row contains (E, bois, bebord, avant, pont, 03:10:00).
*/

/*
L'attribut Side ne peut pas avoir bebord comme valeur, sa valeur doit être 'babord' ou 'tribord'.
*/

INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Side, Position, Lauching_Time) VALUES ('E', 'bois', 'babord', 'gauche', '03:10:00');
/*ERROR:  new row for relation "lifeboat" violates check constraint "lifeboat_position_check"
DETAIL:  Failing row contains (E, bois, babord, gauche, pont, 03:10:00).
*/

/*
L'attribut Position ne peut pas avoir gauche comme valeur, sa valeur ne peut être que 'avant' ou 'arrière'.
*/

INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Position, Lauching_Time) VALUES ('E', 'bois','avant','03:10:00');
/*ERROR:  null value in column "side" of relation "lifeboat" violates not-null constraint
DETAIL:  Failing row contains (E, bois, null, avant, pont, 03:10:00).
*/


/*
L'attribut Side n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/

INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Side, Lauching_Time) VALUES ('E', 'bois', 'babord','03:10:00');
/*ERROR:  null value in column "position" of relation "lifeboat" violates not-null constraint
DETAIL:  Failing row contains (E, bois, babord, null, pont, 03:10:00).
*/

/*
L'attribut Position n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/

INSERT INTO LIFEBOAT (LifeBoatId, LifeBoatCat, Side, Position) VALUES ('E', 'bois', 'babord', 'arriere');
/*ERROR:  null value in column "lauching_time" of relation "lifeboat" violates not-null constraint
DETAIL:  Failing row contains (E, bois, babord, arriere, pont, null).
*/

/*
L'attribut Launching_Time n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/


INSERT INTO RECOVERY VALUES ('E');
/*ERROR:  null value in column "recovery_time" of relation "recovery" violates not-null constraint
DETAIL:  Failing row contains (E, null).
*/

/*
L'attribut Recovery_Time n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/


INSERT INTO RESCUE VALUES (2212);
/*ERROR:  null value in column "lifeboatid" of relation "rescue" violates not-null constraint
DETAIL:  Failing row contains (2212, null).
*/

/*
L'attribut LifeBoatId n'a pas été renseigné alors qu'il doit obligatoirement l'être.
*/





