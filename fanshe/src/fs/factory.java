package fs;
interface animal{
	public void speak();
}
class monkey implements animal{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("�������۽�");
		
	}
	
}
class sheep implements animal{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("С�������");
		
	}
	
}
class dog implements animal{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("С���໽�");
		
	}
	
}
class gj{
	public static animal re(String s) {
		   animal a=null;
		        try {
				a = (animal)Class.forName(s).newInstance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		       return a;
	}
	
	
}
public class factory {
public static void main(String[] args) {
	//animal a = gj.re("monkey");
	animal a = gj.re("fs.sheep");
	  a.speak();
}
}
