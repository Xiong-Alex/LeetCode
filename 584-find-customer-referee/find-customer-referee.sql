# Write your MySQL query statement below
select name 
from Customer
where referee_id <> 2
or
referee_id is null;

-- Must check for null entries 
-- Null values entries get ignored unless explicetly searched for