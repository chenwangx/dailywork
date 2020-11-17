package com.acrabsoft.web;

import org.junit.Test;

public class Solution {
    @Test
    public void testBird() {
        Animal animal = new Bird();
        animal.walk();

        Bird bird = (Bird) animal;
        bird.fly();
        bird.sing();
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


