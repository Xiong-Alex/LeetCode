select e.employee_id 
from Employees e
where salary < 30000                 -- check salary
    and manager_id is not null       -- check if employee | managers have no manager_id
    and not exists (                 -- check if employee / manager relationship exists

        select 1  -- placeholder value; EXISTS only checks whether a row exists (true/false)
        from Employees m 
        where m.employee_id = e.manager_id -- chck if this manager exists by checking id
    )

order by e.employee_id