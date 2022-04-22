package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Experience;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import hrms.hrmssystem.entities.dtos.ExperienceDto;

import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getAll();
    Result add(ExperienceDto experienceDto);
    Result delete(ExperienceDto experienceDto);

    Result update(ExperienceDto experienceDto);
  //  DataResult<List<Experience>> getByResumeId(int resumeId);
    DataResult<List<Experience>> getByNameAndResume(String companyName, String position, int resumeId);


}
