package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;

import java.util.List;

public interface CandidateService {
    SuccessDataResult<List<CandidateDto>> getAll();

    SuccessDataResult<CandidateDto> getById(int id);

    Result delete(CandidateDto candidateDto);

    Result add(CandidateDto candidateDto);

    Result update(CandidateDto candidateDto);

/*
    SuccessDataResult<CandidateDto> findByCandidateEmail(String candidateEmail);

    SuccessDataResult<CandidateDto> findByNationalityNo(String nationalityNo);

 */
DataResult<List<Candidate>> getByFirstNameContains(String firstName);
    DataResult<List<Candidate>> getAllSorted();

    DataResult<List<Candidate>> getByNameAndResume(String firstName, String lastName, int resumeId);


    // DataResult<CandidateCvDto> getCandidateCvById(int id);
    //  DataResult<Candidate> getCandidateByUserId(int userId);

}
