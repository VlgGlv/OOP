public class AnimalTestDrive {
    public static void main(String [] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);
    }
}

public class MyAnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;
    public void add(Animal a)  {
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.println("Animal добавлен в ячейку " + nextIndex);
            nextIndex++;
        }
    }
}
class Animal {}
class Cat extends Animal {}
class Dog extends Animal {}



