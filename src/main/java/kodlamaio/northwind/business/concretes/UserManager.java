package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserDao userDao;
    @Override
    public Result add(User user) {
         this.userDao.save(user);
        return new SuccessResult("Users Added");

    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(
                this.userDao.findByEmail(email),"User found");
    }
}
