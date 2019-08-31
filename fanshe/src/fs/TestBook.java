package fs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.book;
import bean.book1;
public class TestBook {
	public static void main1(String[] args) throws Exception {
		
		//1.获取
		Class<?> class1 = Class.forName("bean.book");
		//2.获取构造方法,利用参数类型
	     Constructor<?> con = class1.getConstructor(String.class,double.class);
	    //3.给对象传参，实例化对象.返回的是object类型的
	     book book = (book)con.newInstance("白占成学Java",23.4);
	     System.out.println(book);
	  //这样做不好。所以至少保留无参的构造方法，这样的话，就可以直接实例化对象，然后用set和GET去设置数据      

	}
	public static void main2(String[] args) throws Exception {
		//这样是最好的方法
		Class<?> class1 = Class.forName("bean.book");
		  book book = (book)class1.newInstance();
		            book.setTitle("白占成学java");
		            book.setPrice(3432.3);
		//输出对象，其实就是输出他的toString方法
		            System.out.println(book);
		            
	}
	public static void main3(String[] args) throws Exception {
		//普通的方法的调用步骤
		/*
		 * String name = "title"; 
		 * //1.调用系统提供的默认无参构造，实例化对象
		 *  Class<?> cls =Class.forName("bean.book1");
		 * 
		 * book1 obj = (book1)cls.newInstance();
		 * 
		 * obj.setTitle("战犯");
		 * 
		 * System.out.println(obj.getTitle());
		 */
		
		//反射调用方法
		   String name = "title";
		 Class<?> class1 = Class.forName("bean.book1");
		 //1.获取对象 
		  book1 conn = (book1)class1.newInstance();
		  //getMethod取得指定方法  跟一个方法名称和参数类型
		  //类对象来获取  class.getMethod
		 Method set = class1.getMethod("set"+initcap(name), String.class);
		//Method set = class1.getMethod("setTitle", String.class);
		  Method get =class1.getMethod("get"+initcap(name)); 
		 //invoke   方法的调用 /，给出对象 和 参数的数值
		  set.invoke(conn, "白占成学习java");//等价于book.setTitle("java")
		  System.out.println(get.invoke(conn)); 
		  System.out.println();
		
	}
	 public static String initcap(String str) {
		 return str.substring(0,1).toUpperCase()+str.substring(1);
	 } 
  public static void main4(String[] args) throws Exception {
	//反射调用类的成员或者说是属性
	    // 1.得到类的字节码对象
	  Class<?> forName = Class.forName("bean.book2");
	     //2.利用无参构造方法 获取类的对象
	   Object conn = forName.newInstance();
	     //3.用类的字节码对象获取，类的属性
	    Field field = forName.getDeclaredField("title");
	  //4.取消封装
        field.setAccessible(true);
	    //5.同样是利用好像普通方法那样来赋值
       field.set(conn, "白占成学java");	
        
       System.out.println(field.get(conn));
                   
}
  public static void main(String[] args) {
	Integer a = 127;
	Integer b = 127;
	System.out.println(a==b);
	Integer c= 128;
	Integer d = 128;
	System.out.println(d==c);
}
}
