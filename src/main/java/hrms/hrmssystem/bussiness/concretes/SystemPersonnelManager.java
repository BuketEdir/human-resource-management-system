package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.SystemPersonnelService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.SystemPersonnelDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.SystemPersonnel;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.SystemPersonnelDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao){
        this.systemPersonnelDao=systemPersonnelDao;
    }

    /*@Override
    public DataResult<List<SystemPersonnel>> getAll() {
        return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll());
    }*/

    @Override
    public DataResult<List<SystemPersonnel>> getAll() {
        List<SystemPersonnelDto> systemPersonnelDtoList = systemPersonnelDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<SystemPersonnel>>
                (this.systemPersonnelDao.findAll(), "List of System Personnels");

    }

    private SystemPersonnelDto convertEntityToDto(SystemPersonnel systemPersonnel) {
        SystemPersonnelDto systemPersonnelDto=new SystemPersonnelDto();
        systemPersonnelDto.setId(systemPersonnel.getId());
        systemPersonnelDto.setFirstName(systemPersonnel.getFirstName());
        systemPersonnelDto.setLastName(systemPersonnel.getLastName());
       return systemPersonnelDto;
    }

    @Override
    public Result add(SystemPersonnelDto systemPersonnelDto) {
        SystemPersonnel systemPersonnel=new SystemPersonnel();
        systemPersonnel.setId(systemPersonnelDto.getId());
        systemPersonnel.setFirstName(systemPersonnelDto.getFirstName());
        systemPersonnel.setLastName(systemPersonnelDto.getLastName());
        this.systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("A system personnel has added");
    }

    @Override
    public Result delete(SystemPersonnelDto systemPersonnelDto) {
        SystemPersonnel systemPersonnel=new SystemPersonnel();
        systemPersonnel.setId(systemPersonnelDto.getId());
        systemPersonnel.setFirstName(systemPersonnelDto.getFirstName());
        systemPersonnel.setLastName(systemPersonnelDto.getLastName());
        this.systemPersonnelDao.delete(systemPersonnel);
        return new SuccessResult("A system personnel has deleted");

    }

    @Override
    public Result update(SystemPersonnelDto systemPersonnelDto) {
        SystemPersonnel systemPersonnel=this.systemPersonnelDao.getById(systemPersonnelDto.getId());
        systemPersonnel.setId(systemPersonnelDto.getId());
        systemPersonnel.setFirstName(systemPersonnelDto.getFirstName());
        systemPersonnel.setLastName(systemPersonnelDto.getLastName());
        this.systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("A system personnel has updated");

    }

}
