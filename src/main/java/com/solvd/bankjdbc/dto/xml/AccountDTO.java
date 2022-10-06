package com.solvd.bankjdbc.dto.xml;

import com.solvd.bankjdbc.models.Account;
import com.solvd.bankjdbc.models.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Set;

public class AccountDTO implements IBaseJAXB<Account> {
    private static final Logger logger = LogManager.getLogger(AccountDTO.class);
    @Override
    public Account unmarshal (String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Account.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Account) unmarshaller.unmarshal(new File(path));
    }

    @Override
    public void marshal (Account account) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Account.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();

        marshaller.marshal(account,stringWriter);
        logger.info(stringWriter);

        String filePath = "src/main/resources/xml/" + "account_id_" + account.getId() + ".xml";

        marshaller.marshal(account,new File(filePath));

    }

    @Override
    public Collection<Account> unmarshalCollection(String path) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Accounts.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Accounts accounts = (Accounts) unmarshaller.unmarshal(new File(path));
        return accounts.getAccounts();
    }

    @Override
    public void marshalCollection(Collection<Account> accountCollection) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Accounts.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        Accounts accounts = new Accounts();
        if (accountCollection instanceof Set){
            accounts.setAccounts((Set)accountCollection);
        }
        marshaller.marshal(accounts,stringWriter);
        logger.info(stringWriter);
        String filePath = "src/main/resources/xml/accounts.xml";
        marshaller.marshal(accounts,new File("src/main/resources/xml/accounts.xml"));
    }
}