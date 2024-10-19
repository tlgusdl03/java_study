package midterm_practice;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        System.out.println(vector.capacity());  // 출력: 10 (기본 초기 용량)
        vector.add("A");
        System.out.println(vector.capacity());  // 출력: 10 (아직 용량을 다 사용하지 않음)
        for (int i = 0; i < 10; i++) {
            vector.add("Element " + i);
        }
        System.out.println(vector.size());      // 출력: 11
        System.out.println(vector.capacity());  // 출력: 20 (capacity가 자동으로 증가함)
    }
}
