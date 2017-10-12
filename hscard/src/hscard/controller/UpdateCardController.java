package hscard.controller;

import hscard.bean.Hscard;
import hscard.model.CardDao;

public class UpdateCardController {
	CardDao cardDao;
	
	public int updateCard(Hscard cardBean) {
		cardDao = new CardDao();
		return cardDao.updateCard(cardBean);
		
	}

}
