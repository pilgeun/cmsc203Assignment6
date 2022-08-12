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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable
{
	private int orderNumber;
	private int time;
	private DAY day;
	private Customer customer;
	private ArrayList<Beverage> listBeverages = new ArrayList<Beverage>();

	//int time, DAY day, String customerName, int customerAge
	public Order(int t, DAY d, Customer c)
	{
		orderNumber = rand();
		time = t;
		day = d;
		customer = c;
	}

	public static int rand()
	{
		Random rand = new Random();
		int randInt = rand.nextInt(79999) + 10001;
		return randInt;
	}
	
	public int getTotalItems() {
		return listBeverages.size();
	}
	
	@Override
	public Beverage getBeverage(int itemNo)
	{
		return listBeverages.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		listBeverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size)	
	{
		listBeverages.add(new Alcohol(bevName, size, isWeekend()));
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein)
	{
		listBeverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	@Override
	public String toString()
	{
		String str = "Order #: " + orderNumber 
				+ "\nDay: " + day 
				+ "\nName: " + customer.getName() 
				+ "\nAge: " + customer.getAge();
		for (int i = 0; i < listBeverages.size(); i++)
			str += "\n" + listBeverages.get(i).toString();
		str += "\nTotal: " + calcOrderTotal();
		
		return str;
	}
	
	@Override
	public int compareTo(Object o)
	{
		if (orderNumber > ((Order) o).orderNumber) {
			return 1;
		}
		if (orderNumber < orderNumber) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean isWeekend()
	{
		if (day == DAY.SATURDAY || day == DAY.SUNDAY)
			return true;
		else
			return false;
	}
	
	@Override
	public double calcOrderTotal()
	{
		double total = 0;
		for (int i = 0; i < listBeverages.size(); i++) {
			total += listBeverages.get(i).calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type)
	{
		int count = 0;
		
		for (int i = 0; i < listBeverages.size(); i++) {
			if (listBeverages.get(i).getType() == type)
				count ++;
		}
		
		return count;
	}

	public int getOrderNo()
	{
		return orderNumber;
	}

	public void setOrderNo(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public DAY getOrderDay()
	{
		return day;
	}

	public void setOrderDay(DAY day)
	{
		this.day = day;
	}

	public Customer getCustomer()
	{
		Customer copy = new Customer(customer);
		return copy;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public ArrayList<Beverage> getListBeverages()
	{
		return listBeverages;
	}

	public void setListBeverages(ArrayList<Beverage> listBeverages)
	{
		this.listBeverages = listBeverages;
	}

	public int getOrderTime() {
		return time;
	}

	public void setOrderTime(int time) {
		this.time = time;
	}
	
}