package ie.atu.golfclubmanagerlrea;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EquipmentController {

    private List<Equipment> equipmentList = new ArrayList<>();

    public EquipmentController() {
        equipmentList.add(new Equipment("Golf Buggy", "Transport", 29.99, true));
        equipmentList.add(new Equipment("Caddie", "Service", 19.99, true));
        equipmentList.add(new Equipment("Clubs", "Gear", 24.99, true));
        equipmentList.add(new Equipment("Balls", "Consumable", 7.99, true));
    }

    @GetMapping("/equipment")
    public String equipmentPage() {

        StringBuilder html = new StringBuilder("<h1>Equipment</h1><ul>");

        for (Equipment e : equipmentList) {
            html.append("<li>")
                    .append(e.name)
                    .append(" (€").append(e.price).append(") - ")
                    .append(e.available ? "Available" : "Rented");

            if (e.available) {
                html.append(" <a href='/rent?name=")
                        .append(e.name)
                        .append("'>Rent</a>");
            }

            html.append("</li>");
        }

        html.append("</ul><br><a href='/home'>Back</a>");

        return html.toString();
    }

    @GetMapping("/rent")
    public String rent(@RequestParam String name) {

        for (Equipment e : equipmentList) {
            if (e.name.equalsIgnoreCase(name) && e.available) {
                e.available = false;
                break;
            }
        }

        return "<meta http-equiv='refresh' content='0;url=/equipment'>";
    }
}
