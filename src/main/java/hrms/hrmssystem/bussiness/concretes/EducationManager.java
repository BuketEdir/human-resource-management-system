package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.EducationService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.EducationDao;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;
    @Autowired
    public EducationManager(EducationDao educationDao){
        this.educationDao=educationDao;
    }


   @Override
    public DataResult<List<Education>> getAll(){
        List<EducationDto> educationDtoList=educationDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Education>>
                (this.educationDao.findAll(),"List of Educations");

    }

    private EducationDto convertEntityToDto(Education education){
        EducationDto educationDto=new EducationDto();
        educationDto.setId(education.getId());
        educationDto.setSchoolName(education.getSchoolName());
        educationDto.setDepartment(education.getDepartment());
        educationDto.setStartYear(education.getStartYear());
        educationDto.setGreduateYear(education.getGraduateYear());
        return educationDto;
    }




    @Override
    public Result add(EducationDto educationDto) {
       Education education=new Education();
       education.setId(educationDto.getId());
       education.setDepartment(educationDto.getDepartment());
       education.setSchoolName(educationDto.getSchoolName());
       education.setStartYear(educationDto.getStartYear());
       education.setGraduateYear(educationDto.getGreduateYear());
        this.educationDao.save(education);
        return new SuccessResult("Education added");
    }

    @Override
    public Result delete(EducationDto educationDto) {
        Education education=new Education();
        education.setId(educationDto.getId());
        education.setDepartment(educationDto.getDepartment());
        education.setSchoolName(educationDto.getSchoolName());
        education.setStartYear(educationDto.getStartYear());
        education.setGraduateYear(educationDto.getGreduateYear());
        this.educationDao.delete(education);
        return new SuccessResult("Education deleted");

    }

    @Override
    public Result update(EducationDto educationDto) {
       Education education=this.educationDao.getById(educationDto.getId());
        education.setId(educationDto.getId());
        education.setDepartment(educationDto.getDepartment());
        education.setSchoolName(educationDto.getSchoolName());
        education.setStartYear(educationDto.getStartYear());
        education.setGraduateYear(educationDto.getGreduateYear());
        this.educationDao.save(education);
        return new SuccessResult("Education updated");

    }
/*
    @Override
    public DataResult<Education> getEducationWithResume(int resumeId) {
        return null;
    }*/




}
