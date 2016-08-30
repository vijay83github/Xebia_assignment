package com.zebia.yakshop.resource;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zebia.yakshop.model.Yak;
import com.zebia.yakshop.service.HerdService;
@RestController
@RequestMapping(value = "/yak-shop/herd")
public class HerdResource {
 
    @Autowired
    HerdService userService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Yak>> listAllYaks() {
        List<Yak> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<Yak>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Yak>>(users, HttpStatus.OK);
    }
 
 
 
}