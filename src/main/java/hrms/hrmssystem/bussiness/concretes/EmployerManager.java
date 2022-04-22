package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.EmployerService;
import hrms.hrmssystem.core.utilities.results.*;
import hrms.hrmssystem.dataAccess.abstracts.EmployerDao;
import hrms.hrmssystem.entities.concretes.Employer;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.dtos.EducationDto;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

  /*  @Override
    public DataResult<List<Employer>> getAll(){
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"List of Employers");
    }*/


    @Override
    public DataResult<List<Employer>> getAll() {
        List<EmployerDto> employerDtoList = employerDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Employer>>
                (this.employerDao.findAll(), "List of employers");

    }

    private EmployerDto convertEntityToDto(Employer employer) {
        EmployerDto employerDto = new EmployerDto();
        employerDto.setId(employer.getId());
        employerDto.setCompanyName(employer.getCompanyName());
        employerDto.setWebSite(employer.getWebSite());
        employerDto.setTelNo(employer.getTelNo());
        employerDto.setEmployerEmail(employer.getEmployerEmail());
        return employerDto;
    }


    @Override
    public Result add(EmployerDto employerDto) {
        Employer employer = new Employer();
        employer.setId(employerDto.getId());
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setEmployerEmail(employerDto.getEmployerEmail());
        employer.setTelNo(employerDto.getTelNo());
        employer.setWebSite(employerDto.getWebSite());

        this.employerDao.save(employer);
        return new SuccessResult("Employer added.");
    }

    @Override
    public Result delete(EmployerDto employerDto) {
        Employer employer = new Employer();
        employer.setId(employerDto.getId());
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setEmployerEmail(employerDto.getEmployerEmail());
        employer.setTelNo(employerDto.getTelNo());
        employer.setWebSite(employerDto.getWebSite());

        this.employerDao.delete(employer);
        return new SuccessResult("Employer deleted.");

    }

    @Override
    public Result update(EmployerDto employerDto) {
        Employer employer=this.employerDao.getById(employerDto.getId());
        employer.setId(employerDto.getId());
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setEmployerEmail(employerDto.getEmployerEmail());
        employer.setTelNo(employerDto.getTelNo());
        employer.setWebSite(employerDto.getWebSite());
        this.employerDao.save(employer);
        return new SuccessResult("Employer updated.");
    }




 /*   @Override
    public DataResult<Employer> findByEmployerEmail(String employerEmail) {
        return new SuccessDataResult<Employer>(this.employerDao.findByEmployerEmail(employerEmail));
    }*/


    @Override
    public SuccessDataResult<EmployerDto> findByEmployerEmail(String employerEmail) {
        Employer employer = employerDao.findByEmployerEmail(employerEmail);
        EmployerDto employerDto = convertEntityToDto(employer);

        return new SuccessDataResult<EmployerDto>(employerDto);
    }


    private Result isEmployerEmailExists(String employerEmail) {
        if (employerDao.findByEmployerEmail(employerEmail) != null) {
            return new ErrorResult("Email is exists");
        } else return new SuccessResult();
    }


}
