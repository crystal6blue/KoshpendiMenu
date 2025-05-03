package com.project.koshpendimenu1.Service.DeliverService;


import com.project.koshpendimenu1.Model.Deliver;

import java.util.Optional;

public interface IDeliverService {
    // Add a new delivery
    Deliver addDeliver(Deliver deliver);

    // Update an existing delivery
    Deliver updateDeliver(Long id, Deliver updatedDeliver);

    // Delete a delivery by ID
    void deleteDeliver(Long id);

    // Fetch a delivery by ID
    Optional<Deliver> getDeliverById(Long id);

    // Fetch all deliveries
    Iterable<Deliver> getAllDelivers();
}
