# mgioc
    轻巧，低耦合，单例的IOC框架，只用来做依赖注入的。

##关于作者
    一个喜爱代码的狂热工作者，常用名梦网，梦来梦往，mg0324等。
    QQ:1092017732
    github:https://github.com/mg0324
    gitoschina:https://git.oschina.net/mgang
    
    如果觉得不错的话，别忘了给个star咯。thanks.<br/>

##快速入门
###第0步 
    引入mgioc.jar到自己的web工程下的lib目录中

###第一步
    在web.xml中添加启动容器的必要配置

    <!-- 启动mgioc配置 -->
    <listener>
        <listener-class>mg.ioc.core.IocListener</listener-class>
	</listener>

###第二步
    建立测试包package mg.test;
    分别有三个类,TestAction(用的是mgwork框架做mvc控制),TestService,TestDao.

TestAction.java

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

TestService.java

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
    
TestDao.java

    package mg.test;

    import mg.ioc.annotation.ToBean;
    
    @ToBean
    public class TestDao {
        
    	public void save(){
    		System.out.println("保存test对象成功");
    	}
    }

###第三步
    启动项目，访问http://localhost:8080/mgioc/test.do/index，后台打印出“保存test对象成功”说明运行正常。
    
##心得
    目前，就是为了做一个轻巧型的ioc依赖注入容器，后续可能会加入缓存来提交容器性能，在要管理
    的实例对象多出的时候。
    
    先阶段有和自己开发的另外一个基于servlet3.0的点对点小巧型的mvc框架mgwork完成整合。具体见
    本人的mgfinal项目。
    
##快速跳转
    mgwork : mvc 框架 : http://git.oschina.net/mgang/mgwork 
    
    mgioc : ioc框架 :  http://git.oschina.net/mgang/mgioc
    
    mgfinal : mgwork + mybatis + mgioc : http://git.oschina.net/mgang/mgfinal
