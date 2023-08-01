package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Entity
@Data
public class BoardModel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
  String name;

}
