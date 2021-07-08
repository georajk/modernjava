package com.codergk.lambda.fi;

public class HelloWorldLambda {

    public static void main(String[] args) {
        HelloWorldInterface helloWorldInterface = () -> {
            return "Hello World";
        };

        System.out.println(helloWorldInterface.sayHelloWorld());
    }
}
