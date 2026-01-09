# Write your MySQL query statement below

select query_name, 
    round( avg(rating/position), 2) as quality, 
    round(100 * avg(rating < 3), 2) as poor_query_percentage
from  Queries
group by query_name;




-- pos: 1 - 500
-- rating: 1 - 5
-- poor rating < 3
-- poor query percentge = % of all queries w/rating < 3

-- quality = avg of ratio between query rating & pos

-- FIND
-- query_name, quality, poor_query_percentage



