package Iterater_DPP;

public class MintiaCaseSearch implements MyIterater {
	private MintiaCase mc;
	private int index;

	public MintiaCaseSearch(MintiaCase mc) {
		this.mc = mc;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < mc.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object nextOne() {
		Mintia mintia = mc.getMinta(index);
		index++;
		return mintia;
	}


	@Override
	public boolean hasPrev() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object PrevOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
