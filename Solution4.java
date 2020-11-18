package com.acrabsoft.web;

import io.netty.util.internal.ConcurrentSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

public class Solution4 {
    // Question 9
    Animal[] animals = new Animal[]{
            new Bird(),
            new Duck(),
            new Chicken(),
            new Rooster(),
            new Parrot(),
            new Fish(),
            new Shark(),
            new Clownfish(),
            new Animal(),
            new Frog(),
            new Dog(),
            new Butterfly(),
            new Cat()
    };
    @Test
    public void testCount() {
        String[] methods = {"walk","fly","sing","swim"};
        for (String methodName : methods) {
            countByMethodName(methodName);
        }
    }


    public void countByMethodName(String methodName) {
        // Set is used to remove duplication
        Set<Class<? extends  Animal>> set = new ConcurrentSet<>();
        for (Animal animal: animals ){
            Class<? extends Animal> tClass = animal.getClass();
            // Check if there is a specified method
            if(checkMethod(tClass,methodName)) {
                set.add(tClass);
                for (Animal animal1: animals){
                    Class<? extends Animal> aClass = animal1.getClass();
                    if(tClass.isAssignableFrom(aClass)) {
                        set.add(aClass);
                    }
                }
            }
        }
        System.out.println("There are "+set.size()+" animals can "+methodName);
    }

    /**
     * Check if there is a specified method
     * @return
     */
    public boolean checkMethod(Class<? extends Animal> tClass,String methodName) {
        Method[] methods = tClass.getMethods();
        if(methods.length<1) {
            return false;
        }
        for (Method method: tClass.getDeclaredMethods()){
            if(method.getName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    // Question 10
      // I don't understand the meaning of the title

}

// Question 9
class Frog extends Animal{
    void jump() {
        System.out.println("I am jumping");
    }
}


// Question 11
@RestController
@RequestMapping("/animal")
class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     *
     * @param type    Animal type
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/v1.0.0/queryAnimals",method = RequestMethod.POST)
    public PageObject queryAnimals(@RequestParam(value = "type") String type,
                               @RequestParam(value = "pagesize") int pagesize,
                               @RequestParam(value = "pagenum") int pagenum) {
        return this.service.queryAnimals(type,pagesize,pagenum);
    }
}

@Service
class AnimalService {
    @Autowired
    private AnimalDao dao;

    public PageObject queryAnimals(String type, int pagesize, int pagenum) {
        //1.Construct a paging object
        //2.Call the method in dao
        PageObject pageobject = this.dao.queryAnimals(type,new PageObject(pagesize,pagenum));
        return PageObject;
    }
}

@Repository
class AnimalDao{
    public PageObject queryAnimals(String type,PageObject pageObject) {
        //1.Get persistent objects
        // 2.Write sql statement
        // 3.Execute sql statement
        // 4.Return execution result
    }
}