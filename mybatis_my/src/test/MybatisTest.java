package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import bean.Employee;
import mapper.EmployeeMapper;
import util.Factory;

public class MybatisTest {
	public static void main(String[] args) throws Exception {
		//1.根据xml文件（全局配置） 创建一个sqlSessionFactory对象
				String resource  = "mybatis-config.xml";
		 InputStream inputStream  = Resources.getResourceAsStream(resource);
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		          //2.获取sqlsession实例,能直接执行已经映射的sql语句
		 SqlSession openSession = factory.openSession();
		 try {

		  //3. select 两个参数 第一个：sql的唯一标识 也就是配置文件中的id 第二个： 执行sql用的参数
		 //为了以防万一 一般是namespace+id :  bean.EmployeeMapper.selectEmp
		//openSession 有增删查改四种，对应映射文件中的增删查改
		 Employee employee = (Employee)openSession.selectOne("selectEmp", 1);
		 System.out.println(employee); 
		 //关掉session
		 }finally{
		     openSession.close();
		 }
	}
	@Test
public void test() throws Exception{
		//1.根据xml文件（全局配置） 创建一个sqlSessionFactory对象
		String resource  = "mybatis-config.xml";
 InputStream inputStream  = Resources.getResourceAsStream(resource);
 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
          //2.获取sqlsession实例,能直接执行已经映射的sql语句
 SqlSession openSession = factory.openSession();
 try {

 /* 3. 调用openSession的增删改查
 select 两个参数 
   第一个：sql的唯一标识 也就是配置文件中的id 第二个： 执行sql用的参数
   为了以防万一 一般是namespace+id :  bean.EmployeeMapper.selectEmp
 */
// Employee employee = (Employee)openSession.selectOne("selectEmp", 1);
	 
	 Employee employee = (Employee)openSession.selectOne("getEmpById", 1);
 System.out.println(employee);
 //关掉session
 }finally{
     openSession.close();
 }
 
}

@Test
//
public void test1() throws Exception{
	//1.获取sqlsessionFactory工厂类.因为经常用到所以把他当做工具类抽象出来
	 Factory f  = new Factory();
	 SqlSessionFactory factory = f.getFactory();
	//2.获取session对象
	 SqlSession openSession = factory.openSession();
	 try {
	
	 //3.和以前的就有了区别，获取接口的实现对象
     EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
     //4.利用接口调用放法
     Employee empById = mapper.getEmpById(1);
     System.out.println(empById);
	 }finally {
		 openSession.close();
	 }
	 
	 
}
}