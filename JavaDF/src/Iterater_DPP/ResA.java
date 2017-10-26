package Iterater_DPP;

import java.util.ArrayList;
import java.util.List;

public class ResA implements Aggregate {
	private List<Menu> menuA;

	public ResA() {
		menuA = new ArrayList<>();
		addMenu("pizza", 20.5);
		addMenu("pasta", 10.5);
	}

	public void addMenu(String menu, double price) {
		Menu myMenu = new Menu(menu, price);
		menuA.add(myMenu);
	}

	@Override
	public MyIterater myIterater() {
		return new ServeMenu(menuA);
	}
}
