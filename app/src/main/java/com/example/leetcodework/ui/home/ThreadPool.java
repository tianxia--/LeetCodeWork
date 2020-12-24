package com.example.leetcodework.ui.home;

import android.os.HandlerThread;
import android.os.Process;

import androidx.annotation.NonNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ThreadPool {
    private static final int UI_TASK_CHECK_INTERVAL = 10_000; // 10 seconds
    private static ScheduledExecutorService taskScheduler;

    public static void startup() {
        // Use a HandlerThread to schedule tasks
        HandlerThread schedulerThread = new HandlerThread("TaskScheduler",
                Process.THREAD_PRIORITY_MORE_FAVORABLE);
        schedulerThread.start();
        taskScheduler = Executors.newScheduledThreadPool(3);

    }

    /**
     * It's for CPU related tasks.
     */
    public static void runCalculatorDelayed(long delayMs, @NonNull Runnable task) {
        taskScheduler.schedule(task,delayMs,TimeUnit.MILLISECONDS);
    }

    public static void removeTask(Runnable task){
//        taskScheduler.s
    }

}
