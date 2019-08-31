package fs;

import java.util.Date;

import org.junit.Test;

public class TestDemo {
	@Test
 public void  Oc(){
		Date d = new Date();
   Class<?> class1 = d.getClass();
   System.out.println("第一种："+class1);  
	}
	@Test
	 public void  Dd(){
	   Class<?> class1 =Date.class;
	   System.out.println("第二种："+class1);  
		}
	@Test
	 public void Ww() throws Exception{
	   Class<?> class1 =Class.forName("java.util.Date");
	   System.out.println("第三种："+class1);  
		}

}
