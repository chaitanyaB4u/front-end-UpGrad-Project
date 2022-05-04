package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;


	@PostMapping
	public ResponseEntity bookAppointment(@RequestBody Appointment appointment) throws InvalidInputException {
		String savedAppointment = appointmentService.appointment(appointment);
		return new ResponseEntity(savedAppointment, HttpStatus.CREATED);
	}


	@GetMapping(value = "/{appointmentsId}")
	public ResponseEntity getAppointment(@PathVariable(name = "appointmentsId") String id) {
		Appointment detailsById = appointmentService.getAppointments(id);
		return new ResponseEntity<>(detailsById, HttpStatus.OK);
	}


}