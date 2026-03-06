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
        int input;

        System.out.println("=== 동물원 관리 시스템 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 동물 상태 확인");
        System.out.println("6. 울음소리 듣기");
        System.out.println("7. 종료");
        while(true){
            try{
                System.out.print("메뉴를 선택하세요: ");
                input = sc.nextInt();
                if(!(1<=input&&input<=7)){
                    throw new IllegalArgumentException("범위가 잘못 되었습니다. 다시 입력해주세요.");
                }
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
                sc.nextLine();
            }
        }

        return input;
    }

}


class Zoo{
    private List<Animal> animals;

    public Zoo(){
        animals = new ArrayList<>();
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
        int age;

        while(true){
            System.out.print("동물 나이를 입력하세요: "); // 나이 입력
            try{
                age = sc.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            }
        }

        while(true){
            System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이): "); // 종류 입력
            try{
                int type = sc.nextInt();
                if(type == 1){
                    System.out.print(name + "강아지, " + age + "살)가 등록되었습니다.");
                    Dog dog = new Dog(name, age, 0, 0);
                    animals.add(dog);
                }
                else if(type == 2) {
                    System.out.print(name + "고양이, " + age + "살)가 등록되었습니다.");
                    Cat cat = new Cat(name, age, 0, 0);
                    animals.add(cat);
                }
                else {
                    throw new IllegalArgumentException("1, 2만 입력 가능합니다.");
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
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

abstract class Animal{
    protected String name;
    protected int age;
    protected int hunger;
    protected int happiness;

    Animal(String name, int age, int hunger, int happiness){
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.happiness = happiness;
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

class Dog extends Animal{
    Dog(String name, int age, int hunger, int happiness){
        super(name, age, hunger, happiness);
    }

    @Override
    public String makeSound(){
        return "멍멍";
    }
}

class Cat extends Animal{
    Cat(String name, int age, int hunger, int happiness){
        super(name, age, hunger, happiness);
    }

    @Override
    public String makeSound(){
        return "야옹";
    }
}