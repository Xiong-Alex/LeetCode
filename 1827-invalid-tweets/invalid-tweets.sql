# Write your MySQL query statement below

select tweet_id 
from tweets
-- where content REGEXP '^[a-zA-Z0-9! ]+$' -- 
where length(content) > 15;


-- tweet_id int
-- content varchar

-- alphanumeric chars, "!" or ' '
-- length >= 15