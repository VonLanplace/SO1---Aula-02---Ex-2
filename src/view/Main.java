package view;

import controller.KillController;

public class Main {
	public Main() {
		super();
	}

	public static void main(String[] args) {
		KillController kc = new KillController();
		System.out.println(kc.listaProcessos());
	}
}
