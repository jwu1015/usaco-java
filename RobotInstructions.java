import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
public class RobotInstructions {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static List<Pair> allSubsets(List<Pair> dirs) {
        List<Pair> v = new ArrayList<>();
        v.add(new Pair(0, 0));
        for (Pair d : dirs) {
            int size = v.size();
            for (int i = 0; i < size; i++) {
                v.add(new Pair(v.get(i).first + d.first, v.get(i).second + d.second));
            }
        }
        Collections.sort(v, (a, b) -> {
            if (a.first == b.first) {
                return Integer.compare(a.second, b.second);
            }
            return Integer.compare(a.first, b.first);
        });
        return v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair goal = new Pair(sc.nextInt(), sc.nextInt());
        List<Pair> dirs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dirs.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        List<Pair> a = allSubsets(dirs.subList(0, N / 2));
        List<Pair> b = allSubsets(dirs.subList(N / 2, N));
        Collections.reverse(b);
        int[]ans = new int[N+1];
        List<Integer>withNum=new ArrayList<>();
        Pair prev = new Pair(10^18,10^18);
        int n=0;
        for(Pair num:a){
            Pair rest= new Pair(goal.first-num.first,goal.second-num.second);
            if(!rest.equals(prev)){
                prev=rest;
                withNum=new ArrayList<>((Collections.nCopies(N/2+1,0)));
                while(n<b.size()&&b.get(n).first> rest.first&&b.get(n).second>rest.second){
                    n++;
                }
                while(n<b.size()&&b.get(n).first== rest.first&&b.get(n).second==rest.second){
                    n++;
                }
            }
            for(int i=0;i<withNum.size();i++){
                ans[i+num.second]+=withNum.get(i);
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(ans[i]);
        }
    }
}
