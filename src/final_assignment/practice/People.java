package final_assignment.practice;

import java.util.ArrayList;

public class People {
    private ArrayList<Person> people;

    public People(){
        people = new ArrayList<>();
    }
    public void clear(){
        people.clear();
    }

    public ArrayList<Person> getPeople(){
        return people;
    }

    public void add(Person person){
        people.add(person);
    }

    public void delete(String name) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).name.equals(name)) {
                people.remove(i);
                break;
            }
        }
    }

    public void update(String name, int newAge) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).name.equals(name)) {
                people.set(i, new Person(name, newAge, "test"));
                break;
            }
        }
    }
}
