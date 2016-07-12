package week1.day1;

public class Day1VariableCollector {

    private String s = "Sally";
    private int i = 189;
    private boolean b = true;
    private long l = 1238;
    private char c = 'a';
    private char[] ca = {'a','b','c'};

    private int[] ia = {1,2,3,4};
    private int[] ia2 = new int[2];


    public void changeArray() {
        ia2[1] = 5;
        System.out.println("Space 2: "+ia2[1]);
    }


    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public char[] getCa() {
        return ca;
    }

    public void setCa(char[] ca) {
        this.ca = ca;
    }
}
