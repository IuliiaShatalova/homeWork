package my_family_tree.view;

import my_family_tree.model.human.Gender;
import my_family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Начинаем работу");
        while (work){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);

    }

    public void error() {
        System.out.println("Вы ввели неверное значение");
    }

    public void finish() {
        work = false;

    }

    public void sortByYear() {
        presenter.sortByYear();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void addHumanToTheFamily() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол: ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        presenter.addHumanToTheFamily(name, gender, birthday);


    }

    private void printMenu(){
        System.out.println(menu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}