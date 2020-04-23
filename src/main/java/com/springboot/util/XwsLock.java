package com.springboot.util;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lulu
 * aqs同步器简单实现
 */
public class XwsLock {
    /**
     * 当前锁状态
     */
    private volatile int state = 0;

    /**
     * 当前持有锁的线程
     */
    private Thread lockHolder;

    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    /**
     * 安全修改state状态数
     */
    private static final Unsafe UNSAFE = UnsafeInstance.reflectGetUnsafe();

    private static final long stateOffset;
    static{
        try {
            stateOffset = UNSAFE.objectFieldOffset(XwsLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            throw new Error();
        }
    }

    private boolean aquire(){
        Thread current = Thread.currentThread();
        int c = this.getState();
        if(c == 0){
            if((waiters.size() == 0 || waiters.peek() == current) && this.compareAndSwapState(0,1)){
                this.setLockHolder(current);
                return true;
            }

        }

        return false;
    }


    /**
     * 锁
     */
    private void lock(){
        //尝试获得锁
        if(this.aquire()){

            return;
        }
        Thread current = Thread.currentThread();
        waiters.add(current);

        for (;;){
            if(current == waiters.peek() && this.aquire()){
                //队列头部节点出队
                waiters.poll();
                return;
            }
            //阻塞当前线程
            LockSupport.park(current);
        }
    }

    /**
     * 解锁
     */
    private void unLock() throws Exception {
        if(Thread.currentThread() != this.getLockHolder()){
            throw new Exception("当前线程并未获得锁");
        }
        int s = this.getState();
        if(compareAndSwapState(s,0)){
            this.setLockHolder(null);
            //唤醒队列的第一个线程
            Thread first = waiters.peek();
            if(first != null){
                LockSupport.unpark(first);
            }
        }
    }

    /**
     * 原子修改state属性
     * @param expect 原来的属性值
     * @param update 期望变为的值
     * @return 是否成功
     */
    private final boolean compareAndSwapState(int expect,int update){
        return UNSAFE.compareAndSwapInt(this,stateOffset,expect,update);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public static Unsafe getUNSAFE() {
        return UNSAFE;
    }

    public static long getStateOffset() {
        return stateOffset;
    }
}
