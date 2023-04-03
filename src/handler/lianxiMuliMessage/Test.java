package handler.lianxiMuliMessage;

import java.util.UUID;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-19:16
 * @email :       1214495199@qq.com
 * @description :
 */
public class Test {
    public static Handler handler;
    private static final String TAG = Test.class.getName()+"========>";

    public static void main(String[] args) {
        Looper.prepare();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println(TAG  + Thread.currentThread().getName() + "线程接收到：" + msg.obj);

            }
        };
        new Thread(() -> {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {

                Message message = new Message();
                synchronized (UUID.class) {
                    message.obj = UUID.randomUUID().toString();
                }
                System.out.println(TAG + "  sup thread " + Thread.currentThread().getName() + ": send message------" + message.obj);

                handler.sendMessage(message);
            }

        }).start();


        Looper.loop();
    }
}
