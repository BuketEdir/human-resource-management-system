package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.JobApplicationService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.JobApplicationDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.JobApplication;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.JobAnnouncementDto;
import hrms.hrmssystem.entities.dtos.JobApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationManager implements JobApplicationService {

    private JobApplicationDao jobApplicationDao;

    @Autowired
    public JobApplicationManager(JobApplicationDao jobApplicationDao) {
        this.jobApplicationDao = jobApplicationDao;
    }

/*    @Override
    public DataResult<List<JobApplication>> getAll() {
        return new SuccessDataResult<List<JobApplication>>
                (this.jobApplicationDao.findAll(),"All Aplications");

    }*/

    @Override
    public DataResult<List<JobApplication>> getAll() {
        List<JobApplicationDto> jobApplicationDtoList = jobApplicationDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<JobApplication>>
                (this.jobApplicationDao.findAll(), "List of job applications");

    }

    private JobApplicationDto convertEntityToDto(JobApplication jobApplication) {
        JobApplicationDto jobApplicationDto = new JobApplicationDto();
        jobApplicationDto.setId(jobApplication.getId());
        jobApplicationDto.setFirstName(jobApplication.getFirstName());
        jobApplicationDto.setLastName(jobApplication.getLastName());
        return jobApplicationDto;
    }

    @Override
    public Result add(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication=new JobApplication();
        jobApplication.setId(jobApplicationDto.getId());
        jobApplication.setFirstName(jobApplicationDto.getFirstName());
        jobApplication.setLastName(jobApplicationDto.getLastName());
        this.jobApplicationDao.save(jobApplication);
        return new SuccessResult("Application added");
    }

    @Override
    public Result delete(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication=new JobApplication();
        jobApplication.setId(jobApplicationDto.getId());
        jobApplication.setFirstName(jobApplicationDto.getFirstName());
        jobApplication.setLastName(jobApplicationDto.getLastName());
        this.jobApplicationDao.delete(jobApplication);
        return new SuccessResult("Application deleted");

    }

    @Override
    public Result update(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication=this.jobApplicationDao.getById(jobApplicationDto.getId());

        jobApplication.setId(jobApplicationDto.getId());
        jobApplication.setFirstName(jobApplicationDto.getFirstName());
        jobApplication.setLastName(jobApplicationDto.getLastName());
        this.jobApplicationDao.save(jobApplication);
        return new SuccessResult("Application updated");
    }

    /*@Override
    public DataResult<List<JobApplication>> getApplicationByUserId(int id) {
        return new SuccessDataResult<List<JobApplication>>(this.jobApplicationDao.getJobApplicationsByCandidateId(id));
    }*/
}
