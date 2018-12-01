package arquitetura.validacao;

import java.util.regex.Pattern;

public final class RegExp {

	public static final Pattern CEI = Pattern.compile("\\S{1,50}");
	public static final Pattern CEP = Pattern.compile("\\d{1,5}[-]\\d{1,3}");
	public static final Pattern CONTA_AGENCIA_BANCARIA = Pattern.compile("(\\d+[ -/]?)+");
	public static final Pattern CRC = Pattern.compile("[A-Z][A-Z][-]\\d{1,6}[/][O,PesquisaRegistro]");
	public static final Pattern DATA = Pattern.compile(
			"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
	public static final Pattern EMAIL = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	public static final Pattern FILHOS = Pattern.compile("\\d{1,3}");
	public static final Pattern FLOAT = null;
	public static final Pattern FONE = Pattern.compile("\\d{0}xx\\d{2}[-]\\d{4}-\\d{4}");
	public static final Pattern IDADE = Pattern.compile("\\d{1,3}");
	public static final Pattern INTEIRO = Pattern.compile("[+,-]?\\d+");
	public static final Pattern INTEIRO_NEGATIVO = Pattern.compile("[-]?\\d+");
	public static final Pattern INTEIRO_POSITIVO = Pattern.compile("\\d+");
	public static final Pattern MOEDA = Pattern.compile("(-)?\\d+[,.]?\\d{1,2}");
	public static final Pattern MOEDA_KEY_LISTENER = Pattern.compile("(-|(-)?\\d+|(-)?\\d+[,.]?|(-)?\\d+[,.]\\d{1,2})");
	public static final Pattern MOEDA_NAO_NEGATIVO = Pattern.compile("\\d+[,.]?\\d{2}");
	public static final Pattern MOEDA_NAO_NEGATIVO_KEY_LISTENER = Pattern.compile("\\d+|\\d+[,.]?|\\d+[,.]\\d{1,2}");
	public static final Pattern NOME = Pattern.compile(
			"^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?${1,50}");
	public static final Pattern NUMERO_AGENCIA_BANCARIA = Pattern.compile("(\\d+[ -]?)+");
	public static final Pattern NUMERO_BANCO = Pattern.compile("\\w(\\w*[ -]?)+");
	public static final Pattern SITE = Pattern.compile("\\w+(\\w+[.]\\w+)+");
	public static final Pattern STRING_INTEIRO_SEM_SINAL = Pattern.compile("\\d+");
	public static final Pattern UF = Pattern.compile(
			"[AC]|[AL]|[AP]|[AM]|[BA]|[CE]|[DF]|[ES]|[GO]|[MA]|[MT]|[MS]|[MG]|[PA]|[PB]|[PR]|[PE]|[PI]|[RR]|[RO]|[RJ]|[RN]|[RS]|[SC]|[SP]|[SE]|[TO]");
	public static final Pattern URL = Pattern.compile(
			"^(http|https|ftp)\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&%\\$#\\=~])*$");
}
