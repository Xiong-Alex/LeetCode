# Write your MySQL query statement below

select round((100 * avg(d.order_date = d.customer_pref_delivery_date)), 2) as immediate_percentage
from delivery d

-- subquery -- verify id & date
where (d.customer_id, d.order_date) in (
    select customer_id, MIN(order_date)
    from Delivery
    group by customer_id
);


-- if order date * pref _delivery_date  --> immediate / scheduled   order_date = customer_pref_delivery_date

-- find % of immediate orders in 1st order of all customers
-- rounded 2