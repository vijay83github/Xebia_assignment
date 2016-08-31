package com.zebia.yakshop.resource;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zebia.yakshop.model.Yak;
import com.zebia.yakshop.service.HerdService;
@RestController
@RequestMapping(value = "/yak-shop/herd")
public class HerdResource {
 
    @Autowired
    HerdService herdService;  
 
    
    //-------------------Retrieve All Yaks--------------------------------------------------------
     
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Yak>> listAllYaks() {
        List<Yak> yaks = herdService.findAllYaks();
        if(yaks.isEmpty()){
            return new ResponseEntity<List<Yak>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Yak>>(yaks, HttpStatus.OK);
    }
 
 
 
}