package com.acrabsoft.web;

import org.junit.Test;

public class Solution {
    // For the first question
    @Test
    public void testBird() {
        Animal animal = new Bird();
        animal.walk();

        Bird bird = (Bird) animal;
        bird.fly();
        bird.sing();
    }

    // For the second question
    @Test
    public void testOtherBird() {
        // duck
        Animal animal = new Duck();
        animal.walk();

        Bird bird = (Bird) animal;
        bird.fly();
        bird.sing();

        Duck duck = (Duck)bird;
        duck.say();
        duck.swim();
        checkfly(duck);
        // chicken
        Animal animal2 = new Chicken();
        Chicken chicken = (Chicken)animal2;
        chicken.say();
        checkfly(chicken);
    }

    public void checkfly(Animal animal) {
        if(animal instanceof Chicken) {
            Chicken chicken = (Chicken)animal;
            chicken.fly();
        }else if(animal instanceof Duck) {
            Duck duck = (Duck)animal;
            duck.fly();
        }
    }
}

abstract class Animal {
    void walk(){
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}

class Duck extends Bird{
    void say() {
        System.out.println("I can say Quack, quack!");
    }
    void swim() {
        System.out.println("I can swim!");
    }
}

class Chicken extends Bird{
    void say() {
        System.out.println("I can say Cluck, cluck!");
    }

    void fly() {
        System.out.println("I am a chicken and i can not fly!");
    }
}

