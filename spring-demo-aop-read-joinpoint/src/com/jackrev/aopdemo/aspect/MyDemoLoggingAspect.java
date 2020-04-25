package com.jackrev.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
