

# 研究：高效反射

Research: Efficient Reflection



## 反射测试数据

### 类反射测试数据

| 测试项           | 循环次数 | 总耗时  | 方式简述                   |
| ---------------- | -------- | ------- | -------------------------- |
| testClassGet     | 500万    | 187ms   | **for** \(Object.class\)   |
|                  | 1000万   | 352ms   |                            |
|                  | 5000万   | 1695ms  |                            |
| testClassForName | 500万    | 4840ms  | **for** \(Class\.forName\) |
|                  | 1000万   | 9943ms  |                            |
|                  | 5000万   | 46877ms |                            |



## 新建对象反射测试数据

| **测试项**       | 循环次数 | **总耗时** | **方式简述**                            |
| ---------------- | -------- | ---------- | --------------------------------------- |
| testNew          | 500万    | 174ms      | **for** \(new object\)                  |
|                  | 1000万   | 314ms      |                                         |
|                  | 5000万   | 1604ms     |                                         |
| testNewInstance1 | 500万    | 4957ms     | **for** \(Class\.forName\.newInstance\) |
|                  | 1000万   | 10053ms    |                                         |
|                  | 5000万   | 50357ms    |                                         |
| testNewInstance2 | 500万    | 192ms      | Class\.forName **for** \(newInstance\)  |
|                  | 1000万   | 365ms      |                                         |
|                  | 5000万   | 1768ms     |                                         |



### 方法反射测试数据

| 测试项                   | 循环次数 | 总耗时 | 方法简述                                          |
| ------------------------ | -------- | ------ | ------------------------------------------------- |
| testDeclaredMethod       | 500万    | 1185ms | **for** \(Class.getDeclaredMethod\)               |
|                          | 1000万   | 2025ms |                                                   |
|                          | 5000万   | 8833ms |                                                   |
| testNormalInvoke         | 500万    | 171ms  | **for** \(object.getMethod\)                      |
|                          | 1000万   | 349ms  |                                                   |
|                          | 5000万   | 1686ms |                                                   |
| testInvoke               | 500万    | 186ms  | Class.getDeclaredMethod **for** \(Method.invoke\) |
|                          | 1000万   | 356ms  |                                                   |
|                          | 5000万   | 1682ms |                                                   |
| testInvokeWithAccessible | 500万    | 182ms  |                                                   |
|                          | 1000万   | 352ms  |                                                   |
|                          | 5000万   | 1683ms |                                                   |

