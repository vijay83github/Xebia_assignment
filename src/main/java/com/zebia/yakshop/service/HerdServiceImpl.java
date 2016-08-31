package com.zebia.yakshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebia.yakshop.model.Yak;

@Service("herdService")
public class HerdServiceImpl implements HerdService{
	private static final String HERD_XML = "herd.xml";

	private static List<Yak> yaks = new ArrayList<Yak>();
	
	@Autowired
	HerdReader herdReader;

	public List<Yak> findAllYaks() {
		if(yaks!=null && yaks.isEmpty()){
			yaks = herdReader.readList(HERD_XML);
		}
		return yaks;
	}
	

}
