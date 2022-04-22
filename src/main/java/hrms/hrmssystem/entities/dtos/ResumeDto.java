package hrms.hrmssystem.entities.dtos;

import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Experience;
import hrms.hrmssystem.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private int id;
    private String gitHubAddress;
    private String linkedinAddress;
    private String coverLetter;



}
