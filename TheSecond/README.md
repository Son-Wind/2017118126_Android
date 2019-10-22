第二次作业:
 1.活动的跳转:需要实现 OnClickListener 重写 onClick()方法
 2.重写 onClick()方法使用显式Intent(意图)
第三次作业:
 1.在AndroidMainfest.xml文件下进行模式修改(launchMode共有4种模式:standard,singleInstance,singleTop,singleTask) 
  <activity android:name=".Hello1" android:launchMode="standard">
 2.进行活动堆栈的检验时,需要设计一个类的计数器ObjCount和对象的计数器mObjCount