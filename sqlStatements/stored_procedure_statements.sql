delimiter //
CREATE PROCEDURE GetInitialAndLastName
    (IN id int, OUT InitialLastName varchar (45))
BEGIN
    SELECT CONCAT(left(first_name,1),last_name)
    INTO InitialLastName
    FROM employee
    WHERE employee_id = id;
END
