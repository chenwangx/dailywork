package com.acrabsoft.web;

import org.junit.Test;

public class Solution {
    // question 1
    @Test
    public void testBird() {
        Animal animal = new Bird();
        animal.walk();

        Bird bird = (Bird) animal;
        bird.fly();
        bird.sing();
    }

    // question 2
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
    //Question 3
    @Test
    public void testRooster() {
        Animal animal = new Rooster();
        Rooster rooster = (Rooster)animal;
        rooster.say();
    }

    //Question 4
    @Test
    public void testParrot() {
        Parrot<Rooster> rp = new Parrot<>();
        rp.add(new Rooster());
        rp.get().say();
        Parrot<Dog> dp = new Parrot<>();
        dp.add(new Dog());
        dp.get().say();
        Parrot<Cat> cp = new Parrot<>();
        cp.add(new Cat());
        cp.get().say();
        Parrot<Duck> duck = new Parrot<>();
        duck.add(new Duck());
        duck.get().say();
    }
}



// question 1
class Animal {
    void walk(){
        System.out.println("I am walking");
    }

    //Other abstract methods
}

class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}


// question 2
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

// question 3
class Rooster extends Chicken{
    void say() {
        System.out.println("Cock-a-doodle-doo");
    }
}

//Question 4
class Dog extends Animal{
    void say(){
        System.out.println("Woof, woof");
    }
}

class Cat extends Animal{
    void say(){
        System.out.println("Meow");
    }
}

class Parrot<T extends Animal> extends Animal{
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    void speak(){
        System.out.println("I can learn to speak");
    }
}


