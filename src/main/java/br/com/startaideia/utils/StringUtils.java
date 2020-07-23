package br.com.startaideia.utils;

public class StringUtils {

	/**
	 * formata o filtro para consulta sql
	 * 
	 * @param filtro
	 * @return - filtro formatado
	 */
	public static String filtroLike(String filtro) {
		String termo = "";
		if (filtro == null || filtro.trim().length() == 0) {
			termo = "%";
		} else {
			termo = "%" + filtro.trim() + "%";
		}
		return termo;
	}
}
