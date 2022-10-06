package com.solvd.bankjdbc.dto.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.Collection;

public interface IBaseJackson<T> {
    T unmarshal (String path) throws IOException;
    void marshal (T object) throws IOException;
    Collection<T> unmarshalCollection (String path) throws IOException;
    void marshalCollection (Collection<T> collection) throws IOException;
}
