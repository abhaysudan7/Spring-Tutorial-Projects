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
		Object result = theProceedingJoinPoint.proceed();

		// get the timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Excecuting @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Excecuting @AfterThrowing on method: " + method);

		// log the Exception
		myLogger.info("\n======>>> The exception is: " + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Excecuting @AfterReturning on method: " + method);

		// print out the results of the method call
		myLogger.info("\n======>>> result is : " + result);

		// let's post-process the data ....let's modify it :-)

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		myLogger.info("\n======>>> result is : " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through the accounts

		for (Account tempAccount : result) {

			// get uppercase version of name
			String theUpperCaseName = tempAccount.getName().toUpperCase();

			// update the name on the account
			tempAccount.setName(theUpperCaseName);

		}
	}

	@Before("com.jackrev.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n======>>> Executing @Before advice on method()");

		// display the method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method: " + methoSig);

		// display method arguments
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info((String) tempArg);

			if (tempArg instanceof Account) {
				// downcast and print account specific stuff

				Account theAccount = (Account) tempArg;

				myLogger.info("account name : " + theAccount.getName());
				myLogger.info("account level : " + theAccount.getLevel());
			}
		}
	}

}
