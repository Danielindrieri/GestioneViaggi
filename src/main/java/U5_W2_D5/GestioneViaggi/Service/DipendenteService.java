package U5_W2_D5.GestioneViaggi.Service;

import U5_W2_D5.GestioneViaggi.Repository.DipendenteRepository;
import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class DipendenteService {
    private final DipendenteRepository repository;

    // Metodo per salvare un nuovo Dipendente
    public Dipendente save(Dipendente body) {
        // Controllo se l'email è già registrata
        repository.findByEmail(body.getEmail()).ifPresent(user -> {
            throw new IllegalArgumentException("L'email " + body.getEmail() + " è già stata utilizzata");
        });

        // Creazione avatar
        if (body.getName() != null && body.getUsername() != null) {
            body.setAvatar("https://ui-avatars.com/api/?name=" +
                    body.getName().charAt(0) + "+" + body.getUsername().charAt(0));
        }

        // Salvataggio del Dipendente
        return repository.save(body);
    }

    // Metodo per ottenere una lista paginata di Dipendenti
    public Page<Viaggio> getDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repository.findAll(pageable);
    }

    // Metodo per trovare un Dipendente per ID
    public Dipendente  findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
