package pattern.create.singleton;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.create.singleton
 * �ļ���:    Singleton
 * ����ʱ��:  2018/1/8 on 11:34
 * ����:     TODO
 *
 * @author zjb
 */
public class Singleton {
    /**
     * ����ʽ�����಻��ʵ���ӳټ��أ����ܽ����ò���ʼ��ռ���ڴ棻
     * ����ʽ�������̰߳�ȫ���Ʒ���������������Ӱ�졣
     * �ɼ��������Ƕ���ʽ������������ʽ�����������������������⣬
     * ��û��һ�ַ������ܹ������ֵ�����ȱ�㶼�˷����������ߵ��ŵ�϶�Ϊһ�أ�
     * ���ǣ�Yes��
     * ����������ѧϰ���ָ��õı���֮ΪInitialization Demand Holder (IoDH)�ļ�����
     */
    private Singleton() {
    }

    /**
     * �����ڵ�����������һ����̬(static)�ڲ��࣬�ڸ��ڲ����д������������ٽ��õ�������ͨ��getInstance()�������ظ��ⲿʹ��
     */
    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }

    /**
     *  ���벢�����������룬���н��Ϊ��true���������ĵ�������s1��s2Ϊͬһ����
     *  ���ھ�̬��������û����ΪSingleton�ĳ�Ա����ֱ��ʵ��������������ʱ����ʵ����Singleton��
     *  ��һ�ε���getInstance()ʱ�������ڲ���HolderClass���ڸ��ڲ����ж�����һ��static���͵ı���instance��
     *  ��ʱ�����ȳ�ʼ�������Ա��������Java���������֤���̰߳�ȫ�ԣ�ȷ���ó�Ա����ֻ�ܳ�ʼ��һ�Ρ�
     *  ����getInstance()����û���κ��߳���������������ܲ�������κ�Ӱ�졣
     */
}
