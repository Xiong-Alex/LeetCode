# Write your MySQL query statement below
select uni.unique_id, emp.name
from Employees as emp
left join EmployeeUNI as uni
on emp.id = uni.id


-- left join showcases all entry even if unique_id !exist
-- will showcase as null.

-- showcase all data that matches


-- show unique ID of each user,
-- if no uqniueID, replace and show w/null