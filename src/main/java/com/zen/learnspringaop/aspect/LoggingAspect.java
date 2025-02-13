package com.zen.learnspringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
    @Before("com.zen.learnspringaop.aspect.CommonPointcutConfig.servicePackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect: Logging method call - {}", joinPoint);
    }

    @After("com.zen.learnspringaop.aspect.CommonPointcutConfig.servicePackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect: {} method has executed", joinPoint);
    }

    @AfterThrowing(pointcut = "com.zen.learnspringaop.aspect.CommonPointcutConfig.servicePackageConfig()", throwing = "exception")
    public void logMethodCallAfterThrowingException(JoinPoint joinPoint, Exception exception) {
        logger.error("After Throwing Aspect: Exception thrown by {} method - {}", joinPoint, exception.toString());
    }

    @AfterReturning(pointcut = "com.zen.learnspringaop.aspect.CommonPointcutConfig.servicePackageConfig()", returning = "result")
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Aspect: {} method has returned - {}", joinPoint, result);
    }

}
