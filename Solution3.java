package com.acrabsoft.web;

import org.junit.Test;

public class Solution3 {
    int metamorphosis = 5; // Indicates the point in time when the caterpillar metamorphoses into a butterfly
    int endTime = 15; // End of time
    int timeCount = 0; // For timing
    // Question 8
    @Test
    public void testButterfly() throws InterruptedException {
        while (true){
            Animal a = null;
            if(timeCount<metamorphosis) {
                a = new Caterpillar();
                System.out.println("current time is:"+timeCount);
                Caterpillar caterpillar = (Caterpillar)a;
                caterpillar.walk();
            }else if (timeCount>=metamorphosis && timeCount<endTime){
                 a = new Butterfly();
                System.out.println("current time is:"+timeCount);
                Butterfly butterfly =  (Butterfly)a;
                butterfly.fly();
                butterfly.noSound();
            }else{
                break;
            }
            Thread.sleep(2000);
            timeCount++;
        }
    }
}

// Question 8
class Butterfly extends Animal{
    void fly() {
        System.out.println("I am flying");
    }
    void noSound() {
        System.out.println("I make no sound");
    }
}

class Caterpillar extends Animal{
    void walk() {
        System.out.println("I am walking(crawling)");
    }
}