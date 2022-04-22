package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.ResumeService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.ResumeDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Resume;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.ResumeDto;
import hrms.hrmssystem.entities.dtos.ResumeWithEducationDto;
import hrms.hrmssystem.entities.dtos.ResumeWithLanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

   /* @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
    }
*/

    @Override
    public DataResult<List<Resume>> getAll() {
        List<ResumeDto> resumeDtoList = resumeDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Resume>>
                (this.resumeDao.findAll(), "List of resumes");

    }

    private ResumeDto convertEntityToDto(Resume resume) {
        ResumeDto resumeDto=new ResumeDto();
        resumeDto.setId(resume.getId());
        resumeDto.setCoverLetter(resume.getCoverLetter());
        resumeDto.setGitHubAddress(resume.getGitHubAddress());
        resumeDto.setLinkedinAddress(resume.getLinkedinAddress());
        return resumeDto;
    }


    @Override
    public Result add(ResumeDto resumeDto) {
        Resume resume=new Resume();
        resume.setId(resumeDto.getId());
        resume.setCoverLetter(resumeDto.getCoverLetter());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        resume.setGitHubAddress(resumeDto.getGitHubAddress());
        this.resumeDao.save(resume);
        return new SuccessResult("Resume added");
    }

    @Override
    public Result delete(ResumeDto resumeDto) {
        Resume resume=new Resume();
        resume.setId(resumeDto.getId());
        resume.setCoverLetter(resumeDto.getCoverLetter());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        resume.setGitHubAddress(resumeDto.getGitHubAddress());
        this.resumeDao.delete(resume);
        return new SuccessResult("Resume deleted");

    }

    @Override
    public Result update(ResumeDto resumeDto) {
        Resume resume=this.resumeDao.getById(resumeDto.getId());
        resume.setId(resumeDto.getId());
        resume.setCoverLetter(resumeDto.getCoverLetter());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        resume.setGitHubAddress(resumeDto.getGitHubAddress());
        this.resumeDao.save(resume);
        return new SuccessResult("Resume updated");

    }

    @Override
    public DataResult<List<ResumeWithEducationDto>> getResumeWithEducationDetails() {
        return new SuccessDataResult<List<ResumeWithEducationDto>>
                (this.resumeDao.getResumeWithEducationDetails(),"Data Listelendi");
    }

    @Override
    public DataResult<List<ResumeWithLanguageDto>> getResumeWithLanguageDetails() {
        return new SuccessDataResult<List<ResumeWithLanguageDto>>
                (this.resumeDao.getResumeWithLanguageDetails());
    }

  /*  @Override
    public DataResult<List<Resume>> getResumeByCandidateId(int id) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findResumeByCandidate_Id(id));
    }*/

    /*@Override
    public DataResult<List<ResumeDto>> getResumeWithAllInformations() {
        return null;
    }*/




   /* @Override
    public DataResult<List<ResumeWithAllInformationsDto>> getResumeWithAllInformations(int jobSeekerId) {
        return new SuccessDataResult<List<ResumeWithAllInformationsDto>>(this.resumeDao.getResumesByJobSeekers_Id(jobSeekerId));
    }*/
}
