package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
		if (leistung != 0.0) {
			if (spannung != 0.0) {
				getWiderstandFromSpannungUndLeistung(leistung, spannung);
				getStromFromLeistungUndSpannung(leistung, spannung);
			} else if (strom != 0.0) {
				getSpannungFromLeistungUndStrom(leistung, strom);
				getWiderstandFromLeistungUndStrom(leistung, strom);
			} else if (widerstand != 0.0) {
				getSpannungFromLeistungUndWiderstand(leistung, widerstand);
				getStromFromLeistungUndWiderstand(leistung, widerstand);
			}
		} else if (spannung != 0.0) {
			if (leistung != 0.0) {
				getStromFromLeistungUndSpannung(leistung, spannung);
				getWiderstandFromSpannungUndLeistung(spannung, leistung);
			} else if (strom != 0.0) {
				getLeistungFromSpannungUndStrom(spannung, strom);
				getWiderstandFromSpannungUndStrom(spannung, strom);
			} else if (widerstand != 0.0) {
				getLeistungFromSpannungUndWiderstand(spannung, widerstand);
				getStromFromSpannungUndWiderstand(spannung, widerstand);
			}
		} else if (strom != 0.0) {
			if (leistung != 0.0) {
				getSpannungFromLeistungUndStrom(leistung, strom);
				getWiderstandFromLeistungUndStrom(leistung, strom);
			} else if (spannung != 0.0) {
				getLeistungFromSpannungUndStrom(spannung, strom);
				getWiderstandFromSpannungUndStrom(spannung, strom);
			} else if (widerstand != 0.0) {
				getSpannungFromWiderstandUndStrom(widerstand, strom);
				getLeistungWiderstandUndStrom(widerstand, strom);
			}
		} else if (widerstand != 0.0) {
			if (leistung != 0.0) {
				getSpannungFromLeistungUndWiderstand(leistung, widerstand);
				getStromFromLeistungUndWiderstand(leistung, widerstand);
			} else if (spannung != 0.0) {
				getLeistungFromSpannungUndWiderstand(spannung, widerstand);
				getStromFromSpannungUndWiderstand(spannung, widerstand);
			} else if (strom != 0.0) {
				getSpannungFromWiderstandUndStrom(widerstand, strom);
				getLeistungWiderstandUndStrom(widerstand, strom);
			}
		}

	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	public void getLeistungFromSpannungUndWiderstand(double spannung, double widerstand) {
		leistung = Math.pow(spannung, 2) / widerstand;
		System.out.println("leistung: " + leistung + "\n" + "formel: (u*u) / r");
	}
  public void getLeistungFromSpannungUndStrom(double spannung, double strom) {
    leistung = spannung * strom;
    System.out.println("leistung: " + leistung + "\n" + "formel: u * i");
}
	public void getLeistungWiderstandUndStrom(double widerstand, double strom) {
		leistung = Math.pow(strom, 2) * widerstand;
		System.out.println("leistung: " + leistung + "\n" + "formel: r * (i * i)");
	}
  public void getSpannungFromLeistungUndWiderstand(double leistung, double widerstand) {
    spannung = Math.sqrt((leistung * widerstand));
    System.out.println("spannung: " + spannung + "\n" + "formel: (p * r)^(1/2) ");
}
public void getSpannungFromLeistungUndStrom(double leistung, double strom) {
  spannung = leistung / strom;
  System.out.println("spannung: " + spannung + "\n" + "formel: p / i");
}
	public void getSpannungFromWiderstandUndStrom(double widerstand, double strom) {
		spannung = widerstand * strom;
		System.out.println("spannung: " + spannung + "\n" + "formel: r * i");
	}
	public void getStromFromLeistungUndWiderstand(double leistung, double widerstand) {
		strom = Math.sqrt((leistung / widerstand));
		System.out.println("strom: " + strom + "\n" + "formel: (p / r)^(1/2)");
	}
}
