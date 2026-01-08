# Write your MySQL query statement below

select e.name, b.bonus
from employee e
left join bonus b
on e.empId = b.empId
where b.bonus < 1000 
or b.bonus is null;



# name and bonus amount
# bonus < 1000
# no bonus (left join)

# left join shows nulls, however b.bonus < 1000 invalidates any nulls becaues its less than 1000
# so make sure to also include via 'is null'