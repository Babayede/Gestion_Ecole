package ecole.gestion.repository;

import java.util.Optional;
import ecole.gestion.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
        Optional<AppUser> findByUsername(String username);
}
