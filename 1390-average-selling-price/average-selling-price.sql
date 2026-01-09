# Write your MySQL query statement below
select p.product_id, round(ifnull(sum(units * price) / sum(units), 0), 2) as average_price

from prices p
left join UnitsSold u
    on p.product_id = u.product_id
    and u.purchase_date between p.start_date and p.end_date
group by p.product_id;

-- check where purchase falls in.
-- price table has a start & end Date

-- group by date range. & product_id
-- each entry should be correlate w/ right date and have corect price.