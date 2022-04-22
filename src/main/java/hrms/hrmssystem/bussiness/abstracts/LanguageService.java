package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();

   // DataResult<List<Language>> getByNameAndResume(String language, int resumeId);

    Result add(LanguageDto languageDto);
    Result update(LanguageDto languageDto);

    Result delete(LanguageDto languageDto);


}
