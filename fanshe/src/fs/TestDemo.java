package fs;

import java.util.Date;

import org.junit.Test;

public class TestDemo {
	@Test
 public void  Oc(){
		Date d = new Date();
   Class<?> class1 = d.getClass();
   System.out.println("��һ�֣�"+class1);  
	}
	@Test
	 public void  Dd(){
	   Class<?> class1 =Date.class;
	   System.out.println("�ڶ��֣�"+class1);  
		}
	@Test
	 public void Ww() throws Exception{
	   Class<?> class1 =Class.forName("java.util.Date");
	   System.out.println("�����֣�"+class1);  
		}

}
