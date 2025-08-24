package controller;

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

	/*
	 * Verifica o SO e, de acordo com SO, selecione o comando para listar os
	 * processos ativos. O método deve receber todas as linhas de saída do processo
	 * de listagem e exibi-las em console.
	 */
	public String listaProcessos() {
		String os = os();
		if (os.contains("Windows")) {
			return processosWindows();
		} else if (os.contains("Linux") || os.contains("Mac")) {
			return processosUnixLike();
		}
		return "OS Desconhecida";
	}

	/*
	 * Recebe um PID como parâmetro de entrada, verifica o SO e, de acordo com SO,
	 * selecione o comando para matar o processo e o finalize.
	 */
	public void mataPid(Long PID) {
		String os = os();
		if (os.contains("Windows")) {

		} else if (os.contains("Linux") || os.contains("Mac")) {

		}
	}

	/*
	 * Recebe um nome de processo como parâmetro de entrada, verifica o SO e, de
	 * acordo com SO, selecione o comando para matar o processo e o finalize.
	 */
	public void mataNome(String Nome) {
		String os = os();
		if (os.contains("Windows")) {

		} else if (os.contains("Linux") || os.contains("Mac")) {

		}
	}
}
