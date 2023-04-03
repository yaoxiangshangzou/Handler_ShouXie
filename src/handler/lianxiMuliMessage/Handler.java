package handler.lianxiMuliMessage;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-23:15
 * @email :       1214495199@qq.com
 * @description :
 */
public class Handler {
    private Looper looper;
    private MessageQueue mQueue;

    public Handler(){
        looper=Looper.myLooper();
        mQueue=looper.messageQueue;
    }



    public void handleMessage(Message msg) {
    }


    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    public void sendMessage(Message message) {
        message.target=this;
        mQueue.enqueueMessage(message);
    }
}
