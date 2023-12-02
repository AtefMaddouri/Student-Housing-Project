package tn.esprit.studenthousing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentHousing extends BaseEntity{

    String houstingName;
    long houstingCapacity;

    @OneToMany(mappedBy = "studentHousing")
    List<Block> blockList;

    @OneToOne(mappedBy = "studentHousing",fetch = FetchType.LAZY)
    University university;

}
