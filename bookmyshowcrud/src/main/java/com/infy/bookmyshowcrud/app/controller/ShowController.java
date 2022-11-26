package com.infy.bookmyshowcrud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.bookmyshowcrud.app.model.ShowTickets;
import com.infy.bookmyshowcrud.app.servicei.ShowServiceI;
  
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/show")
public class ShowController 
{
	
        @Autowired
		ShowServiceI ssi;
		
			
	     //Post api
		@PostMapping(value = "/addShow",consumes = {"application/json","application/xml"})
	    public ResponseEntity<ShowTickets> saveShow(@RequestBody ShowTickets s)
	    {

	     ShowTickets show = ssi.saveShow(s);
	      return new ResponseEntity<ShowTickets>(show ,HttpStatus.CREATED);    //201
	    }   
		
		
	    //Get api
		@GetMapping("getShow/all")
		public  ResponseEntity<Iterable<ShowTickets>> getShow()
		{
			Iterable<ShowTickets> showlist = ssi.getShow();
			return new ResponseEntity<Iterable<ShowTickets>>(showlist,HttpStatus.OK);    //200
		}
		
		//put api
		@PutMapping("/editShow/{showName}")
		public ResponseEntity<ShowTickets> updateShow(@PathVariable String showName, @RequestBody ShowTickets s)
		{
			ShowTickets show = ssi.updateShow(showName,s);
			return new ResponseEntity<ShowTickets>(show ,HttpStatus.OK); //200
			   
		}
		
		//delete api
		@DeleteMapping("/deleteShow/{showName}")
		public ResponseEntity deleteData(@PathVariable String showName)
		{
		    ssi.deleteShow(showName);
		    return new ResponseEntity(HttpStatus.NO_CONTENT);     //404
		}


		//searchshow api
		@GetMapping(value = "getTickets/{showTickets}")
		public ResponseEntity<ShowTickets> searchShowTickets(@PathVariable Integer showTickets)
		{
			ShowTickets s = ssi.searchShowTickets(showTickets);
            return new ResponseEntity<ShowTickets>(s,HttpStatus.OK);
		}

	}
