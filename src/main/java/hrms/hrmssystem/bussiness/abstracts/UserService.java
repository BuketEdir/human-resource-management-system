package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.User;
import hrms.hrmssystem.entities.dtos.UserDto;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(UserDto userDto);
    Result delete(UserDto userDto);

    Result update(UserDto userDto);
    //DataResult<User> findByEmail(String email);

}
