<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

</script>
<div id="updateGoods">
    <form action="">
        <table border="1px" cellspacing="0">
            <tr>
                <td>商品名称</td>
                <td>
                    <input type="text" name="goodsName" value="${goods.goodsName}"/>
                </td>
            </tr>
            <tr>
                <td>商品类型</td>
                <td>
                    <input type="text" value="${goods.goodsType.typeName}" readonly="readonly">
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
                    <input type="file" name="picture" style="padding-top:35px;">
                </td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td>
                    <textarea name="sketch">
                        ${goods.intro}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>商品详情</td>
                <td>
                    <textarea name="details">
                        ${goods.detail}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>商品是否展示</td>
                <td>
                    <input type="text" value="${goods.show==1?'是':'否'}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加">
                    <input type="button" value="取消">
                </td>
            </tr>
        </table>
    </form>
</div>
