package final_assignment.practice;

public interface CrudProgram {
    public People getAll();
    public People update(String name, int newAge);
    public People delete(String name);
    public People create(String name, int age, String profileImagePath);
}
