
public class A1Q1 {
    public static void main(String[]args){
        String name=args[0];
        int ID=Integer.parseInt(args[1]);

        if ((ID>=11510000) && (ID<=11919999))
            System.out.printf("%s, welcome to SUSTECH Hot Pot Restaurant! ",name);
        else
            System.out.printf(" %d  ", ID);
     }
}
