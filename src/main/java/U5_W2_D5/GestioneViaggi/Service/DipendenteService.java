package U5_W2_D5.GestioneViaggi.Service;

import U5_W2_D5.GestioneViaggi.Repository.DipendenteRepository;
import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


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
        return repository.save(body);
    }

    // Metodo per ottenere una lista paginata di Dipendenti
    public Page<Dipendente> getDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repository.findAll(pageable);
    }

    // Metodo per trovare un Dipendente per ID
    public Dipendente findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dipendente con ID " + id + " non trovato"));
    }

    // Metodo per aggiornare un Dipendente che già esiste
    public Dipendente findByIdAndUpdate(Long id, Dipendente body) {
        Dipendente found = findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setUsername(body.getUsername());
        found.setCognome(body.getCognome());
        return DipendenteRepository.save(found);
    }

    // Metodo per ottenere tutti i dipendenti
    public List<Viaggio> getAllDipendenti() {
        return repository.findAll();
    }

    // Metodo per ottenere un dipendente per ID
    public Dipendente getDipendenteById(Long id) {
        return findById(id);
    }

    // Metodo per aggiornare un dipendente
    public Dipendente updateDipendente(Long id, Dipendente dipendente) {
        return findByIdAndUpdate(id, dipendente);
    }

    // Metodo per eliminare un dipendente
    public boolean deleteDipendente(Long id) {
        Dipendente found = findById(id);
        repository.delete(found);
        return true;
    }
}
