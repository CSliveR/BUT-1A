\copy camelot FROM ’camelot.csv’  WITH (DELIMITER ’;’, format CSV, HEADER, ENCODING ’UTF8’);


create table haut_fait as 
select distinct id_hf, lieu, nature,jour  
from camelot  
where id_hf is not null  
order by id_hf; 

alter table haut_fait add primary key(id_hf); 
alter table haut_fait alter column jour set default current_date;

create or replace view equipe_an_passe as 
select p.*  from participe p natural join haut_fait 
where extract(’year’ from jour) = extract(’year’ from current_date) - 1;


create or replace view bilan(heros,nb_hf) as  
select nom, count(id_hf) as nb_hf  
from chevalier 
left join equipe_an_passe on nom=equipier  
group by nom  order by nb_hf desc;


update chevalier set merite = merite + (select nb_hf from bilan where nom=heros)


create or replace function f_participe_d() returns trigger 
as $$ 
begin  
delete from haut_fait where id_hf not in (select id_hf from participe);  
if found then −− BONUS    
raise notice ’% on % fires %: 
suppression de haut−fait’, TG_OP, TG_TABLE_NAME, TG_NAME;  
end if;  
return null; 
end; $$ 
language ’plpgsql’;

create trigger tr_participe_d 
after delete on participe 
for each statement 
execute procedure f_participe_d();



create or replace function f_traces_du_graal_u() returns trigger 
as $$ begin  
update graal set id=new.id, authentique=new.authentique    
where id = old.id;  
update haut_fait set lieu=new.lieu, jour=new.jour    
where id_hf = (select id_hf from graal where id = old.id); 
return new; 
end; $$ 
language ’plpgsql’; 


create trigger tr_traces_du_graal_u 
instead of update on traces_du_graal 
for each row 
execute procedure f_traces_du_graal_u();


create or replace function f_graal_iu() returns trigger 
as $$ begin  
if (select count(*) from graal where authentique) > 1 
then raise exception ’Il ne peut y avoir qu’’un seul Graal authentique’;  
end if;  
return null; 
end; $$ 
language ’plpgsql’; 


create trigger tr_graal_iu 
after insert or update on graal 
for each statement 
execute procedure f_graal_iu();



