package pattern.create.singleton;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.create.singleton
 * �ļ���:    EagerSingleton
 * ����ʱ��:  2018/1/8 on 11:15
 * ����:     TODO ���� ����ʽ
 *
 * @author zjb
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    /**
     * ���౻����ʱ����̬����instance�ᱻ��ʼ������ʱ���˽�й��캯���ᱻ���ã�
     * �������Ψһʵ���������������ʹ�ö���ʽ������ʵ�ָ��ؾ�����LoadBalancer�����ƣ�
     * �򲻻���ִ����������������������ȷ�����������Ψһ�ԡ�
     */

    public static EagerSingleton getInstance() {
        return instance;
    }
}
