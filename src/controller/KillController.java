package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}

	/*
	 * Identifica e retorna o nome do Sistema Operacional
	 */
	private String os() {
		return System.getProperty("os.name");
	}

	private Process createProcess(String proc) {
		try {
			String[] comand = proc.split(" ");
			Process process = Runtime.getRuntime().exec(comand);
			return process;

		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(proc);
				return createProcess(buffer.toString());
			} else
				System.err.println(msg);
		}
		return null;
	}

	/*
	 * Verifica o SO e, de acordo com SO, selecione o comando para listar os
	 * processos ativos. O método deve receber todas as linhas de saída do processo
	 * de listagem e exibi-las em console.
	 */
	public String listaProcessos() {
		String os = os();
		Process process = null;
		if (os.contains("Windows")) {
			process = createProcess("TASKLIST /FO TABLE");
		} else if (os.contains("Linux") || os.contains("Mac")) {
			process = createProcess("ps -ef");
		} else
			return "OS Desconhecida";

		InputStreamReader flow = new InputStreamReader(process.getInputStream());
		try (BufferedReader buffer = new BufferedReader(flow)) {
			StringBuffer text = new StringBuffer();
			String line = buffer.readLine();

			while (line != null) {
				text.append(line);
				text.append("\r\n");
				line = buffer.readLine();
			}
			return text.toString();
		} catch (Exception e) {
			String msg = e.getMessage();
			return msg;
		}
	}

	/*
	 * Recebe um PID como parâmetro de entrada, verifica o SO e, de acordo com SO,
	 * selecione o comando para matar o processo e o finalize.
	 */
	public void mataPid(Long PID) {
		String os = os();
		StringBuffer buffer = new StringBuffer();

		if (os.contains("Windows")) {
			buffer.append("TASKKILL /PID ");

		} else if (os.contains("Linux") || os.contains("Mac")) {
			buffer.append("kill -9 ");
		} else {
			System.err.println("OS não Reconhecida" + os);
		}

		buffer.append(PID);
		createProcess(buffer.toString());
	}

	/*
	 * Recebe um nome de processo como parâmetro de entrada, verifica o SO e, de
	 * acordo com SO, selecione o comando para matar o processo e o finalize.
	 */
	public void mataNome(String Nome) {
		String os = os();
		StringBuffer buffer = new StringBuffer();

		if (os.contains("Windows")) {
			buffer.append("TASKKILL /IM ");

		} else if (os.contains("Linux") || os.contains("Mac")) {
			buffer.append("pkill -f ");
		} else {
			System.err.println("OS não Reconhecida" + os);
		}

		buffer.append(Nome);
		createProcess(buffer.toString());
	}
}
