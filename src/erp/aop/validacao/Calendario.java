package erp.aop.validacao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendario {

	public static short calcularIdade(String dataNasc, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;
		try {
			dataNascInput = sdf.parse(dataNasc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		GregorianCalendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);
		Calendar today = Calendar.getInstance();
		int age = today.get(1) - dateOfBirth.get(1);
		dateOfBirth.add(1, age);
		if (today.before(dateOfBirth)) {
			--age;
		}
		return (short) age;
	}
}
