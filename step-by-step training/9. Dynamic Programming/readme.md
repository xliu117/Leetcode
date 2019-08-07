
# 9. Dynamic Programming

[Triangle](https://github.com/xliu117/Leetcode/tree/master/step-by-step%20training/9.%20Dynamic%20Programming/LeetCode%20120.%20Triangle)

## 什么情况下使用动态规划？

满足下面三个条件之一：

1.求最大值最小值

2.判断是否可行

3.统计方案个数

则极有可能是使用动态规划求解

## 面试中常见的动态规划类型

### 坐标型DP：

[Minimum Path Sum // 初始化二维坐标矩阵动态规划时， 初始化第0行第0列](https://github.com/xliu117/Leetcode/tree/master/step-by-step%20training/9.%20Dynamic%20Programming/LeetCode%2064.%20Minimum%20Path%20Sum)
 

[Unique Path](https://github.com/xliu117/Leetcode/tree/master/step-by-step%20training/9.%20Dynamic%20Programming/LeetCode%2062.%20Unique%20Paths)

Unique Path II

Climbing Stairs

Jump Game // 这个题最优方法是使用greedy, DP复杂度较高

Jump Game II


### 接龙型DP(属于“坐标型”DP的一种）

Longest Increasing Subsequence

Russian Doll Envelopes

Largest Divisible Subset

Frog Jump 青蛙过河

划分型DP

匹配型DP

背包型DP

区间型DP

树图型DP

博弈型DP

区间型DP

## 动态规划总结

### 动态规划的实质：
 
 记忆化搜索
 
 避免重复的中间结果计算
 
### 动态规划与递归的关系

动规四要素(状态<灵感，创造力，存储小规模问题的结果>，方程<状态之间的联系，怎么通过小的状态，来算大的状态>，初始化<最极限的小状态是什么，起点>，答案<最大的那个状态是什么，终点>） 

vs

递归三要素(定义<接受什么参数，做了什么事，返回什么值>，拆解<如何将参数变小>，出口<什么时候可直接return>)

### 什么时候使用动态规划

最优，可行，方案数

### 什么时候不用动态规划

所有方案而不是方案数

集合而非序列

暴力算法已经是多项式级别复杂度

（动态规划擅长优化指数级别（2^n) 到多项式级别(n^2)

## 动态规划四要素：

状态，方程，初始化，答案

## 动态规划经典题：

Longest Increasing Subsequence(LIS)

1.在一个01矩阵中，求最大的全为1的正方形（apple,airbnb,facebook)(Lintcode 436. Maximal Square)

2.在一个01矩阵中，求面积最大的全为1的矩形（Facebook）（Lintcode 510. Maximal Rectangle)

3.在一个01矩阵中，求最大的正方形，其四个角上是1，其余地方是0（1的变形，此类题做法类似）(LintCode 631. Maximal Square II)

4.在一个01矩阵中，1表示障碍物， 求从左上角到右下角的不同路径个数，只能往右或往下走（bloomberg)(LintCode 115.Unique Paths II)

5.有n个房子排成一排和m种颜色，不同的房子用不同的颜色可以得到不同的分值。相邻的房子不能涂同一种颜色，求可以得到的最大分值。（Facebook）(LintCode 516. Paint House II)

6.键盘组合数 http://www.jiuzhang.com/qa/971/ (google)

https://www.jiuzhang.com/qa/3/




