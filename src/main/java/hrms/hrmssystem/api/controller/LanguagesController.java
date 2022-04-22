package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.LanguageService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/languages")
@RestController
@CrossOrigin
public class LanguagesController {
    private LanguageService languagesService;

    @Autowired
    public LanguagesController(LanguageService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll() {
        return this.languagesService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody LanguageDto languageDto) {
        return this.languagesService.add(languageDto);
    }


    @PutMapping("/update/{id}")
    public Result update(@RequestBody LanguageDto languageDto, @PathVariable int id) {

        languageDto.setId(id);
        return this.languagesService.update(languageDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(LanguageDto languageDto) {
        return this.languagesService.delete(languageDto);
    }

     /*   @GetMapping("/getByNameAndResume")
    public DataResult<List<Language>>
    getByNameAndResume(@RequestParam("language") String language,
                       @RequestParam("resumeId") int resumeId){
        return this.languagesService.getByNameAndResume(language,resumeId);
    }
*/
}



