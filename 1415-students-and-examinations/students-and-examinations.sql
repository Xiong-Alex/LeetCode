# Write your MySQL query statement below

select s.student_id, s.student_name, sbj.subject_name, 
count(e.subject_name) as attended_exams
from students s
cross join subjects sbj
left join Examinations e 
    on s.student_id = e.student_id 
    and e.subject_name = sbj.subject_name

group by   
    s.student_id,
    s.student_name,
    sbj.subject_name

order by s.student_id, sbj.subject_name;

# time each student attended each exam
# student_id, subject_name

# cross join to ensure all students have every subject, even if they didnt attend class