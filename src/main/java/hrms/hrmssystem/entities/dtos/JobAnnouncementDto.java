package hrms.hrmssystem.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAnnouncementDto {
    private int id;
    private String jobDescription;
    private int numberOfOpenPosition;
    private Date deadline;
    private double minSalary;
    private double maxSalary;
    private boolean isActive;
}
