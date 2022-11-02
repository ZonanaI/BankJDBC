SELECT ac.account_id, SUM(tl.transaction_amount) AS transactions_amount
FROM TransactionLog AS tl
INNER JOIN account AS ac ON tl.account_id = ac.account_id
GROUP BY ac.account_id
HAVING SUM(tl.transaction_amount) > 9000
ORDER BY ac.account_id ASC;

SELECT ac.account_id, AVG(tl.transaction_amount) AS average_amount
FROM TransactionLog AS tl
INNER JOIN account AS ac ON tl.account_id = ac.account_id
GROUP BY ac.account_id
HAVING AVG(tl.transaction_amount) > 6000
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(lo.loan_id) AS loans_amount
FROM Loan AS lo
INNER JOIN account AS ac ON lo.account_id = ac.account_id
GROUP BY ac.account_id
HAVING COUNT(lo.loan_id) > 2
ORDER BY ac.account_id ASC;

SELECT ac.account_id, SUM(ftd.amount) AS amount_deposited
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
HAVING SUM(ftd.amount) < 20000
ORDER BY ac.account_id ASC;

SELECT ac.account_id, AVG(ftd.amount) AS average_deposited
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
HAVING AVG(ftd.amount) < 10000
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(ftd.fixed_term_deposit_id) AS deposits_amount
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
HAVING COUNT(ftd.fixed_term_deposit_id) = 2
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(cuac.customer_id) AS holders_amount
FROM CustomerAccount AS cuac
INNER JOIN account AS ac ON cuac.account_id = ac.account_id
GROUP BY ac.account_id
HAVING COUNT(cuac.customer_id) > 1
ORDER BY ac.account_id ASC;