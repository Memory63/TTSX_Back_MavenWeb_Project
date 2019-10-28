<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    function updateGoods(id) {
        if(confirm("确定修改吗?")){
            $.ajax({
                url:'${pageContext.request.contextPath}/goods/updateGoods',
                type:'post',
                contentType:false,
                processData:false,
                data:new FormData($("#update_form")[0]),
                success:function (data) {
                    if(data==1){
                        alert("修改成功")
                        $("#display").load("${pageContext.request.contextPath}/goods/showGoods");
                    }else if (data==0){
                        alert("修改失败")
                    }else {
                        alert("未知错误")
                    }
                }
            })
        }
    }
</script>
<div id="updateGoods">
    <form id="update_form" enctype="multipart/form-data">
        <table border="1px" cellspacing="0">
            <tr>
                <td>商品名称</td>
                <td>
                    <input hidden="hidden" name="id" value="${goods.id}">
                    <input type="text" name="goodsName" value="${goods.goodsName}"/>
                </td>
            </tr>
            <tr>
                <td>商品类型</td>
                <td>
                    <input type="text" value="${goods.goodsType.typeName}" readonly="readonly">
                    ==>
                    <select name="tid">
                        <c:forEach var="g" items="${goods.goodsTypeList}">
                            <option value="${g.id}">${g.typeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>商品价钱</td>
                <td>
                    <input type="text" name="price" value="${goods.price}"/>
                </td>
            </tr>
            <tr>
                <td>商品重量</td>
                <td>
                    <input type="text" name="weight" value="${goods.weight}"/>g
                </td>
            </tr>
            <tr>
                <td>修改商品图片</td>
                <td>
                    <img src="${pageContext.request.contextPath}/images/${goods.picture}" style="width:100px;height:100px;float:left">
                    <input name="picture" hidden="hidden" value="${goods.picture}">
                    <input type="file" name="pic" style="padding-top:35px;">
                </td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td>
                    <textarea name="intro">
                        ${goods.intro}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>商品详情</td>
                <td>
                    <textarea name="detail">
                        ${goods.detail}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>商品是否展示</td>
                <td>
                    <input type="radio" name="show" value="1" ${goods.show==1?'checked':''}>是
                    <input type="radio" name="show" value="0" ${goods.show==0?'checked':''}>否
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" onclick="updateGoods(${goods.id})" value="修改">
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
</div>
