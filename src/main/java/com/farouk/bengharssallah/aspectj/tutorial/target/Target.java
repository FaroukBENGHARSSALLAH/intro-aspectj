package com.farouk.bengharssallah.aspectj.tutorial.target;


public class Target {

           public void simpleDisplay(){
        	              System.out.println("Display method is being executed after an @Before aspect and @After aspect");
                   }
           
           
           public void ArroundDisplay(){
	              System.out.println("ArrounDisplay method is being controlled by an @Arround aspect");
                   }

}