package briup.hello;

import org.junit.Test;

public class helloTest {
	@Test
public void TestSay() throws Exception {
	          Class<?> forName = Class.forName("briup.hello.hello");
	            hello h = (hello)forName.newInstance();
	            String say = h.say("白占成");
	            System.out.println(say);
}
}
