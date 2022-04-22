package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.dtos.EducationDto;

import javax.print.DocFlavor;
import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getAll();
    Result add(EducationDto educationDto);
    Result delete(EducationDto educationDto);
    Result update(EducationDto educationDto);


}
