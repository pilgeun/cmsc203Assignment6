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

public class Smoothie extends Beverage
{
	static final double PROTEIN = 1.5;
	static final double PER_FRUIT = 0.5;
	private int numOfFruits;
	private boolean withProtein;

	public Smoothie(String n, SIZE s, int numOfFruits, boolean withProtein)
	{
		super(n, TYPE.SMOOTHIE, s);
		this.numOfFruits = numOfFruits;
		this.withProtein = withProtein;
	}

	@Override
	public String toString()
	{
		return "Name: " + bevName + "\nPrice: " + calcPrice() + "\nSize: " + size + "\nFruits: " + numOfFruits;
	}
	@Override
	public boolean equals(Beverage b)
	{
		if ((super.equals(b)) && 
				(numOfFruits == numOfFruits) && 
				(withProtein == withProtein)) {
			return true;
		}
		return false;
	}
	@Override
	double calcPrice()
	{
		double price = BASE_PRICE + (numOfFruits * PER_FRUIT);
		switch (size)
		{
		case MEDIUM: 
			price += SIZE_PRICE;
			break;
		case LARGE: 
			price += 2 * SIZE_PRICE;
		}
		if (withProtein) {
			price += PROTEIN;
		}
		return price;
	}

	public int getNumOfFruits()
	{
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits)
	{
		this.numOfFruits = numOfFruits;
	}

	public boolean getAddProtein()
	{
		return withProtein;
	}

	public void setWithProtein(boolean withProtein)
	{
		this.withProtein = withProtein;
	}
}