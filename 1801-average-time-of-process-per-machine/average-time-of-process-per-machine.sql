# Write your MySQL query statement below

select 
    a_start.machine_id,
    ROUND(AVG(a_end.timestamp - a_start.timestamp), 3) as processing_time
from Activity a_start
join Activity a_end
on a_start.machine_id = a_end.machine_id
and a_start.process_id = a_end.process_id
and a_start.activity_type = 'start'
and a_end.activity_type = 'end'
group by a_start.machine_id;

# self join, connect start and end & then avg the proceess

# ensure start & end machine id & process_id match
# ensure a_start type is 'start' & a_end type is 'end'

# avg(end - start) to find duration
# round(value, rounded#)
# group by id; group all machine_id's processes  