package hrms.hrmssystem.api.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.hrmssystem.bussiness.abstracts.JobAnnouncementService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.JobAnnouncement;
import hrms.hrmssystem.entities.dtos.ExperienceDto;
import hrms.hrmssystem.entities.dtos.JobAnnouncementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAnnouncements")
@CrossOrigin

public class JobAnnouncementsController {

    private JobAnnouncementService jobAnnouncementService;

    @Autowired
    public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService){
        this.jobAnnouncementService=jobAnnouncementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAnnouncement>> getAll(){
        return this.jobAnnouncementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestParam JobAnnouncementDto jobAnnouncementDto){
        return this.jobAnnouncementService.add(jobAnnouncementDto);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@RequestParam JobAnnouncementDto jobAnnouncementDto){
        return this.jobAnnouncementService.delete(jobAnnouncementDto);}

    @PutMapping("/update/{id}")
    public Result update(@RequestBody JobAnnouncementDto jobAnnouncementDto, @PathVariable int id){
        jobAnnouncementDto.setId(id);
        return  this.jobAnnouncementService.update(jobAnnouncementDto);

    }


  /*  @GetMapping("/getAllActiveJobAnnouncements")
    public DataResult<List<JobAnnouncement>> getAllByIsActiveTrue(){
        return this.jobAnnouncementService.getAllByIsActiveTrue();
    }
*/
   /* @GetMapping("/listbyEmployerId")
    public DataResult<List<JobAnnouncement>> getJobAnnouncementByEmployerId(int employerId){
        return this.jobAnnouncementService.listbyEmployerId(employerId);
    }*/


}
