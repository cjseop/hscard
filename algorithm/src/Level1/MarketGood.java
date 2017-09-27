package Level1;

public class MarketGood 
{
	private String name;
	private int retailPrice;
	private int discountRate;
	
	public MarketGood(String name, int retailPrice, int discountRate) 
	{
		this.name = name;
		this.retailPrice = retailPrice;
		this.discountRate = discountRate;
		if(discountRate < 0 || discountRate > 100)
		{
			this.discountRate = 0;
		}
	}
	
	public MarketGood(String name, int retailPrice) {
		this.name = name;
		this.retailPrice = retailPrice;
		this.discountRate = 0;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public String getName() {
		return name;
	}

	public int getRetailPrice() {
		return retailPrice;
	}
	
	public int getDiscountedPrice()
	{
		int discountPrice = this.retailPrice * (100-discountRate) / 100;
		return discountPrice;
	}
	
}
