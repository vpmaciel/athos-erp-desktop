package arquitetura.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import arquitetura.Sis;

public class Data {

	public static String getDataHoraSimples() {
		Locale locale = Sis.getLocale();
		Calendar calendar = new GregorianCalendar();
		String data = getDia(calendar.get(Calendar.DAY_OF_WEEK));
		DateFormat dateFormat = new SimpleDateFormat(" - [ dd-MM-yyyy ] - [ HH:mm:ss ]", locale);
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	public static String getDataHoraCompleta() {
		Locale locale = Sis.getLocale();
		Calendar calendar = new GregorianCalendar();

		String data = "DATA E HORA: ";
		data += getDia(calendar.get(Calendar.DAY_OF_WEEK));
		DateFormat dateFormat = new SimpleDateFormat(" - [ dd-MM-yyyy ] - [ HH:mm:ss.SSSS ]", locale);
		data += dateFormat.format(calendar.getTime());
		data += Sis.getUsuarioFormatado();
		return data;
	}

	public static String getDataHoraArquivo() {
		Locale locale = Sis.getLocale();
		Calendar calendar = new GregorianCalendar();

		String data = "";
		DateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd]-[HH-mm-ss]", locale);
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	public static String getData() {
		Locale locale = Sis.getLocale();
		Calendar calendar = new GregorianCalendar();
		String data = getDia(calendar.get(Calendar.DAY_OF_WEEK));
		DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yyyy", locale);
		data += dateFormat.format(calendar.getTime());
		return data;
	}

	public static String getHora() {
		Locale locale = Sis.getLocale();
		Calendar calendar = new GregorianCalendar();

		String data = "";
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSS", locale);
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
