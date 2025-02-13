package com.zen.learnspringaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.zen.learnspringaop.service.*.*(..))")
    public Object trackExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start timer
        long startTime = System.currentTimeMillis();

        // Execute the method
        Object resultValue = proceedingJoinPoint.proceed();

        // Stop timer
        long endTime = System.currentTimeMillis();

        // Log the time
        long executionTime = endTime - startTime;
        logger.info("Around Aspect: {} method executed in {} ms", proceedingJoinPoint, executionTime);

        return resultValue;
    }

}
