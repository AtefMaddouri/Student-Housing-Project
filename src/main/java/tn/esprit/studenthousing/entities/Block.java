package tn.esprit.studenthousing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Block extends BaseEntity {

    String blockName;
    long blockCapacite;

    @OneToMany(mappedBy = "block")
    List<Room> roomList;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    StudentHousing studentHousing;
}
