package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
	  
	class SingletonS implements Serializable {
	    // public instance initialized when loading the class
	    public static SingletonS instance = new SingletonS();
	      
	    private SingletonS() 
	    {
	        // private constructor
	    }
	    
	  //Overcome serialization issue:- To overcome this issue, we have to implement method readResolve() method.		 
	    protected Object readResolve() {
	        return instance;
	    }
	    
	}
	  
	  
	public class SerializationPreventSerialization 
	{
	  
	    public static void main(String[] args) 
	    {
	        try
	        {
	            SingletonS instance1 = SingletonS.instance;
	            ObjectOutput out
	                = new ObjectOutputStream(new FileOutputStream("file.text"));
	            out.writeObject(instance1);
	            out.close();
	      
	            // deserialize from file to object
	            ObjectInput in 
	                = new ObjectInputStream(new FileInputStream("file.text"));
	              
	            SingletonS instance2 = (SingletonS) in.readObject();
	            in.close();
	      
	            System.out.println("instance1 hashCode:- "
	                                                 + instance1.hashCode());
	            System.out.println("instance2 hashCode:- " 
	                                                 + instance2.hashCode());
	        } 
	          
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}