package za.ac.cput.model;
/*Keewan Titus
230778577
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Connect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String title;

}
