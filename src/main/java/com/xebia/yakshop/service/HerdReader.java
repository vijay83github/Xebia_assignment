package com.xebia.yakshop.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.xebia.yakshop.model.Herd;

@Component
public class HerdReader {

	private static final String FILE_LOCATION = "src/main/resources/";

	public Herd readList(String fileName) {
		StringBuilder xmlContent = new StringBuilder();
		File xmlFile = new File(FILE_LOCATION + fileName);
		Herd herd = null;
		if (xmlFile.exists()) {
			System.out.println(xmlFile);

			XMLInputFactory f = XMLInputFactory.newInstance();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(xmlFile));
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

			try {
				herd = mapper.readValue(xmlContent.toString(), Herd.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
		return herd;
	}

}
