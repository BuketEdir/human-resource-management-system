package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    @Query("from Experience where companyName=:companyName and position=:position and resume.id=:resumeId")
    List<Experience> getByNameAndResume(String companyName, String position, int resumeId);
}
