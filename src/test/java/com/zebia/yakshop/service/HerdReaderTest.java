package com.zebia.yakshop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakshop.model.Herd;
import com.xebia.yakshop.service.HerdReader;

public class HerdReaderTest {
	HerdReader herdReader;
	

	@Before
	public void setup(){
		herdReader = new HerdReader();
	}
	@Test
	public void test() {
		Herd herd = herdReader.readList("herd.xml");
		
		assertEquals(3, herd.getYaks().length);
		
		herd = herdReader.readList("herd_.xml");
		assertNull(null, herd);
	}

}
