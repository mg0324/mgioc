package mg.test;

import javax.servlet.annotation.WebServlet;

import mg.ioc.annotation.UseBean;
import mg.mvc.core.MGWorkServlet;
@WebServlet("/test.do/*")
public class TestAction extends MGWorkServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//使用UseBean来注入实例对象从mgioc容器中
	@UseBean
	private TestService testService;
	public String index(){
		testService.save();
		return "index";
	}
	
}
