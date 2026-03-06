import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AnimalCareSystem {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Zoo zoo = new Zoo();

        int input = 0;
        while(true){
            input = showMenu(sc);
            switch (input){
                case 1:
                    zoo.addAnimal(sc); break;
                case 2:
                    zoo.showAnimals(); break;
                case 3:
                    zoo.playAnimal(sc); break;
                case 4:
                    zoo.feedAnimal(sc); break;
                case 5:
                    zoo.checkStatus(sc); break;
                case 6:
                    zoo.hearSound(sc); break;
                case 7:
                    System.out.println("시스템을 종료합니다.");
                    return;
            }

        }

    }

    static int showMenu(Scanner sc){
        System.out.println("=== 확장된 동물원 관리 시스템 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 특별 능력 사용");
        System.out.println("6. 사육사 관리");
        System.out.println("7. 통계보기");
        System.out.println("8. 종료");

        return inputInt(sc, "메뉴를 선택하세요: ", 1, 8);
    }

    static int inputInt(Scanner sc, String message, int start, int end){
        int input;
        while(true){
            System.out.print(message);
            try{
                input = sc.nextInt();
                if(input < start || input > end){
                    throw new InputMismatchException("범위 내의 숫자를 입력해주세요.");
                }
                return input;
            }catch (IllegalArgumentException e){
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();

            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}


class Zoo{
    private List<Animal> animals;
    private List<ZooKeeper> keepers;

    public Zoo(){
        animals = new ArrayList<>();
    }

    public void addKeeper(Scanner sc){
        System.out.print("사육사 이름을 입력하세요: ");
        String name = sc.next();
    }

    public void showAnimals(){
        for(int i=0;i<animals.size();i++){
            if(animals.get(i) instanceof Dog){
                System.out.println((i+1)+". " + animals.get(i).name + " (강아지, " + animals.get(i).age + "살)");
            }
            else{
                System.out.println((i+1)+". " + animals.get(i).name + " (고양이, " + animals.get(i).age + "살)");
            }

        }
    }

    public void addAnimal(Scanner sc){
        System.out.print("동물 이름을 입력하세요: "); // 이름 입력
        String name = sc.next();

        int age = AnimalCareSystem.inputInt(sc, "동물 나이를 입력하세요: ", 1, 100);

        int type = AnimalCareSystem.inputInt(sc, "동물 종류를 선택하세요 (1.강아지 2.고양이): ", 1, 2);

        if(type == 1){
            System.out.print(name + " (강아지, " + age + "살)가 등록되었습니다.");
            Dog dog = new Dog(name, age);
            animals.add(dog);
        }
        else{
            System.out.print(name + " (고양이, " + age + "살)가 등록되었습니다.");
            Cat cat = new Cat(name, age);
            animals.add(cat);
        }
    }

    public void feedAnimal(Scanner sc){
        System.out.println("밥을 줄 동물을 선택하세요:");
        showAnimals();
        int choice;
        while(true){
            try{
                System.out.print("선택: ");
                choice = sc.nextInt();
                if(choice < 1 || choice > animals.size()){
                    throw new InputMismatchException("범위 내의 숫자를 입력해주세요.");
                }
                break;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (IllegalArgumentException e){
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();

            }
        }
        choice -= 1;
        System.out.println("밥을 먹으니" + animals.get(choice).name + "의 포만도가 10 올라갔습니다!!");
        animals.get(choice).feed();
    }

    public void playAnimal(Scanner sc){
        System.out.println("놀아줄 동물을 선택하세요:");
        showAnimals();
        int choice;
        while(true){
            try{
                System.out.print("선택: ");
                choice = sc.nextInt();
                if(choice < 1 || choice > animals.size()){
                    throw new InputMismatchException("범위 내의 숫자를 입력해주세요.");
                }
                break;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (IllegalArgumentException e){
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();

            }
        }
        choice -= 1;
        System.out.println("밥을 먹으니" + animals.get(choice).name + "의 행복도가 10 올라갔습니다!!");
        animals.get(choice).play();
    }

    public void checkStatus(Scanner sc){
        System.out.print("상태를 확인할 동물을 선택하세요:");
        showAnimals();
        int choice;
        while(true){
            try{
                System.out.print("선택: ");
                choice = sc.nextInt();
                if(choice < 1 || choice > animals.size()){
                    throw new InputMismatchException("범위 내의 숫자를 입력해주세요.");
                }
                animals.get(choice-1).getStatus();
                break;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (IllegalArgumentException e){
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();

            }
        }
    }

    public void hearSound(Scanner sc){
        System.out.print("울음소리를 들을 동물을 선택하세요: ");
        showAnimals();
        int choice;
        while(true){
            try{
                System.out.print("선택: ");
                choice = sc.nextInt();
                if(choice < 1 || choice > animals.size()){
                    throw new InputMismatchException("범위 내의 숫자를 입력해주세요.");
                }
                System.out.println(animals.get(choice-1).makeSound());
                break;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (IllegalArgumentException e){
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();

            }
        }
    }
}

class ZooKeeper{
    private String name;
    private String major;

    ZooKeeper(String name, String major){
        this.name = name;
        this.major = major;
    }

    public void getStatus(){
        System.out.println("이름: " + this.name + " 전문분야: " + major);
    }
}

enum Food{
    MEAT, FISH, PLANT, NUTS
}

interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

abstract class Animal{
    protected String name;
    protected int age;
    protected int hunger;
    protected int happiness;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
        this.hunger = 0;
        this.happiness = 0;
    }

    public void getStatus(){
        System.out.println(this.name + "의 현재 상태: 포만도(" + this.hunger + ") 행복도(" + this.happiness + ")");
    }

    public void feed(){
        this.hunger += 10;
    }

    public void play(){
        this.happiness += 10;
    }

    abstract String makeSound();
}

abstract class Mammal extends Animal{

    Mammal(String name, int age) {
        super(name, age);
    }
}

abstract class Bird extends Animal{

    Bird(String name, int age) {
        super(name, age);
    }
}

abstract class Reptile extends Animal{

    Reptile(String name, int age) {
        super(name, age);
    }
}

class Dog extends Mammal{
    Dog(String name, int age){
        super(name, age);
    }

    @Override
    public String makeSound(){
        return "멍멍";
    }
}

class Cat extends Mammal{
    Cat(String name, int age){
        super(name, age);
    }

    @Override
    public String makeSound(){
        return "야옹";
    }
}

class Eagle extends Bird{

    Eagle(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound() {
        return "깍깍";
    }
}

class Penguin extends Bird{

    Penguin(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound(){
        return "꺅꺅";
    }
}

class Lion extends Mammal{

    Lion(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound(){
        return "으르렁";
    }
}

class Elephant extends Mammal{

    Elephant(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound(){
        return "뿌우";
    }
}

class Snake extends Reptile{

    Snake(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound(){
        return "쉬익";
    }
}

class Turtle extends Mammal{

    Turtle(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound(){
        return "없음";
    }
}