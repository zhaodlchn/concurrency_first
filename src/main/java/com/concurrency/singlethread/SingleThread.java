package com.concurrency.singlethread;

import com.concurrency.OpenAccountRequest;
import com.concurrency.OpenAccountService;

import java.util.List;

public class SingleThread {

    private final static int INIT_REQUESTS_SIZE = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        OpenAccountService openAccountService = new OpenAccountService();
        List<OpenAccountRequest> requests =
                openAccountService.initOpenAccountRequestDatas(INIT_REQUESTS_SIZE);
        for (OpenAccountRequest request : requests) {
            openAccountService.openAccount(request);
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println("====== 执行时间 ====== : " + (end - start) + " ms");
    }
}
