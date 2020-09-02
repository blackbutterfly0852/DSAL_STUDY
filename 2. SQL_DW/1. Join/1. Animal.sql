/* 1. 없어진 기록 찾기 */
select a2.animal_id, a2.name 
from ANIMAL_OUTS a2 left outer join ANIMAL_INS a1 on (a2.animal_id = a1.animal_id)
where a1.animal_id is null
order by a2.animal_id;

select a2.animal_id, a2.name 
from ANIMAL_OUTS a2, ANIMAL_INS a1
where  a2.animal_id = a1.animal_id(+)
and a1.animal_id is null
order by a2.animal_id;