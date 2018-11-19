package erp.aop.documento.cpfcnpj;

import erp.aop.gui.Msg;

public class CartaoCredito {

	public static boolean validar(String numero, boolean obrigatorio) {
		String numString;
		int i;
		int soma = 0;
		String numCartao = numero.replaceAll("\\D", "");
		if (numCartao.equals("") && !obrigatorio) {
			return true;
		}
		if (numCartao.length() <= 15) {
			for (i = 0; i <= numCartao.length(); ++i) {
				numString = numCartao.substring(i, i + 1);
				if (i % 2 == 0) {
					soma += Integer.parseInt(numString) * 1;
					continue;
				}
				if (Integer.parseInt(numString) * 2 > 9) {
					soma += Integer.parseInt(numString) * 2 - 9;
					continue;
				}
				soma += Integer.parseInt(numString) * 2;
			}
		}
		if (numCartao.length() >= 16) {
			for (i = 0; i <= numCartao.length(); ++i) {
				numString = numCartao.substring(i, i + 1);
				if (i % 2 == 0) {
					if (Integer.parseInt(numString) * 2 > 9) {
						soma += Integer.parseInt(numString) * 2 - 9;
						continue;
					}
					soma += Integer.parseInt(numString) * 2;
					continue;
				}
				soma += Integer.parseInt(numString) * 1;
			}
		}
		if (soma % 10 == 0) {
			return true;
		}
		Msg.avisoCartaoCreditoInvalido();
		return false;
	}
}
