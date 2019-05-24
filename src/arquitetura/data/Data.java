package arquitetura.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import arquitetura.AOP;

public class Data {

	public static String getData() {
		Locale locale = AOP.getLocale();
		Calendar calendar = new GregorianCalendar();
		String data = getDia(calendar.get(Calendar.DAY_OF_WEEK));
		DateFormat dateFormat = new SimpleDateFormat(" - [ dd/MM/yyyy ] - [ HH:mm:ss ]", locale);
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	public static String getDataHora() {
		Locale locale = AOP.getLocale();
		Calendar calendar = new GregorianCalendar();

		String data = "DATA E HORA: ";
		data += getDia(calendar.get(Calendar.DAY_OF_WEEK));
		DateFormat dateFormat = new SimpleDateFormat("- [ dd/MM/yyyy ] - [ HH:mm:ss.SSSS ]", locale);
		data += dateFormat.format(calendar.getTime());
		data += AOP.getUsuarioFormatado();
		return data;
	}

	public static String getHora() {
		Locale locale = AOP.getLocale();
		Calendar calendar = new GregorianCalendar();

		String data = "";
		DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss-SSSS", locale);
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	
	public static String getDia(int dia) {
		String nome = "";

		switch (dia) {

		case Calendar.SUNDAY:
			nome = "- [ DOMINGO ]";
			break;
		case Calendar.MONDAY:
			nome = "- [ SEGUNDA-FEIRA ]";
			break;
		case Calendar.TUESDAY:
			nome = "- [ TERÇA-FEIRA ]";
			break;
		case Calendar.WEDNESDAY:
			nome = "- [ QUARTA-FEIRA ]";
			break;
		case Calendar.THURSDAY:
			nome = "- [ QUINTA-FEIRA ]";
			break;
		case Calendar.FRIDAY:
			nome = "- [ SEXTA-FEIRA ]";
			break;
		case Calendar.SATURDAY:
			nome = "- [ SÁBADO ]";
			break;
		}
		return nome;
	}

	private Data() {
		
	}
}
