package com.zebia.yakshop.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


public class Yak implements Serializable{
	@JacksonXmlProperty(isAttribute=true)
	private String name;
	@JacksonXmlProperty(isAttribute=true)
	private int age;
	
	private int lastShaved;
	
	@JacksonXmlProperty(isAttribute=true)
	private String sex;

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
		if(lastShaved==0)
			return age;
		return lastShaved;
	}

	/**
	 * @param lastShaved the lastShaved to set
	 */
	public void setLastShaved(int lastShaved) {
		this.lastShaved = lastShaved;
	}
	

	


	
}
