package com.solvd.bankjdbc.dto.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.bankjdbc.models.Card;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class CardDTO implements IBaseJackson<Card> {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    @Override
    public Card unmarshal(String path) throws IOException {
        return objectMapper.readValue(new File(path), Card.class);
    }

    @Override
    public void marshal(Card card) throws IOException {
        String filePath = "src/main/resources/json/" + "card_id_" + card.getId() + ".json";
        objectMapper.writeValue(new File(filePath), card);
    }

    @Override
    public Collection<Card> unmarshalCollection(String path) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory()
                .constructCollectionType(Set.class, Card.class);
        return objectMapper.<Set<Card>>readValue(new File(path), javaType);
    }

    @Override
    public void marshalCollection(Collection<Card> collection) throws IOException {
        String filePath = "src/main/resources/json/cards.json";
        objectMapper.writeValue(new File(filePath), collection);
    }
}
