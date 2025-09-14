package controller;

import java.util.concurrent.Semaphore;

public class TransacoesCtrl extends Thread {
	
	private int id;
	private Semaphore stop;
	
	public TransacoesCtrl(int id, Semaphore stop) {
		this.id = id;
		this.stop = stop;
	}
	
	@Override
	public void run() {
		findRem();
	}
	
	// divides the id by 3 and finds the correct time of the operations
	private void findRem() {
		int calculateTime = 0;
		int transactionTime = 0;
		
		if (id % 3 == 1) {
			for (int i = 0; i < 4; i++) {
				// find the interval 0,2 to 1,0 seconds
				if (i % 2 == 0) {
					calculateTime = (int)(200 + (1000 - 200) * Math.random());
					calculate(calculateTime);

				
				} else {
					transactionTime = 1000;
					callTransaction(transactionTime);
				
				}
			}
			
		}
		
		if (id % 3 == 2) {
			for (int i = 0; i < 6; i++) {
				// find the interval 0,5 to 1,5 seconds
				if (i % 2 == 0) {
					calculateTime = (int)(500 + (1500 - 500) * Math.random());
					calculate(calculateTime);

					
				} else {
					transactionTime = 1500;
					callTransaction(transactionTime);
					
				}
			}
		}
		
		if (id % 3 == 0) {
			for (int i = 0; i < 6; i++) {
				// find the interval 1 to 2 seconds
				if (i % 2 == 0) {
					calculateTime = (int)(1000 + (2000 - 1000) * Math.random());
					calculate(calculateTime);

				} else {
					transactionTime = 1500;
					callTransaction(transactionTime);

				}
			
			}
		
		}
		
	}
	
	// call a calculate operation
	private void calculate(int calculateTime) {
		double convertedTime = (double) calculateTime / 1000;
		System.out.println("#"+id+" está realizando um calculo que levara "
							+ convertedTime + "s");

		try {
			sleep(calculateTime);
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());

		}		
		
		System.out.println("#"+id+" finalizou o calculo...");
	}

	// for ease of use
	private void callTransaction(int transactionTime) {
		try {
			stop.acquire();
			bdTransaction(transactionTime);

		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			
		} finally {
			stop.release();
			
		}

		
	}
	
	// call a Data Base transaction
	private void bdTransaction(int transactionTime) {
		double convertedTime = (double) transactionTime / 1000;
		System.out.println("#"+id+" está realizando uma transacao no banco de dados que levará "
							+ convertedTime + "s");
		
		try {
			sleep(transactionTime);
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());

		}
		
		System.out.println("#"+id+" finalizou a transacao...");
		
	}


}
