package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.JobAnnouncementService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.JobAnnouncementDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.JobAnnouncement;
import hrms.hrmssystem.entities.concretes.JobApplication;
import hrms.hrmssystem.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAnnouncementManager implements JobAnnouncementService {

    private JobAnnouncementDao jobAnnouncementDao;

    @Autowired
    public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao){
        this.jobAnnouncementDao=jobAnnouncementDao;
    }


  /*  @Override
    public DataResult<List<JobAnnouncement>> getAll() {
        return new SuccessDataResult<List<JobAnnouncement>>
                (this.jobAnnouncementDao.findAll(), "List of Job Announcement");
    }*/




    @Override
    public DataResult<List<JobAnnouncement>> getAll() {
        List<JobAnnouncementDto> jobAnnouncementDtoList = jobAnnouncementDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<JobAnnouncement>>
                (this.jobAnnouncementDao.findAll(), "List of job announcements");

    }

    private JobAnnouncementDto convertEntityToDto(JobAnnouncement jobAnnouncement) {
        JobAnnouncementDto jobAnnouncementDto = new JobAnnouncementDto();
        jobAnnouncementDto.setId(jobAnnouncement.getId());
        jobAnnouncementDto.setJobDescription(jobAnnouncement.getJobDescription());
        jobAnnouncementDto.setMinSalary(jobAnnouncement.getMinSalary());
        jobAnnouncementDto.setMaxSalary(jobAnnouncement.getMaxSalary());
        jobAnnouncementDto.setNumberOfOpenPosition(jobAnnouncement.getNumberOfOpenPositions());
        jobAnnouncementDto.setDeadline(jobAnnouncement.getDeadline());
        return jobAnnouncementDto;
    }



    @Override
    public Result add(JobAnnouncementDto jobAnnouncementDto){
        JobAnnouncement jobAnnouncement=new JobAnnouncement();
        jobAnnouncement.setJobDescription(jobAnnouncementDto.getJobDescription());
        jobAnnouncement.setDeadline(jobAnnouncementDto.getDeadline());
        jobAnnouncement.setId(jobAnnouncementDto.getId());
        jobAnnouncement.setMinSalary(jobAnnouncementDto.getMinSalary());
        jobAnnouncement.setMaxSalary(jobAnnouncementDto.getMaxSalary());
        jobAnnouncement.setNumberOfOpenPositions(jobAnnouncementDto.getNumberOfOpenPosition());

      this.jobAnnouncementDao.save(jobAnnouncement);
      return new SuccessResult("The announcement added");
    }

    @Override
    public Result delete(JobAnnouncementDto jobAnnouncementDto) {
        JobAnnouncement jobAnnouncement=new JobAnnouncement();
        jobAnnouncement.setJobDescription(jobAnnouncementDto.getJobDescription());
        jobAnnouncement.setDeadline(jobAnnouncementDto.getDeadline());
        jobAnnouncement.setId(jobAnnouncementDto.getId());
        jobAnnouncement.setMinSalary(jobAnnouncementDto.getMinSalary());
        jobAnnouncement.setMaxSalary(jobAnnouncementDto.getMaxSalary());
        jobAnnouncement.setNumberOfOpenPositions(jobAnnouncementDto.getNumberOfOpenPosition());

        this.jobAnnouncementDao.delete(jobAnnouncement);
        return new SuccessResult("The announcement deleted");

    }

    @Override
    public Result update(JobAnnouncementDto jobAnnouncementDto) {
        JobAnnouncement jobAnnouncement=this.jobAnnouncementDao.getById(jobAnnouncementDto.getId());
        jobAnnouncement.setJobDescription(jobAnnouncementDto.getJobDescription());
        jobAnnouncement.setDeadline(jobAnnouncementDto.getDeadline());
        jobAnnouncement.setId(jobAnnouncementDto.getId());
        jobAnnouncement.setMinSalary(jobAnnouncementDto.getMinSalary());
        jobAnnouncement.setMaxSalary(jobAnnouncementDto.getMaxSalary());
        jobAnnouncement.setNumberOfOpenPositions(jobAnnouncementDto.getNumberOfOpenPosition());

        this.jobAnnouncementDao.save(jobAnnouncement);
        return new SuccessResult("The announcement updated");

    }



   /* @Override
    public DataResult<List<JobAnnouncement>> listbyEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAnnouncement>>(jobAnnouncementDao.findJobAnnouncementByEmployer_EmployerId(employerId));
    }*/



    }








    /*@Override
    public DataResult<List<JobAnnouncement>> getAllByIsActiveTrue() {
        return new SuccessDataResult<List<JobAnnouncement>>
                (this.jobAnnouncementDao.getAllByIsActiveTrue(),"List of all active job announcements");
    }
*/




