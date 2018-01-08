package pattern.behavior.observer;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.behavior.observer
 * �ļ���:    ConcreteAllyControlCenter
 * ����ʱ��:  2018/1/8 on 17:33
 * ����:     TODO
 *
 * @author zjb
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {
    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "ս���齨�ɹ���");
        System.out.println("----------------------------");
        this.allyName = allyName;
    }

    /**
     * ʵ��֪ͨ����
     *
     * @param name
     */
    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "ս�ӽ���֪ͨ������" + name + "���ܵ��˹�����");
        //�����۲��߼��ϣ�����ÿһ�����ѣ��Լ����⣩��֧Ԯ����
        for (Object obs : players) {
            if (!((Observer) obs).getName().equalsIgnoreCase(name)) {
                ((Observer) obs).help();
            }
        }
    }
}