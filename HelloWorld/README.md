# 2017118126_Android
一.导入安卓项目并上传到gitHub的具体解决步骤：
   ![image](导入安卓文件截图/1.原始的build.gradle文件.PNG)
   ![image](导入安卓文件截图/2.原始的gradle-wrapper.properties文件.PNG)
   ![image](导入安卓文件截图/3.改后的build.gradle文件.PNG)
   ![image](导入安卓文件截图/4.改后的gradle-wrapper.properties文件.PNG)
   ![image](导入安卓文件截图/5.点击菜单栏.jpg)
   ![image](导入安卓文件截图/6.控制台.PNG)
   ![image](导入安卓文件截图/7.生成本地仓库.jpg)
   ![image](导入安卓文件截图/8.本地库与远程库连接.jpg)
   ![image](导入安卓文件截图/9.添加url地址.jpg)
   ![image](导入安卓文件截图/10.推送失败问题.jpg)
   ![image](导入安卓文件截图/11.解决推送问题.jpg)
   ![image](导入安卓文件截图/12.推送成功.jpg)

二.遇到的问题
1.解决载入时版本问题:
  a.修改build.gradle文件的内容(注意事项)
  ![image](导入安卓文件截图/1.原始的build.gradle文件.PNG)
  ![image](导入安卓文件截图/3.改后的build.gradle文件.PNG)
  
	dependencies {
        classpath 'com.android.tools.build:gradle:3.5.0'
    }
    记得把classpath修改为自己本地的版本,否则会默认从远端下载
    repositories {
        google()
        jcenter()
    }
   
    记得加入google(),否则加载文件会失败
    
   
  b.修改gradle-wrapper.properties文件内容
 ![image](导入安卓文件截图/2.原始的gradle-wrapper.properties文件.PNG)
 ![image](导入安卓文件截图/4.改后的gradle-wrapper.properties文件.PNG)
 
   distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip
  
   修改为本地的版本
2.SourceTree推送失败问题:
![image](导入安卓文件截图/10.推送失败问题.jpg)
![image](导入安卓文件截图/11.解决推送问题.jpg)
![image](导入安卓文件截图/12.推送成功.jpg)
  原因:远程库和本地库存在差异
  解决方法:a. 通过命令行 git pull origin master
  结果:命令行将会报错
  From https://github.com/Son-Wind/2017118126_Android
  * branch            master     -> FETCH_HEAD
   fatal: refusing to merge unrelated histories

   解决方法:b. 通过命令行:git pull origin master --allow-unrelated-histories
   这时就进行了本地库与远程库的合并.排除差异

   最后在sourceTree点击提交就能完美运行
   
  
