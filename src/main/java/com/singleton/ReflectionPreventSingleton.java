package com.singleton;

import java.lang.reflect.Constructor;

//Singleton class
class SingletonR {
	// public instance initialized when loading the class
	private static SingletonR instance = new SingletonR();

	private SingletonR() {
		// private constructor
	}
	public static SingletonR getInstance() {
		return instance;
	}
	
	public enum Singleton 
    {
      INSTANCE;
    }
}

public class ReflectionPreventSingleton {

	public static void main(String[] args) {
		SingletonR instance1 = SingletonR.getInstance();
		SingletonR instance2 = null;
		try {
			Constructor[] constructors = SingletonR.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (SingletonR) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}
}

//Overcome reflection issue: To overcome issue raised by reflection, 
//enums are used because java ensures internally that enum value is instantiated only once. 
//Since java Enums are globally accessible, they can be used for singletons. 
//Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
/*
 * public enum SingletonR { INSTANCE; }
 */