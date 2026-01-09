# Write your MySQL query statement below





-- find out each month, the country, their # of transaction, totalamount, # approved transactions, total amount





select 
    date_format(trans_date, '%Y-%m') as month,
    country,
    count(id) trans_count,
    sum(state = 'approved') as approved_count,
    sum(amount) trans_total_amount,

    sum(case -- if statement
            when state = 'approved' THEN amount 
            ELSE 0 
        END) 
        AS approved_total_amount

from transactions
group by month, country;

