package handler.lianxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sun.plugin.ClassLoaderInfo;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-19:10
 * @email :       1214495199@qq.com
 * @description :
 */
public class MessageQueue {
    Message[] mItems;
    int mPutIndex;
    //队列中消息数
    private int mCount;
    private int mTakeIndex;

    private final Condition getCondition;
    private final Condition addCondition;
    Lock mLock;

    public MessageQueue() {
        mItems=new Message[50];
        mLock = new ReentrantLock();
        getCondition = mLock.newCondition();
        addCondition = mLock.newCondition();
    }

    public Message next() {
        Message msg = null;
        try {
            mLock.lock();

            while (mCount <= 0) {
                System.out.println("MessageQueue：" + "队列空了，读锁阻塞");
                getCondition.await();
            }
            msg = mItems[mTakeIndex];
            mItems[mTakeIndex] = null;
            mTakeIndex = (++mTakeIndex >= mItems.length) ? 0 : mTakeIndex;
            mCount--;
            //通知生产者生产
            addCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
        return msg;
    }

    public void enqueueMessage(Message message) {
        try {
            mLock.lock();
            while (mCount >= mItems.length) {
                System.out.println("MessageQueue：" + "队列空了，写锁阻塞");
                addCondition.await();
            }
            mItems[mPutIndex] = message;
            mPutIndex = (++mPutIndex >= mItems.length) ? 0 : mPutIndex;
            mCount++;
            //通知消费者消费
            getCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mLock.unlock();
        }
    }
}
