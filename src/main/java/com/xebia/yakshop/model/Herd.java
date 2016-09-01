package com.xebia.yakshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="herd")
public class Herd {
	@JacksonXmlProperty(localName="labyak")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty(value="herd")
    private Yak[] yaks;

	public Yak[] getYaks() {
		return yaks;
	}

	public void setYaks(Yak[] yaks) {
		this.yaks = yaks;
	}
	

}
