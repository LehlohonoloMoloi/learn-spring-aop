package com.zen.learnspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // What kind of method calls I would intercept
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.zen.learnspringaop.service.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Before Aspect: Logging method call - {}", joinPoint);
    }

}
