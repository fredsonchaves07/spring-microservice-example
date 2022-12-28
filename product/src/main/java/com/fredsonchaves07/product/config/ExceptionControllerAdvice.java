package com.fredsonchaves07.product.config;

import com.fredsonchaves07.product.exception.ProdutoNaoEncontrado;
import com.fredsonchaves07.product.resources.exception.ErroPadrao;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Value("${springdoc.swagger-ui.path}")
    private String urlDocumentation;

    @ResponseBody
    @ExceptionHandler(ProdutoNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Hidden
    public ErroPadrao erroPadrao(ProdutoNaoEncontrado produtoNaoEncontrado) {
        return new ErroPadrao("ProdutoNaoEncontrado", produtoNaoEncontrado.getMessage(), getUrlErro());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroPadrao erroBadRequest(MethodArgumentTypeMismatchException exception) {
        return new ErroPadrao("ParametroNaoEncontrado", exception.getMessage(), getUrlErro());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroPadrao erro500(Exception exception) {
        return new ErroPadrao("InternalServerError", exception.getMessage(), getUrlErro());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroPadrao erro400(MethodArgumentNotValidException exception) {
        String mensagem = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.joining());
        return new ErroPadrao("ArgumentoInvalido", mensagem, getUrlErro());
    }

    private String getUrlErro() {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        return url + urlDocumentation;
    }

}
