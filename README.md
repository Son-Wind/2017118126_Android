# 2017118126_Android
了解掌握Android的基础知识
第一次作业:导入郭林代码时可能遇到的版本问题以及SourceTree提交到GitHub的流程
第二次作业:
 1.活动的跳转:需要实现 OnClickListener 重写 onClick()方法
 2.重写 onClick()方法使用显式Intent(意图)
第三次作业:
 1.在AndroidMainfest.xml文件下进行模式修改(launchMode共有4种模式:standard,singleInstance,singleTop,singleTask) 
  <activity android:name=".Hello1" android:launchMode="standard">
 2.进行活动堆栈的检验时,需要设计一个类的计数器ObjCount和对象的计数器mObjCount
 第四次作业:隐式Intent的调用
 1.<action android:name="android.intent.action.MAIN" />当action注册了android.intent.action.MAIN时会作为主活动启动
 2.当使用系统的隐式活动时,可以不进行注册。当使用了自定义了隐式活动要进行相应的注册。
 3.使用隐式意图可以避免固定类型的跳转(例如:当你需要访问一个网站,在显式时需要明确你手机所
 第五次作业:进行水果信息图片的增删查改
 第六次作业:多线程实现计数器自增
第七次作业：异步任务传输数据
第八次作业:了解服务的相关知识,并实现一个简单的下载任务服务。