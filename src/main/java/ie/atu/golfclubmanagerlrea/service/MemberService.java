package ie.atu.golfclubmanagerlrea.service;

import ie.atu.golfclubmanagerlrea.model.Member;
import ie.atu.golfclubmanagerlrea.model.MemberStatus;
import ie.atu.golfclubmanagerlrea.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member registerMember(Member member) {
        if (repository.findByEmail(member.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(member);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMemberById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Member updateProfile(Long id, Member updatedMember) {
        Member member = getMemberById(id);

        member.setFullName(updatedMember.getFullName());
        member.setPhoneNumber(updatedMember.getPhoneNumber());

        return repository.save(member);
    }

    public Member updateStatus(Long id, MemberStatus status) {
        Member member = getMemberById(id);
        member.setStatus(status);
        return repository.save(member);
    }
}
