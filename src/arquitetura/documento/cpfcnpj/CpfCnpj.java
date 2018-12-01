package arquitetura.documento.cpfcnpj;

public class CpfCnpj {

	public static final int CNPJ_DIGITS = 14;
	public static final String CNPJ_MASK = "##.###.###/####-##";
	public static final int CPF_DIGITS = 11;
	public static final String CPF_MASK = "###.###.###-##";

	public static String completeDv(String number) {
		if (number != null) {
			String n = number.replaceAll("[^0-9]", "");
			boolean isCpf = n.length() == 9;
			n = n + CpfCnpj.getModule11Dv(n, isCpf);
			n = n + CpfCnpj.getModule11Dv(n, isCpf);
			return n;
		}
		return null;
	}

	public static String extractDv(String completeNumber) {
		if (completeNumber != null) {
			String n = completeNumber.replaceAll("[^0-9]", "");
			boolean isCpf = n.length() == 9;
			return "" + CpfCnpj.getModule11Dv(completeNumber, isCpf);
		}
		return null;
	}

	public static char getModule11Dv(String number, boolean isCpf) {
		String n = number.replaceAll("[^0-9]", "");
		int sum = 0;
		int coeficient = 2;
		for (int i = n.length() - 1; i >= 0; --i) {
			int digit = Integer.parseInt(String.valueOf(n.charAt(i)));
			sum += digit * coeficient;
			if (++coeficient <= 9 || isCpf) {
				continue;
			}
			coeficient = 2;
		}
		int dv = 11 - sum % 11;
		if (dv >= 10) {
			dv = 0;
		}
		return Integer.toString(dv).charAt(0);
	}

	public static boolean isValid(String cpfOrCnpj) {
		boolean isCpf;
		if (cpfOrCnpj == null) {
			return false;
		}
		String n = cpfOrCnpj.replaceAll("[^0-9]", "");
		boolean isCnpj = n.length() == 14;
		@SuppressWarnings("unused")
		boolean bl = isCpf = n.length() == 11;
		if (!isCpf && !isCnpj) {
			return false;
		}
		int[] foundDv = new int[] { 0, 0 };
		int dv1 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 2)));
		int dv2 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
		for (int j = 0; j < 2; ++j) {
			int sum = 0;
			int coeficient = 2;
			for (int i = n.length() - 3 + j; i >= 0; --i) {
				int digit = Integer.parseInt(String.valueOf(n.charAt(i)));
				sum += digit * coeficient;
				if (++coeficient <= 9 || !isCnpj) {
					continue;
				}
				coeficient = 2;
			}
			foundDv[j] = 11 - sum % 11;
			if (foundDv[j] < 10) {
				continue;
			}
			foundDv[j] = 0;
		}
		return dv1 == foundDv[0] && dv2 == foundDv[1];
	}

	private boolean autoCorrection = false;

	private String mask = null;

	private String number = null;

	public CpfCnpj() {
	}

	public CpfCnpj(String cpfCnpj) {
		this.setCpfCnpj(cpfCnpj);
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	public String getCpfCnpj() {
		if (this.number != null) {
			return this.number.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1\\.$2\\.$3-$4");
		}
		return null;
	}

	public String getMask() {
		return this.mask;
	}

	public String getNumber() {
		return this.number;
	}

	public boolean isAutoCorrection() {
		return this.autoCorrection;
	}

	public boolean isCnpj() {
		System.out.println("e cnpj");
		return this.number != null && this.number.length() == 14;
	}

	public boolean isCpf() {
		return this.number != null && this.number.length() == 11;
	}

	public boolean isFormatValid() {
		return this.isCpf() || this.isCnpj();
	}

	public boolean isValid() {
		return CpfCnpj.isValid(this.getNumber());
	}

	public void setAutoCorrection(boolean autoCorrection) {
		this.autoCorrection = autoCorrection;
	}

	public void setCpfCnpj(String cpfCnpj) {
		if (cpfCnpj != null) {
			this.number = cpfCnpj.replaceAll("[^0-9]*", "");
			if (this.isCpf()) {
				this.mask = "###.###.###-##";
			} else if (this.isCnpj()) {
				this.mask = "##.###.###/####-##";
			}
		} else {
			this.number = null;
		}
	}

	public long toLong() {
		if (this.number != null && this.number.length() > 0) {
			return Long.parseLong(this.number);
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.getCpfCnpj();
	}
}
