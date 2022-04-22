package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language,Integer> {

/*    @Query("from Language where language=:language and  resume.id=:resumeId")
    List<Language> getByNameAndResume(String language, int resumeId);*/
}
