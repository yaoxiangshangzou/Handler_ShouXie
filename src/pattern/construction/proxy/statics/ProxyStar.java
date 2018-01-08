package pattern.construction.proxy.statics;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.construction.proxy.statics
 * �ļ���:    ProxyStar
 * ����ʱ��:  2018/1/8 on 16:37
 * ����:     TODO ���Ǵ�����󣺾�����
 *
 * @author zjb
 */
public class ProxyStar implements Star {

    /**
     * ��ʵ��������ã����ǣ�
     */
    private Star star;

    /**
     * ͨ������������ʵ��ɫ��ֵ
     *
     * @param star
     */
    public ProxyStar(Star star) {
        this.star = star;
    }


    @Override
    public void signContract() {
        System.out.println("������.ǩ��ͬ()");
    }


    @Override
    public void sing() {
        //��ʵ����Ĳ��������ǳ��裩
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("������.��β��()");
    }


}