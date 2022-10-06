package com.solvd.bankjdbc.dto.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.bankjdbc.models.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class EmployeeDTO implements IBaseJackson<Employee> {
     private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;
    @Override
    public Employee unmarshal(String path) throws IOException {
        return objectMapper.readValue(new File(path), Employee.class);
    }

    @Override
    public void marshal(Employee employee) throws IOException {
        String filePath = "src/main/resources/json/" + "employee_id_" + employee.getId() + ".json";
        objectMapper.writeValue(new File(filePath), employee);
    }

    @Override
    public Collection<Employee> unmarshalCollection(String path) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory()
                .constructCollectionType(Set.class, Employee.class);
        return objectMapper.<Set<Employee>>readValue(new File(path), javaType);
    }

    @Override
    public void marshalCollection(Collection<Employee> collection) throws IOException {
        String filePath = "src/main/resources/json/employees.json";
        objectMapper.writeValue(new File(filePath), collection);
    }
}
