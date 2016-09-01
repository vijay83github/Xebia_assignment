package com.xebia.yakshop.resource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.yakshop.model.YakProducts;
import com.xebia.yakshop.service.ProductFacade;
import com.xebia.yakshop.utils.YakshopConstants;
@RestController
@RequestMapping(value = "/yak-shop/stock")
public class StockResource {
 
    @Autowired
    ProductFacade productFacade;  
 
    //-------------------Retrieve All Stock--------------------------------------------------------
     
    @RequestMapping(value= "/{days}", method = RequestMethod.GET, produces="application/json")
    
    public ResponseEntity<YakProducts> listAllStock(@PathVariable Integer days) {
    	YakProducts products= productFacade.findAllStock(days - YakshopConstants.CURRENT_DAY);
        if(products==null){
            return new ResponseEntity<YakProducts>(new YakProducts(),HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<YakProducts>(products, HttpStatus.OK);
    }
 
 
 
}