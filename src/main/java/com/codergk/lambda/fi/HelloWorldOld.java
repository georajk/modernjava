package com.codergk.lambda.fi;

public class HelloWorldOld implements HelloWorldInterface{


    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }

    public static void main(String[] args) {
        HelloWorldInterface helloWorldInterface = new HelloWorldOld();
        System.out.println(helloWorldInterface.sayHelloWorld());
    }
}
