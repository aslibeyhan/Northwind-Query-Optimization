package kodlamaio.northwind.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(name = "/api/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user)) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object>   handleValidException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<String, String>(); //hangi alanda ne hatası
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Erros");
        return  errors;
    }
}
