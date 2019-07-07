package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpenAccountService {

    public void openAccount(OpenAccountRequest request) {
        openCustomerAccount(request);
        openPaymentAccount(request);
        openTradeAccount(request);
        saveAccountRequest(request);
    }

    private void openCustomerAccount(OpenAccountRequest request) {
        System.out.println("====== 开客户账号 ====== : " + request.getCertificateNo());
    }

    private void openPaymentAccount(OpenAccountRequest request) {
        System.out.println("====== 开付款账号 ====== : " + request.getBankAccountNo());
    }

    private void openTradeAccount(OpenAccountRequest request) {
        System.out.println("====== 开交易账号 ====== : " + request.getName());
    }

    private void saveAccountRequest(OpenAccountRequest request) {
        System.out.println("====== 保存申请信息 ====== : " + request.getName());
    }

    public List<OpenAccountRequest> initOpenAccountRequestDatas(int size) {
        List<OpenAccountRequest> requests = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String fourRandom = getFourRandom();
            OpenAccountRequest request = new OpenAccountRequest();
            request.setCertificateType("1");
            request.setCertificateNo("13018119871017" + fourRandom);
            request.setName("张明_" + getSeqNo(i));
            request.setBankAccountName("张明_" + getSeqNo(i));
            request.setBankAccountNo("622848126824891" + fourRandom);
            request.setTelephoneNo("1891256" + fourRandom);
            requests.add(request);
        }
        return requests;
    }

    private static String getSeqNo(int index) {
        String str = "00000000" + index;
        return str.substring(str.length() - 4, str.length());
    }

    /**
     * 产生4位随机数(0000-9999)
     *
     * @return 4位随机数
     */
    public static String getFourRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }
}
