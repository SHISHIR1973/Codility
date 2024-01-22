import java.util.*;
import java.io.File;

public class task2{
    public int solution(int []F, int []S){
        int down_index=0;
        int F_cost=F[0];
        int S_cost=Arrays.stream(S).sum();
        int min_cost_path=F_cost+S_cost;
        for(int i=1;i<F.length;i++){
            F_cost+=F[i];
            S_cost-=S[i-1];
            if(min_cost_path > (F_cost+S_cost)){
                min_cost_path=F_cost+S_cost;
                down_index=i;
            }
        }
        String blank=new String(new char[down_index]).replace("\0", "    ");
        for (int i=0;i<F.length-1;i++){
            if (i<down_index){
                System.out.print(F[i]+"-->");
            }
            else if(i==down_index){
                System.out.print(F[i]+"\n"+blank+"|"+"\n"+blank+"v"+"\n"+blank+S[i]+"-->");
            }
            else{
                System.out.print(S[i]+"-->");
            }
        }
        if (down_index==(F.length-1)){
            System.out.println(F[F.length-1]+"\n"+blank+"|"+"\n"+blank+"v"+"\n"+blank+S[S.length-1]);
        }
        else{
            System.out.println(S[S.length-1]);
        }
        return min_cost_path;
    }
    public static void main(String []args) throws Exception{
        task2 obj=new task2();
        Scanner sc = new Scanner(new File("input.txt"));
        while(sc.hasNextLine()){
            String inp=sc.nextLine();
            System.out.println(inp);
            String []val=Arrays.stream(inp.split("[\\](,) \\[]")).filter(str -> !str.isEmpty()).toArray(String[]::new);
            int k=val.length/2;
            int []p=new int[k];
            int []s=new int[k];
            for (int i=0;i<val.length;i++){
                if (i<k){
                    p[i]=Integer.parseInt(val[i]);
                }
                else{
                    s[i-k]=Integer.parseInt(val[i]);
                }
            }
            System.out.println(obj.solution(p, s));
        }
        sc.close();

    }
}