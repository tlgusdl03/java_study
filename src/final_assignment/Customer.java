//package final_assignment;
//
//import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Customer {
//
////    public static Connection getConnection(){
////        try{
////            String driver = "개인 sql hosting 사용";
////            String url = "개인 서버 url";
////            String user = "usr ID";
////            String pass = "usr PW";
////            Class.forName(driver);
////            Connection con = DriverManager.getConnection(url, user, pass);
////            System.out.println("The Connection Successful");
////            return con;
////        }catch (Exception e){
////            System.out.println(e.getMessage());
////            return null;
////        }
////    }
//
////    public static void main(String[] args) {
////        createTable();
////    }
//
////    public static String [][] getCustomers(){
////        try{
////            Connection con = getConnection();
////            PreparedStatement statement = con.prepareStatement("Select name, author, booknumber, publisher, category, introduction FROM customer");
////            ResultSet results = statement.executeQuery();
////            ArrayList<String[]> list = new ArrayList<String[]>();
////            while(results.next()){
////                list.add(new String[] {
////                        results.getString("name"),
////                        results.getString("author"),
////                        results.getString("booknumber"),
////                        results.getString("publisher"),
////                        results.getString("category"),
////                        results.getString("introduction"),
////                });
////            }
////            System.out.println("The data has been fetched");
////            String[][] arr = new String[list.size()][5];
////            return list.toArray(arr);
////
////        }catch(Exception e){
////            System.out.println(e.getMessage());
////            return null;
////        }
////    }
//
//    // 기존 2차원 String 배열로 된 customers 정보를 ArrayList<StringTokenizer>로 변경
//    public static ArrayList<StringTokenizer> getCustomers(){
//        ArrayList<StringTokenizer> customers = new ArrayList<>();
//
//        try{
//            FileReader fr = new FileReader("./customers.txt");
//            BufferedReader br = new BufferedReader(fr);
//
//            String line;
//            while((line = br.readLine()) != null){
//                StringTokenizer attributes = new StringTokenizer(line);
//                customers.add(attributes);
//            }
//            br.close();
//            fr.close();
//        }catch (IOException e){
//            e.printStackTrace();
//            return null;
//        }
//
//        return customers;
//    }
//
//    public void createCusomer(String name, String author, String bookNumber, String publisher, String category, String introduction){
//        ArrayList<StringTokenizer> customers = new ArrayList<>();
//        try{
//
//        }
//    }
//
//    public static void createCustomer(String name, String author, String booknumber, String publisher, String category, String introduction){
//        try{
//            Connection con = getConnection();
//            PreparedStatement insert = con.prepareStatement(""
//                    + "INSERT INTO customer"
//                    + "(name, author, booknumber, publisher, category, introduction) "
//                    + "VALUE "
//                    + "('"+name+"','"+author+"','"+booknumber+"','"+publisher+"','"+category+"','"+introduction+"')");
//            insert.executeUpdate();
//            System.out.println("The data has been saved!");
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    public static void createTable(){
//        try {
//            Connection con = getConnection();
//            PreparedStatement create = con.prepareStatement(
//                    "CREATE TABLE IF NOT EXISTS "
//                            + "customer(id int NOT NULL AUTO_INCREMENT,"
//                            + "name varChar(255),"
//                            + "author varChar(255),"
//                            + "booknumber varChar(255),"
//                            + "publisher varChar(255),"
//                            + "category varChar(255),"
//                            + "introduction varChar(255),"
//                            + "PRIMARY KEY(id))");
//            create.execute();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally{
//            System.out.println("Table successfully created");
//        }
//    }
//
//
//}
