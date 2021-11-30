package pat刷题.APBforPolynomials;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        //指数
        int[] numsaex = new int[a];
        //系数
        double[] numsaco = new double[a];
        for(int i = 0; i < a; i++) {
            numsaex[i] = in.nextInt();
            numsaco[i] = in.nextDouble();
        }

        int b = in.nextInt();
        int[] numsbex = new int[b];
        double[] numsbco = new double[b];
        for(int i = 0; i < b; i++) {
            numsbex[i] = in.nextInt();
            numsbco[i] = in.nextDouble();
        }

        int all = 0;
        int i = 0, j = 0;
        int[] ex = new int[a + b];
        double[] co = new double[a + b];
        while(i < a || j < b) {
            if (i == a) {
                ex[all] = numsbex[j];
                co[all] = numsbco[j];
                j++;
            } else if (j == b) {
                ex[all] = numsaex[i];
                co[all] = numsaco[i];
                i++;
            } else if (numsaex[i] < numsbex[j]) {
                ex[all] = numsbex[j];
                co[all] = numsbco[j];
                j++;
            } else if (numsaex[i] > numsbex[j]) {
                ex[all] = numsaex[i];
                co[all] = numsaco[i];
                i++;
            } else {
                ex[all] = numsaex[i];
                co[all] = numsaco[i] + numsbco[j];
                i++;
                j++;
            }
            all++;
        }

        System.out.print(all);
        for (int k = 0; k < all; k++) {
            System.out.print(" " + ex[k] + " " + co[k]);
        }
    }
}
