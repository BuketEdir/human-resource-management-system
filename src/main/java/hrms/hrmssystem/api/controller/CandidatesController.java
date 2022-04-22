package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.CandidateService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.ErrorDataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

    @Autowired
    private CandidateService candidateService;



    @GetMapping("/getAll")
    public SuccessDataResult<List<CandidateDto>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("/getByFirstNameContains")
    public  DataResult<List<Candidate>> getByFirstNameContains(@RequestParam String firstName){
        return this.candidateService.getByFirstNameContains(firstName);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CandidateDto candidateDto) {
        return this.candidateService.add(candidateDto);
    }


    @PutMapping("/update/{id}")
    public Result update(@RequestBody CandidateDto candidateDto, @PathVariable int id){
        candidateDto.setId(id);
        return  this.candidateService.update(candidateDto);

    }

    /*@GetMapping("/getByEmail")
    public DataResult<CandidateDto> findByCandidateEmail(@RequestParam  String candidateEmail){
        return candidateService.findByCandidateEmail(candidateEmail);
    }*/
/*

    @GetMapping("/getByNationalityNo")
    public DataResult<CandidateDto> findByNationalityNo(@RequestParam String nationalityNo){
        return candidateService.findByNationalityNo(nationalityNo);
    }
*/

    @GetMapping("/getAllDesc")
    public DataResult<List<Candidate>> getAllSorted(){
        return this.candidateService.getAllSorted();
    }




    @GetMapping("/getByNameAndResume")
    public DataResult<List<Candidate>>
    getByNameAndResume(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
                                  @RequestParam("resumeId") int resumeId){
        return this.candidateService.getByNameAndResume(firstName,lastName,resumeId);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(CandidateDto candidateDto){
        return  this.candidateService.delete(candidateDto);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors=new HashMap<String,String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors
                =new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return errors;
    }








}
