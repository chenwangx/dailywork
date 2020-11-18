package com.acrabsoft.web;

import org.junit.Test;

public class Solution2 {

    // Question 5
    @Test
    public void testFish() {
        Animal animal = new Fish("","","");
        animal.walk();
        Fish fish = (Fish)animal;
        fish.walk();
        fish.sing();
        fish.swim();
    }

    // Question 6
    @Test
    public void testOtherFish() {
        Animal animal = new Shark("grey","large","Sharks");
        Shark shark = (Shark)animal;
        shark.showColor();
        shark.eat();

        Animal animal2 = new Clownfish("colourful (orange)","small","Clownfish");
        Clownfish clownfish = (Clownfish)animal2;
        clownfish.showColor();
        clownfish.joke();
    }

    //Question 7
    @Test
    public void testDolphin(){
        Dolphin dolphin = new Dolphin();
        dolphin.swim();
    }
}

// Question 5
class Fish extends Animal{
    public Fish() {

    }
    void walk() {
         System.out.println(" Fish don't walk");
     }

     void sing() {
         System.out.println(" Fish don't sing");
     }

     void swim() {
         System.out.println("Fish can swim");
     }

    // Question 6
    private String color;
    private String bodyType;
    private String name;

    public Fish(String color, String bodyType, String name) {
        this.color = color;
        this.bodyType = bodyType;
        this.name = name;
    }
    void showColor(){
        System.out.println(name+" are "+ bodyType+" and "+color);
    }
}

// Question 6
class Shark extends Fish{
    public Shark() {
    }

    public Shark(String color, String bodyType, String name) {
        super(color, bodyType, name);
    }

    void eat(){
        System.out.println("Sharks eat other fish");
    }
}

class Clownfish extends Fish{
    public Clownfish(String color, String bodyType, String name) {
        super(color, bodyType, name);
    }

    public Clownfish() {

    }

    void joke() {
        System.out.println("Clownfish make jokes");
    }
}

// Question 7
class Dolphin{
    private static Fish fish = new Fish();
    void swim(){
        fish.swim();
    }
}

