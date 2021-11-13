package games.ani.fbsender.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleUserNotFoundException(ApiRequestException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiExeption exception = new ApiExeption(
                e.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exception, status);
    }
}
