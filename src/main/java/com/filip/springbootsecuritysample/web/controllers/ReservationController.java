package com.filip.springbootsecuritysample.web.controllers;

import com.filip.springbootsecuritysample.domain.models.Reservation;
import com.filip.springbootsecuritysample.services.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API Description") // it is the description of the api at the top of swagger-ui.html
@RestController
@RequestMapping("/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // ------------ Retrieve all reservations ------------
    @ApiOperation(value = "Retrieve all reservations")
    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    // ------------ Retrieve a reservation ------------
    @GetMapping(value = "/reservations/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Retrieve an existing reservation")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Reservation with given id has been found and returned", response = Reservation.class),
            @ApiResponse(code = 404, message = "Reservation with given id does not exist")
    })
    public ResponseEntity getReservation(@ApiParam(value = "Id of a reservation", required = true)
                                         @PathVariable("id") Long id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    // ------------ Create a reservation ------------
    @ApiOperation(value = "Create a new reservation")
    @PostMapping(value = "/reservations", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    // ------------ Update a reservation ------------
    @ApiOperation(value = "Update an existing reservation")
    @PutMapping(value = "/reservations/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateReservation(@RequestBody Reservation reservation, @PathVariable("id") Long id) {
        reservationService.updateReservation(id, reservation);
    }

    // ------------ Delete a reservation ------------
    @ApiOperation(value = "Delete an existing reservation")
    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }


}
