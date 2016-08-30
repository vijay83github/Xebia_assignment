package com.zebia.yakshop.model;

import java.io.Serializable;

public class Yak implements Serializable{

	private String name;
	
	private int age;
	
	private int lastShaved;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the lastShaved
	 */
	public int getLastShaved() {
		return lastShaved;
	}

	/**
	 * @param lastShaved the lastShaved to set
	 */
	public void setLastShaved(int lastShaved) {
		this.lastShaved = lastShaved;
	}
	

	


	
}
