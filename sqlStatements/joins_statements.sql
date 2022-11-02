SELECT * FROM Employee e
RIGHT JOIN TransactionLog AS tl ON e.employee_id = tl.employee_id;

SELECT * FROM Customer cu, CustomerAccount ca
INNER JOIN Account AS ac ON ac.account_id = ca.account_id;

SELECT * FROM AccountStatus acs
LEFT JOIN Account AS ac ON acs.account_status_id = ac.account_status_id;

SELECT * FROM UserLogin ul, AccountUserLogin aul
INNER JOIN Account AS ac ON ac.account_id = aul.account_id;

SELECT * FROM Loan lo
LEFT JOIN Account AS ac ON lo.account_id = ac.account_id ;