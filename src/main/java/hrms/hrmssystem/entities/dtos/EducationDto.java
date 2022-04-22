package hrms.hrmssystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
    private int id;
    private String schoolName;
    private String department;
    private Date startYear;
    private Date greduateYear;


}
