public class Alcohol extends Beverage
{
	static final double WEEKEND_COST = 0.6;
	private boolean onWeekend;	// false by default

	public Alcohol(String n, SIZE s, boolean onWeekend)
	{
		super(n, TYPE.ALCOHOL, s);
		this.onWeekend = onWeekend;
	}

	@Override
	public String toString()
	{
		return "Name: " + bevName + "\nPrice: " + calcPrice() + "\nSize: " + size;
	}
	@Override
	public boolean equals(Beverage b)
	{
		if ((super.equals(b)) && (onWeekend == ((Alcohol) b).onWeekend)) 
		{
			return true;
		}
		return false;
	}
	@Override
	public double calcPrice()
	{
		double price = BASE_PRICE;
		switch (size)
		{
		case MEDIUM: 
			price += SIZE_PRICE;
			break;
		case LARGE: 
			price += 2 * SIZE_PRICE;
		}
		if (onWeekend) {
			price += WEEKEND_COST;
		}
		return price;
	}

	public boolean onWeekend()
	{
		return onWeekend;
	}

	public void setWeekend(boolean onWeekend)
	{
		this.onWeekend = onWeekend;
	}
}