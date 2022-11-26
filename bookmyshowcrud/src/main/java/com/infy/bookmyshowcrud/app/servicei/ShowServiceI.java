package com.infy.bookmyshowcrud.app.servicei;

import com.infy.bookmyshowcrud.app.model.ShowTickets;

public interface ShowServiceI {

	public ShowTickets saveShow(ShowTickets s);

	public Iterable<ShowTickets> getShow();

	public ShowTickets updateShow(String showName, ShowTickets s);

	public void deleteShow(String showName);

	public ShowTickets searchShowTickets(Integer showTickets);

	
}
