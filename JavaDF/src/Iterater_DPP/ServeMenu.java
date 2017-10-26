package Iterater_DPP;

import java.util.List;

public class ServeMenu implements MyIterater {
	List<Menu> item;
	int index;
	int maxIndex;
	
	public ServeMenu(List<Menu> item) {
		this.item = item;
		index = 0;
		maxIndex = item.size() - 1;
	}

	@Override
	public boolean hasNext() {
		if(this.item.size() > index){
			return true;
		}
		return false;
	}

	@Override
	public Object nextOne() {
		Menu menu = this.item.get(index);
		index++;
		return menu;
	}

	@Override
	public boolean hasPrev() {
		if(-1 < maxIndex){
			return true;
		}
		return false;
	}

	@Override
	public Object PrevOne() {
		Menu menu = this.item.get(maxIndex);
		maxIndex--;
		return menu;
	}
}
