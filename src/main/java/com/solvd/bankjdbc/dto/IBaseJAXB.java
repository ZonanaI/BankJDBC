package com.solvd.bankjdbc.dto;

import jakarta.xml.bind.JAXBException;
import java.util.Collection;

public interface IBaseJAXB<T> {
    T unmarshal (String path) throws JAXBException;
    void marshal (T object) throws JAXBException;
    Collection<T> unmarshalCollection (String path) throws JAXBException;
    void marshalCollection (Collection<T> collection) throws JAXBException;
}
