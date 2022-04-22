package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.EmployerService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Employer;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

    private EmployerService employerService;
    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService=employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody EmployerDto employerDto) {
        return employerService.add(employerDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(EmployerDto employerDto){
        return  this.employerService.delete(employerDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody EmployerDto employerDto, @PathVariable int id){
        employerDto.setId(id);
        return  this.employerService.update(employerDto);
    }

    @GetMapping("/getByEmail")
    public DataResult<EmployerDto> findByEmployerEmail(@RequestParam  String employerEmail){
        return employerService.findByEmployerEmail(employerEmail);
    }


}
