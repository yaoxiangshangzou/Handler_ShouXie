package pattern.construction.proxy.dynamic;

import pattern.construction.proxy.statics.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.construction.proxy.dynamic
 * �ļ���:    StarHandler
 * ����ʱ��:  2018/1/8 on 17:23
 * ����:     TODO
 *
 * @author zjb
 */
public class StarHandler implements InvocationHandler {
    /**
     * ��ʵ��ɫ
     */
    private Star realStar;

    /**
     * ͨ������������ʼ����ʵ��ɫ
     *
     * @param realStar
     */
    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    /**
     * ���е����̿��ƶ���invoke������
     * proxy��������
     * method�����ڵ��õķ���
     * args�������Ĳ���
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("��ʵ��ɫ����֮ǰ�Ĵ���.....");
        if (method.getName().equals("sing")) {
            //�������realStar��sing����
            object = method.invoke(realStar, args);
        }
        System.out.println("��ʵ��ɫ����֮��Ĵ���.....");
        return object;
    }

}
