DELETE FROM Customer
WHERE customer_id = 1;

DELETE FROM Card
WHERE exp_date < CURRENT_DATE();

DELETE FROM TransactionLog
WHERE transaction_date < DATE_SUB(CURRENT_DATE(), INTERVAL 180 DAY);

DELETE FROM Account ac
INNER JOIN AccountStatus AS acs ON ac.account_status_id = acs.account_status_id
WHERE acs.account_status = 'Suspended';

DELETE FROM Loan
WHERE returned_amount > amount *(1 + rate / (12 * 100) * FLOOR(DATEDIFF(current_date,from_date)/30));

DELETE FROM FixedTermDeposit
WHERE ftd.account_id = 2;

DELETE FROM TransactionLog tl
INNER JOIN TransactionType as tt ON tl.transaction_type_id = tt.transaction_type_id
WHERE tt.transaction_name = 'Deposit';

DELETE FROM employee
WHERE first_name LIKE '%a%';

DELETE FROM FailedTransactionLog
WHERE failed_transaction_time < DATE_SUB(CURRENT_DATE, INTERVAL 120 DAY);

DELETE FROM UserSecurityQuestion usq
INNER JOIN UserSecurityAnswer AS usa ON usq.user_security_question_id = usa.user_security_question_id
WHERE LENGTH(usa.user_security_answer) < 2 or length(usa.user_security_answer) = null;
