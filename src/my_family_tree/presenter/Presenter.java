package my_family_tree.presenter;

import my_family_tree.model.human.Gender;
import my_family_tree.model.human.Human;
import my_family_tree.model.service.Service;
import my_family_tree.model.tree.FamilyTree;
import my_family_tree.model.tree.TreeItem;
import my_family_tree.view.View;

import java.time.LocalDate;

public class Presenter <E extends TreeItem<E>> {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHumanToTheFamily(String name, Gender gender, LocalDate birthday) {
        service.addHumanToTheFamily(name, gender, birthday);
        getTreeInfo();
    }

    public void getTreeInfo() {
        String answer = service.getTreeInfo();
        view.answer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByYear() {
        service.sortByYear();
        getTreeInfo();
    }

    public void addParents(int par, int chil) {
        service.addParents(par, chil);
    }

    public void wedding(int spouse1, int spouse2) {
        service.wedding(spouse1, spouse2);
    }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }

    public void setDeathDate(int iD, LocalDate deathday) {
        service.setDeathDate(iD, deathday);
    }
}
