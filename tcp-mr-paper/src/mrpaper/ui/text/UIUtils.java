package mrpaper.ui.text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UIUtils {

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final UIUtils INSTANCE = new UIUtils();
	
	private final BufferedReader reader;
	private final SimpleDateFormat sdf;
	private final SimpleDateFormat sdtf;

	private UIUtils() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.sdf = new SimpleDateFormat(DATE_FORMAT);
		this.sdtf = new SimpleDateFormat(DATE_TIME_FORMAT);
	}

	public String formatDateTime(Date value) {
		return sdtf.format(value);
	}

	/**
	 * @return the textManager
	 */
	public void handleUnexceptedError(Exception e) {
		System.out.println("Uma excecao inesperada ocorreu");
		e.printStackTrace();
		System.exit(-1);
	}

	public Double readDouble(String field) {
		Double value = null;
		while (value == null) {
			try {
				System.out.print(field +": ");
				value = new Double(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Um valor numerico e esperado");
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field) {
		Integer value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(field+ ": ");
				value = new Integer(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Um valor numerico inteiro e esperado");
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field, int min, int max) {
		Integer value = null;
		while (value == null) {
			value = readInteger(field);
			if (value < min || value > max) {
				value = null;
				System.out.println("Valor fora do limite");
			}
		}
		return value;
	}

	public Long readLong(String field) {
		Long value = null;
		while (value == null) {
			try {
				System.out.print(field + ": ");
				value = new Long(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out
						.println("Um valor numerico inteiro e esperado");
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public String readString(String field) {
		String value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(field + ": ");
				value = reader.readLine();
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

}
