package com.storeparsers.microservices.citilinkparserservice.aspect;

import com.storeparsers.microservices.citilinkparserservice.parser.CitilinkPageParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Aspect
@Slf4j
public class ParserLoggingAspect {

    @Around("execution(public * com.storeparsers.microservices.citilinkparserservice.service.*.*(..))")
    public Object aroundServiceMethodsAdvise(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String shortClassName = methodSignature.getDeclaringType().getSimpleName();
        String fullMethodName = shortClassName + "." + methodSignature.getName();
        log.info("[ParserLogging] Begin of method " + fullMethodName);
        long startTimeMillis = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
        long timeElapsed = System.currentTimeMillis() - startTimeMillis;
        int parsedCount = CitilinkPageParser.counter.get();
        CitilinkPageParser.counter.set(0);
        log.info(String.format("[ParserLogging] Items parsed: %d", parsedCount));
        log.info(String.format("[ParserLogging] End of method %s; Time elapsed: %d",
                fullMethodName, timeElapsed));
        return targetMethodResult;
    }
}
