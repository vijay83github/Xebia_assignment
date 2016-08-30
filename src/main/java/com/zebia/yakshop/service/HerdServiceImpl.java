package com.zebia.yakshop.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zebia.yakshop.model.Yak;

@Service("herdService")
public class HerdServiceImpl implements HerdService{
	private static List<Yak> users = new ArrayList<Yak>();
	

	public List<Yak> findAllYaks() {
		if(users!=null && users.isEmpty()){
			users = readList();
		}
		return users;
	}
	

}
