package arquitetura.validacao;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public final class Mascara {

	public static final MaskFormatter getAno() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("0000");
		return mascara;
	}

	public static final String getAnoVazio() {
		return "    ";
	}

	public static final MaskFormatter getCei() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##.###.#####/##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("00.000.00000/00");
		return mascara;
	}

	public static final MaskFormatter getEnderecoCep() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("00000-000");
		return mascara;
	}

	public static final String getEnderecoCepVazio() {
		return "     -   ";
	}

	public static final MaskFormatter getCnpj() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("00.000.000/0000-00");
		return mascara;
	}

	public static final String getCnpjVazio() {
		return "  .   .   /    -  ";
	}

	public static final MaskFormatter getCpf() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("000.000.000-00");
		return mascara;
	}

	public static final String getCpfVazio() {
		return "   .   .   -  ";
	}

	public static final MaskFormatter getCtps() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.#####.##-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("000.00000.00-0");
		return mascara;
	}

	public static final MaskFormatter getCtpsSerie() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("000-0");
		return mascara;
	}

	public static final MaskFormatter getData() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("00/00/0000");
		return mascara;
	}

	public static final String getDataVazio() {
		return "  /  /    ";
	}

	public static final MaskFormatter getFax() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("(##) ####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("(00) 0000-0000");
		return mascara;
	}

	public static final String getFaxVazio() {
		return "(  )     -    ";
	}

	public static final MaskFormatter getFone() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("(##) #-####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("(00) 0-0000-0000");
		return mascara;
	}

	public static final String getFoneVazio() {
		return "(  )  -    -    ";
	}

	public static final MaskFormatter getHora() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("##:##");
		return mascara;
	}

	public static final String getHoraVazio() {
		return "  :  ";
	}

	public static final MaskFormatter getPis() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("###.#####.##-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("000.00000.00-0");
		return mascara;
	}

	public static final String getPisVazio() {
		return "   .     .  - ";
	}

	public static final MaskFormatter getUf() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("UU");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mascara.setPlaceholder("AA");
		return mascara;
	}
}
