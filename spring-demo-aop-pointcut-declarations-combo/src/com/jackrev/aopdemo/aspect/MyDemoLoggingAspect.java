package com.jackrev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// @Before("execution(* add*(com.jackrev.aopdemo.Account))")

	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create point cut for getter methods
	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create point cut for setter methods
	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create point cut : include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalyticsAdvice() {
		System.out.println("\n======>>> Performing API analytics");
	}

}
