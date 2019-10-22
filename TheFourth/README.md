第四次作业:隐式Intent的调用
 1.<action android:name="android.intent.action.MAIN" />当action注册了android.intent.action.MAIN时会作为主活动启动
 2.当使用系统的隐式活动时,可以不进行注册。当使用了自定义了隐式活动要进行相应的注册。
 3.使用隐式意图可以避免固定类型的跳转(例如:当你需要访问一个网站,在显式时需要明确你手机所安装的浏览器,而隐式则不需要了解你手机的应用)