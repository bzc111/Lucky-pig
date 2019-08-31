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
		//1.����xml�ļ���ȫ�����ã� ����һ��sqlSessionFactory����
				String resource  = "mybatis-config.xml";
		 InputStream inputStream  = Resources.getResourceAsStream(resource);
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		          //2.��ȡsqlsessionʵ��,��ֱ��ִ���Ѿ�ӳ���sql���
		 SqlSession openSession = factory.openSession();
		 try {

		  //3. select �������� ��һ����sql��Ψһ��ʶ Ҳ���������ļ��е�id �ڶ����� ִ��sql�õĲ���
		 //Ϊ���Է���һ һ����namespace+id :  bean.EmployeeMapper.selectEmp
		//openSession ����ɾ������֣���Ӧӳ���ļ��е���ɾ���
		 Employee employee = (Employee)openSession.selectOne("selectEmp", 1);
		 System.out.println(employee); 
		 //�ص�session
		 }finally{
		     openSession.close();
		 }
	}
	@Test
public void test() throws Exception{
		//1.����xml�ļ���ȫ�����ã� ����һ��sqlSessionFactory����
		String resource  = "mybatis-config.xml";
 InputStream inputStream  = Resources.getResourceAsStream(resource);
 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
          //2.��ȡsqlsessionʵ��,��ֱ��ִ���Ѿ�ӳ���sql���
 SqlSession openSession = factory.openSession();
 try {

 /* 3. ����openSession����ɾ�Ĳ�
 select �������� 
   ��һ����sql��Ψһ��ʶ Ҳ���������ļ��е�id �ڶ����� ִ��sql�õĲ���
   Ϊ���Է���һ һ����namespace+id :  bean.EmployeeMapper.selectEmp
 */
// Employee employee = (Employee)openSession.selectOne("selectEmp", 1);
	 
	 Employee employee = (Employee)openSession.selectOne("getEmpById", 1);
 System.out.println(employee);
 //�ص�session
 }finally{
     openSession.close();
 }
 
}

@Test
//
public void test1() throws Exception{
	//1.��ȡsqlsessionFactory������.��Ϊ�����õ����԰�������������������
	 Factory f  = new Factory();
	 SqlSessionFactory factory = f.getFactory();
	//2.��ȡsession����
	 SqlSession openSession = factory.openSession();
	 try {
	
	 //3.����ǰ�ľ��������𣬻�ȡ�ӿڵ�ʵ�ֶ���
     EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
     //4.���ýӿڵ��÷ŷ�
     Employee empById = mapper.getEmpById(1);
     System.out.println(empById);
	 }finally {
		 openSession.close();
	 }
	 
	 
}
}