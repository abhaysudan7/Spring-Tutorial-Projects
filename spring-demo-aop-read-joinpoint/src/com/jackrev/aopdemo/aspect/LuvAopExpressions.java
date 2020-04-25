package com.jackrev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	// @Before("execution(* add*(com.jackrev.aopdemo.Account))")

	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create point cut for getter methods
	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create point cut for setter methods
	@Pointcut("execution(* com.jackrev.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create point cut : include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
