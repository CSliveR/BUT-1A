/*Quel lien peut-on établir entre le nutriscore (A,B,C,D,E) et les variables nutritionnelles
pour les produits de la famille 'en:poultry' en France ?*/

/*2.1. EXPLORATION*/

/*On affiche un extrait de 5 lignes des 8 premiers champs*/

/*SELECT code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags 
FROM  openfoodfacts 
LIMIT 5;*/


/*openfoodfacts=> select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags from openfoodfacts limit 5;
     code      |                                       url                                       |      product_name       | brands_tags | stores | owner | food_groups | labels_tags
---------------+---------------------------------------------------------------------------------+-------------------------+-------------+--------+-------+-------------+--------------
 0635985801900 | http://world-en.openfoodfacts.org/product/0635985801900/white-claw-vodka-soda   | white claw vodka+soda   |             |        |       |             |
 0635985801924 | http://world-en.openfoodfacts.org/product/0635985801924/white-claw-vodka-soda   | White Claw Vodka + Soda |             |        |       |             |
 0635985801986 | http://world-en.openfoodfacts.org/product/0635985801986/white-claw-hard-seltzer | White Claw Hard Seltzer | white-claw  |        |       |             | en:no-gluten
 0635985802075 | http://world-en.openfoodfacts.org/product/0635985802075/white-claw              | White Claw              |             |        |       |             |
 0635985802136 | http://world-en.openfoodfacts.org/product/0635985802136/white-claw-hard-selzer  | White Claw Hard Selzer  |             |        |       |             | en:no-gluten
(5 rows)*/


/*Il est intéressant pour la question d'explorer les champs où food_groups est renseigné*/

/*SELECT code, product_name, brands_tags, stores, owner, food_groups, labels_tags 
FROM openfoodfacts
GROUP BY code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags 
HAVING count(food_groups) = 1
LIMIT 5;*/

/*
         code         |         product_name         |  brands_tags  |    stores     | owner |       food_groups       |   labels_tags
----------------------+------------------------------+---------------+---------------+-------+-------------------------+------------------
 00000000000000225    | jeunes pousses               | endives       |               |       | en:vegetables           |
 00000000000026772226 | Skyr                         | danone        |               |       | en:dairy-desserts       |
 0000000000100        |  moutarde au mo¹t de raisin  | courte-paille | courte paille |       | en:dressings-and-sauces | fr:delois-france
 000000000080         | Pur jus de pomme             |               |               |       | en:fruit-juices         |
 000000000088         | Pate d'amande                |               |               |       | en:sweets               |
(5 rows)*/

/*Le champ food_groups est toujours renseigné*/


/*bio signifie "issu de "l'agriculture biologique" dans ce contexte, cette information peut âtre trouvée dans le champ labels_tags*/


/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*2.2. EXTRACTION ET NETTOYAGE*/

/*Requête pour traiter la contrainte du champ data_quality_errors_tags*/

/*SELECT data_quality_errors_tags
WHERE data_quality_errors_tags IS NULL
LIMIT 5;*/

/*Requête pour traiter la contrainte du pays de la question*/

/*SELECT countries, food_groups
FROM openfoodfacts 
WHERE countries SIMILAR TO 'Fr%'
LIMIT 5;*/


/*Requête qui sélectionne les champs équivalents à d'autres ...*/

/*Ajout d'un DISTINCT dans la clause SELECT*/

/*Requête qui sélectionne les n-uplets où les champs code et nutriscore_grade
ne sont pas renseignés ou non exploitables. */

/*SELECT code, nutriscore_grade 
FROM openfoodfacts 
WHERE code IS NOT NULL AND nutriscore_grade IS NOT NULL 
AND nutriscore_grade != 'unknown' AND nutriscore_grade != 'not-applicable';*/


/*Requête qui sélectionne les codes-barres à 13 chiffres*/

/*SELECT code 
FROM openfoodfacts
WHERE char_length(code) = 13;*/


/*Requête pour traiter la contrainte des produits _100g*/

/*SELECT fat_100g,
saturated_fat_100g,
sugars_100g,
proteins_100g,
carbohydrates_100g,
energy_100g,
salt_100g,
sodium_100g
FROM openfoodfacts
WHERE fat_100g BETWEEN 0 AND 100 AND 
saturated_fat_100g BETWEEN 0 AND 100 AND 
sugars_100g BETWEEN 0 AND 100 AND
proteins_100g BETWEEN 0 AND 100 AND 
carbohydrates_100g BETWEEN 0 AND 100 AND 
energy_100g BETWEEN 0 AND 100 AND 
salt_100g BETWEEN 0 AND 100 AND 
sodium_100g BETWEEN 0 AND 100;*/

/*Première extraction*/

CREATE TEMP TABLE extractionV1 AS
    SELECT DISTINCT code, url, product_name, brands_tags, stores, owner, food_groups,
     labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g,
     sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g,
     nutriscore_score, nutriscore_grade, ingredients_analysis_tags, nutrient_levels_tags
     FROM openfoodfacts
     WHERE data_quality_errors_tags IS NULL 
     AND countries SIMILAR TO 'Fr%'
     AND char_length(code) = 13 AND nutriscore_grade IS NOT NULL 
     AND nutriscore_grade != 'unknown' AND nutriscore_grade != 'not-applicable'
     AND fat_100g BETWEEN 0 AND 100 
     AND saturated_fat_100g BETWEEN 0 AND 100
     AND sugars_100g BETWEEN 0 AND 100 
     AND proteins_100g BETWEEN 0 AND 100
     AND carbohydrates_100g BETWEEN 0 AND 100
     AND energy_100g BETWEEN 0 AND 100
     AND salt_100g BETWEEN 0 AND 100
     AND sodium_100g BETWEEN 0 AND 100;

/*donne 9 lignes avec AND food_group 'en:poultry'*/


ALTER TABLE extractionV1 ADD COLUMN computed_energy_100g float;

UPDATE extractionV1 
SET computed_energy_100g = 4*proteins_100g + 4*carbohydrates_100g + 9*fat_100g;




/*Ajout d'un champ dont le nom est la traduction anglaise de "bio" dans ce contexte
TRUE si le produit est "bio"
FALSE s'il ne l'est pas 
NULL si le champ contenant cette information est vide (valeur inconnue)*/

ALTER TABLE extractionV1 ADD COLUMN organic boolean;

UPDATE extractionV1 SET organic = true
WHERE labels_tags LIKE '%organic%';

UPDATE extractionV1 SET organic = false 
WHERE labels_tags NOT LIKE '%organic%';

UPDATE extractionV1 SET organic = NULL
WHERE labels_tags IS NULL;

/*À partir du champ ingredients_analysis_tags, ajout des trois champs suivants*/

ALTER TABLE extractionV1 ADD COLUMN vegan character varying;
ALTER TABLE extractionV1 ADD COLUMN vegetarian character varying;
ALTER TABLE extractionV1 ADD COLUMN palm_oil character varying;

/*1- vegan indique si le produit est compatible avec un régime végan
Il vaut:
t' si ingredients_analysis_tags contient la valeur en:vegan, 
'f' s'il contient la valeur en:non-vegan 
NULL sinon*/

UPDATE extractionV1 SET vegan = 't'
WHERE ingredients_analysis_tags LIKE '%en:vegan%';

UPDATE extractionV1 SET vegan = 'f'
WHERE ingredients_analysis_tags LIKE '%en:non-vegan%';

UPDATE extractionV1 SET vegan = NULL
WHERE ingredients_analysis_tags LIKE '%en:vegan-status-unknown%';

/*2- vegetarian indique si le produit est compatible avec un régime végétarien
En vous inspirant de vegan, 
trouver les valeurs que ingredients_analysis_tags doit contenir pour que ce champ vaille 
't' (pour vrai), 'f' (pour faux), ou NULL (pour indéterminé ou non renseigné*/

UPDATE extractionV1 SET vegetarian = 't'
WHERE ingredients_analysis_tags LIKE '%en:vegetarian%';

UPDATE extractionV1 SET vegetarian = 'f'
WHERE ingredients_analysis_tags LIKE '%en:non-vegetarian%';

UPDATE extractionV1 SET vegetarian = NULL
WHERE ingredients_analysis_tags LIKE '%en:vegetarian-status-unknown%';


/*3-palm_oil indique si le produit contient de l'huile de palme.
 En vous inspirant de vegan,
trouver les valeurs que ingredients_analysis_tags doit contenir pour que ce champ vaille 
't' (pour vrai), 'f' (pour faux), ou NULL (pour indéterminé ou non renseigné).*/

UPDATE extractionV1 SET palm_oil = 't'
WHERE ingredients_analysis_tags LIKE '%en:palm_oil%';

UPDATE extractionV1 SET palm_oil = 'f'
WHERE ingredients_analysis_tags LIKE '%en:palm-oil-free%';

UPDATE extractionV1 SET palm_oil = NULL
WHERE ingredients_analysis_tags LIKE '%en:palm-oil-content-unknown%';


/*A partir du champ nutrient_levels_tags 
ajout des quatre champs suivants*/

ALTER TABLE extractionV1 ADD COLUMN level_fat character varying;
ALTER TABLE extractionV1 ADD COLUMN level_saturated_fat character varying;
ALTER TABLE extractionV1 ADD COLUMN level_sugars character varying;
ALTER TABLE extractionV1 ADD COLUMN level_salt character varying;

/*level_fat indique la quantité de graisse contenue dans le produit.*/
UPDATE extractionV1 SET level_fat = 'h'
WHERE nutrient_levels_tags LIKE '%en:fat-in-high-quantity%';

UPDATE extractionV1 SET level_fat = 'm'
WHERE nutrient_levels_tags LIKE '%en:fat-in-moderate-quantity%';

UPDATE extractionV1 SET level_fat = 'l' 
WHERE nutrient_levels_tags LIKE '%en:fat-in-low-quantity%';

UPDATE extractionV1 SET level_fat = NULL
WHERE nutrient_levels_tags IS NULL;


/*level_saturated_fat qui indique la quantité de graisse saturée contenue dans le produit.*/

UPDATE extractionV1 SET level_saturated_fat = 'h'
WHERE nutrient_levels_tags LIKE '%en:saturated-fat-in-high-quantity%';

UPDATE extractionV1 SET level_saturated_fat = 'm'
WHERE nutrient_levels_tags LIKE '%en:saturated-fat-in-moderate-quantity%';

UPDATE extractionV1 SET level_saturated_fat = 'l'
WHERE nutrient_levels_tags LIKE '%en:saturated-fat-in-low-quantity%';

UPDATE extractionV1 SET level_saturated_fat = NULL
WHERE nutrient_levels_tags IS NULL;


/*level_sugars qui indique la quantité de sucres contenue dans le produit.*/

UPDATE extractionV1 SET level_sugars = 'h'
WHERE nutrient_levels_tags LIKE '%en:sugars-in-high-quantity%';

UPDATE extractionV1 SET level_sugars = 'm' 
WHERE nutrient_levels_tags LIKE '%en:sugars-in-moderate-quantity%';

UPDATE extractionV1 SET level_sugars = 'l'
WHERE nutrient_levels_tags LIKE '%en:sugars-in-low-quantity%';

UPDATE extractionV1 SET level_sugars = NULL
WHERE nutrient_levels_tags IS NULL;

/*level_salt qui indique la quantité de sel contenue dans le produit.*/

UPDATE extractionV1 SET level_salt = 'h'
WHERE nutrient_levels_tags LIKE '%en:salt-in-high-quantity%';

UPDATE extractionV1 SET level_salt = 'm'
WHERE nutrient_levels_tags LIKE '%en:salt-in-moderate-quantity%';

UPDATE extractionV1 SET level_salt = 'l'
WHERE nutrient_levels_tags LIKE '%en:salt-in-low-quantity%';

UPDATE extractionV1 SET level_salt = NULL
WHERE nutrient_levels_tags IS NULL;

/*Suppression des champs ingredients_analysis_tags et nutrient_levels_tags*/
ALTER TABLE extractionV1 DROP ingredients_analysis_tags;
ALTER TABLE extractionV1 DROP nutrient_levels_tags;


CREATE TEMP TABLE extractionVF AS
     SELECT DISTINCT *
     FROM extractionV1;



\copy extractionVF to 'team_c08.sql' 
WITH (DELIMITER E'\t', format CSV, HEADER, ENCODING 'UTF8');













 





