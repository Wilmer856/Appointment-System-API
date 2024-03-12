package dev.api.appointments.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join t.userAccounts u
      WHERE u.userId = :id AND (t.expired = false OR t.revoked = false)
      """)
    List<Token> findAllValidTokenByUser(long id);

    Optional<Token> findByToken(String token);
}
