package fs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import bean.book;
import bean.book1;
public class TestBook {
	public static void main1(String[] args) throws Exception {
		
		//1.��ȡ
		Class<?> class1 = Class.forName("bean.book");
		//2.��ȡ���췽��,���ò�������
	     Constructor<?> con = class1.getConstructor(String.class,double.class);
	    //3.�����󴫲Σ�ʵ��������.���ص���object���͵�
	     book book = (book)con.newInstance("��ռ��ѧJava",23.4);
	     System.out.println(book);
	  //���������á��������ٱ����޲εĹ��췽���������Ļ����Ϳ���ֱ��ʵ��������Ȼ����set��GETȥ��������      

	}
	public static void main2(String[] args) throws Exception {
		//��������õķ���
		Class<?> class1 = Class.forName("bean.book");
		  book book = (book)class1.newInstance();
		            book.setTitle("��ռ��ѧjava");
		            book.setPrice(3432.3);
		//���������ʵ�����������toString����
		            System.out.println(book);
		            
	}
	public static void main3(String[] args) throws Exception {
		//��ͨ�ķ����ĵ��ò���
		/*
		 * String name = "title"; 
		 * //1.����ϵͳ�ṩ��Ĭ���޲ι��죬ʵ��������
		 *  Class<?> cls =Class.forName("bean.book1");
		 * 
		 * book1 obj = (book1)cls.newInstance();
		 * 
		 * obj.setTitle("ս��");
		 * 
		 * System.out.println(obj.getTitle());
		 */
		
		//������÷���
		   String name = "title";
		 Class<?> class1 = Class.forName("bean.book1");
		 //1.��ȡ���� 
		  book1 conn = (book1)class1.newInstance();
		  //getMethodȡ��ָ������  ��һ���������ƺͲ�������
		  //���������ȡ  class.getMethod
		 Method set = class1.getMethod("set"+initcap(name), String.class);
		//Method set = class1.getMethod("setTitle", String.class);
		  Method get =class1.getMethod("get"+initcap(name)); 
		 //invoke   �����ĵ��� /���������� �� ��������ֵ
		  set.invoke(conn, "��ռ��ѧϰjava");//�ȼ���book.setTitle("java")
		  System.out.println(get.invoke(conn)); 
		  System.out.println();
		
	}
	 public static String initcap(String str) {
		 return str.substring(0,1).toUpperCase()+str.substring(1);
	 } 
  public static void main4(String[] args) throws Exception {
	//���������ĳ�Ա����˵������
	    // 1.�õ�����ֽ������
	  Class<?> forName = Class.forName("bean.book2");
	     //2.�����޲ι��췽�� ��ȡ��Ķ���
	   Object conn = forName.newInstance();
	     //3.������ֽ�������ȡ���������
	    Field field = forName.getDeclaredField("title");
	  //4.ȡ����װ
        field.setAccessible(true);
	    //5.ͬ�������ú�����ͨ������������ֵ
       field.set(conn, "��ռ��ѧjava");	
        
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
