public class A1Q1 {
  public static void main(String[] args) {
    String name = args[0];
    int id = Integer.parseInt(args[1]);
    if (id < 11500000 || id > 11999999){
      System.out.println(id);
    }else {
      System.out.println(name + ", welcome to SUSTECH Hot Pot Restaurant!");
    }
  }
}
