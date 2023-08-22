package Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Employee details already exists !!!")
public class EmployeeAlreadyExistsException extends Exception{

}
