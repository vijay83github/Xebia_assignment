package com.zebia.yakshop.resource;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zebia.yakshop.model.Yak;
import com.zebia.yakshop.model.YakProducts;
import com.zebia.yakshop.service.HerdService;
@RestController
@RequestMapping(value = "/yak-shop/stock")
public class StockResource {
 
    @Autowired
    ProductService herdService;  
 
    
    //-------------------Retrieve All Stocks--------------------------------------------------------
     
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<YakProducts> listAllStock() {
    	YakProducts products= herdService.findAllStock();
        if(products==null){
            return new ResponseEntity<YakProducts>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<YakProducts>(products, HttpStatus.OK);
    }
 
 
 
}