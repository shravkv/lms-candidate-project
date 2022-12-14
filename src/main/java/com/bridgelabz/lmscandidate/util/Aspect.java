package com.bridgelabz.lmscandidate.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Aspect {

    @Before(value = "exection(* com.bridgelabz.lmscandidate.service.CandidateService.*(..))")
    public void Before(JoinPoint joinPoint) {
        System.out.println("Before: "+joinPoint.getSignature().getName());
    }

    @After(value = "exection(* com.bridgelabz.lmscandidate.service.CandidateService.*(..))")
    public void After(JoinPoint joinPoint) {
        System.out.println("After: "+ Arrays.toString(joinPoint.getArgs()));
    }

}
