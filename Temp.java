class Temp {
    static int x = 10; // variable 
    public static void show() {
        // method
        System.out.println(x);
    }

    public static void main(String args[]) {
        Temp t = new Temp(); // object 1
        t.show(); // method call
        Temp t1 = new Temp(); // object 2
        t1.x = 20;
        t1.show();
    }
}
