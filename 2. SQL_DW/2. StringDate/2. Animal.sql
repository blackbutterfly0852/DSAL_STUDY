SELECT a1.ANIMAL_ID, a1.name FROM ANIMAL_INS a1
where UPPER(a1.name) like '%EL%'
and a1.ANIMAL_TYPE = 'Dog'
order by a1.name