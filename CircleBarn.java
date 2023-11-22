import java.util.Scanner;
public class CircleBarn {
        public static void main(String[] args) {
            int MAXV = 5000000;
            boolean[] sieve = new boolean[MAXV + 1];
            int i = 2;
            while (i * i < sieve.length) {
                if (!sieve[i]) {
                    for (int j = i * i; j < sieve.length; j += i) {
                        sieve[j] = true;
                    }
                }
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int k = 0; k < t; k++) {
                int n = scanner.nextInt();
                int[] l = new int[n];
                for (int j = 0; j < n; j++) {
                    l[j] = scanner.nextInt();
                }
                int moves = (int) 1e9;
                for (int j = 0; j < n; j++) {
                    int x = l[j];
                    int numMoves;
                    if (x % 2 == 0) {
                        numMoves = x / 2;
                    } else {
                        int cand = x;
                        while (sieve[cand]) {
                            cand -= 4;
                        }
                        numMoves = (x - cand) / 2 + 1;
                    }
                    if (numMoves / 2 < moves / 2) {
                        moves = numMoves;
                        if (moves == 1) {
                            break;
                        }
                    }
                }
                if (moves % 2 == 1) {
                    System.out.println("Farmer John");
                } else {
                    System.out.println("Farmer Nhoj");
                }
            }
        }
    }