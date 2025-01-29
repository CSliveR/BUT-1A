 /*=======================================================================*/
/* DROUICHE Ilyès - TP05 : Triggers pour vérifier des contraintes complexes  */
/*=======================================================================*/

/*=============================================================*/
/* Adhérent                                                    */
/*=============================================================*/
/***********************************************************/
/* 1 - Un adhérent ne peut pas perdre l'agrément skipper.  */
/***********************************************************/

CREATE TRIGGER t_adherent_u
BEFORE UPDATE
ON adherent
FOR EACH ROW 
EXECUTE FUNCTION f_adherent_u();

CREATE FUNCTION f_adherent_u() RETURNS trigger
AS $$
BEGIN
    IF old.skipper AND not new.skipper
    THEN RAISE EXCEPTION 'l''agrément skipper ne peut pas être perdu';
    END IF;
    RETURN new;
END
$$language 'plpgsql';



update adherent set skipper = false where skipper = true;

/*drouichi=> update adherent set skipper = false where skipper = true;
ERROR:  l'agrément skipper ne peut pas être perdu
CONTEXT:  PL/pgSQL function f_adherent_u() line 4 at RAISE*/

update adherent set skipper = true where numadh = 18;

/*drouichi=> update adherent set skipper = true where numadh = 18;
UPDATE 1*/


/*=============================================================*/
/* Course                                                      */
/*=============================================================*/

CREATE TRIGGER t_course_ui
BEFORE UPDATE OR INSERT
ON course
FOR EACH ROW 
EXECUTE FUNCTION f_course_ui();

CREATE FUNCTION f_course_ui() RETURNS trigger 
AS $$
BEGIN
    IF EXISTS(SELECT * FROM course 
        WHERE (datedebut, INTERVAL '1 day') OVERLAPS (datedebut, datefin))
    THEN RAISE EXCEPTION 'Une nouvelle course ne peut pas commencer pendant une course en cours';
    END IF;
END
$$language 'plpgsql';

insert into course (numcourse, datedebut) values (3, '2024-06-13');

/*drouichi=> insert into course (numcourse, datedebut) values (3, '2024-06-13');
ERROR:  Une nouvelle course ne peut pas commencer pendant une course en cours
CONTEXT:  PL/pgSQL function f_course_ui() line 5 at RAISE*/


update course set datedebut='2021-05-08' where datedebut='2024-06-15'

/*drouichi=> update course set datedebut='2021-05-08' where datedebut='2024-06-15'; 
ERROR:  Une nouvelle course ne peut pas commencer pendant une course en cours
CONTEXT:  PL/pgSQL function f_course_ui() line 5 at RAISE*/


/*=============================================================*/
/* Chef de bord                                                */
/*=============================================================*/

CREATE TRIGGER t_chefdebord_ui
BEFORE UPDATE OR INSERT
ON course
FOR EACH ROW 
EXECUTE FUNCTION f_course_ui();