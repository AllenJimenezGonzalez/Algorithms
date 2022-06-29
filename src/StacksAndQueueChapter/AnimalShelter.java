package StacksAndQueueChapter;

import java.util.LinkedList;

public class AnimalShelter {
    LinkedList<Animal> animals = new LinkedList<>();

    public void enqueue (Animal animal){
        animals.add(animal);
    }
    public Animal dequeueAny(){
        return animals.remove();
    }

    public Animal dequeueCat(){
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Cat){
                return animals.remove(i);
            }
        }
        return null;
    }

    public Animal dequeueDog(){
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i) instanceof Dog){
                return animals.remove(i);
            }
        }
        return null;
    }

    public static void main(String [] args){

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog(1));
        animalShelter.enqueue(new Cat(740));
        animalShelter.enqueue(new Dog(2));
        animalShelter.enqueue(new Dog(3));
        animalShelter.enqueue(new Dog(4));
        animalShelter.enqueue(new Cat(8990));

        System.out.println(animalShelter.dequeueAny().type);
        Cat a = (Cat) animalShelter.dequeueCat();
        System.out.println(a.id );
        Cat a1 = (Cat) animalShelter.dequeueCat();
        System.out.println(a1.id );
    }
}

class Animal{
    public char type;
}

class Dog extends Animal {
    public int id;
    public Dog(int id){
        super();
        this.type = 'd';
        this.id = id;
    }
}

class Cat extends Animal{
    public int id;
    public Cat(int id){
        super();
        this.type = 'c';
        this.id = id;
    }
}
