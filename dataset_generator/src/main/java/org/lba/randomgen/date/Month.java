package org.lba.randomgen.date;

import org.lba.randomgen.costraints.MonthEnum;

public class Month {

	private int number;
	private double weight;
	private String name;
	
	private MonthEnum monthEnum;
	
	public Month() {
		//Implement if necessary
	}

	/**
	 * 
	 * @param number
	 * @param weight
	 * @param name
	 */
	public Month(int number, double weight, String name) {
		super();
		this.number = number;
		this.weight = weight;
		this.name = name;
	}
	
	/**
	 * 
	 * @param number
	 * @param weight
	 * @param name
	 * @param monthEnum
	 */
	public Month(int number, double weight, String name, MonthEnum monthEnum) {
		super();
		this.number = number;
		this.weight = weight;
		this.name = name;
		this.monthEnum = monthEnum;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MonthEnum getMonthEnum() {
		return monthEnum;
	}

	public void setMonthEnum(MonthEnum monthEnum) {
		this.monthEnum = monthEnum;
	}

	@Override
	public String toString() {
		return "Month [number=" + number + ", weight=" + weight + ", name=" + name + ", monthEnum=" + monthEnum + "]";
	}

}
