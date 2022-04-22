package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.JobAnnouncement;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import hrms.hrmssystem.entities.dtos.JobAnnouncementDto;
import hrms.hrmssystem.entities.dtos.JobApplicationDto;

import java.util.Date;
import java.util.List;

public interface JobAnnouncementService {
    DataResult<List<JobAnnouncement>> getAll();
    Result add(JobAnnouncementDto jobAnnouncementDto);

    Result delete(JobAnnouncementDto jobAnnouncementDto);
    Result update(JobAnnouncementDto jobAnnouncementDto);

   // DataResult<List<JobAnnouncement>> listbyEmployerId(int employerId);

    //DataResult<List<JobAnnouncement>> getAllByIsActiveTrue();

  //  DataResult<List<JobAnnouncementDto>> getAllByIsActiveTrue();



}
