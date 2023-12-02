package tn.esprit.studenthousing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room extends BaseEntity {

    long roomNbr;

    @Enumerated(EnumType.STRING)
    RoomType roomType;

    @OneToMany
    List<Booking> bookingList;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    Block block;

}
