package org.lba.randomgen.date;

import java.io.Serializable;

import org.lba.randomgen.costraints.DayEnum;

public class Day implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3738569248370204020L;
	
	private int number;
	private double weight;
	private String name;
	
	private DayEnum dayEnum;
	
	public Day() {
		//Implement if necessary
	}

	/**
	 * 
	 * @param number
	 * @param weight
	 * @param name
	 */
	public Day(int number, double weight, String name) {
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
	 * @param dayEnum
	 */
	public Day(int number, double weight, String name, DayEnum dayEnum) {
		super();
		this.number = number;
		this.weight = weight;
		this.name = name;
		this.dayEnum = dayEnum;
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

	public DayEnum getDayEnum() {
		return dayEnum;
	}

	public void setDayEnum(DayEnum dayEnum) {
		this.dayEnum = dayEnum;
	}

	@Override
	public String toString() {
		return "Day [number=" + number + ", weight=" + weight + ", name=" + name + ", dayEnum=" + dayEnum + "]";
	}
	
}
