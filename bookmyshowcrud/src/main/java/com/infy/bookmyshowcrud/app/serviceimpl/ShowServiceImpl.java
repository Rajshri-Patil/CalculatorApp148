package com.infy.bookmyshowcrud.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.bookmyshowcrud.app.exception.TicketsNotFoundException;
import com.infy.bookmyshowcrud.app.model.ShowTickets;
import com.infy.bookmyshowcrud.app.repository.ShowRepository;
import com.infy.bookmyshowcrud.app.servicei.ShowServiceI;

@Service
public class ShowServiceImpl implements ShowServiceI{

	@Autowired
	ShowRepository sr;
	
	@Override
	public ShowTickets saveShow(ShowTickets s) {
	   
		return sr.save(s);
	}

	@Override
	public Iterable<ShowTickets> getShow() {
		
		return sr.findAll();
	}

	@Override
	public ShowTickets updateShow(String showName, ShowTickets s) {
		Optional<ShowTickets> op = sr.findByShowName(showName);
		if(op.isPresent())
		{
			ShowTickets show = op.get();
			show.setShowId(s.getShowId());
			show.setShowName(s.getShowName());
			show.setShowPrice(s.getShowPrice());
			show.setShowDate(s.getShowDate());
			show.setShowTime(s.getShowTime());
			show.setShowTickets(s.getShowTickets());
			return sr.save(show);
		}
		else
		{
			return null;
		}
	
	}

	@Override
	public void deleteShow(String showName) {
		sr.deleteByShowName(showName);
		
	}

	@Override
	public ShowTickets searchShowTickets(Integer showTickets) 
	{
			ShowTickets s = sr.findByShowTickets(showTickets);
			 if(s!=null)
			  {
//				 int count=showTickets;
//				 if(count>=0)
//				 {
//					 count++;
//					 return 
//				 }
				  return s;
			  }
			  else
			  {
				  //return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);  //405
			      //use for custom exception
			      throw new TicketsNotFoundException("Show Not Available");
			  }
		}

	}

