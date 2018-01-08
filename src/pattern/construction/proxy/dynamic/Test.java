package pattern.construction.proxy.dynamic;

import pattern.construction.proxy.statics.RealStar;
import pattern.construction.proxy.statics.Star;

import java.lang.reflect.Proxy;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.construction.proxy.dynamic
 * �ļ���:    Test
 * ����ʱ��:  2018/1/8 on 17:25
 * ����:     TODO
 *
 * @author zjb
 */
public class Test {
    public static void main(String[] args) {
        //��ʵ��ɫ
        Star realStar = new RealStar();
        //������
        StarHandler handler = new StarHandler(realStar);
        //������
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        //���ô�����ĳ��跽������ʵ���õ�����ʵ��ɫ�ĳ��跽��
        proxy.sing();
    }
}
