import java.util.*;
public class Cowntagion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[]tree=new ArrayList[N];
		for(int i=0;i<N;i++) {
			tree[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			tree[i].add(a);
			tree[i].add(b);
		}
	}
	public static int ans(int node,boolean[]sick, ArrayList<Integer>[]tree) {
		sick[node]=true;
		int cows=0;
		int ans=0;
		for(int x:tree[node]) {
			if(sick[x]) {
				continue;
			}
			cows++;
			ans+=ans(x,sick,tree);
		}
		int pow=1;
		while(pow<cows+1) {
			
		}
	}

}
