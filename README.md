# 2017118126_Android
1.�������ʱ�汾����:
  a.�޸�build.gradle�ļ�������
	dependencies {
        classpath 'com.android.tools.build:gradle:3.5.0'
    }
    �ǵð�classpath�޸�Ϊ�Լ����صİ汾,�����Ĭ�ϴ�Զ������
    repositories {
        google()
        jcenter()
    }
    �ǵü���google(),��������ļ���ʧ��
  b.�޸ĺ�gradle-wrapper.properties�ļ�����
   distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip
   �޸�Ϊ���صİ汾
2.SourceTree����ʧ������:
  ԭ��:Զ�̿�ͱ��ؿ���ڲ���
  �������:a. ͨ�������� git pull origin master
  ���:�����н��ᱨ��
  From https://github.com/Son-Wind/2017118126_Android
  * branch            master     -> FETCH_HEAD
   fatal: refusing to merge unrelated histories

   �������:b. ͨ��������:git pull origin master --allow-unrelated-histories
   ��ʱ�ͽ����˱��ؿ���Զ�̿�ĺϲ�.�ų�����

   �����sourceTree����ύ������������