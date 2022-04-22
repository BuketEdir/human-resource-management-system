package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.ExperienceService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.ExperienceDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Education;
import hrms.hrmssystem.entities.concretes.Experience;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.ExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao){
        this.experienceDao=experienceDao;
    }

   /* @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
    }*/



    @Override
    public DataResult<List<Experience>> getAll() {
        List<ExperienceDto> experienceDtoList = experienceDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Experience>>
                (this.experienceDao.findAll(), "List of experiences");

    }

    private ExperienceDto convertEntityToDto(Experience experience) {
        ExperienceDto experienceDto = new ExperienceDto();
        experienceDto.setId(experience.getId());
       experienceDto.setCompanyName(experience.getCompanyName());
       experienceDto.setPosition(experience.getPosition());
       experienceDto.setStartYear(experience.getStartYear());
       experienceDto.setQuitYear(experience.getQuitYear());
       experienceDto.setContinues(experience.isContinues());
        return experienceDto;
    }



    @Override
    public Result add(ExperienceDto experienceDto) {
        Experience experience=new Experience();
        experience.setId(experienceDto.getId());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setPosition(experienceDto.getPosition());
        experience.setStartYear(experienceDto.getStartYear());
        experience.setQuitYear(experienceDto.getQuitYear());

        this.experienceDao.save(experience);
        return new SuccessResult("Experience added");
    }

    @Override
    public Result delete(ExperienceDto experienceDto) {
        Experience experience=new Experience();
        experience.setId(experienceDto.getId());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setPosition(experienceDto.getPosition());
        experience.setStartYear(experienceDto.getStartYear());
        experience.setQuitYear(experienceDto.getQuitYear());

        this.experienceDao.delete(experience);
        return new SuccessResult("Experience deleted");

    }

    @Override
    public Result update(ExperienceDto experienceDto) {
        Experience experience=this.experienceDao.getById(experienceDto.getId());
        experience.setId(experienceDto.getId());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setPosition(experienceDto.getPosition());
        experience.setStartYear(experienceDto.getStartYear());
        experience.setQuitYear(experienceDto.getQuitYear());

        this.experienceDao.save(experience);
        return new SuccessResult("Experience updated");


    }

    @Override
    public DataResult<List<Experience>> getByNameAndResume(String companyName, String position, int resumeId) {
        return new SuccessDataResult<List<Experience>>
                (this.experienceDao.getByNameAndResume(companyName,position,resumeId));
    }





}
