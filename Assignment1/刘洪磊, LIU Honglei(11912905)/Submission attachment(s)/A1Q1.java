public class A1Q1 {
    public static void main(String[] args){
        String name = args[0];
        int studentID = Integer.parseInt(args[1]);
        if (studentID>=11500000&&studentID<=11999999)
        { System.out.println(name+", welcome to SUSTECH Hot Pot Restaurant!");}
        else
        {System.out.println(studentID);}


    }
}
