package hscard.controller;

import java.util.List;
import hscard.bean.HsNameIma;
import hscard.bean.HscardValue;
import hscard.model.CardDao;
import hscard.util.HsPaging;

public class SearchCardController {
	//Instance
	CardDao cardDao;
	HsPaging paging;
	
	//Constructor
	public SearchCardController() {
		cardDao = new CardDao();
		paging = new HsPaging();
	}
	
	//Method
	public HscardValue getCardByCardName(String cardName){
		return cardDao.getCardByCardName(cardName);
	}
	
	public List<HsNameIma> getNameImagebyjob(int jobNumber){
		return cardDao.getNameImagebyjob(jobNumber);
	}

	public List<HsNameIma> getNameImagebySearch(int searchJob, int searchCost, int searchCardset, String searchName, int selectPage) {
		int begin = paging.StartNum(selectPage);
		int end = paging.EndNum(selectPage);
		return cardDao.getNameImagebySearch(searchJob, searchCost, searchCardset, searchName, begin, end);
	}

	public int getTotalCountByContidion(int searchJob, int searchCost, int searchCardset, String searchName) {
		return cardDao.getTotalCountByContidion(searchJob, searchCost, searchCardset, searchName);
	}

}
