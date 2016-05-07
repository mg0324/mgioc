package mg.test;

import mg.ioc.annotation.ToBean;
import mg.ioc.annotation.UseBean;
//使用ToBean注解告知mgioc在初始化的时候将该类的实例交给mgioc容器管理
@ToBean
public class TestService {
	//使用UseBean来注入
	@UseBean
	private TestDao testDao;
	
	public void save(){
		testDao.save();
	}
}
