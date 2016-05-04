# mgioc
轻巧，低耦合，单例的IOC框架，只用来做依赖注入的。


##目的
专注于依赖注入。

##更新日志
###2016-5-4
1.完成基本的ioc功能，并结合mgwork2.0测试成功。<br/>
2.修改v0.1版本为不整合mgwork2.0的版本，支持手动获取bean实例。

	/**
	 * java手动代码写入，试用如j2se,j2ee
	 */
	private TestService testService = (TestService) IocFactory.getBean(TestService.class);

