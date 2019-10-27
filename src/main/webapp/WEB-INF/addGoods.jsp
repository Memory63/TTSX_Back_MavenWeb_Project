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
    function addGoods() {
        $.ajax({
            url:'/TTSX_Back_MavenWeb_Project/goods/addGoods',
            type:'post',
            data:JSON.stringify($("#add_form").serializeJSON()),
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            success:function (data) {
                alert(data)
            }
        })
    }
</script>
<div id="addGoods">
    <form id="add_form">
        <table border="1" cellspacing="0" style="text-align: center">
            <tr>
                <td>商品名称</td>
                <td>
                    <input type="text" name="goodsName"/>
                </td>
            </tr>
            <tr>
                <td>商品类型</td>
                <td>
                    <select id="goodsType" name="tid" style="width:158px;height:25px;">
                        <c:forEach var="g" items="${goodsType}" varStatus="vs">
                            <option value="${g.id}">${g.typeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>商品价钱</td>
                <td>
                    <input type="text" name="price"/>
                </td>
            </tr>
            <tr>
                <td>商品重量</td>
                <td>
                    <input type="text" name="weight"/>g
                </td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td>
                    <input type="file" name="picture">
                </td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td>
                    <textarea name="intro"></textarea>
                </td>
            </tr>
            <tr>
                <td>商品详情</td>
                <td>
                    <textarea name="detail">

                    </textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" onclick="addGoods()" value="添加">
                    <input type="button" value="取消">
                </td>
            </tr>
        </table>
    </form>
</div>
