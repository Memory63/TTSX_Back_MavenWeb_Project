# 后台系统

### 异步上传图片和数据

> * 需要两个依赖
> * 需要在springmvc中添加上传配置
> * 实体类中封装MultipartFile类型属性，这个就是用来接受图片
> * 还要注意一个问题，表单中如果有时间类型，要在实体类的时间属性上添加注解@DateTimeFormat(pattern='yyyy-MM-dd')
> * new FormData()将form表单元素的name与value进行组合，实现表单数据的序列化，从而减少表单元素的拼接，提高工作效率。

### 地址中带有'%2F'自动转为'/'，如何处理？

> * 不使用URLEncode.encode(),使用下面的方法
> * produces = "text/plain;charset=utf-8"
> * 注解RequestMapping中produces属性可以设置返回数据的类型以及编码，可以是json或者xml：
> * 但是必须要和@ResponseBody注解一起使用才可以，不加@ResponseBody注解相当于按照和返回String同名jsp页面解析自然就会报错

### jQuery_ajax报错：Uncaught TypeError: Illegal invocation

> * 异步上传图片出现这个错误。原因：参数写错或没写

### 前后台图片显示问题

> * 后台添加图片，前台无法访问到。
> * 怎么让前后台都能访问到??