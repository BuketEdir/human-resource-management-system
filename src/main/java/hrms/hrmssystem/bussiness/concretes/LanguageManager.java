package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.LanguageService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.LanguageDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languagesDao) {
        this.languageDao = languagesDao;
    }

  /*  @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
    }*/

    @Override
    public DataResult<List<Language>> getAll() {
        List<LanguageDto> languageDtoList = languageDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Language>>
                (this.languageDao.findAll(), "List of languages");

    }

    private LanguageDto convertEntityToDto(Language language) {
        LanguageDto languageDto = new LanguageDto();
        languageDto.setId(language.getId());
        languageDto.setLanguage(language.getLanguage());
        languageDto.setLanguageLevel(language.getLanguageLevel());
        return languageDto;
    }

/*
    @Override
    public Result add(Language languages) {
        this.languageDao.save(languages);
        return new SuccessResult("Languages has been added");
    }*/



/*
    @Override
    public DataResult<List<Language>> getByNameAndResume(String language, int resumeId) {
        return new SuccessDataResult<List<Language>>
                (this.languageDao.getByNameAndResume(language,resumeId));
    }*/

    @Override
    public Result add(LanguageDto languageDto) {
        Language language=new Language();
        language.setLanguage(languageDto.getLanguage());
        language.setLanguageLevel(languageDto.getLanguageLevel());
        language.setId(languageDto.getId());

        this.languageDao.save(language);
        return new SuccessResult("language added");


    }

    @Override
    public Result delete(LanguageDto languageDto){
        Language language=this.languageDao.getById(languageDto.getId());
        language.setLanguage(languageDto.getLanguage());
        language.setLanguageLevel(languageDto.getLanguageLevel());
        language.setId(languageDto.getId());
        this.languageDao.delete(language);
        return new SuccessResult("language deleted");
    }

    @Override
    public Result update(LanguageDto languageDto) {
        Language language=this.languageDao.getById(languageDto.getId());
        language.setLanguage(languageDto.getLanguage());
        language.setLanguageLevel(languageDto.getLanguageLevel());
        language.setId(languageDto.getId());
        this.languageDao.save(language);
        return new SuccessResult("updated");


    }
}
