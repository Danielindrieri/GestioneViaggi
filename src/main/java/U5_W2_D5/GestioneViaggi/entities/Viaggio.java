package U5_W2_D5.GestioneViaggi.entities;

import U5_W2_D5.GestioneViaggi.Stato.StatoViaggio;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "viaggio")
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "destinazione")
    private String destinazione;

    @Column(name = "data_partenza")
    private Date dataPartenza;

    @Column(name = "data_ritorno")
    private Date dataRitorno;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato_viaggio")
    private StatoViaggio statoViaggio;

    public String getEmail() {
        return "";
    }
}