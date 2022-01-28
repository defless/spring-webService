package com.cours.spring.controllers;

import com.cours.spring.entities.Trip;
import com.cours.spring.entities.User;
import com.cours.spring.services.TripService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @Operation(summary = "Récupération de toutes les sorties")
    @RequestMapping(method = RequestMethod.GET)
    public List<Trip> getAllUsers() {
        return tripService.getAllTrips();
    }

    @Operation(summary = "Récupération d'une sortie")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Trip get(@PathVariable(name = "id") Long trip) {
        return tripService.getTripById(trip);
    }

    @Operation(summary = "Modification ou création d'une sortie")
    @RequestMapping(method = RequestMethod.PUT)
    public Trip createOrUPdate(@RequestBody Trip trip) {
        return tripService.createOrUpdate(trip);
    }

    @Operation(summary = "Suppression d'une sortie à partir de son identifiant")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable(value = "id") Long id) {
        tripService.deleteTrip(id);
    }

    /* @Operation(summary = "Suppression d'une sortie à partir de son identifiant")
    @RequestMapping(path = "/{id}/addUser", method = RequestMethod.POST)
    public void addUserToTrip(@PathVariable(value = "id") String userId, @RequestBody Long tripId) {
        tripService.addUserToTrip(userId, tripId);
    }*/
}
