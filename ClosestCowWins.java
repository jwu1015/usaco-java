import java.util.*;
public class ClosestCowWins {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        List<Pair> patches = new ArrayList<>();
        for (int i = 0; i < K; ++i) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            patches.add(new Pair(first, second));
        }
        
        for (int i = K; i < K + M; ++i) {
            int first = scanner.nextInt();
            patches.add(new Pair(first, -1));
        }
        Collections.sort(patches);
        List<Long> increases = new ArrayList<>();
        int last_i = -1;
        long sum_range = 0;
        
        
	}
	static class Pair implements Comparable<Pair> {
        int first;
        int second;
        
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    } 
	
}
