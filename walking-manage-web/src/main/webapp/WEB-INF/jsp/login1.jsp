<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>欢迎登录毛嗑王国</title>
            
        <!-- CSS -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/form.css" rel="stylesheet">
        <link href="/css/style.css" rel="stylesheet">
        <link href="/css/animate.css" rel="stylesheet">
        <link href="/css/generics.css" rel="stylesheet"> 
    </head>
    <body id="skin-blur-violate" style="">
        <section id="login">
            <header>
                <h1>毛嗑王国</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
            </header>
        
            <div class="clearfix"></div>
            
            <!-- Login -->
            <form class="box tile animated active" id="box-login">
                <h2 class="m-t-0 m-b-15">Login</h2>
                <input type="text" class="login-control m-b-10" placeholder="Username or Email Address">
                <input type="password" class="login-control" placeholder="Password">
                <div class="checkbox m-b-20">
                    <label>
                        <input type="checkbox">
                        Remember Me
                    </label>
                </div>
                <button class="btn btn-sm m-r-5">Sign In</button>
                
                <small>
                    <a class="box-switcher" data-switch="box-register" href="">Don't have an Account?</a> or
                    <a class="box-switcher" data-switch="box-reset" href="">Forgot Password?</a>
                </small>
            </form>
            
            <!-- Register -->
            <form class="box animated tile" id="box-register">
                <h2 class="m-t-0 m-b-15">Register</h2>
                <input type="text" class="login-control m-b-10" placeholder="Full Name">
                <input type="text" class="login-control m-b-10" placeholder="Username">
                <input type="email" class="login-control m-b-10" placeholder="Email Address">    
                <input type="password" class="login-control m-b-10" placeholder="Password">
                <input type="password" class="login-control m-b-20" placeholder="Confirm Password">

                <button class="btn btn-sm m-r-5">Register</button>

                <small><a class="box-switcher" data-switch="box-login" href="">Already have an Account?</a></small>
            </form>
            
            <!-- Forgot Password -->
            <form class="box animated tile" id="box-reset">
                <h2 class="m-t-0 m-b-15">Reset Password</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
                <input type="email" class="login-control m-b-20" placeholder="Email Address">    

                <button class="btn btn-sm m-r-5">Reset Password</button>

                <small><a class="box-switcher" data-switch="box-login" href="">Already have an Account?</a></small>
            </form>
        </section>                      
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="/js/jquery.min.js"></script> <!-- jQuery Library -->
        
        <!-- Bootstrap -->
        <script src="/js/bootstrap.min.js"></script>
        
        <!--  Form Related -->
        <script src="/js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        
        <!-- All JS functions -->
        <script src="/js/functions.js"></script>
        <script src="/js/cookie.util.js"></script>
    </body>
</html>