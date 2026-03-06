```mermaid
classDiagram
    class Main{
        +showMenu(Scanner) int
    }
    
    class Zoo{
        -List<Animal> animals
        -List<ZooKeeper> keepers;
        +Zoo()
        +addKeeper(Scanner) void
        +addAnimal(Scanner) void
        +showAnimals() void
        +feedAnimal(Scanner) void
        +playAnimal(Scanner) void
        +checkStatus(Scanner) void
    }

    class ZooKeeper{
        -String name
        -String major
        +ZooKeeper(String name, String major)
        +getStatus()
        
    }
    
    class Animal{
        <<abstract>>
        -String name
        -int age
        -int hunger
        -int happiness
        +Animal(String name, int age, int hunger, int happiness)
        +feed() void
        +play() void
        +makeSound()* String
    }
    
    class Bird{
        
    }
    
    class Mammal{
        
    }
    
    class Reptile{
        
    }
    
    class Dog{
        +Dog(String name, int age, int hunger, int happiness)
        +makeSound() String
    }

    class Cat{
        +Cat(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Eagle{
        +Eagle(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Penguin{
        +Penguin(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Lion{
        +Lion(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Elephant{
        +Elephant(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Snake{
        +Snake(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    class Turtle{
        +Turtle(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    
    Zoo o-- Animal
    Animal <|-- Bird
    Animal <|-- Mammal
    Animal <|-- Reptile
    Bird <|-- Eagle
    Bird <|-- Penguin
    Mammal <|-- Lion
    Mammal <|-- Elephant
    Mammal <|-- Dog
    Mammal <|-- Cat
    Reptile <|-- Snake
    Reptile <|-- Turtle

```