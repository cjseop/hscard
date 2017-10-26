package Singleton_DPP;

public class TripleMain {

	public static void main(String[] args) {
			Triple obj0 = Triple.getTPinstance(0);
			Triple obj1 = Triple.getTPinstance(1);
			Triple obj2 = Triple.getTPinstance(2);
			Triple obj00 = Triple.getTPinstance(0);
			Triple obj11 = Triple.getTPinstance(1);
			Triple obj22 = Triple.getTPinstance(2);
			
			if(obj0 == obj00){
				System.out.println("obj0 == obj00");
			}
			if(obj1 == obj11){
				System.out.println("obj1 == obj11");
			}
			if(obj2 == obj22){
				System.out.println("obj2 == obj22");
				
			}
			if(obj0 == obj1){
				System.out.println("obj0 == obj00");
			}
			if(obj0 == obj2){
				System.out.println("obj0 == obj00");
			}
			if(obj1 == obj2){
				System.out.println("obj0 == obj00");
			}
			
	}

}
