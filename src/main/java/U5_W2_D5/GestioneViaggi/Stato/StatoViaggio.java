package U5_W2_D5.GestioneViaggi.Stato;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public enum StatoViaggio {
    IN_PROGRAMMA("In Programma"),
    COMPLETATO("Completato");

    private String Descrizione;
}
