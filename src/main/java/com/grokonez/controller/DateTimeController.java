package com.grokonez.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.model.DateTimeModel;
import com.grokonez.repository.DateTimeModelRepository;

@RestController
public class DateTimeController {

	
	@Autowired
	private DateTimeModelRepository dateTimeModelRepository;
	
	@GetMapping("/getdatetime")
	public Iterable<DateTimeModel> findAll() {
		return dateTimeModelRepository.findAll();
	}
	
	@PostMapping("/postdatetime")
	public DateTimeModel saveDateTime(@RequestBody DateTimeModel dateTimeModel) {
		return dateTimeModelRepository.save(dateTimeModel);
	}
	
	@GetMapping("/getdatetimebetween")
	public List<DateTimeModel> getDateTimeBetween(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate) {
		return dateTimeModelRepository.findAllByDateTimeBetween(startDate, endDate);
	}
	
	@GetMapping("/getdatetimebefore")
	public List<DateTimeModel> getDateTimeBefore(@RequestParam("dateTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beforeDateTime) {
		return dateTimeModelRepository.findAllWithDateTimeBefore(beforeDateTime);
	}
}
