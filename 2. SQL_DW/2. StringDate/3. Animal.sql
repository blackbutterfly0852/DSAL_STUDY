SELECT 
a1.animal_id, 
a1.name,
case when a1.SEX_UPON_INTAKE like ('Neutered%') 
     or a1.SEX_UPON_INTAKE like ('Spayed%')
     then 'O'
     else 'X' end flag
FROM ANIMAL_INS a1
order by a1.animal_id;
