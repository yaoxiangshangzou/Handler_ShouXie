package handler.lianxi;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-23:15
 * @email :       1214495199@qq.com
 * @description :
 */
public class Handler {
    private Looper mLooper;
    private MessageQueue messageQueue;

    public Handler() {
        this.mLooper = Looper.myLooper1();
        this.messageQueue = mLooper.messageQueue;
    }

    public void handleMessage(Message message){

    }


    public void dispatchMessage(Message message){
        handleMessage(message);
    }

    public void sendMessage(Message message) {
        message.target=this;
        messageQueue.enqueueMessage(message);
    }
}
