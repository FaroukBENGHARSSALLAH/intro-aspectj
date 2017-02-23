package com.farouk.bengharssallah.aspectj.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.farouk.bengharssallah.aspectj.tutorial.target.Target;


     // @Aspect means that SimpleAspect is an aspect class; a tool class to monitor class execution in Java runtime
   @Aspect
public class SimpleAspect {
	
	  private long startTime, finishTime;
	 
	        /* without using a @Pointcut */
	   
	   // @Before means that the 'beforeMethodCalling' method will be called before the 
	  // call 'call' of 'simpleDisplay' method with every possible parameter '..' with every possible return type using a wildcard '*' in 'Target' class 
	 // existed in 'com.farouk.bengharssallah.aspectj.tutorial.target' package 
	 
	@Before("call(* com.farouk.bengharssallah.aspectj.tutorial.target.Target.simpleDisplay(..))")
	public void beforeMethodCalling(JoinPoint thisJoinPoint){
		
		                        // JoinPoint is a context class to get additional details like the method signature on monitored method 'JoinPoint.getSignature()'
		                startTime = System.currentTimeMillis();
		                System.out.println("------ @Before Aspect starting execution on Target.simpleDisplay method with signature : '" + thisJoinPoint.getSignature() + "'   -----------");
		                
	         }
	
	
	
	         /* without using a @Pointcut */
	
	   // @After means that the 'afterMethodCalling' method will be called after the 
	  // call 'call' of 'simpleDisplay' method with every possible parameter '..' with every possible return type using a wildcard '*' in 'Target' class 
	 // existed in 'com.farouk.bengharssallah.aspectj.tutorial.target' package
	
	@After("call(* com.farouk.bengharssallah.aspectj.tutorial.target.Target.simpleDisplay(..))")
	public void afterMethodCalling(JoinPoint thisJoinPoint){
		
		                   // JoinPoint is a context class to get additional details like the method signature on monitored method 'JoinPoint.getSignature()'
					finishTime = System.currentTimeMillis(); 
					
					      // JoinPoint enables to get a reference on the current monitored class target instance
					Target target = (Target) thisJoinPoint.getTarget();
					
					System.out.println("------ @After Aspect finishing execution on " + target.getClass().getName() + ".simpleDisplay method with signature : '" + thisJoinPoint.getSignature() + "' with duration " + 
					(finishTime - startTime) + "ms --------------");
					
	          }

	 }
