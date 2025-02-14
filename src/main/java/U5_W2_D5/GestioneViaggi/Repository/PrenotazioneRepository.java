package U5_W2_D5.GestioneViaggi.Repository;

import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Viaggio, Long> {
    Optional<Viaggio> findById(Long id);
}