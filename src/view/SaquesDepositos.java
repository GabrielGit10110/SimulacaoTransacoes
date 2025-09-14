package view;

import controller.SaquesDepositosCtrl;
import utils.Util;

public class SaquesDepositos {

	public static void main(String[] args) {
		double accountBalance = 0; 
		double transactionValue = 0;
		int option = 0;

		for (int transactions = 0; transactions < 20; transactions++) {
			accountBalance = Util.genRandomDouble(10.0, 1000);
			transactionValue = Util.genRandomDouble(1.0, 1000);
			option = Util.genRandomInteger(0, 1);
			SaquesDepositosCtrl newTransaction = new SaquesDepositosCtrl(transactions, option, accountBalance, 
																		 transactionValue);
			newTransaction.start();
		}
		
	}
	
}
