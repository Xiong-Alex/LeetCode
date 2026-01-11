# Write your MySQL query statement below

select activity_date as day, 
       count(DISTINCT user_id) as active_users
from activity
where activity_date between 
    date_sub('2019-07-27', INTERVAl 29 day) 
    and '2019-07-27'
group by activity_date 
order by activity_date;


-- 2019-07-27