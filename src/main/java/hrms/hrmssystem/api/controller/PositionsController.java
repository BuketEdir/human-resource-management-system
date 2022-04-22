package hrms.hrmssystem.api.controller;


import hrms.hrmssystem.bussiness.abstracts.PositionService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Employer;
import hrms.hrmssystem.entities.concretes.Position;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.JobApplicationDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import hrms.hrmssystem.entities.dtos.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController //android ios hepsinden ulasabilmek için ekledik
@RequestMapping("api/positions")
@CrossOrigin
public class PositionsController {

    private PositionService positionService;

    @Autowired//positionService ı ortama enjekte etmiş olduk
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Position>> getAll() {
        return this.positionService.getAll();

    }
    @PostMapping("/add")
    public Result add(@RequestBody PositionDto positionDto) {
        return this.positionService.add(positionDto);
    }

    @GetMapping("/findByPositionName")
    public DataResult<PositionDto> findByPositionName(@RequestParam String positionName){
        return positionService.findByPositionName(positionName);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(PositionDto positionDto){
        return  this.positionService.delete(positionDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody PositionDto positionDto, @PathVariable int id){
        positionDto.setId(id);
        return  this.positionService.update(positionDto);

    }


}

