package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.JobApplicationService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.JobApplication;
import hrms.hrmssystem.entities.dtos.JobAnnouncementDto;
import hrms.hrmssystem.entities.dtos.JobApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")

public class JobApplicationsController {
    private JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationsController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestParam JobApplicationDto jobApplicationDto){
        return this.jobApplicationService.delete(jobApplicationDto);}

/*
    @GetMapping("/getApplicationsByUserId")
    public DataResult<List<JobApplication>> getApplicationsByUserId(int id){
        return jobApplicationService.getApplicationByUserId(id);
    }*/

    @PostMapping("/add")
    public Result addApplication(@RequestBody JobApplicationDto jobApplicationDto){
        return this.jobApplicationService.add(jobApplicationDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody JobApplicationDto jobApplicationDto, @PathVariable int id){
        jobApplicationDto.setId(id);
        return  this.jobApplicationService.update(jobApplicationDto);

    }

}
