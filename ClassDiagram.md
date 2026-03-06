```mermaid
classDiagram
    class Main{
        +showMenu(Scanner) int
    }
    
    class Zoo{
        -List<Animal> animals
        +Zoo()
        +showAnimals() void
        +addAnimal(Scanner) void
        +feedAnimal(Scanner) void
        +playAnimal(Scanner) void
        +checkStatus(Scanner) void
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
    
    class Dog{
        +Dog(String name, int age, int hunger, int happiness)
        +makeSound() String
    }

    class Cat{
        +Cat(String name, int age, int hunger, int happiness)
        +makeSound() String
    }
    Zoo o-- Animal
    Animal <|-- Dog
    Animal <|-- Cat

```