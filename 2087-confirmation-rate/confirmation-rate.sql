# Write your MySQL query statement below


 
select s.user_id, round(ifnull(avg(c.action = 'confirmed'), 0), 2) as confirmation_rate -- avg calcs confirmation rate for us
from signups s                                                               -- c.action = 'confirm' counts those and / by *
left join confirmations c                                                    -- ifnull to default 0 if null...
    on s.user_id = c.user_id
group by s.user_id;


--  user_id

--  action = 'confirmed' || 'timeout'

--  confirmation rate = # of 'cofirmed' msg / total msg request

--  confirmation rate of user w/no request = 0

--  round to two decimal places | ROUND(x, 2)