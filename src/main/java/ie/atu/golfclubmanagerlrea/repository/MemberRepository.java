package ie.atu.golfclubmanagerlrea.repository;

import ie.atu.golfclubmanagerlrea.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
