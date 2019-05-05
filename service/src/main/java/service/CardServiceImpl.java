package service;

import converter.CardConverter;
import dao.CardDAO;
import dao.UserDAO;
import daoImpl.CardDaoImpl;
import daoImpl.UserDaoImpl;
import dto.CardDTO;

import java.util.List;

public class CardServiceImpl implements CardService {
    private static CardServiceImpl instance;

    private CardServiceImpl() {
    }

    public static CardServiceImpl getInstance() {
        if (instance == null) {
            instance = new CardServiceImpl();
        }
        return instance;
    }
    private CardConverter cardConverter=new CardConverter();
    private CardDAO cardDAO= CardDaoImpl.getInstance();
    private UserDAO userDAO= UserDaoImpl.getInstance();
    @Override
    public List<CardDTO> getListCardForUser(String userName) {
        return cardConverter.convertListCardToListCardDTO(cardDAO.getListCardForUser(userDAO.getByUserName(userName).getId()));
    }

    @Override
    public void addCardForUser(CardDTO cardDTO, String userName) {
        cardDAO.addCard(cardConverter.convertCardDTOToCard(cardDTO),userDAO.getByUserName(userName).getId());
    }
}
