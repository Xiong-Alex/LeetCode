# Write your MySQL query statement below
select p.product_name, s.year, s.price
from sales s
left join product p on s.product_id = p.product_id;


-- sale_id, year = pk
-- product_id = fk

-- for each sale_id in the Sales table.
-- utlize left join, to esnure all sale_id are showing even if other cols null

-- this problem, normal join passes, but left join to be safe