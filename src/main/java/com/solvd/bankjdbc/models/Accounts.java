package com.solvd.bankjdbc.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {
        @XmlElement(name = "account")
        private Set<Account> accounts = null;

        public Set<Account> getAccounts() {
            return accounts;
        }

        public void setAccounts(Set<Account> accounts) {
            this.accounts = accounts;
        }
    

}
