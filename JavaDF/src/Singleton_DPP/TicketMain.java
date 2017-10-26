package Singleton_DPP;

public class TicketMain {

	public static void main(String[] args) {
		TicketMaker t1 = TicketMaker.getInstanceTicket();
		TicketMaker t2 = TicketMaker.getInstanceTicket();
		if(t1 == t2){
			System.out.println(t1.getNextTicketNumber());
			System.out.println(t2.getNextTicketNumber());
		}
	}

}
