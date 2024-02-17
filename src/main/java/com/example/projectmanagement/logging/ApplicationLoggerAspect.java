package com.example.projectmanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.example.projectmanagement.controllers..*)")
    //pointcut defines WHERE that logging should happen
    public void definedPackagedPointcuts() {

    }

    @After("definedPackagedPointcuts()") //this is what is done
    public void logAfter(JoinPoint joinPoint) {
        logger.debug("\n \n \n");
        logger.debug("********** Before method execution *********\n {}.{} () with arguments[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        logger.debug("*********************************************** \n \n \n");
    }
}
