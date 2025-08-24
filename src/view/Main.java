package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public Main() {
		super();
	}

	public static void main(String[] args) {
		KillController kc = new KillController();
		JOptionPane.showMessageDialog(null, kc.listaProcessos());
	}
}
