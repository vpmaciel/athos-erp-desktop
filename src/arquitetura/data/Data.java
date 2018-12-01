package arquitetura.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Data {

	public Data() {
		System.out.println(getDateTime());
	}

	public static String getDateTime() {
		Locale locale = new Locale("pt", "BR");
		Calendar calendar = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSS", locale);
		String data = "DATA E HORA DE EMISSÃO: ";
		data += getDia(calendar.get(Calendar.DAY_OF_WEEK)) + " ";
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	public static String getDia(int dia) {
		String nome = "";

		switch (dia) {

		case Calendar.SUNDAY:
			nome = "DOMINGO";
			break;
		case Calendar.MONDAY:
			nome = "SEGUNDA";
			break;
		case Calendar.TUESDAY:
			nome = "TERÇA";
			break;
		case Calendar.WEDNESDAY:
			nome = "QUARTA";
			break;
		case Calendar.THURSDAY:
			nome = "QUINTA";
			break;
		case Calendar.FRIDAY:
			nome = "SEXTA";
			break;
		case Calendar.SATURDAY:
			nome = "SÁBADO";
			break;
		}

		return nome;
	}

}
