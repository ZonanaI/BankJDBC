SET SQL_SAFE_UPDATES = 0;
UPDATE Account ac
INNER JOIN AccountStatus AS acs ON ac.account_status_id = acs.account_status_id
SET ac.account_status_id = 2
WHERE acs.account_status = 'Suspended';

UPDATE Customer
SET first_name = 'Joe'
WHERE customer_id =1;

UPDATE Loan
SET rate = 5.5
WHERE returned_amount < amount *(1 + rate / (12 * 100) * FLOOR(DATEDIFF(current_date,from_date)/30));

UPDATE FixedTermDeposit
SET rate = 7.0
WHERE from_date < DATE_SUB(CURRENT_DATE(), INTERVAL 180 DAY);

CALL GetInitialAndLastName(1, @Init);
UPDATE Employee
SET email = CONCAT(LOWER(@init),'@mybank.com')
WHERE employee_id=1;

UPDATE Customer
SET email = 'lynnmurphy@gmail.com'
WHERE customer_id = 2;

UPDATE TransactionLog
SET transaction_amount = 7000.00
WHERE transaction_log_id = 3;

UPDATE FailedTransactionLog ftl
INNER JOIN FailedTransactionErrorType AS ftet
ON ftl.failed_transaction_error_type_id = ftet.failed_transaction_error_type_id
SET ftl.failed_transaction_error_type_id = 2
WHERE ftet.error_description = 'Expired card';

UPDATE TransactionType
SET fee_amount = 2.00
WHERE transaction_name = 'Wire transfer';

UPDATE Customer
SET first_name = 'Laura', last_name = 'Smith'
WHERE first_name = 'Dale' AND last_name = 'Range';




