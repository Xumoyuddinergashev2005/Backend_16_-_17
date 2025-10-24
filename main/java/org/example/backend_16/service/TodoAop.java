package org.example.backend_16.service;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TodoAop {


    @Pointcut("execution(* org.example.backend_16.repository.TodoRepository.*())")
    private void pointCut(){
    }



    @AfterThrowing(value = "pointCut()", throwing = "e")
    private void afterThrowing(Exception e){
        log.error("Error : {}" , e.getMessage());
        throw new RuntimeException("Error :"+e.getMessage());
    }
}
