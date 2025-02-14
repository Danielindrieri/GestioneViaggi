package U5_W2_D5.GestioneViaggi.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table (name = "dipendente")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
}
