package week_4;

class ArrayUtil{

    static int[] concat(int[] array1, int[] array2){
        int newLength = array1.length + array2.length;
        int[] result;
        result = new int[newLength];

        int index = 0;

        for(int element : array1){
            result[index] = element;
            index++;
        }

        for(int element : array2){
            result[index] = element;
            index++;
        }

        return result;
    }

    static void print(int[] array){
        int num = array.length;

        System.out.print("[ ");
        for (int i = 0; i < num; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

}
public class FirstTime_04 {
    public static void main(String[] args) {
        int[] array1 = {1993, 0, 5, 1, 6};
        int[] array2 = {1990, 0, 2, 1, 2};
        int[] array3;

        array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
