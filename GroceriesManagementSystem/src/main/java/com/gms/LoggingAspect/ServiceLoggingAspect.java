package com.gms.LoggingAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {
	
	@Around("execution(* com.gms.service..*(..))")
	public Object logServiceMethods(ProceedingJoinPoint joinpoint) throws Throwable{
		String method=joinpoint.getSignature().toShortString();
		System.out.println(" [AOP] Entering method: "+method);
		Object result=joinpoint.proceed();
		System.out.println(" [AOP] Exiting method: "+method);
		return result;
	}
	


}
