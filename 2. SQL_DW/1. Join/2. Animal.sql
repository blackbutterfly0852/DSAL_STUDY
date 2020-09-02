/* 2. 있었는데요 없었습니다 */

select a1.animal_id, a1.name
from ANIMAL_INS a1 inner join ANIMAL_OUTS a2 on (a1.animal_id = a2.animal_id)
where a1.datetime > a2.datetime 
order by a1.datetime;

/* a1.datetime = 보호시작일 , a2.datetime = 입양일 
   입양일이 보호시작일 보다 빠르다? 보호시작일의 값이 더 크다 */

