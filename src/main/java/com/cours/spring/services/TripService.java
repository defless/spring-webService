package com.cours.spring.services;

import com.cours.spring.entities.Trip;
import com.cours.spring.entities.User;
import com.cours.spring.repositories.TripRepository;
import com.cours.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    public Trip createOrUpdate(Trip trip) {
        return tripRepository.save(trip);
    }
    public Trip getTripById(Long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    /* public Trip addUserToTrip(String userId, Long tripId) {
        User user = userRepository.findById(userId).orElse(null);
        Trip trip = tripRepository.findById(tripId).orElse(null);
        List<User> usersList = trip.getUsers();
        usersList.add(user);
        return tripRepository.save(trip);

    }*/
}
