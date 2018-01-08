package pattern.behavior.observer;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.behavior.observer
 * �ļ���:    Observer
 * ����ʱ��:  2018/1/8 on 17:32
 * ����:     TODO ����۲���
 *
 * @author zjb
 */
public interface Observer {
    public String getName();

    public void setName(String name);

    /**
     * ����֧Ԯ���ѷ���
     */
    public void help();

    /**
     * �������ܹ�������
     *
     * @param acc
     */
    public void beAttacked(AllyControlCenter acc);
}
