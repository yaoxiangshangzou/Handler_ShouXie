package pattern.behavior.observer;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.behavior.observer
 * �ļ���:    Player
 * ����ʱ��:  2018/1/8 on 17:32
 * ����:     TODO ����۲���
 *
 * @author zjb
 */
public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * ֧Ԯ���ѷ�����ʵ��
     */
    @Override
    public void help() {
        System.out.println("���ס��" + this.name + "�����㣡");
    }

    /**
     * ���ܹ���������ʵ�֣������ܹ���ʱ������ս�ӿ����������֪ͨ����notifyObserver()��֪ͨ����
     *
     * @param acc
     */
    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "��������");
        acc.notifyObserver(name);
    }
}