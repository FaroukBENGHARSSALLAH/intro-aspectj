package com.farouk.bengharssallah.aspectj.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.farouk.bengharssallah.aspectj.tutorial.application.AroundAspectJApplication;


     // @Aspect means that AroundAspect is an aspect class; a tool class able to monitor class execution in Java runtime
   @Aspect
public class AroundAspect {
	
	 private long startTime, finishTime;
	 
	 
	          // @Pointcut means that the 'pointcutMonitor' method will monitor the target method signature 
	         // by AspectJ APIs like @Before, @After or @Around annotations. 
	        //  In this case we will just type  the target method signature with a specified format
	 
		  // call 'call' of 'performAroundAspectingRSS' method with every possible parameter '..' with every possible return type by using wildcard in 'AroundAspectJRSSApplication' class 
		 // existed in 'com.farouk.bengharssallah.aspectj.tutorial.target' package 
	 
	   @Pointcut("call(* com.farouk.bengharssallah.aspectj.tutorial.application.AroundAspectJApplication.performAroundAspecting(..))")
	 public void pointcutMonitor(ProceedingJoinPoint proceedingJoinPoint){}
	 
	 
	
	
      /*  using a @Pointcut */
	
	    // @Around means that the 'aroundMethodCalling' method will control 'getNews' method 
	   //specified by @Pointcut annotation and associate some instructions 
	   
	       // @Before means that the 'beforeMethodCalling' method will be called before the 
		  // call 'call' of 'ArroundDisplay' method in 'Target' class 
		 // existed in 'com.farouk.bengharssallah.aspectj.tutorial.target' package 
	
	   @Around("pointcutMonitor(proceedingJoinPoint)")
	public void aroundMethodCalling(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint){
				  
				   try {
					          // JoinPoint enables to get a reference on the current monitored class target instance
					        AroundAspectJApplication aroundAspectJApplication  = (AroundAspectJApplication) joinPoint.getTarget();
					             
					        System.out.println("------ @Around Aspect starting execution on " + aroundAspectJApplication.getClass().getName() + " class"  +  " on method with signature : '" + joinPoint.getSignature() + "'   -----------");
					        startTime = System.currentTimeMillis();
					        
					           // 'AroundAspectJApplication.ArroundDisplay' method execution instruction
					        proceedingJoinPoint.proceed();
					        
					        finishTime = System.currentTimeMillis();
					        System.out.println("------ @Around Aspect finishing execution on " + aroundAspectJApplication.getClass().getName() + " class"  +  " on method with signature : '" + joinPoint.getSignature() + 
					        		"' with duration " + (finishTime - startTime ) + " ms  -----------");
				              
				                          }
				   catch (Throwable throwableException) {
					   
					            throwableException.printStackTrace();
				                 
				                          }
	                   }
	
	       }
