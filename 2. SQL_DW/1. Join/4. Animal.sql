/* 4. 보호소에서 중성화한 동물 */
select a1.animal_id, a1.animal_type, a1.name 
from ANIMAL_INS a1 inner join ANIMAL_OUTS a2 on (a1.animal_id = a2.animal_id)
where substr(a1.sex_upon_intake,1,6) = 'Intact'
and (substr(a2.sex_upon_outcome,1,6) = 'Spayed' or substr(a2.sex_upon_outcome,1,8) = 'Neutered')
order by a1.animal_id;

select a1.animal_id, a1.animal_type, a1.name 
from ANIMAL_INS a1 inner join ANIMAL_OUTS a2 on (a1.animal_id = a2.animal_id)
where a1.sex_upon_intake like 'Intact%'
and (a2.sex_upon_outcome like 'Spayed%' or a2.sex_upon_outcome like 'Neutered%')
order by a1.animal_id;


select a1.animal_id, a1.animal_type, a1.name 
from ANIMAL_INS a1 inner join ANIMAL_OUTS a2 on (a1.animal_id = a2.animal_id)
where decode(INSTR(a1.sex_upon_intake,'Intact',1,1),0,1,0) = 0
and (decode(INSTR(a2.sex_upon_outcome,'Spayed',1,1),0,1,0) = 0 or decode(INSTR(a2.sex_upon_outcome,'Neutered',1,1),0,1,0) = 0)
order by a1.animal_id;