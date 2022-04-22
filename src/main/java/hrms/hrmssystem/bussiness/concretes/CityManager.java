package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.CityService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessResult;
import hrms.hrmssystem.dataAccess.abstracts.CityDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.dtos.CityDto;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    /*@Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }*/

    @Override
    public DataResult<List<City>> getAll() {
        List<CityDto> cityDtoList = cityDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<City>>
                (this.cityDao.findAll(), "List of cities");

    }

   @Override
    public Result add(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        city.setId(cityDto.getId());
        this.cityDao.save(city);

        return new SuccessResult("City added");
    }








    @Override
    public Result delete(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        city.setId(cityDto.getId());
        this.cityDao.delete(city);

        return new SuccessResult("City deleted");
    }

    @Override
    public Result update(CityDto cityDto) {
        City city=this.cityDao.getById(cityDto.getId());
        city.setName(cityDto.getName());
        city.setId(cityDto.getId());
        this.cityDao.save(city);
        return new SuccessResult("City updated");
    }








    private CityDto convertEntityToDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }


}
