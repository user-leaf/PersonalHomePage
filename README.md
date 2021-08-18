### PersonalHomePage

用到的Jetpack组件有：LiveData、Room、ViewModel和DataBinding

注意：json中，login与name是两个字段，不一样，需要用login去请求数据、去查数据库。

##### 目的&概念

1. MVVM
2. 数据模型驱动界面更新

---

`Room`

1. 定义好Entity(①表名 ②列名 ③主键..)。@Entity()。
2. 创建用于访问表的Dao文件。@Dao。
3. 创建Room数据库。@Database()。

```java
Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME).build();
```

---

`LiveData`通常与ViewModel一起使用，`ViewModel`是用于存放数据的，可将数据库放在ViewModel中进行实例化。

`Repository`那个地方的实现，逻辑是怎样的。// 一方面从数据库查询数据；一方面从网络请求数据并存入数据库。

`DataBinding`中，location:beijing是怎么实现文字与变量字段共同存在的，就是，怎么添加hint的。// 看strings.xml

