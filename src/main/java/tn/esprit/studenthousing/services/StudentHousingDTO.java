package tn.esprit.studenthousing.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.entities.StudentHousing;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class StudentHousingDTO{


    private String housingName;
    private List<Block> blockList;

    public StudentHousingDTO(String housingName, List<Block> blockList) {
        this.housingName = housingName;
        this.blockList = blockList;
    }

    public StudentHousingDTO(StudentHousing studentHousing) {
        this.housingName = studentHousing.getHoustingName();
        this.blockList = studentHousing.getBlockList();
    }
}