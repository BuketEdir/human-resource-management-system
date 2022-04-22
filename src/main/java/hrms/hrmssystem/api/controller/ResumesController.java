package hrms.hrmssystem.api.controller;


import hrms.hrmssystem.bussiness.abstracts.ResumeService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Resume;
import hrms.hrmssystem.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {
    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }

    /*@GetMapping("/getAllByCandidateId")
    public DataResult<List<Resume>> getAllByCandidateId( int id){

        return this.resumeService.getResumeByCandidateId(id);
    }*/


 /*   @GetMapping("/getAllInfoById")
    public DataResult<List<ResumeDto>> getResumeWithAllInformations(){

        return this.resumeService.getResumeWithAllInformations();
    }*/

    @DeleteMapping("/delete/{id}")
    public Result delete(ResumeDto resumeDto){
        return  this.resumeService.delete(resumeDto);
    }

    @PostMapping("/add")
    public Result add(@RequestBody ResumeDto resumeDto){
        return this.resumeService.add(resumeDto);
    }


    @GetMapping("/getResumeWithEducationDetails")
    public DataResult<List<ResumeWithEducationDto>> getResumeWithEducationDetails() {

        return this.resumeService.getResumeWithEducationDetails();
    }
    @GetMapping("/getResumeWithLanguageDetails")
    public DataResult<List<ResumeWithLanguageDto>> getResumeWithLanguageDetails() {

        return this.resumeService.getResumeWithLanguageDetails();
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody ResumeDto resumeDto, @PathVariable int id){
        resumeDto.setId(id);
        return  this.resumeService.update(resumeDto);

    }


}
