# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums 
from logs l1
join logs l2
    on l1.id = l2.id + 1
join logs l3
    on l1.id = l3.id + 2

where l1.num = l2.num
and l2.num = l3.num

-- via self join, connect 1st, 2nd, and 3rd row
-- -- 3 consecutive rows now joined

-- then check if 2nd and 3rd row value is same as 1st