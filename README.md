# 易班请假系统后台
---

## 使用技术
- 框架：spring+springMVC+mybatis
- 登录验证：JJWT
- 数据处理：fastjson，Jackson依赖

## 问题

#### 访问RoleController，会出现已经token验证不通过的现象：token使用junit生成的字符串，目前上网查是由于token生成之后，重载class而造成验证失败，但是因为时间问题暂时没有解决


## 完成功能

### 已经实现用aop添加权限验证，同时加入了alibaba.fastjson来实现拒绝访问时的json格式的错误信息返回

## 待完成事项

- [ ] 修改上述bug

- [x] 总结项目

- [x] 上传含有SQL文件