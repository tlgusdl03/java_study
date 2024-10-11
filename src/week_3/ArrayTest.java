package week_3;

class Student{

}
public class ArrayTest {
    public static void main(String[] args) {
        int[][] intArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}};

        for (int[] i : intArray) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
