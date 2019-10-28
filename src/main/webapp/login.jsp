<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/26
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                $.ajax({
                    url:'${pageContext.request.contextPath}/admin/login',
                    type:'post',
                    data:$("#form_admin").serialize(),
                    success:function (data) {
                        if(data!=null){
                            window.location="${pageContext.request.contextPath}/admin/admin"
                        }else{
                            $(".msg").show();
                        }
                    },
                    error:function () {
                        alert("登录用户名或密码错误")
                    }
                })
            })
        })
    </script>
</head>
<body>
<div class="dowebok">
    <div class="logo"></div>
    <form id="form_admin">
    <div class="form-item">
        <input id="username" type="text" name="username" autocomplete="off" placeholder="用户名">
        <p class="tip">请输入用户名</p>
    </div>
    <div class="form-item">
        <input id="password" type="password" name="password" autocomplete="off" placeholder="登录密码">
        <p class="msg" hidden="hidden">用户或密码不正确</p>
    </div>
    <div class="form-item">
        <input type="button" id="submit" value="登录">
    </div>
    </form>
    <div class="reg-bar">
        <a class="forget" href="javascript:">忘记密码</a>
    </div>
</div>
</body>
</html>
