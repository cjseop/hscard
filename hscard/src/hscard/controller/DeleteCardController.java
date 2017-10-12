package hscard.controller;

import hscard.bean.Hscard;
import hscard.model.CardDao;

public class DeleteCardController {
CardDao cardDao;
	
	public int DeleteCard (String cardName){
		cardDao = new CardDao();
		return cardDao.DeleteCard(cardName);
	}
}
