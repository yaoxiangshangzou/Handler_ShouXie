package pattern.behavior.observer;

import java.util.ArrayList;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.behavior.observer
 * �ļ���:    AllyControlCenter
 * ����ʱ��:  2018/1/8 on 17:33
 * ����:     TODO
 *
 * @author zjb
 */
public abstract class AllyControlCenter {
    /**
     * ս������
     */
    protected String allyName;
    /**
     * ����һ���������ڴ洢ս�ӳ�Ա
     */
    protected ArrayList<Observer> players = new ArrayList<Observer>();

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public String getAllyName() {
        return this.allyName;
    }

    /**
     * ע�᷽��
     *
     * @param obs
     */
    public void join(Observer obs) {
        System.out.println(obs.getName() + "����" + this.allyName + "ս�ӣ�");
        players.add(obs);
    }

    /**
     * ע������
     *
     * @param obs
     */
    public void quit(Observer obs) {
        System.out.println(obs.getName() + "�˳�" + this.allyName + "ս�ӣ�");
        players.remove(obs);
    }

    /**
     * ��������֪ͨ����
     *
     * @param name
     */
    public abstract void notifyObserver(String name);
}
