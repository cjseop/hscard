package Singleton_DPP;

public class TicketMaker {
	private int ticket = 1000;
	private static TicketMaker tm = new TicketMaker();
	
	private TicketMaker() {
		System.out.println("ticket인스턴스를 생성했습니다.");
	}
	
	public int  getNextTicketNumber(){
		return ticket++;
	}
	
	public static TicketMaker getInstanceTicket(){
		return tm;
	}
}
