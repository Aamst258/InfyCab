package com.infy.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.api.Service.BookingService;
import com.infy.api.dto.CabBookingDTO;

@RestController  
public class CabBookingAPI{     
	    @Autowired
	private  BookingService bookingService ;  
	
	 

@GetMapping("/getallbooking") 
public ResponseEntity<List<CabBookingDTO>>  getAll (){   
	List<CabBookingDTO>  list =  this.bookingService.getAllBookingDetails();  

	if(list.size()<= 0){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return   ResponseEntity.of(Optional.of(list));
}

	 @PostMapping("/")  
	 public ResponseEntity<String> bookCab (@RequestBody CabBookingDTO cabBookingDTO) {  
		 
		int cabId =  this.bookingService.bookCab(cabBookingDTO);
		return new ResponseEntity<String>("you have successfully booked the cab and your id is : "+cabId ,HttpStatus.CREATED);
		    
		 
	 }      
	 // get single booking
	 @GetMapping("/{mobileNo}")
	 public ResponseEntity<CabBookingDTO> getBookingDetails(@PathVariable("mobileNo") long mobileNo){  
		CabBookingDTO list = this.bookingService.getDetails(mobileNo) ;
		if (list == null) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		   return  ResponseEntity.of(Optional.of(list)) ;
	 }     
	 @DeleteMapping("/{bookingId}")
	 public ResponseEntity<String> cancelBooking(@RequestBody CabBookingDTO cab,  @PathVariable("bookingId") int bookingId){ 
		  this.bookingService.cancelBooking(bookingId);
		 return  new ResponseEntity<String>("You have canceled your booking",HttpStatus.OK) ;
	 }
	 
}
