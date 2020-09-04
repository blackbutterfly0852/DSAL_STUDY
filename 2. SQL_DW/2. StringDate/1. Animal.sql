SELECT a1.animal_id, a1.name , a1.SEX_UPON_INTAKE from ANIMAL_INS a1
WHERE a1.name in ( 'Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by a1.animal_id;