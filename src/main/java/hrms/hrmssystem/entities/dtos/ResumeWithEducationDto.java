package hrms.hrmssystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWithEducationDto {
    private int id;
    private String schoolName;
    private String department;


}
