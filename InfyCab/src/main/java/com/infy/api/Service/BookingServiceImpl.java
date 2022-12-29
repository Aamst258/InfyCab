package com.infy.api.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.infy.api.dto.CabBookingDTO; 
import java.util.stream.*;

@Component
public class BookingServiceImpl implements BookingService {

private  static List<CabBookingDTO> list = new ArrayList<>();
   
static {
	list.add(new CabBookingDTO(13,8123456789L,"betgeri","Gadag",40));
	list.add(new CabBookingDTO(14,8111456789L,"MulgundNaka","Bus Stand",30));
}

	@Override
	public int bookCab(CabBookingDTO cab) {
		list.add(cab);
		return cab.getBookingId();
	}

	@Override 
	
	public CabBookingDTO getDetails(long mobileNo) {  
		CabBookingDTO cab = null ;
		try {
			cab =	list.stream().filter(e->e.getMobileNo()== mobileNo).findFirst().get();
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return   cab ;
	  
	}

	@Override
	public void cancelBooking(int bid) {
		list.stream().filter(cab->{
			if(cab.getBookingId()!= bid){
                return true ;
			} else {
				return false ;
			}
		}).collect(Collectors.toList());

	}

	@Override
	public List<CabBookingDTO> getAllBookingDetails() {
		//
		return list;
	}

}
