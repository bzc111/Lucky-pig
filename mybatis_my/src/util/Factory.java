package util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
public SqlSessionFactory getFactory() throws Exception {
	String resource  = "mybatis-config.xml";
	 InputStream inputStream  = Resources.getResourceAsStream(resource);
	 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
	 return factory;
	 
}
}
