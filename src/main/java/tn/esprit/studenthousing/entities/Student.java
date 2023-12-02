package tn.esprit.studenthousing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends BaseEntity {

    String firstName;
    String lastName;
    long inc;
    LocalDate birthDate;

    @JsonBackReference
    @ManyToMany(mappedBy = "studentList")
    List<Booking> bookingList;
}
