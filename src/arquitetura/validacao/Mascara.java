package arquitetura.validacao;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public final class Mascara {

	public static MaskFormatter getCei() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##.###.#####/##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getCep() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("#####-###");
			mascara.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mascara;
	}

	public static MaskFormatter getCnpj() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getCpf() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getCrc() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("UU-######/U");
			mascara.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mascara;
	}

	public static MaskFormatter getCtps() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.#####.##-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getCtpsSerie() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getData() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getHora() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getFone() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##-#####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getPis() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.#####.##-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public static MaskFormatter getUf() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("UU");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholderCharacter('_');
		return mascara;
	}

	public String getSimbolos() {
		String s = "#./_-";
		return s;
	}
}
