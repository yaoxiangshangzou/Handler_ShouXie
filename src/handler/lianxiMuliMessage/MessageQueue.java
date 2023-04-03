package handler.lianxiMuliMessage;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :      SunHuaJie
 * @date :        2023/3/30-19:10
 * @email :       1214495199@qq.com
 * @description :
 */
public class MessageQueue {
    private static final String TAG = MessageQueue.class.getName();
    private final Condition nNotEmpty;
    private final Condition mNotFull;

    Message[] mItems;
    int mPutIndex;
    private int mCount;

    Lock mLock = new ReentrantLock();
    private int mTakeIndex;

    public MessageQueue() {
        mItems = new Message[5];
        nNotEmpty = mLock.newCondition();
        mNotFull = mLock.newCondition();
    }

    public Message next() {
        Message msg = null;

        try {
            mLock.lock();
            while (mCount <= 0) {
                nNotEmpty.await();
                System.out.println(TAG+ "队列空了，阻塞");
            }
            msg = mItems[mTakeIndex];
            mItems[mTakeIndex] = null;
            mTakeIndex = (++mTakeIndex >= mItems.length) ? 0 : mTakeIndex;
            mCount--;
            mNotFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mLock.unlock();
        }

        return msg;
    }


    public void enqueueMessage(Message message) {
        try {
            mLock.lock();
            while (mCount >= mItems.length) {
                //阻塞
                mNotFull.await();
                System.out.println(TAG+  "队列满了，阻塞");
            }
            mItems[mPutIndex] = message;
            mPutIndex = (++mPutIndex >= mItems.length ? 0 : mPutIndex);
            mCount++;
            //通知消费者消费
            nNotEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }


    }
}
