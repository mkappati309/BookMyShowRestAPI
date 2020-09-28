package com.bookmyshow.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.restapi.model.BookRequest;
import com.bookmyshow.restapi.repository.BookMyShowRepository;

@RestController
public class BookMyShowController {

	@Autowired
	private BookMyShowRepository bookMyShowRepository;

	@RequestMapping(value = "/bookingShow", method = RequestMethod.POST)
	public String bookShow(@RequestBody BookRequest bookRequest) {
		BookRequest response = bookMyShowRepository.save(bookRequest);
		return "Hi " + response.getUserName() + " your request for " + response.getShowName() + " on date "
				+ response.getBookingTime() + " is confirmed";
	}

	@RequestMapping(value = "/getAllBooking", method = RequestMethod.GET)
	public List<BookRequest> getAllBooking() {
		return bookMyShowRepository.findAll();
	}

	@RequestMapping(value = "/getBooking/{bookingId}", method = RequestMethod.GET)
	public BookRequest getBooking(@PathVariable int bookingId) {
		return bookMyShowRepository.findById(bookingId).get();
	}

	@RequestMapping(value = "/deleteBooking/{bookingId}", method = RequestMethod.DELETE)
	public String cancelBooking(@PathVariable int bookingId) {
		bookMyShowRepository.deleteById(bookingId);
		return "Hi your booking has been canceled with booking ID :  " + bookingId;
	}

	@RequestMapping(value = "/updateBooking/{bookingId}", method = RequestMethod.PUT)
	public BookRequest updateBooking(@RequestBody BookRequest updateBookingRequest, @PathVariable int bookingId) {
		BookRequest dbResponse = bookMyShowRepository.findById(bookingId).get();
		dbResponse.setBookingTime(updateBookingRequest.getBookingTime());
		dbResponse.setPrice(updateBookingRequest.getPrice());
		dbResponse.setShowName(updateBookingRequest.getShowName());
		dbResponse.setUserCount(updateBookingRequest.getUserCount());

		bookMyShowRepository.saveAndFlush(dbResponse);

		return dbResponse;
	}
}
