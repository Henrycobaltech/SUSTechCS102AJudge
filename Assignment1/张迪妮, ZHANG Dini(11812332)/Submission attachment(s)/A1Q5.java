package self_ordering_system;

import java.util.ArrayList;
import java.util.Scanner;

public class A1Q5 {

	private String MenuPrice ;
	public A1Q5()
	{
		
	}
	
	private void ScanInput()
	{
		 Scanner in=new Scanner(System.in);//ͨ��new Scanner(System.in)����һ��Scanner������̨��һֱ�ȴ����룬ֱ���ûس���������������������ݴ���Scanner
			System.out.println("please input the A1Q5 data");
		while( in.hasNext() )
		{
			in.useDelimiter("\n");
			MenuPrice = in.next() ;
			CheckMenuPrice() ;
			break ;
		}
		System.out.println("End");
	}
	
	private void CheckMenuPrice()
	{
	 int mPos = 0 ;
   	 int nPos = 0 ;
   	 String price = this.MenuPrice ;
   	 String space = " " ;
   	 int totalConSume = 0 ; //�����ܼ�ֵ
   	 int consumeNum = 0 ; //���Ѵ���
   	 int maxAcount = 0 ;
   	 while( nPos >= 0 )
   	 {
   		 String value = "" ;
   		 nPos = price.indexOf(space,mPos) ;
   		 if( nPos < 0 ) {
   			 if( mPos == price.length()) break ;
   			 value = price.substring(mPos, price.length()-1) ;
   		 }
   		 else
   		 {
   		     value = price.substring(mPos, nPos) ;
   		 }
   		 int kPos = value.indexOf(".") ;
   		 if( kPos > 0 )
   		 {
   			 String sBit = value.substring(kPos-1, kPos) ;
   			 if( sBit.equals("4") ) //��λ��Ϊ4�ģ���Ҫ�޸ĳ�9
   			 {
   				 float fPrice = Float.valueOf(value) ;
   				 fPrice += 5 ; //��ΪҪ�ĳ�9.ֻ��Ҫ+5�Ϳ�����
   				 sBit = String.valueOf(fPrice) ;
   				 //���
   				System.out.println(sBit);
   			 }
   			 if( sBit.equals("2"))//��λ��Ϊ2�ģ���Ҫ�޸ĳ�6
   			 {
   				float fPrice = Float.valueOf(value) ;
  				 fPrice += 4 ; //��ΪҪ�ĳ�6.ֻ��Ҫ+4�Ϳ�����
  				 sBit = String.valueOf(fPrice) ;
  				 //���
  				System.out.println(sBit);
   			 }
   		 }
         if( nPos < 0 ) break ;
   	     mPos = nPos+space.length() ; 
   	 }
	}
	
	 public static void main(String[] args) 
	 {
		 A1Q5 a5 = new A1Q5() ;
		 a5.ScanInput();
	 }
}
