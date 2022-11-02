SELECT ac.account_id, SUM(lo.amount) AS amount_borrowed
FROM Loan AS lo
INNER JOIN account AS ac ON lo.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, AVG(lo.amount) AS average_borrowed
FROM Loan AS lo
INNER JOIN account AS ac ON lo.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(lo.loan_id) AS loans_amount
FROM Loan AS lo
INNER JOIN account AS ac ON lo.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, SUM(ftd.amount) AS amount_deposited
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, AVG(ftd.amount) AS average_deposited
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(ftd.fixed_term_deposit_id) AS deposits_amount
FROM FixedTermDeposit AS ftd
INNER JOIN account AS ac ON ftd.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;

SELECT ac.account_id, COUNT(cuac.customer_id) AS holders_amount
FROM CustomerAccount AS cuac
INNER JOIN account AS ac ON cuac.account_id = ac.account_id
GROUP BY ac.account_id
ORDER BY ac.account_id ASC;