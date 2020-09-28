package com.bookmyshow.restapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "BookMyShow")
public class BookRequest {

	@Id
	@GeneratedValue
	public int bookingId;
	private String userName;
	private String showName;
	@JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING, timezone = "USA/Chicago")
	private Date bookingTime;
	private int userCount;
	private Double price;

}
