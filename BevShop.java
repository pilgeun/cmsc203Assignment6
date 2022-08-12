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

public class BevShop implements BevShopInterfce {
	
	private int numAlcohol;
	private ArrayList<Order> listOrders = new ArrayList<Order>();

	/**
	 * 
	 * @return the last 
	 * */
	public Order getCurrentOrder() {
		return listOrders.get(listOrders.size() - 1);
	}
	
	public int getNumOfAlcoholDrink() {
		int count = 0;
		
		for (Order order : listOrders) {
			count += order.findNumOfBeveType(TYPE.ALCOHOL);
		}
		
		return count;
	}
		
	public int getNumOfCoffeeDrink() {
		int count = 0;
		
		for (Order order : listOrders) {
			count += order.findNumOfBeveType(TYPE.COFFEE);
		}
		
		return count;
	}

	public int getNumOfSmoothieDrink() {
		int count = 0;
		
		for (Order order : listOrders) {
			count += order.findNumOfBeveType(TYPE.SMOOTHIE);
		}
		
		return count;
	}
	
	public int totalNumOfMonthlyOrders() {
		return listOrders.size();
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (Order order : listOrders)
			str += order.toString() + "\n";
	
		str += "Total amount for all orders:" + totalMonthlySale();
		
		return str;
	}
	
	@Override
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME)
			return true;
		else
			return false;
	}

	@Override
	public boolean eligibleForMore() {
		if (numAlcohol < MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}

	@Override
	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL)
			return true;
		else
			return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		listOrders.add(new Order(time, day, new Customer(customerName, customerAge)));		
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		getCurrentOrder().addNewBeverage(bevName, size);
	}
	
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);;
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		int i = 0;
		
		for (; i < listOrders.size(); i++) 
		{
			if (getOrderAtIndex(i).getOrderNo() == orderNo)
				return i;
		}
		
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return getOrderAtIndex(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		
		for (Order order : listOrders)
			total += order.calcOrderTotal();
		
		return total;
	}

	@Override
	public void sortOrders() {
		int listSize = listOrders.size();
		
		for(int i = 0; i < listSize-1; i++) 
		{
			int minIndex = i;
						
			for (int j = i+1; j < listSize; j++)
			{
				int orderNum1 = getOrderAtIndex(i).getOrderNo();
				int orderNum2 = getOrderAtIndex(j).getOrderNo();
				
				if (orderNum1 > orderNum2)
				{
					minIndex = j;
				}
					
				Order tempOrder = getOrderAtIndex(minIndex);
				listOrders.set(minIndex, getOrderAtIndex(i));
				listOrders.set(i, tempOrder);
			}
		}
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return listOrders.get(index);
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL; 
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getNumAlcohol() {
		return numAlcohol;
	}

	public void setNumAlcohol(int numAlcohol) {
		this.numAlcohol = numAlcohol;
	}

	public ArrayList<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(ArrayList<Order> listOrders) {
		this.listOrders = listOrders;
	}
	
}
