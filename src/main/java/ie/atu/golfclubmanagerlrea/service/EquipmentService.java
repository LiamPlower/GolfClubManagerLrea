package ie.atu.golfclubmanagerlrea.service;

import ie.atu.golfclubmanagerlrea.exceptions.EquipmentConflictException;
import ie.atu.golfclubmanagerlrea.exceptions.EquipmentNotFoundException;
import ie.atu.golfclubmanagerlrea.model.Equipment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    private final List<Equipment> equipmentList = new ArrayList<>();
    private long nextId = 1;

    public Equipment addEquipment(Equipment eq) {
        eq.setId(nextId++);
        equipmentList.add(eq);
        return eq;
    }

    public List<Equipment> getAll() {
        return equipmentList;
    }

    public Equipment rentEquipment(String name) {
        Equipment eq = equipmentList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found"));

        if (!eq.isAvailable()) {
            throw new EquipmentConflictException("Equipment already rented");
        }
        eq.setAvailable(false);
        return eq;
    }
}
