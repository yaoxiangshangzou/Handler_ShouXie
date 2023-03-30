package handler.lianxi;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-19:10
 * @email :       1214495199@qq.com
 * @description :
 */
public class Looper {

    final MessageQueue messageQueue;
    private static ThreadLocal<Looper> threadLocal=new ThreadLocal<>();

    public Looper() {
        this.messageQueue = new MessageQueue();
    }

    public static void prepare(){
        if (threadLocal.get()!=null) {
            throw new RuntimeException("Only one Looper may be created per thread");

        }
        threadLocal.set(new Looper());
        System.out.println("loop初始化");
    }


    public static void loop() {
        Looper me=myLooper1();
        Message msg;
        for (;;){
           msg= me.messageQueue.next();
           if (msg==null || msg.target==null){
               System.out.println("Looper：" + "空消息");

               continue;
           }
            System.out.println("Looper：" + "looper轮询到了消息，发送消息");

           msg.target.dispatchMessage(msg);
        }
    }

    public static Looper myLooper1() {
        return threadLocal.get();
    }
}
