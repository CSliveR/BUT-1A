 /*===================================================*/
/* NOM Prénom - TP03 : Triggers et fonctions simples */
/*===================================================*/

/*============================================================*/
/* Ex 1 : Trigger pour respecter une contrainte référentielle */
/*============================================================*/
/***********************************************************/
/* 1 - Supression d'un personnage                          */
/***********************************************************/

/*1.Lorsque l'on supprime un personnage, une contrainte de clé étrangère lève une erreur. Ecrire un trigger et la fonction associée qui, 
lors de la suppression d'un personnage, suppriment tous les enregistrements dépendant du personnage à supprimer, 
afin qu'aucune exception ne soit levée (attention à l'ordre des suppressions).
Afin de rendre visibles ces effets de bords, faire en sorte que la fonction affiche une notice déclarant qu'un trigger est déclenché. */

CREATE TRIGGER t_personnage_d
BEFORE DELETE 
ON Personnage
FOR EACH ROW 
EXECUTE FUNCTION f_personnage_d();

CREATE FUNCTION f_personnage_d() RETURNS TRIGGER
AS
$$
BEGIN 
    RAISE NOTICE 'Supprime les enregistrements dépendant du personnage supprimé dans les tables favoris, etat_civil et apparait_dans';
    DELETE FROM favoris WHERE perso = old.nom;
    DELETE FROM Etat_civil WHERE nom = old.alias;
    DELETE FROM Apparait_dans WHERE nom = old.nom;
    RETURN old;
END
$$language 'plpgsql';

/*2.Expériences : Afficher le nom de vos personnages favoris accompagnés du nombre de fans (login) partageant ce lien (utiliser la vue mes_favoris pour écrire cette requête).
Supprimer ensuite l'un de ces personnages de la table personnage, et constater la suppression des occurrences de ce personnage dans toutes les tables de la base.*/

SELECT perso, count(*) AS nb_fans
FROM mes_favoris NATURAL JOIN favoris
WHERE perso = perso
GROUP BY perso;
/*3.En faire de même pour la suppression d'un fan.*/

/*4.Expériences : Insérer un nouveau fan de login arthur appréciant Thor. Après sa suppression de la table fan, constatez qu'il n'est plus dans aucune table de la base.
Trigger pour réaliser un historique*/

INSERT INTO FAN VALUES ('Arthur');
INSERT INTO FAVORIS VALUES ('Arthur', 'Thor');

/*============================================================*/
/* Ex 1 : Trigger pour réaliser un historique */
/*============================================================*/

/*On souhaite conserver l'historique du nombre de fans enregistrés (avec ou sans personnage favori) ainsi que le nombre de likes 
tous personnages confondus, autrement dit de déclarations de personnage favori par les fans (et non le nombre de personnages 
étant le favori d'au moins un fan) au cours du temps. Cet historique doit enregistrer la date et l'heure de chacune des instructions 
faisant évoluer un de ces deux nombres, ainsi que la valeur de ces derniers à leur issue.*/


/*5.En préambule, insérer à nouveau le fan de login arthur. Puis créer la table historique_fan_base(heure,nb_fans,nb_likes), où heure est de type timestamp, qui va contenir chaque nouvelle valeur de nb_fans ou nb_likes au fil des opérations réalisées sur les tables de la base. Ne pas définir de clé primaire.*/

CREATE TABLE historique_fan_base(
    heure timestamp,
    nb_fans int,
    nb_likes int
);

/*6.Insérer un premier enregistrement défini par la valeur de current_timestamp pour l'heure, et deux sous-requêtes, pour les deux autres attributs.*/

INSERT INTO historique_fan_base VALUES (
    current_timestamp, 
);