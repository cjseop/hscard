package Iterater_DPP;

import java.util.ArrayList;
import java.util.List;

public class ResB implements Aggregate {
	private List<Menu> menuB;

	public ResB() {
		menuB = new ArrayList<>();
		addMenu("toast", 7.5);
		addMenu("coke", 3.5);
		addMenu("curry", 9.5);
		addMenu("potato chips", 5.5);
		addMenu("tomato salad", 2.5);
	}

	public void addMenu(String menu, double price) {
		Menu myMenu = new Menu(menu, price);
		menuB.add(myMenu);
	}

	@Override
	public MyIterater myIterater() {
		return new ServeMenu(menuB);
	}
}
