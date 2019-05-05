package daoBoroznaES;


import modelBoroznaES.Card;

import java.util.List;

public interface CardDAO {
    List<Card> getListCardForUser(Integer idUser);

    boolean addCard(Card infoAboutCard, Integer idUser);
}
