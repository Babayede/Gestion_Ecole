package ecole.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ecole.gestion.repository.CoursRepository;
import ecole.gestion.repository.EtudiantRepository;
import ecole.gestion.repository.InscriptionRepository;
import ecole.gestion.repository.ProfesseurRepository;
import ecole.gestion.repository.AppUserRepository;
import ecole.gestion.entity.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@ComponentScan(basePackages= {"ecole.gestion"})
@EntityScan(basePackages = "ecole.gestion.entity")
public class GestionApplication implements CommandLineRunner {
	private final CoursRepository crepository;
	private final EtudiantRepository erepository;
	private final InscriptionRepository irepository;
	private final ProfesseurRepository prepository;
	private final AppUserRepository urepository;

	public GestionApplication(CoursRepository crepository,
							  EtudiantRepository erepository,
							  InscriptionRepository irepository,
							  ProfesseurRepository prepository,
							  AppUserRepository urepository) {
		this.crepository = crepository;
		this.erepository = erepository;
		this.irepository = irepository;
		this.prepository = prepository;
		this.urepository = urepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Username: user, password: user
		urepository.save(new AppUser("user", "$2a$10$dPpzV7SvNf13evgF.UjxeeEltfcvIxNZenZ5mwPErT6rqqp.yzLNC", "USER"));
		// Username: admin, password: admin
		urepository.save(new AppUser("admin", "$2a$10$v2zIX3E64Lq0CNuqIEKqbOwxO3aG3hWrBxdaafIqnL.XEJsvfds1G", "ADMIN"));
	}
}
