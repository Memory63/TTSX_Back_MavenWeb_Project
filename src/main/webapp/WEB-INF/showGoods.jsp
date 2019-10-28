<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="showGoods">
    <table border="1px" id="showGoodsTable" cellspacing="0">
        <c:if test="${goodsList!=null}">
            <tr>
                <td style="width:100px;">商品编号</td>
                <td style="width:100px;">商品名称</td>
                <td style="width:100px;">商品类型</td>
                <td style="width:100px;">商品价钱</td>
                <td style="width:100px;">商品重量</td>
                <td>商品介绍</td>
                <td>商品详情</td>
                <td style="width:140px;">发布时间</td>
                <td style="width:100px;">商品是否首页展示</td>
                <td style="width:100px;">操作</td>
            </tr>

            <c:forEach var="g" items="${goodsList}" varStatus="vs">
                <tr id="${g.id}">
                    <td>${g.id}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/images/${g.picture}" style="width:180px;height:180px;">
                        ${g.goodsName}
                    </td>
                    <td>${g.goodsType.typeName}</td>
                    <td>${g.price}</td>
                    <td>${g.weight}</td>
                    <td>
                        <textarea style="margin: 0px;width: 289px;height: 206px;">
                            ${g.intro}
                        </textarea>
                    </td>
                    <td>
                        <textarea style="margin: 0px;width: 289px;height: 206px;">
                            ${g.detail}
                        </textarea>
                    </td>
                    <td>
                        <fmt:formatDate value="${g.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    </td>
                    <td>${g.show==1?'是':'否'}</td>
                    <td>
                        <button onclick="deleteGoods(${g.id})">删除</button>
                        <button onclick="updateGoodsPage(${g.id})">修改</button>
                    </td>

                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${goodsList==null}">
            暂无商品，请<a>添加</a>
        </c:if>
    </table>
</div>
