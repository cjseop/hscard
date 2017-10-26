package Adapter_DP;

public class Main {

	public static void main(String[] args) {
		Print p = new PrintBanner("Hello");
		PrintBanner q = new PrintBanner("okay");
		q.printWeak();
		q.printStrong();
		p.printWeak();
		p.printStrong();
		
	}

}
