package com.jackrev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// @Before("execution(* add*(com.jackrev.aopdemo.Account))")

	@Before("execution(* com.jackrev.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {

		System.out.println("\n======>>> Executing @Before advice on method()");
	}
}
