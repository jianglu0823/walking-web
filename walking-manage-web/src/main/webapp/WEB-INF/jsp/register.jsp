<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎加入毛嗑王国</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="/css/reset_login.css">
        <link rel="stylesheet" href="/css/supersized_login.css">
        <link rel="stylesheet" href="/css/style_login.css">
        <link rel="stylesheet" href="/css/form.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1 style="color: red" >欢迎加入</h1>
            <h1 style="color: red" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
             						 毛嗑王国</h1>
            
            <form action="/register" method="post">
                <input type="text" name="userName" class="username" placeholder="Username">
                <input type="text" name="realName" class="realname" placeholder="RealName">
                <input type="text" name="password" class="password" placeholder="Password">
                <input type="text" name="phone" class="phone" placeholder="Phone">
                
                <button type="submit">注册</button>
                <h6>${error }</h6>
                <div class="error"><span>+${error }</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>

        <!-- Javascript -->
        <script src="/js/jquery-1.8.2.min.js"></script>
        <script src="/js/supersized.3.2.7.min.js"></script>
        <script src="/js/supersized-init.js"></script>
        <script src="/js/scripts.js"></script>

    </body>

</html>