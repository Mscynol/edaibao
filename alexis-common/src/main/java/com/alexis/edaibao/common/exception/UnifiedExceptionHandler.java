package com.alexis.edaibao.common.exception;

import com.alexis.edaibao.common.result.R;
import com.alexis.edaibao.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author cc-zj
 * @create 2022-04-13 14:08
 * 在controller层加上通知,如果使用@ControllerAdvice,则方法上需要添加@ResponseBody
 */
@RestControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage(), e);
        return R.error();
    }
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public R handleException(BadSqlGrammarException e){
        log.error(e.getMessage(), e);
        return R.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }
    @ExceptionHandler(value = BusinessException.class)
    public R handleException(BusinessException e){
        log.error(e.getMessage(), e);
        return R.error().message(e.getMessage()).code(e.getCode());
    }
    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        return R.setResult(ResponseEnum.SERVLET_ERROR);
    }
}
