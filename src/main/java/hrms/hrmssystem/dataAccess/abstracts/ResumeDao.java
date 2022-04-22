package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Resume;
import hrms.hrmssystem.entities.dtos.ResumeDto;
import hrms.hrmssystem.entities.dtos.ResumeWithEducationDto;
import hrms.hrmssystem.entities.dtos.ResumeWithLanguageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume,Integer> {


    @Query("Select new hrms.hrmssystem.entities.dtos.ResumeWithEducationDto"
    +"(r.id,e.schoolName,e.department)"
    +"From Education e Inner Join e.resume r")

    List<ResumeWithEducationDto> getResumeWithEducationDetails();



    @Query("Select new hrms.hrmssystem.entities.dtos.ResumeWithLanguageDto"
    +"(r.id,l.language,l.languageLevel)"
    +"From Language l Inner Join l.resume r")

    List<ResumeWithLanguageDto> getResumeWithLanguageDetails();




/*
  @Query("from Resume r where r.candidate.candidateId=:candidateId and r.id=:resumeId")
    Resume findResumeByCandidateIdAndResumeId(int CandidateId,int resumeId);

    List<JobApplication> getByResumeId(int resumeId);
*/

  /*  @Query("select new hrms.hrmssystem.entities.dtos.ResumeDto")*/


   /* @Query("select new hrmsSystem.hrms.entities.dtos.ResumeWithAllInformationsDto" +
            "(r.resumeId,r.jobSeekers.id,r.gitHubAddress,r.linkedinAddress,r.coverLetter,e.workplace,e.position,e.startYear,e.quitYear,e.experinceYear,e.isContinues," +
            "ed.schoolName,ed.department,ed.startYear,ed.graduateYear,ed.isContinues,l.language,l.languageLevel," +
            "s.skillName,s.skillLevel) from Resume r " +
            "inner join r.experiences e inner join r.educations ed inner join r.languages l inner join r.skills s where r.jobSeekers.id=:jobSeekerId")
    List<ResumeWithAllInformationsDto> getResumesByJobSeekers_Id(int jobSeekerId);
*/
}
