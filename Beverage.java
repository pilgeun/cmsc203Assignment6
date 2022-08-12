enum DAY { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };
enum TYPE {ALCOHOL, COFFEE, SMOOTHIE};
enum SIZE {SMALL, MEDIUM, LARGE};


public abstract class Beverage
{
	static final double BASE_PRICE = 2.0;
	static final double SIZE_PRICE = 1.0;
	protected String bevName;
	protected TYPE type;
	protected SIZE size;

	public Beverage(String n, TYPE t, SIZE s)
	{
		bevName = n;
		type = t;
		size = s;
	}

	abstract double calcPrice();

	@Override
	public String toString()
	{
		return "Name: " + bevName + "\nPrice: " + calcPrice() + "\nSize: " + size;
	}
	

	public boolean equals(Beverage b)
	{
		if ((bevName == b.bevName) && (type == b.type) && (size == b.size)) {
			return true;
		}
		return false;
	}

	public String getBevName() {
		return bevName;
	}

	public void setBevName(String name) {
		this.bevName = name;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public static double getBasePrice() {
		return BASE_PRICE;
	}

	public static double getSizePrice() {
		return SIZE_PRICE;
	}

	
}
