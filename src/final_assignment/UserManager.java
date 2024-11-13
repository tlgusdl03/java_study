package final_assignment;

import java.io.*;
import java.util.LinkedHashMap;

public class UserManager {
    private static UserManager instance = new UserManager();
    public static UserManager getInstance(){
        return  instance;
    }

    private File file;

    private LinkedHashMap<String, User> users = new LinkedHashMap<String, User>();

    public UserManager(){
        file = new File("./data.csv");
        if (file.exists()) {
            load();
        }
    }

    public void load(){
        try{
            var fr = new FileReader(file);
            var br = new BufferedReader(fr);

            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] tokens = line.split(",");

                User user = new User();
                user.studentName = tokens[0];
                user.studentNumber = tokens[1];
                user.grade = tokens[2];
                user.studentID = tokens[3];
                user.studentPW = tokens[4];
                user.phoneNumber = tokens[5];
                user.email = tokens[6];
                user.address = tokens[7];

                System.out.println(user.studentName);

                users.put(user.studentID, user);
            }

            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void save(){
        try{
            FileWriter fw = new FileWriter(file);
            fw.append("StudentName,StudentNumber,Grade,StudentID,StudentPW,PhoneNumber,Email,Address\n");

            for (var entry : users.entrySet()) {
                User user = entry.getValue();

                String[] tokens = new String[]{
                        user.studentName,
                        user.studentNumber,
                        user.grade,
                        user.studentID,
                        user.studentPW,
                        user.phoneNumber,
                        user.email,
                        user.address
                };
                fw.append(String.join(",", tokens) + "\n");
            }
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public User getUser(String studentID){
        return users.get(studentID);
    }

    public void  createUser(User user){
        users.put(user.studentID, user);
        save();
    }
}
