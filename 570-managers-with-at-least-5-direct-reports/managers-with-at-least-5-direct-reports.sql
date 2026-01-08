# Write your MySQL query statement below

select e2.name

from employee e1
join employee e2
    on e1.managerId = e2.id

group By e1.managerId

having count(*) >= 5;



#-- all entries w/same managerID will get grouped..... 
#--I essentially need to find all employee who is a manager and has 5+ employees


-- key note

-- where filters out before group by
-- having does it after.

-- need to group by first before we filter out >= 5

-- additionally count(*) counts all in query / since we grouped, it counts all entries in group