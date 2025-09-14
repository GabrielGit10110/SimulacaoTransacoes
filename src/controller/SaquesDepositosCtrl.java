package controller;

import java.util.concurrent.Semaphore;
import utils.Util;

public class SaquesDepositosCtrl extends Thread {
    private static final Semaphore withdrawSemaphore = new Semaphore(1);    // Apenas 1 saque
    private static final Semaphore depositSemaphore = new Semaphore(1); // Apenas 1 depósito
    
    private final int accountCode;
    private final int option; // 0 = Saque, 1 = Depósito
    private final double accountBalance;
    private final double transactionValue;
    
    public SaquesDepositosCtrl(int accountCode, int option, 
                              double accountBalance, double transactionValue) {
        this.accountCode = accountCode;
        this.option = option;
        this.accountBalance = accountBalance;
        this.transactionValue = transactionValue;
    }
    
    @Override
    public void run() {
        try {
            if (option == 0) { // WITHDRAW
                withdrawSemaphore.acquire(); // only one withdraw at a time 
                withdraw();
            } else { // DEPOSIT
                depositSemaphore.acquire(); // only one deposit at a time 
                deposit();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void withdraw() {
        try {
            Util.printWithTimeStamps("Conta: " + accountCode + " saque de " + 
                                    transactionValue + " em processamento...");
            
            for (int i = 0; i <= 100; i++) {
                Util.sleep(5);
            }
            
            if (accountBalance >= transactionValue) {
                Util.printWithTimeStamps("Conta: " + accountCode + " saque realizado com sucesso!");
            } else {
                Util.printWithTimeStamps("Conta: " + accountCode + " saldo insuficiente para saque!");
            }
            
        } finally {
            withdrawSemaphore.release(); // next withdraw can pass
        }
    }
    
    private void deposit() {
        try {
            Util.printWithTimeStamps("Conta: " + accountCode + " depósito de " + 
                                    transactionValue + " em processamento...");
            
            for (int i = 0; i <= 100; i++) {
                Util.sleep(5);
            }
            
            Util.printWithTimeStamps("Conta: " + accountCode + " depósito realizado com sucesso!");
            
        } finally {
            depositSemaphore.release(); // next deposit can pass 
        }
    }
}