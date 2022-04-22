package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.UserService;
import hrms.hrmssystem.core.utilities.results.*;
import hrms.hrmssystem.dataAccess.abstracts.UserDao;
import hrms.hrmssystem.entities.concretes.Language;
import hrms.hrmssystem.entities.concretes.User;
import hrms.hrmssystem.entities.dtos.LanguageDto;
import hrms.hrmssystem.entities.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        List<UserDto> userDtoList = userDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(), "List of users");

    }

    @Override
    public Result add(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userDao.save(user);
        return new SuccessResult("user added");
    }

    @Override
    public Result delete(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userDao.delete(user);
        return new SuccessResult("user deleted");
    }

    @Override
    public Result update(UserDto userDto) {
        User user = this.userDao.getById(userDto.getId());
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userDao.save(user);
        return new SuccessResult("user updated");

    }



 /*   @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email));
    }*/

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }


}
