package U5_W2_D5.GestioneViaggi.Service;
import U5_W2_D5.GestioneViaggi.Repository.DipendenteRepository;
import U5_W2_D5.GestioneViaggi.Repository.PrenotazioneRepository;
import U5_W2_D5.GestioneViaggi.Repository.ViaggioRepository;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import U5_W2_D5.GestioneViaggi.entities.Prenotazione;
import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final DipendenteRepository dipendenteRepository;

    // Creazione di un nuovo viaggio
    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    // Recupero tutti i viaggi
    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    // Recupero un viaggio per ID
    public Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Viaggio con ID " + id + " non trovato"));
    }

    // Aggiorna stato viaggio
    public Viaggio updateViaggio(Long id, Viaggio viaggioDetails) {
        Viaggio viaggio = getViaggioById(id);
        viaggio.setDestinazione(viaggioDetails.getDestinazione());
        viaggio.setDataPartenza(viaggioDetails.getDataPartenza());
        viaggio.setDataRitorno(viaggioDetails.getDataRitorno());
        viaggio.setStatoViaggio(viaggioDetails.getStatoViaggio());
        return viaggioRepository.save(viaggio);
    }

    // Aggiungi una prenotazione per un viaggio
    public Prenotazione addPrenotazione(Long dipendenteId, Long viaggioId, Prenotazione prenotazione) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId).orElseThrow(() -> new IllegalArgumentException("Dipendente con ID " + dipendenteId + " non trovato"));
        Viaggio viaggio = viaggioRepository.findById(viaggioId).orElseThrow(() -> new IllegalArgumentException("Viaggio con ID " + viaggioId + " non trovato"));

        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        return prenotazioneRepository.save(prenotazione);
    }

    // Recupero tutte le prenotazioni per un dipendente
    public List<Prenotazione> getPrenotazioniByDipendente(Long dipendenteId) {
        return prenotazioneRepository.findByDipendenteId(dipendenteId);
    }

    // Recupero tutte le prenotazioni per un viaggio
    public List<Prenotazione> getPrenotazioniByViaggio(Long viaggioId) {
        return prenotazioneRepository.findByViaggioId(viaggioId);
    }

    // Elimina un viaggio
    public boolean deleteViaggio(Long id) {
        Viaggio viaggio = getViaggioById(id);
        viaggioRepository.delete(viaggio);
        return true;
    }
}
