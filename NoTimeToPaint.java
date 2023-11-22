import java.util.Scanner;
import java.util.Stack;
public class NoTimeToPaint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[]colors=new char[N];
        String S=scanner.nextLine();
        for(int i=0;i<N;i++){
            colors[i]=S.charAt(i);
        }
        int Q =scanner.nextInt();
        int[]ans=new int[N];
        ans[0]=1;
        Stack<Character> stack =new Stack<>();
        stack.push(colors[0]);
        for(int i=0;i<N;i++){
            while(stack.size()>0&& stack.peek()>colors[i]){
                stack.pop();
            }
            if(stack.peek()<colors[i]||stack.size()==0){
                stack.push(colors[i]);
                ans[i]=ans[i-1]+1;
            }else{
                ans[i]=ans[i-1];
            }
        }
        stack=new Stack<Character>();
        stack.push(colors[N-1]);
        int[] back=new int[N];
        back[N-1]=1;
        for(int i=N-1;i>0;i--){
            while(stack.size()>0&& stack.peek()>colors[i]){
                stack.pop();
            }
            if(stack.peek()<colors[i]||stack.size()==0){
                stack.push(colors[i]);
                back[i]=ans[i+1]+1;
            }else{
                ans[i]=ans[i+1];
            }
        }
        for(int i=0;i<Q;i++){
            int k=scanner.nextInt();
            int ans1=ans[i-1];
            int q=scanner.nextInt();
            int ans2=back[N-q];
            System.out.println(ans1+ans2);
        }
    }

}
