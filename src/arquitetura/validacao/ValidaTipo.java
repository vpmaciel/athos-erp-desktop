package arquitetura.validacao;

public class ValidaTipo {

	public static boolean ehDouble(String valor) {
		try {
			Double.parseDouble(valor);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}

	public static boolean ehInteiro(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
}
