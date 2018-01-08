package pattern.construction.proxy.statics;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.construction.proxy.statics
 * �ļ���:    Test
 * ����ʱ��:  2018/1/8 on 16:38
 * ����:     TODO ��̬���������
 *
 * @author zjb
 */
public class Test {
    /**
     * ����ģʽ��Ϊ���������ṩһ�ִ����Ա���ƶ��������ķ��ʡ�
     * <p>
     * ������ϸ���Ʒ���ĳ���ࣨ���󣩵ķ������ڵ����������ǰ����ǰ�ô���ͳһ�����̴���ŵ������д�����������������������ô���
     */
    /**
     * �����ɫ��ָ�����ɫ�������ˣ�����ʵ��ɫ�����ǣ������ṩ�Ĺ���������һ��Ϊһ���ӿ�
     * <p>
     * ��ʵ��ɫ����Ҫʵ�ֳ����ɫ�ӿڣ���������ʵ��ɫ��Ҫʵ�ֵ�ҵ���߼����Ա㹩�����ɫ���á�Ҳ����������ҵ���߼��ڴˡ�
     * <p>
     * �����ɫ����Ҫʵ�ֳ����ɫ�ӿڣ�����ʵ��ɫ�Ĵ���ͨ����ʵ��ɫ��ҵ���߼�������ʵ�ֳ��󷽷��������Ը����Լ��Ĳ�����
     * <p>
     * ��ͳһ�����̿��ƶ��ŵ������ɫ�д���
     *
     * @param args
     */
    public static void main(String[] args) {
        //��ʵ��ɫ
        RealStar realStar = new RealStar();
        //�����ɫ
        Star star = new ProxyStar(realStar);
        star.collectMoney();
        star.signContract();
        star.sing();
    }
}
