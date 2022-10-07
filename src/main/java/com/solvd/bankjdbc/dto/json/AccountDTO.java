package com.solvd.bankjdbc.dto.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.bankjdbc.models.Account;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class AccountDTO implements IBaseJackson<Account> {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    @Override
    public Account unmarshal(String path) throws IOException {
        return objectMapper.readValue(new File(path), Account.class);
    }

    @Override
    public void marshal(Account account) throws IOException {
        String filePath = "src/main/resources/json/" + "account_id_" + account.getId() + ".json";
        objectMapper.writeValue(new File(filePath), account);
    }

    @Override
    public Collection<Account> unmarshalCollection(String path) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory()
                .constructCollectionType(Set.class, Account.class);
        return objectMapper.<Set<Account>>readValue(new File(path), javaType);
    }

    @Override
    public void marshalCollection(Collection<Account> collection) throws IOException {
        String filePath = "src/main/resources/json/accounts.json";
        objectMapper.writeValue(new File(filePath), collection);
    }
}
