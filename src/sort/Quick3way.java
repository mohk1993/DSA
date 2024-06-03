package sort;

import java.util.Random;
import java.util.Scanner;

public class Quick3way {
    private static Random random = new Random();
    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static void shuffle(Object[] a) {
        if (a == null) throw new IllegalStateException();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int rand = i + random.nextInt(n - i);
            Object swap = a[i];
            a[i] = a[rand];
            a[rand] = swap;
        }
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split(" ");
        Quick3way.sort(a);
        Quick3way.show(a);
    }
}
