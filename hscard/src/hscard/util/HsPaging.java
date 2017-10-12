package hscard.util;

import hscard.controller.SearchCardController;

public class HsPaging {
	// Instance
	private final int perOnePageCount = 10;
	private int selectPage = 1;
	private int totalPage;

	// Method
	public int getTotalPage(int searchJob, int searchCost, int searchCardset, String searchName) {
		SearchCardController searchCardCon = new SearchCardController();
		int totalCount = searchCardCon.getTotalCountByContidion(searchJob, searchCost, searchCardset, searchName);
		totalPage = (int) Math.ceil((double) totalCount / perOnePageCount);
		System.out.println("totalPage : " + totalPage);
		if(totalPage == 0){
			return totalPage = 1;
		}
		return totalPage;
	}

	public int StartNum(int selectPage) {
		return ((selectPage - 1) * perOnePageCount) + 1;
	}

	public int EndNum(int selectPage) {
		return StartNum(selectPage) + perOnePageCount - 1;
	}

	public int getSelectPage() {
		return selectPage;
	}

	public void setSelectPage(int selectPage) {
		this.selectPage = selectPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
