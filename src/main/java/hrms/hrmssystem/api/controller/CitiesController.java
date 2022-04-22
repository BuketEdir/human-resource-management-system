package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.CityService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/city")
@RestController
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        super();
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CityDto cityDto) {
        return this.cityService.add(cityDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(CityDto cityDto) {
        return this.cityService.delete(cityDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody CityDto cityDto, @PathVariable int id) {
        cityDto.setId(id);
        return this.cityService.update(cityDto);

    }
}