package final_assignment.practice.admin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AdminManager {
    private final String adminFilePath = "src/final_assignment/practice/admin.txt";
    private Map<String, String> adminMap = new HashMap<>();

    public AdminManager(){
        loadAdmins();
    }

    private void loadAdmins(){
        File file = new File(adminFilePath);
        if (!file.exists()) {
            try{
                file.createNewFile();
                System.out.println("Created new admin file.");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if(parts.length == 2){
                    adminMap.put(parts[0], parts[1]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean login(String id, String password){
        String storedPassword = adminMap.get(id);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void addAdmin(String id, String password){
        adminMap.put(id, password);
        saveAdmins();
    }

    public void removeAdmin(String id){
        adminMap.remove(id);
        saveAdmins();
    }

    public void saveAdmins() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(adminFilePath))) {
            for (Map.Entry<String, String> entry : adminMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
