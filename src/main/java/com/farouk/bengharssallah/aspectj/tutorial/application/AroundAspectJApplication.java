package com.farouk.bengharssallah.aspectj.tutorial.application;

import com.farouk.bengharssallah.aspectj.tutorial.target.Target;

public class AroundAspectJApplication {

	
	
	
	public static void main(String[] args) {
						new AroundAspectJApplication().performAroundAspecting();
                 }
	
	
	
	public void performAroundAspecting(){
						  Target target = new Target();
						  target.ArroundDisplay();  
	            }

  }
    
