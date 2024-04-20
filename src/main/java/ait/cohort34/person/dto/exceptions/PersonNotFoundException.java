package ait.cohort34.person.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person can't be found")
public class PersonNotFoundException extends RuntimeException {
}
