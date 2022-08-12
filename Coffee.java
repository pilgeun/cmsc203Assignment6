/*
 Class: CMSC203 CRN 46519
 Program: Assignment 4 Design
 Instructor: Farnaz Eivazi
 Summary of Description: Software to track monthly orders for Bradley’s Beverage Shop
 Due Date: 8/11/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently. 
 I have not copied the code from a student or any source.
 Student: Philip Song
*/

public class Coffee extends Beverage
{
	static final double EXTRA_SHOT = 0.5;
	static final double EXTRA_SYRUP = 0.5;
	private boolean extraShot;
	private boolean extraSyrup;

	public Coffee(String n, SIZE s, boolean shot, boolean syrup)
	{
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + bevName + "\nPrice: " + calcPrice() + "\nSize: " + size;
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
			price += 2*SIZE_PRICE;
		}
		if (extraShot) {
			price += EXTRA_SHOT;
		}
		if (extraSyrup) {
			price += EXTRA_SYRUP;
		}
		return price;
	}

	@Override
	public boolean equals(Beverage b)
	{
		if ((super.equals(b)) && 
				(this.extraShot == extraShot) && 
				(this.extraSyrup == extraSyrup)) {
			return true;
		}
		return false;
	}

	public boolean getExtraShot()
	{
		return extraShot;
	}

	public void setExtraShot(boolean extraShot)
	{
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup)
	{
		this.extraSyrup = extraSyrup;
	}
}