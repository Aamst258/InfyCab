package com.infy.api.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.infy.api.dto.CabBookingDTO;
@Component
public interface BookingService {   
	public int bookCab(CabBookingDTO cab);
	public   CabBookingDTO getDetails(long mobileNo);  
	public void cancelBooking(int bid);  
	public List<CabBookingDTO> getAllBookingDetails();

}
