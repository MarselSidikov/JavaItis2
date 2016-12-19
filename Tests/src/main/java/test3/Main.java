package test3;


public class Main {

    int getValue() {
        return (true ? null : 0);
    }


    public static void main(String[] args)  {
        Main obj = new Main();
        obj.getValue();;
    }
}
