package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Resume;
import hrms.hrmssystem.entities.dtos.ResumeDto;
import hrms.hrmssystem.entities.dtos.ResumeWithEducationDto;
import hrms.hrmssystem.entities.dtos.ResumeWithLanguageDto;

import javax.print.DocFlavor;
import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    Result add(ResumeDto resumeDto);

    Result delete(ResumeDto resumeDto);

    Result update(ResumeDto resumeDto);

    //DataResult<List<Resume>> getResumeByCandidateId(int id);
    //DataResult<List<ResumeDto>> getResumeWithAllInformations();

    DataResult<List<ResumeWithEducationDto>> getResumeWithEducationDetails();

    DataResult<List<ResumeWithLanguageDto>> getResumeWithLanguageDetails();
}
