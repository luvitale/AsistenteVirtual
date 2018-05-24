package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	
	private Calendar ahora;
	private int año;
	private int mes;
	private int dia;
	private int hr_12;
	private int hr_24;
	private int min;
	private int seg;
	private String am_pm;
	private String mes_nombre;
	private String dia_nombre;
	private String[] v_am_pm = {"AM", "PM"};
	private String[] v_mes_nombre = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
	private String[] v_dia_nombre = {"DOMINGO", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO"};


//	 Constructor por defecto seteado al 01/04/2018 15:15:00, para probar con los tests
//	Para que funcione con la fecha del sistema, comentar la linea "ahora.set(2018, 3, 1, 15, 15, 0);"
	public Fecha () {
		this.ahora = Calendar.getInstance();
		ahora.set(2018, 3, 1, 15, 15, 0);	 
		año = ahora.get(Calendar.YEAR);
		mes = ahora.get(Calendar.MONTH) + 1; // 1 (ENERO) y 12 (DICIEMBRE)
		dia = ahora.get(Calendar.DAY_OF_MONTH);
		hr_12 = ahora.get(Calendar.HOUR);
		hr_24 = ahora.get(Calendar.HOUR_OF_DAY);
		min = ahora.get(Calendar.MINUTE);
		seg = ahora.get(Calendar.SECOND);
		am_pm = v_am_pm[ahora.get(Calendar.AM_PM)]; //ahora.get(Calendar.AM_PM)=> 0 (AM) y 1 (PM)
		mes_nombre = v_mes_nombre[ahora.get(Calendar.MONTH)];
		dia_nombre = v_dia_nombre[ahora.get(Calendar.DAY_OF_WEEK) - 1];

	}
	
//	Constructor para Fecha Futuro. Ordesn de ".add" es de segundos hasta años.
	public Fecha (int año_p, int mes_p, int dia_p, int hr_p, int min_p, int seg_p) {
		this.ahora = Calendar.getInstance();
		ahora.set(2018, 3, 1, 15, 15, 0);
		if(seg_p != 0)
			ahora.add(Calendar.SECOND, seg_p);
		if(min_p != 0)
			ahora.add(Calendar.MINUTE, min_p);
		if(hr_p != 0)
			ahora.add(Calendar.HOUR, hr_p);
		if(dia_p != 0)
			ahora.add(Calendar.DATE, dia_p);
		if(mes_p != 0)
			ahora.add(Calendar.MONTH, mes_p);
		if(año_p != 0)
			ahora.add(Calendar.YEAR, año_p);
		año = ahora.get(Calendar.YEAR);
		mes = ahora.get(Calendar.MONTH) + 1; // 1 (ENERO) y 12 (DICIEMBRE)
		dia = ahora.get(Calendar.DAY_OF_MONTH);
		hr_12 = ahora.get(Calendar.HOUR);
		hr_24 = ahora.get(Calendar.HOUR_OF_DAY);
		min = ahora.get(Calendar.MINUTE);
		seg = ahora.get(Calendar.SECOND);
		am_pm = v_am_pm[ahora.get(Calendar.AM_PM)]; //ahora.get(Calendar.AM_PM)=> 0 (AM) y 1 (PM)
		mes_nombre = v_mes_nombre[ahora.get(Calendar.MONTH)];
		dia_nombre = v_dia_nombre[ahora.get(Calendar.DAY_OF_WEEK) - 1];

	}
	
	
//	Constructor para Fecha Pasado. Ordesn de ".add" es de años a segundos. 
//	Ultimo parametro un String para no distingir del 	Constructor para Fecha Futuro
	public Fecha (int año_p, int mes_p, int dia_p, int hr_p, int min_p, int seg_p, String pasado) {
		this.ahora = Calendar.getInstance();
		ahora.set(2018, 3, 1, 15, 15, 0);
		if(año_p != 0)
			ahora.add(Calendar.YEAR, año_p);
		if(mes_p != 0)
			ahora.add(Calendar.MONTH, mes_p);
		if(dia_p != 0)
			ahora.add(Calendar.DATE, dia_p);
		if(hr_p != 0)
			ahora.add(Calendar.HOUR, hr_p);
		if(min_p != 0)
			ahora.add(Calendar.MINUTE, min_p);
		if(seg_p != 0)
			ahora.add(Calendar.SECOND, seg_p);
		año = ahora.get(Calendar.YEAR);
		mes = ahora.get(Calendar.MONTH) + 1; // 1 (ENERO) y 12 (DICIEMBRE)
		dia = ahora.get(Calendar.DAY_OF_MONTH);
		hr_12 = ahora.get(Calendar.HOUR);
		hr_24 = ahora.get(Calendar.HOUR_OF_DAY);
		min = ahora.get(Calendar.MINUTE);
		seg = ahora.get(Calendar.SECOND);
		am_pm = v_am_pm[ahora.get(Calendar.AM_PM)]; //ahora.get(Calendar.AM_PM)=> 0 (AM) y 1 (PM)
		mes_nombre = v_mes_nombre[ahora.get(Calendar.MONTH)];
		dia_nombre = v_dia_nombre[ahora.get(Calendar.DAY_OF_WEEK) - 1];

	}
	
	
	public Fecha (String fecha, String format_date) throws ParseException {
		
		Date parsed = new Date();
		SimpleDateFormat format = new SimpleDateFormat(format_date);
		parsed = format.parse(fecha);
		this.ahora = Calendar.getInstance();
		ahora.setTime(parsed);
		año = ahora.get(Calendar.YEAR);
		mes = ahora.get(Calendar.MONTH) + 1; // 1 (ENERO) y 12 (DICIEMBRE)
		dia = ahora.get(Calendar.DAY_OF_MONTH);
		hr_12 = ahora.get(Calendar.HOUR);
		hr_24 = ahora.get(Calendar.HOUR_OF_DAY);
		min = ahora.get(Calendar.MINUTE);
		seg = ahora.get(Calendar.SECOND);
		am_pm = v_am_pm[ahora.get(Calendar.AM_PM)]; //ahora.get(Calendar.AM_PM)=> 0 (AM) y 1 (PM)
		mes_nombre = v_mes_nombre[ahora.get(Calendar.MONTH)];
		dia_nombre = v_dia_nombre[ahora.get(Calendar.DAY_OF_WEEK) - 1];
		
	}
	
		
	public int getAño() {
		return año;
	}


	public String[] formato_hora =	{"H:MM_AM", "HH:MM_AM", "H:MM:SS_AM", "HH:MM:SS_AM",
									 "H:MM", "HH:MM", "H:MM:SS", "HH:MM:SS"};
	
	
	public String[] formato_fecha =	{"d 'de' MMMMM 'de' yyyy", "dd 'de' MMMMM 'de' yyyy", "DD/MM/AAAA", "DD/MM/AA",
									"nameDay D de mmmm de AAAA"};

	
	public String hora(String format_time) {
		if(format_time.equals(formato_hora[0]))
			return "" + hr_12 + ":" + (min<10?"0":"") + min + " " + am_pm;

		if(format_time.equals(formato_hora[1]))
			return "" + (hr_12<10?"0":"") + hr_12 + ":" + (min<10?"0":"") + min + " " + am_pm;

		if(format_time.equals(formato_hora[2]))
			return "" + hr_12 + ":" + (min<10?"0":"") + min + ":" + (seg<10?"0":"") + seg + " " + am_pm;

		if(format_time.equals(formato_hora[3]))
			return "" + (hr_12<10?"0":"") + hr_12 + ":" + (min<10?"0":"") + min + ":" + (seg<10?"0":"") + seg + " " + am_pm;

		if(format_time.equals(formato_hora[4]))
			return "" + hr_24 + ":" + (min<10?"0":"") + min ;
		
		if(format_time.equals(formato_hora[5]))
			return "" + (hr_24<10?"0":"") + hr_24 + ":" + (min<10?"0":"") + min ;

		if(format_time.equals(formato_hora[6]))
			return "" + hr_24 + ":" + (min<10?"0":"") + min + ":" + (seg<10?"0":"") + seg;

		if(format_time.equals(formato_hora[7]))
			return "" + (hr_24<10?"0":"") + hr_24 + ":" + (min<10?"0":"") + min + ":" + (seg<10?"0":"") + seg;
		
		
		return "" + ahora.getTime();
	}

		
	public String fechaToString(String format_date) {
		if(format_date.equals(formato_fecha[0]))
			return "" + dia + " de " + mes_nombre.toLowerCase() + " de " + año;

		if(format_date.equals(formato_fecha[1]))
			return "" + (dia<10?"0":"")  + dia + " de " + mes_nombre.toLowerCase() + " de " + año;

		if(format_date.equals(formato_fecha[2]))
			return "" + (dia<10?"0":"")  + dia + "/"  + (mes<10?"0":"")  + mes + "/" + año;

		if(format_date.equals(formato_fecha[3]))
			return "" + (dia<10?"0":"")  + dia + "/"  + (mes<10?"0":"")  + mes + "/" + año%100;

		if(format_date.equals(formato_fecha[4]))	// lunes 2 de abril de 2018"
			return dia_nombre.toLowerCase() + " " + dia + " de " + mes_nombre.toLowerCase() + " de " + año;
		
		
		return "" + ahora.get(Calendar.DATE);
	}
	
	
	public String diaSemana() {
		return dia_nombre.toLowerCase();
	}
	
	
	public boolean esFechasMenorA(Fecha fecha2){
		Date fec1 = this.ahora.getTime();
		Date fec2 = fecha2.ahora.getTime();
		return ((long)fec1.getTime() < (long)fec2.getTime());
	}
	
	public int restaFechas_Dias(Fecha fechaFin){
		GregorianCalendar fechaInicio = new GregorianCalendar();
		GregorianCalendar fechaFinal = new GregorianCalendar();
		Date fec1 = this.ahora.getTime();
		Date fec2 = fechaFin.ahora.getTime();
		if((long)fec1.getTime() < (long)fec2.getTime()) {
			fechaInicio.setTime(this.ahora.getTime());
			fechaFinal.setTime(fechaFin.ahora.getTime());			
		}
		else {
			fechaInicio.setTime(fechaFin.ahora.getTime());
			fechaFinal.setTime(this.ahora.getTime());	
		}
		int dias = 0;
		if(fechaFinal.get(Calendar.YEAR) == fechaInicio.get(Calendar.YEAR)){
			dias =(fechaFinal.get(Calendar.DAY_OF_YEAR)- fechaInicio.get(Calendar.DAY_OF_YEAR))+1;
		}
		else {
			int rangoAños = fechaFinal.get(Calendar.YEAR) - fechaInicio.get(Calendar.YEAR);
			for(int i = 0; i <= rangoAños; i++) {
				int diasAño = fechaInicio.isLeapYear(fechaInicio.get(Calendar.YEAR)) ? 366 : 365;
				if(i == 0) {
					dias = 1 + dias +(diasAño - fechaInicio.get(Calendar.DAY_OF_YEAR));
				}
				else if (i == rangoAños) {
					dias = dias + fechaFinal.get(Calendar.DAY_OF_YEAR);
				}
				else {
					dias = dias + diasAño;
				}
			}
		}
		return (dias - 1) * ((long)fec1.getTime() < (long)fec2.getTime() ? 1 : -1);
	}
	
	
	public int restaFechas_Semanas(Fecha fecha2){
		GregorianCalendar fechaInicio = new GregorianCalendar();
		GregorianCalendar fechaFinal = new GregorianCalendar();
		Date fec1 = this.ahora.getTime();
		Date fec2 = fecha2.ahora.getTime();
		if((long)fec1.getTime() < (long)fec2.getTime()) {
			fechaInicio.setTime(this.ahora.getTime());
			fechaFinal.setTime(fecha2.ahora.getTime());			
		}
		else {
			fechaInicio.setTime(fecha2.ahora.getTime());
			fechaFinal.setTime(this.ahora.getTime());	
		}
		int dias = 0;
		if(fechaFinal.get(Calendar.YEAR) == fechaInicio.get(Calendar.YEAR)){
			dias =(fechaFinal.get(Calendar.DAY_OF_YEAR)- fechaInicio.get(Calendar.DAY_OF_YEAR))+1;
		}
		else {
			int rangoAños = fechaFinal.get(Calendar.YEAR) - fechaInicio.get(Calendar.YEAR);
			for(int i = 0; i <= rangoAños; i++) {
				int diasAño = fechaInicio.isLeapYear(fechaInicio.get(Calendar.YEAR)) ? 366 : 365;
				if(i == 0) {
					dias = 1 + dias +(diasAño - fechaInicio.get(Calendar.DAY_OF_YEAR));
				}
				else if (i == rangoAños) {
					dias = dias + fechaFinal.get(Calendar.DAY_OF_YEAR);
				}
				else {
					dias = dias + diasAño;
				}
			}
		}
		return ((dias - 1) / 7) * ((long)fec1.getTime() < (long)fec2.getTime() ? 1 : -1);
	}
	
	public int restaFechas_Meses(Fecha fecha2){
		GregorianCalendar fechaInicio = new GregorianCalendar();
		GregorianCalendar fechaFinal = new GregorianCalendar();
		Date fec1 = this.ahora.getTime();
		Date fec2 = fecha2.ahora.getTime();
		if((long)fec1.getTime() < (long)fec2.getTime()) {
			fechaInicio.setTime(this.ahora.getTime());
			fechaFinal.setTime(fecha2.ahora.getTime());			
		}
		else {
			fechaInicio.setTime(fecha2.ahora.getTime());
			fechaFinal.setTime(this.ahora.getTime());	
		}
		int meses = ((fechaFinal.get(Calendar.YEAR) - fechaInicio.get(Calendar.YEAR)) * 12);
		meses += fechaFinal.get(Calendar.MONTH) - fechaInicio.get(Calendar.MONTH);
		meses += (fechaFinal.get(Calendar.DAY_OF_MONTH) < fechaInicio.get(Calendar.DAY_OF_MONTH) ? -1 : 0);
		return meses * ((long)fec1.getTime() < (long)fec2.getTime() ? 1 : -1);
	}
	
	public int restaFechas_Años(Fecha fecha2){
		GregorianCalendar fechaInicio = new GregorianCalendar();
		GregorianCalendar fechaFinal = new GregorianCalendar();
		Date fec1 = this.ahora.getTime();
		Date fec2 = fecha2.ahora.getTime();
		if((long)fec1.getTime() < (long)fec2.getTime()) {
			fechaInicio.setTime(this.ahora.getTime());
			fechaFinal.setTime(fecha2.ahora.getTime());			
		}
		else {
			fechaInicio.setTime(fecha2.ahora.getTime());
			fechaFinal.setTime(this.ahora.getTime());	
		}
		int años = (fechaFinal.get(Calendar.YEAR) - fechaInicio.get(Calendar.YEAR));
		años += (fechaFinal.get(Calendar.DAY_OF_YEAR) < fechaInicio.get(Calendar.DAY_OF_YEAR) ? -1 : 0);
		return años * ((long)fec1.getTime() < (long)fec2.getTime() ? 1 : -1);
	}
	
}


//Calendar ahoraCal = Calendar.getInstance();
//ahoraCal.set(2018,10,25,14,30,15); // 2018-11-25 14:30:15
//System.out.println(ahoraCal.getTime());
//System.out.println(ahoraCal.get(Calendar.MONTH));

//Date parsed1 = new Date();
//System.out.println(parsed1.toString());
//Calendar hoy = Calendar.getInstance();
//System.out.println(hoy);
//
//SimpleDateFormat format = new SimpleDateFormat("d 'de' MMMMM 'de' yyyy");
//try {
//    Date parsed = format.parse("1 de abril de 2017");
//    System.out.println(parsed.toString());
//}
//catch (ParseException pe) {
//    System.out.println("ERROR: Cannot parse \"" + "1 de abril de 2017" + "\"");
//}
//
//
//SimpleDateFormat format = new SimpleDateFormat("d 'de' MMMMM 'de' yyyy");
//try 
//{
//    Date parsed = format.parse("1 de abril de 2017");
//    System.out.println(parsed.toString());
//}
//catch (ParseException pe) {
//    System.out.println("ERROR: Cannot parse \"" + "1 de abril de 2017" + "\"");
//}
//System.out.println(jenkins.escuchar("@jenkins cuántos días pasaron desde el 1 de abril de 2017?"));
//