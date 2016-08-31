package com.zebia.yakshop.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLInputFactory;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.xebia.yakshop.utils.YakShopPrinter;
import com.zebia.yakshop.model.Herd;
import com.zebia.yakshop.model.Yak;

public class HerdReader {
	

	private static final String FILE_LOCATION = "src/main/resources/";

	public List<Yak> readList(String fileName) {
		StringBuilder xmlContent = new StringBuilder();
        File XmlFile = new File(FILE_LOCATION + fileName);
        System.out.println(XmlFile);

        XMLInputFactory f = XMLInputFactory.newInstance();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(XmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s;

        try {
            while ((s = br.readLine()) != null) {
                xmlContent.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(xmlContent.toString());
        XmlMapper mapper = new XmlMapper(f);
        Herd herd= null;
        try {
            herd = mapper.readValue(xmlContent.toString(), Herd.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Yak[] yaks=herd.getYaks();
       
       return  Arrays.asList(yaks);	
	}
	
	public static void main(String[] args) {
		HerdReader herdReader = new HerdReader();
		YakShopPrinter  printer = new YakShopPrinter();
		printer.printHerd(herdReader.readList("herd.xml"));
	}

}
