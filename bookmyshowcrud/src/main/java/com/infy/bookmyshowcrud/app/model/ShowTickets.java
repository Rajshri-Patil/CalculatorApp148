package com.infy.bookmyshowcrud.app.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ShowTickets 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer showId;
	private String showName;
	private Double showPrice;
	private Date showDate;
	private Time showTime;
	private Integer showTickets;

}
