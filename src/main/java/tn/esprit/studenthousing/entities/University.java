package tn.esprit.studenthousing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University extends BaseEntity {


    String universityName;
    String adresse;
    @OneToOne(fetch = FetchType.LAZY)
    StudentHousing studentHousing;

}
