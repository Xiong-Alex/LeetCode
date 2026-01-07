# Write your MySQL query statement below

select v.customer_id, Count(*) as count_no_trans
from visits v
left join transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id;


--  difference between is null && == null
-- = null ---- this compares values (null doesnt have value)
-- is null --- checks for absence of value 



-- id of users that visit w/purchase
-- window shoppers & times they visited