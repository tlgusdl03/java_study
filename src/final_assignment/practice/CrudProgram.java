package final_assignment.practice;

import final_assignment.practice.dto.Person;

import java.util.List;

public interface CrudProgram {
    public List<Person> getAllPeople();
    public List<Person> findPeople(String name);
    public void update(String name, int newAge);
    public void delete(String name);
    public void addPerson(String name, int age, String profileImagePath);

}
