package mg.test;

import javax.servlet.annotation.WebServlet;

import mg.core.MGWorkServlet;
import mg.ioc.core.IocFactory;
@WebServlet("/test.do/*")
public class TestAction extends MGWorkServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * java手动代码写入，试用如j2se,j2ee
	 */
	private TestService testService = (TestService) IocFactory.getBean(TestService.class);
	
	public String index(){
		testService.save();
		return "index";
	}
}
