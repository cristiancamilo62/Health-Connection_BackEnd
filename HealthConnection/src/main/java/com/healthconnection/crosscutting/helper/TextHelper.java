package com.healthconnection.crosscutting.helper;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	private static final String PATTERN_SOLO_DIGITOS = "\\d+";
	private static final String PATTERN_SOLO_LETRAS = "^[A-Za-záéíóúÁÉÍÓÚ]+$";
	private static final String PATTERN_SOLO_LETRAS_DIGITOS = "^[0-9A-Za-záéíóúÁÉÍÓÚ]+$";
	private static final String PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS = "^[0-9A-Za-záéíóúÁÉÍÓÚ ]+$";
	private static final String PATTERN_SOLO_LETRAS_DIGITOS_ARROBA_DOMINIO = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

	private TextHelper() {
		super();
	}

	public static final boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static final boolean isNullOrEmpty(final String string) {
		return isNull(string) || EMPTY.equals(applyTrim(string));
	}

	public static final String applyTrim(final String string) {
		return getDefault(string).trim();
	}

	public static final String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static final String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static final String concatenate(final String... strings) {
		return Arrays.asList(ObjectHelper.getDefault(strings, new String[0])).stream().map(string -> string)
				.collect(Collectors.joining());
	}
	public static boolean contieneSoloLetras(final String valor) {
	    return applyTrim(valor).matches(PATTERN_SOLO_LETRAS);
	}
	public static boolean contieneSoloLetrasDigitosEspacios(final String valor) {
	    return applyTrim(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
	public static boolean contieneSoloLetrasDigitosArrobaDominio(final String valor) {
		return applyTrim(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ARROBA_DOMINIO);
	}
	public static final boolean contieneSoloDigitos(final String valor) {
		return applyTrim(valor).matches(PATTERN_SOLO_DIGITOS);
	}
	public static final boolean contieneSoloLetrasDigitos(final String valor) {
		return applyTrim(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS);
	}
}
