
public class A1Q1 {
    public static void main(String[] args){
       String name = args[0];
       int num = Integer.parseInt(args[1]);
       if (11500000< num && num< 12000000){
           System.out.printf("%s,Welcome to SUSTECH Hot Pot Restaurant",name);
       }else{
           System.out.printf("%d",num);
       }



    }
}
