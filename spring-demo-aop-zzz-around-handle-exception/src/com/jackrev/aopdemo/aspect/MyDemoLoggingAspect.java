package com.jackrev.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jackrev.aopdemo.Account;
import com.jackrev.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.jackrev.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Excecuting @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now,let's execute the method
		Object result = null;

		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {

			// log the exception
			myLogger.warning(e.getMessage());

			// give user a custom message
			// result = "Major Accident! But no worries, your private AOP helicopter is on
			// the way!";

			throw e;
		}

		// get the timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

}
