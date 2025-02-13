package com.zen.learnspringaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.zen.learnspringaop.service.*.*(..))")
    public void servicePackageConfig() {}

    @Pointcut("execution(* com.zen.learnspringaop.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void beanContainingServiceConfig() {}

}
