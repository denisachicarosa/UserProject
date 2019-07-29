package userProject.controller;

import org.apache.coyote.Response;
//import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import userProject.exception.UserNotFoundException;

import javax.swing.text.html.parser.Entity;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

}

