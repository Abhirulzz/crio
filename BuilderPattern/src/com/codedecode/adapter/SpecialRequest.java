package com.codedecode.adapter;

//Target interface that the client expects
interface Target {
 void request();
}

//Adaptee class with an incompatible interface
class Adaptee {
 void specificRequest() {
     System.out.println("Adaptee's specific request");
 }
}

//Adapter class that implements the Target interface and delegates the request to the Adaptee
class Adapter implements Target {
 private Adaptee adaptee;

 Adapter(Adaptee adaptee) {
     this.adaptee = adaptee;
 }

 @Override
 public void request() {
     System.out.println("Adapter's request");
     adaptee.specificRequest();
 }
}

//Client code
public class SpecialRequest {
 public static void main(String[] args) {
     // Creating an Adaptee object
     Adaptee adaptee = new Adaptee();

     // Creating an Adapter object and passing the Adaptee to it
     Target adapter = new Adapter(adaptee);

     // Using the Target interface to make a request
     adapter.request();
 }
}

