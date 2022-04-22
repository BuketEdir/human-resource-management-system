package hrms.hrmssystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {
    private int id;
    private String companyName;
    private String position;
    private Date startYear;
    private Date quitYear;
    private boolean isContinues;

}
