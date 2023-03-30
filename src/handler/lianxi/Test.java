package handler.lianxi;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-19:16
 * @email :       1214495199@qq.com
 * @description :
 */
public class Test {
    public static Handler handler;

    public static void main(String[] args) {
        Looper.prepare();

        handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                System.out.println("Test：" + Thread.currentThread().getName() + "线程接收到：" + message.obj);
            }
        };
        new Thread(()->{
            try {
                Thread.sleep(3000);
                Message message=new Message();
                message.obj=Thread.currentThread().getName()+"发送的消息";
                handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Looper.loop();
    }
}
