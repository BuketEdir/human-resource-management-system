package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.dtos.CityDto;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();

    Result add(CityDto cityDto);

    Result delete(CityDto cityDto);
    Result update(CityDto cityDto);



}
