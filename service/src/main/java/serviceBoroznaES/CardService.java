package serviceBoroznaES;

import dtoBoroznaES.CardDTO;

import java.util.List;

public interface CardService {
    List<CardDTO> getListCardForUser(String userName);

    void addCardForUser(CardDTO cardDTO, String userName);
}
