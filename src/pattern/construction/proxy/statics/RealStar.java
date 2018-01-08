package pattern.construction.proxy.statics;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.construction.proxy.statics
 * �ļ���:    RealStar
 * ����ʱ��:  2018/1/8 on 16:35
 * ����:     TODO ��ʵ��ɫ���������ˣ���Ѧ֮ǫ
 *
 * @author zjb
 */
public class RealStar implements Star {

    @Override
    public void signContract() {
        System.out.println("Ѧ֮ǫ.ǩ��ͬ()");
    }

    @Override
    public void collectMoney() {
        System.out.println("Ѧ֮ǫ.��β��()");
    }

    @Override
    public void sing() {
        //��ʵ��ɫ�Ĳ�����������ҵ���߼�
        System.out.println("Ѧ֮ǫ.sing()");
    }
}
