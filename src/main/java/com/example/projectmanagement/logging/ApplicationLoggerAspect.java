package com.example.projectmanagement.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.example.projectmanagement.controllers..*) " +
            "|| within(com.example.projectmanagement.dao..*)")
    //pointcut defines WHERE that logging should happen
    public void definedPackagedPointcuts() {

    }

    @After("definedPackagedPointcuts()") //this what is done
    public void log() {
        logger.debug("*-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-*");
    }
}
