package com.singleton;

class SingletonDoubleCheck {

//Java Program to write double checked locking 
//of Singleton class
// Volatile variables have the visibility features of synchronized but not the atomicity features.

 private volatile static SingletonDoubleCheck instance;

 private SingletonDoubleCheck() {}

 // 1st version: creates multiple instances if two thread
 // access this method simultaneously
 public static SingletonDoubleCheck getInstance1()
 {
     if (instance == null) {
         instance = new SingletonDoubleCheck();
     }

     return instance;
 }

 // 2nd version : this is thread-safe and only
 // creates one instance of Singleton on concurrent
 // environment but it is unnecessarily expensive due to
 // cost of synchronization at every call.
 public static synchronized SingletonDoubleCheck getInstance2()
 {
     if (instance == null) {
         instance = new SingletonDoubleCheck();
     }
     return instance;
 }

 // 3rd version : An implementation of double-checked
 // locking of Singleton. Intention is to reduce cost
 // of synchronization and improve performance, by only
 // locking critical section of code, the code which
 // creates instance of Singleton class.
 public static SingletonDoubleCheck getInstance3()
 {
     if (instance == null) { // if instance is not created than only accure the lock.
         synchronized (SingletonDoubleCheck.class)
         {
             if (instance == null) { // again check and return instance
                 instance = new SingletonDoubleCheck();
             }
         }
     }
     return instance;
 }
}