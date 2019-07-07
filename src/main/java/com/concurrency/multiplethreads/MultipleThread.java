package com.concurrency.multiplethreads;

import com.concurrency.OpenAccountRequest;
import com.concurrency.OpenAccountService;

import java.util.List;

public class MultipleThread implements Runnable {

    private List<OpenAccountRequest> requests;

    public MultipleThread(List<OpenAccountRequest> requests) {
        this.requests = requests;
    }

    @Override
    public void run() {
        for (OpenAccountRequest request : requests) {
            OpenAccountService openAccountService = new OpenAccountService();
            openAccountService.openAccount(request);
            System.out.println();
        }
    }
}
