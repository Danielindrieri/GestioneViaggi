package U5_W2_D5.GestioneViaggi.Payloads;

import lombok.Getter;

@Getter
public class NuovaPrenotazioneViaggio {
    private Long dipendenteId; // ID del dipendente che sta prenotando
    private Long viaggioId;    // ID del viaggio che viene prenotato
    private String dataRichiesta; // Data della prenotazione ("yyyy-MM-dd")
    private String note;
}
