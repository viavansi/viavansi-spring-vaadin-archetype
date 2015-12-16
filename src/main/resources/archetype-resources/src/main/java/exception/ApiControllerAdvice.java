package ${package}.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice("${package}.restcontroller")
public class ApiControllerAdvice {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Exception genericExceptionHandler(Exception e) {
//        // TODO return ApiErrorResponse
//        return e;
//    }

}
