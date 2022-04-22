package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.SystemPersonnelService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.ErrorDataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.SystemPersonnel;
import hrms.hrmssystem.entities.dtos.ResumeDto;
import hrms.hrmssystem.entities.dtos.SystemPersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/personnel")
@CrossOrigin
public class SystemPersonnelsController {

    private SystemPersonnelService systempersonnelService;

    @Autowired
    public SystemPersonnelsController(SystemPersonnelService systempersonnelService) {
        this.systempersonnelService = systempersonnelService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SystemPersonnel>> getAll() {
        return this.systempersonnelService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemPersonnelDto systemPersonnelDto) {
        return this.systempersonnelService.add(systemPersonnelDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(SystemPersonnelDto systemPersonnelDto){
        return  this.systempersonnelService.delete(systemPersonnelDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody SystemPersonnelDto systemPersonnelDto, @PathVariable int id){
        systemPersonnelDto.setId(id);
        return  this.systempersonnelService.update(systemPersonnelDto);

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
