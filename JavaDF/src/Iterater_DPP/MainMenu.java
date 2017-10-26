package Iterater_DPP;

public class MainMenu {
	public static void main(String[] args) {
		MyIterater a = new ResA().myIterater();
		MyIterater b = new ResB().myIterater();
		printMenu(a);
		printReverseMenu(b);
		printMenu(b);
		
	}

	public static void printReverseMenu(MyIterater menuItem) {
		while(menuItem.hasPrev()){
			Menu menu = (Menu) menuItem.PrevOne();
			System.out.println(menu.getMenu() + " / " + menu.getPrice());
		}
	}

	public static void printMenu(MyIterater menuItem) {
		while(menuItem.hasNext()){
			Menu menu = (Menu) menuItem.nextOne();
			System.out.println(menu.getMenu() + " / " + menu.getPrice());
		}
	}
}
