package hscard.controller;

import hscard.bean.Hscard;
import hscard.model.CardDao;

public class InsertCardController {
	CardDao cardDao;
	
	public int insertCard (Hscard cardBean){
		cardDao = new CardDao();
		return cardDao.InsertCard(cardBean);
	}
}
