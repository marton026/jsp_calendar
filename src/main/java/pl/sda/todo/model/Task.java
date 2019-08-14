package pl.sda.todo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.commons.repository.DomainEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Task implements DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private LocalDate date;
    private Boolean completed;

}
