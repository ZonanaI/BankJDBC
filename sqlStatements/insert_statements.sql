USE mydb;

INSERT INTO accounttype (account_type) VALUES
('Checking'),
('Savings'),
('Money market');

INSERT INTO accountstatus (account_status) VALUES
('Pre-activated'),
('Activated'),
('Suspended');

INSERT INTO failedtransactionerrortype (error_description) VALUES
('Insuficient funds'),
('Wrong security code'),
('Expired card'),
('Unknown network error');

INSERT INTO cardtype (card_type) VALUES
('Debit'),
('Credit');

INSERT INTO accountnumber (account_number) VALUES
('61030693'),
('93812998'),
('29299003'),
('03422745'),
('03411593'),
('41798048');

INSERT INTO cardnumber (card_number) VALUES
('4539669246229490'),
('4716779126770003'),
('4929846993044318'),
('4393852493390174'),
('5438153166765030'),
('5372466000380990'),
('5466966799410079'),
('5360484956883507'),
('341429823553796'),
('345707257018246'),
('372867566112712'),
('377238644392707');

INSERT INTO account (balance,account_type_id,account_status_id,account_number_id) VALUES
(0,1,1,1),
(50000,2,2,2),
(20000,2,2,3),
(150000,3,2,4),
(-25000,3,3,5),
(250000,3,2,6);

INSERT INTO card (from_date,exp_date,security_number,card_number_id,card_type_id,account_id) VALUES
('2022-05-31','2025-05-31','719',1,1,1),
('2022-05-31','2025-10-31','434',2,2,1),
('2022-05-31','2025-05-31','488',3,2,1),
('2022-05-31','2025-05-31','785',4,2,2),
('2022-05-31','2025-05-31','478',5,1,2),
('2022-05-31','2025-05-31','652',6,1,3),
('2022-05-31','2025-05-31','725',7,1,4),
('2022-05-31','2025-05-31','336',8,2,5),
('2022-05-31','2025-05-31','571',9,1,5),
('2022-05-31','2025-05-31','318',10,2,6),
('2022-05-31','2025-05-31','182',11,1,6),
('2022-05-31','2025-05-31','176',12,2,6);

INSERT INTO customer (first_name,last_name,address,city,state,phone) VALUES
('David','Weathers','1452 Fairway Drive',' Fairfield','California','707-428-7549'),
('Lynn','Murphy','633 Mayo Street','Cincinnati','Kentucky','859-802-2180'),
('Pearl','Sailer','4676 Court Street','Saint Louis','Missouri','636-689-0491'),
('Dale','Range','1801 Leverton Cove Road','Springfield','Massachusetts','413-431-3971');

INSERT INTO employee (first_name,last_name) VALUES
('Ada','Artis'),
('Benjamin','Merrell'),
('Violet','Clapp'),
('John','Strand');

INSERT INTO failedtransactionlog (failed_transaction_time,failed_transaction_error_type_id) VALUES
('2022-07-22 09:54:05',1),
('2022-06-10 06:24:33',2),
('2022-03-07 14:38:07',3);

INSERT INTO fixedtermdeposit (amount,rate,from_date,account_id) VALUES
(5000.00,3.5,'2022-02-15',2),
(15000.00,2.5,'2022-05-09',3),
(20000.00,4.5,'2022-04-26',3),
(500.00,3.5,'2022-08-13',1);

INSERT INTO loan (amount,rate,returned_amount,from_date,account_id) VALUES
(5000.00,3.5,4000.00,'2022-02-15',4),
(50000.00,2.5,25000.00,'2022-05-09',5),
(20000.00,4.5,18000.00,'2022-04-26',4),
(5000.00,3.5,6050.00,'2022-02-13',4);

INSERT INTO transactiontype (transaction_name,fee_amount,transaction_description) VALUES
('Cash withdrawl',0,'Cash withdrawl from account'),
('Debit payment',0,'Payment with debit card'),
('Deposit',0,'Deposit into account'),
('Wire transfer',0.5,'Wire transfer from account');

INSERT INTO transactionlog (transaction_date,transaction_amount,new_balance,employee_id,account_id,transaction_type_id) VALUES
('2022-07-18',5000,45000,null,2,2),
('2022-07-18',7000,27000,null,3,3),
('2022-07-18',5000,50000,null,3,2),
('2022-07-18',50000,200000,null,4,3),
('2022-07-18',10000,189950,3,4,4),
('2022-07-18',10000,240000,null,6,2);

INSERT INTO username (user_name) VALUES
('davidW1990'),
('lynnM1980'),
('pearlS1985'),
('daleR1978');

INSERT INTO userlogin (user_password,user_name_id) VALUES
('123d543',1),
('345L786',2),
('346P143',3),
('364D858',4);

INSERT INTO usersecurityquestion (user_security_question,user_login_id) VALUES
('First pet name?',1),
('Mothers last name?',2),
('First pet name?',3),
('Favourite ice cream flavour?',4);

INSERT INTO usersecurityanswer (user_security_answer,user_security_question_id) VALUES
('Lulu',1),
('Luiz',2),
('Suzi',3),
('Chocolate',4);

INSERT INTO AccountUserLogin (account_id,user_login_id) VALUES
(1,1),
(2,1),
(2,2),
(3,2),
(5,3),
(4,4),
(6,4);

INSERT INTO CustomerAccount (customer_id,account_id) VALUES
(1,1),
(1,2),
(2,2),
(2,3),
(3,5),
(4,4),
(4,6);