package com.example.leetcodework.ui.home;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class UIMonitor{
    private static final int TIME_BLOCK = 800;
    private static final String TAG_THREAD = "UIMonitor_TAG:";
    @NonNull
    private static UIMonitor instance = new UIMonitor();

    private final long monitorStartTime;
    private int dispatchCount;
    private int blockCount;

    private long timeStart;

    @Nullable
    private StackTraceElement[] lastBlockStackTrace;

    @NonNull
    private Runnable monitorTask = new Runnable() {
        @Override
        public void run() {
            lastBlockStackTrace = Looper.getMainLooper().getThread().getStackTrace();
        }
    };

    private UIMonitor() {
        HandlerThread monitorThread = new HandlerThread("ui-monitor");
        monitorThread.start();
        monitorStartTime = SystemClock.elapsedRealtime();
    }

    @NonNull
    static UIMonitor getInstance() {
        return instance;
    }

    void start() {
        Looper.getMainLooper().setMessageLogging(x -> {
            if (x.startsWith(">>>>> Dispatching")) {
                onMessageStart();
            } else if (x.startsWith("<<<<< Finished")) {
                onMessageFinish();
            }
        });
    }

    private void onMessageStart() {
        if (dispatchCount < Integer.MAX_VALUE) {
            dispatchCount++;
            timeStart = SystemClock.elapsedRealtime();
            lastBlockStackTrace = null;
            ThreadPool.runCalculatorDelayed(TIME_BLOCK, monitorTask);
        } else {
            timeStart = 0;
        }
    }

    private void onMessageFinish() {
        if (timeStart > 0) {
//            ThreadPool.removeCalculator(monitorTask);
            long timeUsed = SystemClock.elapsedRealtime() - timeStart;
            StackTraceElement[] blockStackTrace = lastBlockStackTrace;
            if (timeUsed > TIME_BLOCK && blockStackTrace != null) {
                logBlockEvent(timeUsed, blockStackTrace);
            }
        }
    }

    private void logBlockEvent(long timeUsed, @NonNull StackTraceElement[] blockStackTrace) {
        blockCount++;

        final int maxStacksPerLog = 30;
        final boolean multiPart = blockStackTrace.length > maxStacksPerLog;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int partNo = 0;
        for (StackTraceElement s : blockStackTrace) {
            sb.append("\tat ").append(s.toString()).append("\n");
            if (multiPart && ++count == maxStacksPerLog) {

                Log.e(TAG_THREAD,String.format("UIMonitor found block, timeUsed: %dms (Part %d)\n%s",timeUsed, ++partNo, sb.toString()));
                sb = new StringBuilder();
                count = 0;
            }
        }

        if (sb.length() > 0) {
            if (multiPart) {
                Log.e(TAG_THREAD,String.format("UIMonitor found block, timeUsed: %dms (Part %d)\n%s",
                       timeUsed, ++partNo, sb.toString()));
            } else {
                Log.e(TAG_THREAD,String.format("%s UIMonitor found block, timeUsed: %dms\n%s",
                         timeUsed, sb.toString()));
            }
        }
    }
}