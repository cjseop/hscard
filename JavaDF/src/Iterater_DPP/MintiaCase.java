package Iterater_DPP;

public class MintiaCase implements Aggregate {
	private Mintia[] mintArr;
	private int last;
	
	public MintiaCase(int num){
		mintArr = new Mintia[num];
	}
	
	public int getLength(){
		return last;
	}
	
	public void addMintia(Mintia mintia){
		mintArr[last] = mintia;
		last++;
	}
	
	public Mintia getMinta(int index){
		return mintArr[index];
	}
	
	@Override
	public MyIterater myIterater() {
		return new MintiaCaseSearch(this);
	}

}
