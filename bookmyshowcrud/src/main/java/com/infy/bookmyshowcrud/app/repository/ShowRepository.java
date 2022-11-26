package com.infy.bookmyshowcrud.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.bookmyshowcrud.app.model.ShowTickets;

@Repository
public interface ShowRepository extends JpaRepository<ShowTickets, Integer>
{

	public Optional<ShowTickets> findByShowName(String showName);

    public ShowTickets findByShowTickets(Integer showTickets);

    public void deleteByShowName(String showName);
	

}
