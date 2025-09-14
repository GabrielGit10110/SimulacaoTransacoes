package view;

import java.util.concurrent.Semaphore;

import controller.TransacoesCtrl;

public class Transacoes {

	public static void main(String[] args) {
		Semaphore stop = new Semaphore(1);
		
		for (int id = 1; id <= 21; id++) {
			TransacoesCtrl transacao = new TransacoesCtrl(id, stop);
			transacao.start();
			
		}
		

	}

}
