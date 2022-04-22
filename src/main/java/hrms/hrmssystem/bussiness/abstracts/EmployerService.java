package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Employer;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.EducationDto;
import hrms.hrmssystem.entities.dtos.EmployerDto;

import javax.print.DocFlavor;
import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result add(EmployerDto employerDto);
    Result delete(EmployerDto employerDto);
    Result update(EmployerDto employerDto);



    SuccessDataResult<EmployerDto>findByEmployerEmail(String employerEmail);

}
