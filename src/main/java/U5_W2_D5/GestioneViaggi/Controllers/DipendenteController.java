package U5_W2_D5.GestioneViaggi.Controllers;

import U5_W2_D5.GestioneViaggi.Service.DipendenteService;
import U5_W2_D5.GestioneViaggi.entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    // Crea un nuovo dipendente
    @PostMapping("/crea")
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.getDipendenti(dipendente);
    }

    // Ottieni tutti i dipendenti
    @GetMapping("/")
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    // Ottieni un dipendente per ID
    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable Long id) {
        return dipendenteService.getDipendenteById(id);
    }

    // Aggiorna un dipendente
    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        return dipendenteService.updateDipendente(id, dipendente);
    }

    // Elimina un dipendente
    @DeleteMapping("/{id}")
    public boolean deleteDipendente(@PathVariable Long id) {
        return dipendenteService.deleteDipendente(id);
    }
}

