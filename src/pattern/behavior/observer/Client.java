package pattern.behavior.observer;

/**
 * ��Ŀ��:    Demo
 * ����       pattern.behavior.observer
 * �ļ���:    Client
 * ����ʱ��:  2018/1/8 on 17:47
 * ����:     TODO
 *
 * @author zjb
 */
public class Client {
    public static void main(String[] args) {
        //����۲�Ŀ�����
        AllyControlCenter acc;
        acc = new ConcreteAllyControlCenter("��ӹȺ��");

        //�����ĸ��۲��߶���
        Observer player1, player2, player3, player4;

        player1 = new Player("���");
        acc.join(player1);

        player2 = new Player("�����");
        acc.join(player2);

        player3 = new Player("���޼�");
        acc.join(player3);

        player4 = new Player("����");
        acc.join(player4);

        //ĳ��Ա���ܹ���
        player1.beAttacked(acc);
    }
}
