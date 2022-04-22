package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {

  /*  @Query("from Education where schoolName=:schoolName and resume.id=:resumeId")
    List<Education> getBySchoolNameAndResumeId(String schoolName,int resumeId);*/

}
