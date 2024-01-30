/*
还需要考虑重复，因为有可能第一个是重复的！
*/

Create table If Not Exists Employee (id int, salary int)
Truncate table Employee
insert into Employee (id, salary) values ('1', '100')
insert into Employee (id, salary) values ('2', '200')
insert into Employee (id, salary) values ('3', '300')

/* DISTINCT保证没有重复，MAX可以生成需要的null */
SELECT max(a.salary) AS SecondHighestSalary
FROM
(SELECT DISTINCT salary
FROM Employee
ORDER BY salary DESC
OFFSET 1 ROWS 
FETCH NEXT 1 ROWS ONLY) a 

/* 不是第一的第一 */
Select MAX(a.salary) as SecondHighestSalary 
From Employee as a
Where salary NOT In
(
    Select Max(salary) as salary    
    From Employee
)

/* Write your T-SQL query statement below */

select max(salary) as SecondHighestSalary
from employee
where salary < (select max(salary) from employee)


/* Write your T-SQL query statement below */

WITH tblSalaryRank  AS (
SELECT
    salary,
    ROW_NUMBER() OVER(ORDER BY salary DESC) RankID
FROM
    (
        SELECT DISTINCT salary FROM Employee
    )tbl
)
SELECT (
SELECT 
    salary
FROM
    tblSalaryRank
WHERE
    RANKID = 2) SecondHighestSalary 