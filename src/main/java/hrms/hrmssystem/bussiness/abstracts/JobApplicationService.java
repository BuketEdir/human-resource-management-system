package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.JobAnnouncement;
import hrms.hrmssystem.entities.concretes.JobApplication;
import hrms.hrmssystem.entities.dtos.JobApplicationDto;

import java.util.List;

public interface JobApplicationService {
    DataResult<List<JobApplication>> getAll();
    Result add(JobApplicationDto jobApplicationDto);
   // DataResult<List<JobApplication>> getApplicationByUserId(int id);

    Result delete(JobApplicationDto jobApplicationDto);

    Result update(JobApplicationDto jobApplicationDto);

}
