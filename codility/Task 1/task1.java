import java.util.*;
import java.io.File;

public class task1{
    public int solution(int []P, int []S){
        int Psum=0;
        int tmp=0;
        int res=0;
        for (int i=0;i<P.length;i++){
            if ((P[i]>9)||(S[i]>9)||(P[i]>S[i])){
                return -1;
            }
            else{
                Psum+=P[i];
            }
        }
        Arrays.sort(S);
        for(int i=S.length-1;i>=0;i--){
            if (tmp<Psum){
                tmp+=S[i];
                res+=1;
            }
        }
        return res;
    }
    public static void main(String []args) throws Exception{
        task1 obj=new task1();
        Scanner sc = new Scanner(new File("test-input.txt"));
        while(sc.hasNextLine()){
            String inp=sc.nextLine();
            System.out.println(inp);
            int k=(inp.length()-5)/4;
            int []p=new int[k];
            int []s=new int[k];
            int x=0;
            for (int i=2;i<(inp.length()-2);i+=2){
                if (i<((inp.length()-1)/2)){
                    p[x]=Integer.parseInt(String.valueOf(inp.charAt(i)));
                    x+=1;
                }
                else if (i>((inp.length()-1)/2)){
                    s[x-k]=Integer.parseInt(String.valueOf(inp.charAt(i)));
                    x+=1;
                }
                else{
                    continue;
                }
            }
            System.out.println(obj.solution(p, s));
        }
        sc.close();

    }
}