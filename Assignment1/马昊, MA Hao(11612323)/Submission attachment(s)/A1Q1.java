public class A1Q1 {
    public static void main(String[] args) {
        String name = args[0];
        int id = Integer.parseInt(args[1]);
        if(11500000<=id&&id<=11999999){
            System.out.println(name+", welcome to SUSTECH Hot Pot Restaurant");
        }else {
            System.out.println(id);
        }
    }
}
