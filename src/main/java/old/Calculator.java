package old;

public class Calculator {
    private int arg1;
    private int arg2;
    private int sum;


    public Calculator(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.sum = arg1+arg2;
    }


    public int getArg1() {
        return arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public int getSum() {
        return sum;
    }
}
