package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.ExperienceService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Experience;
import hrms.hrmssystem.entities.dtos.EducationDto;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import hrms.hrmssystem.entities.dtos.ExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {

    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> getAll(){
        return this.experienceService.getAll();
    }

   /* @GetMapping("/getByResumeId")
    public DataResult<List<Experience>> getByResumeId(int resumeId){
        return this.experienceService.getByResumeId(resumeId);
    }*/

    @PostMapping("/add")
    public Result add(@RequestBody ExperienceDto experienceDto){
        return this.experienceService.add(experienceDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(ExperienceDto experienceDto){
        return  this.experienceService.delete(experienceDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody ExperienceDto experienceDto, @PathVariable int id){
        experienceDto.setId(id);
        return  this.experienceService.update(experienceDto);

    }


    @GetMapping("/getByNameAndResume")
    public DataResult<List<Experience>>
    getByNameAndResume(@RequestParam("companyName") String companyName,@RequestParam("position") String position,
                       @RequestParam("resumeId") int resumeId){
        return this.experienceService.getByNameAndResume(companyName,position,resumeId);
    }
}
