package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByCandidateEmail(String candidateEmail);

    Candidate findByNationalityNo(String nationalityNo);

    @Query("from Candidate  where firstName=:firstName and lastName=:lastName and resume.id=:resumeId")
   List<Candidate> getByNameAndResume(String firstName,String lastName,int resumeId);

    List<Candidate> findAllByFirstNameIgnoreCaseContains(String firstName);




}
