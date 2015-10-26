class Pascal {
    public static int giaithua(int n) {
        if (n == 0) return 1;
        else return n * giaithua(n - 1);
    }

    public static int tohop(int n, int k) {
        if (n < k) return 0;
        else return giaithua(n) / giaithua(k) / giaithua(n - k);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 4 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(tohop(i, j) + " ");
            }
            System.out.println();
        }
    }
}
