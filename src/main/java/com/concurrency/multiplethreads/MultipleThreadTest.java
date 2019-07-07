package com.concurrency.multiplethreads;

import com.concurrency.OpenAccountRequest;
import com.concurrency.OpenAccountService;

import java.util.List;

public class MultipleThreadTest {

    private final static int INIT_REQUESTS_SIZE = 1000;

    private final static int THREADS_SIZE = 10;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        OpenAccountService openAccountService = new OpenAccountService();
        List<OpenAccountRequest> requests =
                openAccountService.initOpenAccountRequestDatas(INIT_REQUESTS_SIZE);
        int size = INIT_REQUESTS_SIZE / THREADS_SIZE;
        for (int i = 0; i < THREADS_SIZE; i++) {
            int startIndex = i * size;
            int endIndex = (i + 1) * size;
            List<OpenAccountRequest> subRequests = requests.subList(startIndex, endIndex);
            Thread thread = new Thread(new MultipleThread(subRequests));
            thread.start();
        }
        long end = System.currentTimeMillis();
        System.out.println("====== 执行时间 ====== : " + (end - start) + " ms");
    }
}
