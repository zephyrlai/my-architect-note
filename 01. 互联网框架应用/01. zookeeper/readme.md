## 1. zookeeper基础知识
## 1. zookeeper安装
## 1. zookeeper原生api的使用
1. 建立连接
1. 创建结点
    1. 同步方式（sync）
    1. 异步方式（async）
        “a”是追加参数，可以在回调方法里使用
        -1 是跳过版本检查（dataversion），如果不是指定版本的数据，就不予删除
1. 获取结点与子结点
    getChildern只能获取直接子节点，不能获取子节点的子节点
1. 修改节点
1. 节点是否存在
1. 删除结点
## 1. 基于实现Watcher接口的zookeeper连接

## 1. zookeeper的权限控制
    digest模式：只有addAuthInfo之后，才能链接zookeeper操作结点
## 1. 使用watcher动态修改zookeeper地址






## 零散知识点
1. countdownlatch的应用
1. 基于zookeeper临时结点实现的分布式锁
    1. __场景__：同一套服务在不同的服务器上部署了2套，两者同时去将user表中id未1001的用户进行age++操作
    1. __分布式锁__：两者在改表之前，先去zookeeper上获取形式为“/表名/id值”的结点（在当前场景中的结点是“/user/1001”），如果获取到，则说明已有服务在对user表中id为1001的数据进行操作，则当前服务进行等待，持续获取“/user/1001”的结点，直到获取不到时，表示当前没有其他服务在操作user表中编号为1001的数据，则在zookeeper中创建一个“/user/1001”的临时结点，完成数据库写入操作之后，再结束zookeeper会话，“/user/1001”的临时结点将自动清除，其他服务可以再继续操作user表中id为1001的数据
1. AtomicInteger