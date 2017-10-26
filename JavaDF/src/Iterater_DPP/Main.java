package Iterater_DPP;

public class Main {

	public static void main(String[] args) {
		MintiaCase mc = new MintiaCase(4);
		mc.addMintia(new Mintia("A"));
		mc.addMintia(new Mintia("B"));
		mc.addMintia(new Mintia("C"));
		mc.addMintia(new Mintia("D"));
		
		MyIterater mi = mc.myIterater();
		while(mi.hasNext()){
			Mintia min = (Mintia)mi.nextOne();
			System.out.println(min.getFlavor());
			
		}
	}

}
