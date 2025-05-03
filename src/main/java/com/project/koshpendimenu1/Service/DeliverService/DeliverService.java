package com.project.koshpendimenu1.Service.DeliverService;

import com.project.koshpendimenu1.Model.Deliver;
import com.project.koshpendimenu1.Repository.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliverService implements IDeliverService {

    private final DeliverRepository deliverRepository;

    @Autowired
    public DeliverService(DeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }

    // Add a new delivery
    @Override
    public Deliver addDeliver(Deliver deliver) {
        return deliverRepository.save(deliver);
    }

    // Update an existing delivery
    @Override
    public Deliver updateDeliver(Long id, Deliver updatedDeliver) {
        if (deliverRepository.existsById(id)) {
            updatedDeliver.setId(id);
            return deliverRepository.save(updatedDeliver);
        }
        return null; // or throw an exception if the delivery does not exist
    }

    // Delete a delivery by ID
    @Override
    public void deleteDeliver(Long id) {
        if (deliverRepository.existsById(id)) {
            deliverRepository.deleteById(id);
        }
    }

    // Fetch a delivery by ID
    @Override
    public Optional<Deliver> getDeliverById(Long id) {
        return deliverRepository.findById(id);
    }

    // Fetch all deliveries
    @Override
    public Iterable<Deliver> getAllDelivers() {
        return deliverRepository.findAll();
    }
}

