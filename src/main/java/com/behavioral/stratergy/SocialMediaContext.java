package com.behavioral.stratergy;

public class SocialMediaContext {
	//Composition has a relationship
	ISocialMediaStrategy smStrategy;

	public void setSocialmediaStrategy(ISocialMediaStrategy smStrategy) {
		this.smStrategy = smStrategy;
	}

	public void connect(String name) {
		smStrategy.connectTo(name);
	}
}

//is a relation -> inheritance
//has a relation -> 1. he has a car (Composition)
			//	->  2. Aggrigation loos coupling

