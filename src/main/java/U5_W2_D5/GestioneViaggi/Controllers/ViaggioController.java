package U5_W2_D5.GestioneViaggi.Controllers;
import U5_W2_D5.GestioneViaggi.Service.ViaggioService;
import U5_W2_D5.GestioneViaggi.entities.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    // Crea un nuovo viaggio
    @PostMapping("/crea")
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.createViaggio(viaggio);
    }

    // Ottieni tutti i viaggi
    @GetMapping("/")
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    // Ottieni un viaggio per ID
    @GetMapping("/{id}")
    public Optional<Viaggio> getViaggioById(@PathVariable Long id) {
        return Optional.ofNullable(viaggioService.getViaggioById(id));
    }

    // Aggiorna un viaggio
    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggio) {
        return viaggioService.updateViaggio(id, viaggio);
    }

    // Elimina un viaggio
    @DeleteMapping("/{id}")
    public boolean deleteViaggio(@PathVariable Long id) {
        return viaggioService.deleteViaggio(id);
    }
}
