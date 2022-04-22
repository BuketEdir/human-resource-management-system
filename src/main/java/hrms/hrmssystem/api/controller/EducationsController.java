package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.EducationService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/education")
@RestController
@CrossOrigin
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

  /*  @GetMapping("/getByResumeId")
    public Result getByResumeId(int resumeId){

        return this.educationService.getEducationWithResume(resumeId);
    }*/

    @PostMapping("/add")
    public Result add(@RequestBody EducationDto educationDto){
        return this.educationService.add(educationDto);
    }


    @DeleteMapping("/delete/{id}")
    public Result delete(EducationDto educationDto){
        return  this.educationService.delete(educationDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody EducationDto educationDto, @PathVariable int id){
        educationDto.setId(id);
        return  this.educationService.update(educationDto);

    }


}
