package ie.atu.golfclubmanagerlrea;


import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "<h1>Welcome to Golf Club Manager Loughrea </h1>" +
                "<a href='/equipment'><button>Go to Equipment</button></a>";
    }
}