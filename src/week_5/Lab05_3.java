package week_5;

import java.util.Scanner;

abstract class Stack{
    public abstract int length();
    public abstract  int capacity();
    public abstract String pop();
    public abstract boolean push(String str);
}

class StringStack extends Stack {

    private String[] input;
    private int tos;

    StringStack () {
        this.tos = 0;
    }

    public void setInput(int length) {
        input = new String[length];
    }

    @Override
    public int length() {
        return tos;
    }

    @Override
    public int capacity() {
        return input.length;
    }

    @Override
    public String pop() {
        if (tos == 0) {
            return null;
        } else {
            tos--;
            return input[tos];
        }
    }

    @Override
    public boolean push(String str) {
        if(tos < input.length){
            input[tos] = str;
            tos++;
            return true;
        }
        else{
            return false;
        }
    }
}
public class Lab05_3 {

    static StringStack myStack = new StringStack();
    static Scanner scanner = new Scanner(System.in);

    public static void closeScanner(){
        scanner.close();
    }

    public static void setLength(){
        System.out.print("size of stack: ");
        int length = scanner.nextInt();
        myStack.setInput(length);
        scanner.nextLine();
    }
    public static void setStack(){
        while(true){

            System.out.print("input: ");
            String input = scanner.nextLine();

            if(input.equals("exit")){
                String element;
                int length = myStack.length();

                System.out.print("pop all strings: ");
                for(int i=0; i<length; i++){
                    element = myStack.pop();
                    System.out.print(element + " ");
                }
                break;
            }
            else{
                boolean result = myStack.push(input);
                if(!result){
                    System.out.println("stack is full!");
                }
            }
        }
    }
    public static void main(String[] args) {
        setLength();
        setStack();
        closeScanner();
    }
}
