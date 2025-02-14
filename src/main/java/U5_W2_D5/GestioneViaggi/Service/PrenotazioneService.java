package U5_W2_D5.GestioneViaggi.Service;

import U5_W2_D5.GestioneViaggi.Repository.DipendenteRepository;
import U5_W2_D5.GestioneViaggi.Repository.PrenotazioneRepository;
import U5_W2_D5.GestioneViaggi.Repository.ViaggioRepository;
import U5_W2_D5.GestioneViaggi.entities.Prenotazione;
import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    // Creazione di una nuova prenotazione
    public Prenotazione createPrenotazione(Long dipendenteId, Long viaggioId, Prenotazione prenotazione) {
        Optional<Dipendente> dipendente = dipendenteRepository.findById(dipendenteId);
        Optional<Viaggio> viaggio = viaggioRepository.findById(viaggioId);

        if (dipendente.isPresent() && viaggio.isPresent()) {
            prenotazione.setDipendente(dipendente.get());
            prenotazione.setViaggio(viaggio.get());
            return prenotazioneRepository.save(prenotazione);
        }
        return null;
    }

    // Recupera tutte le prenotazioni per un dipendente
    public List<Prenotazione> getPrenotazioniByDipendente(Long dipendenteId) {
        return prenotazioneRepository.findByDipendenteId(dipendenteId);
    }

    // Recupera tutte le prenotazioni per un viaggio
    public List<Prenotazione> getPrenotazioniByViaggio(Long viaggioId) {
        return prenotazioneRepository.findByViaggioId(viaggioId);
    }

    // Aggiorna una prenotazione
    public Prenotazione updatePrenotazione(Long id, Prenotazione prenotazioneDetails) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);

        if (prenotazione.isPresent()) {
            Prenotazione updatedPrenotazione = prenotazione.get();
            updatedPrenotazione.setDataRichiesta(prenotazioneDetails.getDataRichiesta());
            updatedPrenotazione.setNote(prenotazioneDetails.getNote());
            return prenotazioneRepository.save(updatedPrenotazione);
        } else {
            return null;
        }
    }

    // Elimina una prenotazione
    public boolean deletePrenotazione(Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);

        if (prenotazione.isPresent()) {
            prenotazioneRepository.delete(prenotazione.get());
            return true;
        }
        return false;
    }
}

