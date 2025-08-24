package view;

import java.util.Scanner;

import controller.KillController;

public class Main {
	public Main() {
		super();
	}

	public static void main(String[] args) {
		KillController kc = new KillController();
		boolean loop = true;
		Scanner in = new Scanner(System.in);

		while (loop) {
			// Create Scanner

			System.out.print("""
					|------------------|
					| Main Menu        |
					|------------------|
					| 1 - List process |
					| 2 - Kill by name |
					| 3 - Kill by PID  |
					| 9 - Close        |
					|------------------|
					""");
			System.out.print("Option: ");
			int opc = 0;

			try {
				String aux = in.next();
				opc = Integer.parseInt(aux);

			} catch (Exception e) {
				opc = 0;
			}

			switch (opc) {
			case 1:
				System.out.println(kc.listaProcessos());
				break;

			case 2:
				System.out.print("Process name: ");
				kc.mataNome(in.next());
				break;

			case 3:
				System.out.print("Process PID: ");
				kc.mataPid(in.nextLong());
				break;

			case 9:
				System.out.println("Closed.");
				loop = false;
				break;

			default:
				System.err.println("Invalid Option!!");
				break;
			}
			System.out.println();
		}

		in.close();
	}
}
