package com.solvd.bankjdbc.dto.xml;

import com.solvd.bankjdbc.models.Employee;
import com.solvd.bankjdbc.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

public class EmployeeDTO implements IBaseJAXB<Employee> {
    private static final Logger logger = LogManager.getLogger(EmployeeDTO.class);
    @Override
    public Employee unmarshal (String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Employee) unmarshaller.unmarshal(new File(path));
    }

    @Override
    public void marshal (Employee employee) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();

        marshaller.marshal(employee,stringWriter);
        logger.info(stringWriter);

        String filePath = "src/main/resources/xml/" + "employee_id_" + employee.getId() + ".xml";

        marshaller.marshal(employee,new File(filePath));

    }

    @Override
    public Collection<Employee> unmarshalCollection(String path) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employees employees = (Employees) unmarshaller.unmarshal(new File(path));
        return employees.getEmployees();
    }

    @Override
    public void marshalCollection(Collection<Employee> employeeCollection) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        Employees employees = new Employees();
        if (employeeCollection instanceof List){
            employees.setEmployees((List)employeeCollection);
        }
        marshaller.marshal(employees,stringWriter);
        logger.info(stringWriter);
        String filePath = "src/main/resources/xml/employees.xml";
        marshaller.marshal(employees,new File(filePath));
    }
}
