package pattern.create.singleton;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.create.singleton
 * �ļ���:    LazySingleton
 * ����ʱ��:  2018/1/8 on 11:16
 * ����:     TODO ���� ����ʽ
 *
 * @author zjb
 */
public class LazySingleton {
//    private statics LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * ����ʽ�����ڵ�һ�ε���getInstance()����ʱʵ�������������ʱ��������ʵ������
     * ���ּ����ֳ�Ϊ�ӳټ���(Lazy Load)����������Ҫ��ʱ���ټ���ʵ����
     * Ϊ�˱������߳�ͬʱ����getInstance()����������ʹ�ùؼ���synchronized
     */

//    synchronized public statics LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    /**
     * ������ʽ��������getInstance()����ǰ�������˹ؼ���synchronized�����߳�����
     * �Դ������߳�ͬʱ���ʵ����⡣���ǣ�����������Ȼ������̰߳�ȫ���⣬
     * ����ÿ�ε���getInstance()ʱ����Ҫ�����߳������жϣ��ڶ��̸߲߳������ʻ����У�
     * ���ᵼ��ϵͳ���ܴ�󽵵͡���μȽ���̰߳�ȫ�����ֲ�Ӱ��ϵͳ�����أ�
     * ���Ǽ���������ʽ�������иĽ���
     * ��ʵ�ϣ��������������getInstance()��������������
     * ֻ������еĴ��롰instance = new LazySingleton();�������������ɡ�
     *  ���getInstance()�������Խ������¸Ľ���
     */
//    public statics LazySingleton getInstance() {
//        if (instance == null) {
//            synchronized (LazySingleton.class) {
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }

    /**
     * ����ò�Ƶ��Խ������ʵ������ˡ����ʹ�����ϴ�����ʵ�ֵ��������ǻ���ڵ�������Ψһ��ԭ�����£�
     * ������ĳһ˲���߳�A���߳�B���ڵ���getInstance()��������ʱinstance����Ϊnullֵ��
     * ����ͨ��instance == null���жϡ�����ʵ����synchronized�������ƣ�
     * �߳�A����synchronized�����Ĵ�����ִ��ʵ���������룬�߳�B�����Ŷӵȴ�״̬��
     * ����ȴ��߳�Aִ����Ϻ�ſ��Խ���synchronized�������롣����Aִ�����ʱ��
     * �߳�B����֪��ʵ���Ѿ������������������µ�ʵ�������²��������������
     * Υ������ģʽ�����˼�룬�����Ҫ���н�һ���Ľ���
     * ��synchronized���ٽ���һ��(instance == null)�жϣ�
     * ���ַ�ʽ��Ϊ˫�ؼ������(Double-Check Locking)��
     * ʹ��˫�ؼ������ʵ�ֵ�����ʽ��������������������ʾ��
     */

    /**
     * ��Ҫע����ǣ����ʹ��˫�ؼ��������ʵ������ʽ�����࣬
     * ��Ҫ�ھ�̬��Ա����instance֮ǰ�������η�volatile��
     * ��volatile���εĳ�Ա��������ȷ������̶߳��ܹ���ȷ����
     * �Ҹô���ֻ����JDK 1.5�����ϰ汾�в�����ȷִ�С�
     * ����volatile�ؼ��ֻ�����Java�����������һЩ�����Ż��������򣩣�
     * ���ܻᵼ��ϵͳ����Ч�ʽ��ͣ�
     * ��˼�ʹʹ��˫�ؼ��������ʵ�ֵ���ģʽҲ����һ��������ʵ�ַ�ʽ��
     */
    private volatile static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        //��һ���ж�
        if (instance == null) {
            //���������
            synchronized (LazySingleton.class) {
                //�ڶ����ж�
                if (instance == null) {
                    //��������ʵ��
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
