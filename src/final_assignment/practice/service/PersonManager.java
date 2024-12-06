package final_assignment.practice.service;

import final_assignment.practice.CrudProgram;
import final_assignment.practice.dao.PersonDAO;
import final_assignment.practice.dto.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class PersonManager implements CrudProgram {
    private final PersonDAO personDAO;
    public PersonManager(String filePath){
        this.personDAO = new PersonDAO(filePath);
    }
    @Override
    public List<Person> getAllPeople() {
        return personDAO.getAll();
    }
    public List<Person> findPeople(String name){
        if(nameChecker(name)){
            return personDAO.find(name);
        }
        return null;
    }
    public void addPerson(String name, int age, String profileImagePath) {
        if(!nameChecker(name)){
            return;
        }

        if(!ageChecker(age)){
            return;
        }

        if(!imagePathChecker(profileImagePath)){
            profileImagePath = changeImagePath(profileImagePath);
        }

        Person person = new Person(name, age, profileImagePath);
        personDAO.add(person);
    }
    public void update(String name, int newAge){
        if(!nameChecker(name)){
            return;
        }

        if(!ageChecker(newAge)){
            return;
        }

        personDAO.update(name, newAge);
    }
    public void delete(String name){
        if(!nameChecker(name)){
            return;
        }

        personDAO.delete(name);
    }

    private String changeImagePath(String profileImagePath){
        File imageFile = new File(profileImagePath);
        if (!imageFile.exists()) {
            System.out.println("Image file does not exist: " + profileImagePath);
            return null;
        }

        String directoryPath = "src/images/";
        String fileName = imageFile.getName();
        File dir = new File(directoryPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String targetPath = resolveFileNameConflict(directoryPath, fileName);
        File targetFile = new File(targetPath);

        try{
            Files.copy(imageFile.toPath(), targetFile.toPath());
            System.out.println("Image file copied to: " + targetPath);
        }catch (IOException e){
            e.printStackTrace();
        }

        return targetPath;
    }
    private String resolveFileNameConflict(String directoryPath, String fileName) {
        File targetFile = new File(directoryPath, fileName);
        String name = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        int count=1;

        while (targetFile.exists()) {
            targetFile = new File(directoryPath, name + "_" + count + extension);
            count++;
        }

        return targetFile.getAbsolutePath();
    }
    private boolean nameChecker(String name){
        if(name.equals(null) || name.isEmpty()){
            System.out.println("Name cannot be null or empty");
            return false;
        }
        return true;
    }
    private boolean ageChecker(int age){
        if(age<0){
            System.out.println("Age cannot be negative");
            return false;
        }
        return true;
    }
    private boolean imagePathChecker(String profileImagePath){
        if(profileImagePath != null && !profileImagePath.startsWith("src/")){
            return false;
        }
        return true;
    }
}
