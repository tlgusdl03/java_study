package midterm_practice;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        // ArrayList 생성
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // Iterator 생성
        Iterator<String> iterator = list.iterator();

        // Iterator를 사용한 요소 순회
        System.out.println("Iterator를 사용한 리스트 순회:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // 새로운 Iterator 생성 후 요소 삭제
        Iterator<String> removeIterator = list.iterator();
        while (removeIterator.hasNext()) {
            String fruit = removeIterator.next();
            if (fruit.equals("Banana")) {
                removeIterator.remove();  // 요소 삭제
            }
        }

        // 요소 삭제 후 리스트 출력
        System.out.println("\nBanana 삭제 후 리스트:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
