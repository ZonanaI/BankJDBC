package com.solvd.bankjdbc.dto;
import com.solvd.bankjdbc.models.Card;
import com.solvd.bankjdbc.models.Cards;
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

public class CardDTO implements IBaseJAXB<Card> {
    private static final Logger logger = LogManager.getLogger(CardDTO.class);
    @Override
    public Card unmarshal (String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Card.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Card) unmarshaller.unmarshal(new File(path));
    }

    @Override
    public void marshal (Card card) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Card.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();

        marshaller.marshal(card,stringWriter);
        logger.info(stringWriter);

        String filePath = "src/main/resources/xml/" + "card_id_" + card.getId() + ".xml";

        marshaller.marshal(card,new File(filePath));

    }

    @Override
    public Collection<Card> unmarshalCollection(String path) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Cards.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Cards cards = (Cards) unmarshaller.unmarshal(new File(path));
        return cards.getCards();
    }

    @Override
    public void marshalCollection(Collection<Card> cardCollection) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Cards.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        Cards cards = new Cards();
        if (cardCollection instanceof Set){
            cards.setCards((Set)cardCollection);
        }
        marshaller.marshal(cards,stringWriter);
        logger.info(stringWriter);
        String filePath = "src/main/resources/xml/cards.xml";
        marshaller.marshal(cards,new File("src/main/resources/xml/cards.xml"));
    }
}
