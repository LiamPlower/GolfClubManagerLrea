package ie.atu.golfclubmanagerlrea.controller;

import ie.atu.golfclubmanagerlrea.model.Member;
import ie.atu.golfclubmanagerlrea.model.MemberStatus;
import ie.atu.golfclubmanagerlrea.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Member register(@Valid @RequestBody Member member) {
        return service.registerMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping("/{id}/profile")
    public Member updateProfile(@PathVariable Long id, @RequestBody Member member) {
        return service.updateProfile(id, member);
    }

    @PutMapping("/{id}/status")
    public Member updateStatus(@PathVariable Long id, @RequestParam MemberStatus status) {
        return service.updateStatus(id, status);
    }
}
