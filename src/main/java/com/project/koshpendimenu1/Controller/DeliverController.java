package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Deliver;
import com.project.koshpendimenu1.Service.DeliverService.IDeliverService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliverController {

    private final IDeliverService deliverService;

    public DeliverController(IDeliverService deliverService) {
        this.deliverService = deliverService;
    }

    // Add a new delivery
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Deliver addDeliver(@RequestBody Deliver deliver) {
        return deliverService.addDeliver(deliver);
    }

    // Get a delivery by ID
    @GetMapping("/{id}")
    public Optional<Deliver> getDeliverById(@PathVariable Long id) {
        return deliverService.getDeliverById(id);
    }

    // Get all deliveries
    @GetMapping
    public Iterable<Deliver> getAllDelivers() {
        return deliverService.getAllDelivers();
    }

    // Update an existing delivery
    @PutMapping("/{id}")
    public Deliver updateDeliver(@PathVariable Long id, @RequestBody Deliver updatedDeliver) {
        return deliverService.updateDeliver(id, updatedDeliver);
    }

    // Delete a delivery by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeliver(@PathVariable Long id) {
        deliverService.deleteDeliver(id);
    }
}
