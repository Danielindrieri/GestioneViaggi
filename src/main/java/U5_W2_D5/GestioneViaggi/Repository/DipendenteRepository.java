package U5_W2_D5.GestioneViaggi.Repository;

import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Viaggio, Long> {
    static Dipendente save(Dipendente found) {
        return found;
    }

    Optional<Viaggio> findByEmail(String email);
}

