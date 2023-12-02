package tn.esprit.studenthousing.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking implements Serializable {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 20)
    private String id;

    LocalDate academicYear;
    Boolean isValid;

    @ManyToMany
    List<Student> studentList;
}
