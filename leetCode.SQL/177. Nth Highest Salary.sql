Create table If Not Exists Employee (Id int, Salary int)
Truncate table Employee
insert into Employee (id, salary) values ('1', '100')
insert into Employee (id, salary) values ('2', '200')
insert into Employee (id, salary) values ('3', '300')



CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    IF (@N < 1) -- 有这种情况，要弹出去
    BEGIN
        RETURN NULL
    END

    RETURN (
        /* Write your T-SQL query statement below. */
       SELECT MAX(salary) FROM Employee
       WHERE salary NOT IN (
           SELECT DISTINCT salary FROM Employee
           ORDER BY salary DESC
           OFFSET 0 ROWS 
           FETCH NEXT @N - 1 ROWS ONLY
       )
    );
END


CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
    SELECT max(salary)
    FROM
    (
        SELECT salary,
        DENSE_RANK() OVER (ORDER BY salary DESC) as rn
        FROM Employee
    ) t 
    WHERE rn=@N
    );
END