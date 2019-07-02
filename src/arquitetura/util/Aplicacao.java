package arquitetura.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Aplicacao {

	public static boolean estaExecutando(String processo) {
		if(System.getProperty("os.name").contains("windows")) {
			
		}
		
		return estaExecutandoLinux(processo);
	}
	
	public static boolean estaExecutandoLinux(String processo) {
		try {
			Process p = Runtime.getRuntime().exec("ps ax"); // aqui fica o comando que vai pegar os processos

			BufferedReader resultado = new BufferedReader(new InputStreamReader(p.getInputStream()));

			// mostra os resultados obtidos pelo comando 'ps ax'
			String s;
			while ((s = resultado.readLine()) != null)
				if (s.contains("athos")) {
					return true;
				}
			System.out.println(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
