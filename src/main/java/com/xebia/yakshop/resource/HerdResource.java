package com.xebia.yakshop.resource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.yakshop.model.Herd;
import com.xebia.yakshop.service.HerdService;
import com.xebia.yakshop.utils.YakshopConstants;
@RestController
@RequestMapping(value = "/yak-shop/herd")

public class HerdResource {
	private static final int CURRENT_DAY = 1;
    @Autowired
    HerdService herdService;  
 
    
    //-------------------Retrieve All Yaks--------------------------------------------------------
     
    @RequestMapping(value= "/{days}",  method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Herd> listAllYaks(@PathVariable Integer days) {
        Herd herd = herdService.findAllYaks(days - YakshopConstants.CURRENT_DAY);
        if(herd==null){
            return new ResponseEntity<Herd>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<Herd>(herd, HttpStatus.OK);
    }
 
 
 
}