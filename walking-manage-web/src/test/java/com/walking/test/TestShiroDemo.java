/*package com.walking.test;

import java.util.Arrays;



import junit.framework.Assert;

public class TestShiroDemo extends BaseTest {
    
	@Test
	public void testHelloworld (){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		//Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

		//2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang1", "123");
		try{
			//4、登录，即身份验证
			subject.login(token);
		}catch(AuthenticationException e){
			e.printStackTrace();
			//5、身份验证失败
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		
		//6、退出
		subject.logout();
	}
	
	@Test  
	public void testHasRole() {  
	    login("classpath:shiro-role.ini", "zhang", "123");  
	    //判断拥有角色：role1  
	    Assert.assertTrue(subject().hasRole("role1"));  
	    //判断拥有角色：role1 and role2  
	    Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));  
	    //判断拥有角色：role1 and role2 and !role3  
	    boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));  
	    Assert.assertEquals(true, result[0]);  
	    Assert.assertEquals(true, result[1]);  
	    Assert.assertEquals(false, result[2]);  
	} 
	
	@Test(expected = UnauthorizedException.class)  
	public void testCheckRole() {  
	    login("classpath:shiro-role.ini", "zhang", "123");  
	    //断言拥有角色：role1  
	    subject().checkRole("role1");  
	    //断言拥有角色：role1 and role3 失败抛出异常  
	    try {
	    	subject().checkRoles("role1", "role3");  
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	    
	} 
	
	@Test  
	public void testIsPermitted() {  
	    login("classpath:shiro-permission.ini", "zhang", "123");  
	    //判断拥有权限：user:create  
	    try {
	  	    Assert.assertTrue(subject().isPermitted("user:create"));  
	  	    //判断拥有权限：user:update and user:delete  
	  	    Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));  
	  	    //判断没有权限：user:view  
	  	    Assert.assertTrue(subject().isPermitted("user:view")); 
	  	     boolean permitted = subject().isPermitted("user:view");
	  	    System.out.println(permitted);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   
	} 
	@Test(expected = UnauthorizedException.class)  
	public void testCheckPermission () {  
	    login("classpath:shiro-permission.ini", "zhang", "123");  
	    //断言拥有权限：user:create  
	    subject().checkPermission("user:create");  
	    //断言拥有权限：user:delete and user:update  
	    subject().checkPermissions("user:delete", "user:update");  
	    //断言拥有权限：user:view 失败抛出异常  
	    try {
	    	 subject().checkPermissions("user:view");  
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	   
	}   
	
}
*/