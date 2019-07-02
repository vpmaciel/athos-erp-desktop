package arquitetura;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;

public class Util {

	public static List<Integer> caracteresNumericosDecimais() {
		List<Integer> lista = new LinkedList<Integer>();

		lista.add(KeyEvent.VK_0);
		lista.add(KeyEvent.VK_1);
		lista.add(KeyEvent.VK_2);
		lista.add(KeyEvent.VK_3);
		lista.add(KeyEvent.VK_4);
		lista.add(KeyEvent.VK_5);
		lista.add(KeyEvent.VK_6);
		lista.add(KeyEvent.VK_7);
		lista.add(KeyEvent.VK_8);
		lista.add(KeyEvent.VK_9);
		lista.add(KeyEvent.VK_COMMA);
		lista.add(KeyEvent.VK_PERIOD);
		
		return lista;
	}
	
	public static DecimalFormat formatoDecimal() {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,###");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat;
	}
}
