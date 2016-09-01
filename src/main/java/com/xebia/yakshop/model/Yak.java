package com.xebia.yakshop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Yak implements Serializable{
	@JacksonXmlProperty(isAttribute=true)
	private String name;
	@JacksonXmlProperty(isAttribute=true)
	private float age;
	
	@JsonProperty(value="age-last-shaved")
	private float lastShaved;
	@JsonIgnore
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
	public float getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(float age) {
		this.age = age;
	}

	/**
	 * @return the lastShaved
	 */
	public float getLastShaved() {
		return lastShaved;
	}
	

	/**
	 * @param lastShaved the lastShaved to set
	 */
	public void setLastShaved(float lastShaved) {
		this.lastShaved = lastShaved;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	


	
}
