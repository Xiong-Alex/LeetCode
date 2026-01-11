# Write your MySQL query statement below


select     
    e.employee_id,
    e.name,
    COUNT(r.employee_id) AS reports_count,
    ROUND(AVG(r.age), 0) AS average_age
from Employees e
join employees r
    on r.reports_to = e.employee_id -- this gives us all the rows that match boss_id
group by e.employee_id, e.name -- group by boss_id
order by e.employee_id
