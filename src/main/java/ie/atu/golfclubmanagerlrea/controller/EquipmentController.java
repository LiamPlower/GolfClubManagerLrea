package ie.atu.golfclubmanagerlrea.controller;


import ie.atu.golfclubmanagerlrea.model.Equipment;
import ie.atu.golfclubmanagerlrea.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(EquipmentService service) { this.service = service; }

    @PostMapping
    public Equipment add(@RequestBody Equipment eq) { return service.addEquipment(eq); }

    @GetMapping
    public List<Equipment> getAll() { return service.getAll(); }

    @PostMapping("/rent")
    public Equipment rent(@RequestParam String name) { return service.rentEquipment(name); }
}