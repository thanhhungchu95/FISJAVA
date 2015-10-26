public class Telephone {
    public static int bill(int minutes) {
        int money = 27000;
        if (minutes > 0) {
            if (minutes <= 200) money += (minutes * 120);
            else if (minutes <= 400) money += 200 * 120 + (minutes - 200) * 80;
            else money += 200 * 120 + 200 * 80 + (minutes - 400) * 40;
        }
        return money;
        
    }

    public static void main(String[] args)  {
        System.out.println("Tong thoi gian goi: " + args[0] + " phut.");
        System.out.println("Tinh tien: " + Telephone.bill(Integer.parseInt(args[0])) + "d.");
    }
}
