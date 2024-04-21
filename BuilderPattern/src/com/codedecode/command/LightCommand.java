package com.codedecode.command;

//Receiver class
class Light {
 void turnOn() {
     System.out.println("Light is on");
 }

 void turnOff() {
     System.out.println("Light is off");
 }
}

//Command interface
interface Command {
 void execute();
}

//Concrete command for turning on the light
class TurnOnCommand implements Command {
 private Light light;

 TurnOnCommand(Light light) {
     this.light = light;
 }

 @Override
 public void execute() {
     light.turnOn();
 }
}

//Concrete command for turning off the light
class TurnOffCommand implements Command {
 private Light light;

 TurnOffCommand(Light light) {
     this.light = light;
 }

 @Override
 public void execute() {
     light.turnOff();
 }
}

//Invoker class
class RemoteControl {
 private Command command;

 void setCommand(Command command) {
     this.command = command;
 }

 void pressButton() {
     command.execute();
 }
}

//Client code
public class LightCommand {
 public static void main(String[] args) {
     // Create a receiver (Light)
     Light light = new Light();

     // Create concrete commands
     Command turnOnCommand = new TurnOnCommand(light);
     Command turnOffCommand = new TurnOffCommand(light);

     // Create an invoker (RemoteControl)
     RemoteControl remoteControl = new RemoteControl();

     // Set commands for remote control buttons
     remoteControl.setCommand(turnOnCommand); // Set turnOnCommand to the remote's button
     remoteControl.pressButton(); // Press the button, should turn the light on

     remoteControl.setCommand(turnOnCommand); // Set turnOffCommand to the remote's button
     remoteControl.pressButton(); // Press the button, should turn the light off
 }
}

