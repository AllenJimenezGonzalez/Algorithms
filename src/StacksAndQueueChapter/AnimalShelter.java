package StacksAndQueueChapter;

import java.util.LinkedList;

public class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int actualOrder = -1;

    public void enqueue (Animal animal){
        animal.order = ++actualOrder;
        if(animal.type == 'c') cats.add((Cat) animal);
        else dogs.add((Dog) animal);
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0 && cats.size() == 0) return null;
        else{
            if(dogs.size() == 0) return cats.pop();
            else if(cats.size() == 0) return dogs.pop();
            else{
                return dogs.peekFirst().order < cats.peekFirst().order? dogs.pollFirst(): cats.pollFirst();
            }
        }
    }

    public Cat dequeueCat(){
        if(cats.size() == 0) return null;
        return cats.pollFirst();
    }

    public Dog dequeueDog(){
        if(dogs.size() == 0) return null;
        return dogs.pollFirst();
    }

    void print(){
        cats.forEach(cat -> System.out.print(cat.order + "-"));
        System.out.println("\n");
        dogs.forEach(dog -> System.out.print(dog.order+"-"));
        System.out.println("\n");
    }

    public static void main(String [] args){

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.print();
        System.out.println(animalShelter.dequeueAny().toString());
        System.out.println(animalShelter.dequeueAny().toString());
        System.out.println(animalShelter.dequeueCat().toString());
        System.out.println(animalShelter.dequeueDog().toString());
    }
}

class Animal{
    public char type;
    public int order;
    public String toString(){
        return type + " " + order;
    }
}

class Dog extends Animal {
    public Dog(){
        super();
        this.type = 'd';
    }
}

class Cat extends Animal{

    public Cat(){
        super();
        this.type = 'c';
    }
}
