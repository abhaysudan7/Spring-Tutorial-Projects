package com.jackrev.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jackrev.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@After("execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Excecuting @After (finally) on method: " + method);
		
		
		
	}

	@AfterThrowing(pointcut = "execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Excecuting @AfterThrowing on method: " + method);

		// log the Exception
		System.out.println("\n======>>> The exception is: " + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.jackrev.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Excecuting @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n======>>> result is : " + result);

		// let's post-process the data ....let's modify it :-)

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n======>>> result is : " + result);
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
		System.out.println("\n======>>> Executing @Before advice on method()");

		// display the method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methoSig);

		// display method arguments
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print account specific stuff

				Account theAccount = (Account) tempArg;

				System.out.println("account name : " + theAccount.getName());
				System.out.println("account level : " + theAccount.getLevel());
			}
		}
	}

}
