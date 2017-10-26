package Iterater_DPP;

public class Menu {
	private String menu;
	private double price;
	
	public Menu(String menu, double price) {
		this.menu = menu;
		this.price = price;
	}
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
