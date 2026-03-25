package ie.atu.golfclubmanagerlrea;


import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/")
    public String loginPage(@RequestParam(required = false) String error) {

        String msg = (error != null) ? "<p style='color:red;'>Invalid login</p>" : "";

        return "<h2>Login</h2>" +
                msg +
                "<form action='/login' method='post'>" +
                "Username: <input name='username'><br><br>" +
                "Password: <input type='password' name='password'><br><br>" +
                "<button type='submit'>Login</button>" +
                "</form>";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if ((username.equals("Liam") && password.equals("Buggy1")) ||
                (username.equals("Paraic") && password.equals("Buggy1"))) {

            return "<meta http-equiv='refresh' content='0;url=/home'>";
        }

        return "<meta http-equiv='refresh' content='0;url=/?error=true'>";
    }
}
