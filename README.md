# 天天生鲜项目，后台管理

> * 项目名：TTSX_Back_MavenWeb_Project
> * 界面：极其丑陋

## 使用技术

> * 项目管理工具：Maven
> * 基本框架:Spring+SpringMVC+MyBatis
> * 安全控制框架:Shiro
> * 使用Tomcat 8.5.45
> * 使用JDK 1.8.0_211

## 定义后台系统功能

>   - 完成商品的添加(基本信息，图片上传)
>       - 使用ajax异步上传，图片也异步上传
>   - 商品的删除✔
>       - 使用Ajax异步删除
>   - 商品的修改
>       - 这个不是用异步，普通表单提交，后端修改完成后跳转商品显示页面
>   - 建立两种角色：user /  admin  
>       - 使用shiro安全框架，控制访问
>   - 两种权限：product:query  product:update  
>       - 使用shiro安全框架，控制访问
>   - product:update权限的才可以堆商品进行 添加和修改 
>       - 使用shiro安全框架，控制访问
