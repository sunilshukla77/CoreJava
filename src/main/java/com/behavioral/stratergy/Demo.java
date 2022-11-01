package com.behavioral.stratergy;

public class Demo {
	public static void main(String[] args) {
		
		String name = "Sunil";
		 
	    // Creating social Media Connect Object for connecting with friend by
	    // any social media strategy.
	    SocialMediaContext context = new SocialMediaContext();
	 
	    // Setting Facebook strategy.
	    context.setSocialmediaStrategy(new FacebookStrategy());
	    context.connect(name);
	 
	    System.out.println("====================");
	 
	    // Setting Twitter strategy.
	    context.setSocialmediaStrategy(new TwitterStrategy());
	    context.connect(name);
	 
	    System.out.println("====================");
	 
	    // Setting GooglePlus strategy.
	    context.setSocialmediaStrategy(new GooglePlusStrategy());
	    context.connect(name);
	 
	    System.out.println("====================");
	 
	  }
}

// Refer: https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/