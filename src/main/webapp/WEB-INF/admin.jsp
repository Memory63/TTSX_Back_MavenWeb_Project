<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/26
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>管理界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.serializejson.js"></script>
    <script type="text/javascript">
        $(function () {
            /* 添加商品 */
            $("#add").click(function () {
                $("#display").load("${pageContext.request.contextPath}/goods/addGoods");
            })
            /* 查看商品 */
            $("#see").click(function () {
                $("#display").load("${pageContext.request.contextPath}/goods/showGoods");
            })
        })


        /* 修改商品 */
        function updateGoods(id) {
            $("#display").load("${pageContext.request.contextPath}/goods/updateGoods?id="+id);
        }

        /* 删除商品 */
        function deleteGoods(id) {
            if(confirm("确定删除吗?")){
                $.ajax({
                    url:'${pageContext.request.contextPath}/goods/deleteGoods',
                    type:'get',
                    data:'id='+id,
                    success:function (data) {
                        if(data==1){
                            alert("删除成功")
                            $("#"+id).remove();
                        }else{
                            alert("删除失败")
                        }
                    }

                })
            }
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.username==null}">
    <c:redirect url="/admin/login"></c:redirect>
</c:if>
    <div>
        <sapn>
            管理员:<shiro:principal></shiro:principal>
        </sapn>
        <span>
            <a href="${pageContext.request.contextPath}/admin/logout">退出</a>
        </span>
    </div>
    <hr/>
    <div id="function" style="width:100px;height:284px;border: 1px solid #000000;text-align: center;float:left">
        <hr/>
            <p>
                <button id="see">查看商品</button>
            </p>
        <hr/>
            <p>
                <button id="add">添加商品</button>
            </p>
        <hr/>
    </div>
    <div id="display">

    </div>

    <script type="text/javascript">
        window.load(welcome());
        function welcome() {
            $("#display").html("<img src='../images/backgroud.png' style='width: 400px;height:284px'/>");
        }
    </script>
</body>
</html>
