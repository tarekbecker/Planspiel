package Server;



/**
 * Dieser Typ gibt den Marktanteil (in 100% ( d.h. ein Monopol sind 10000 !)) einer Firma an
 * 
 * @author Tarek
 * 
 */
// TODO: ist jetz ein Typ :D
public class TMarketShare {

	private Company	c;
	private int		marketShare;

	/**
	 * Konstruktor f�r Marketshare
	 * 
	 * @param c
	 *            Die Firma f�r den dieser Marktanteil gilt
	 * @param marketShare
	 *            der Marktanteil in ganze Prozent
	 */
	public TMarketShare(Company c, int marketShare) {
		if (!checkMarketShare(marketShare)) {
			throw new IllegalArgumentException("Marktanteil ist ung�ltig: '" + marketShare + "'");
		}
		if (c == null) {
			throw new IllegalArgumentException("Company-Referenz darf nicht auf NULL zeigen!");
		}
		this.c = c;
		this.marketShare = marketShare;
	}

	/**
	 * 
	 * @return liefert die Firma des Marktanteils zur�ck
	 */
	public Company getCompany() {
		return c;
	}

	/**
	 * 
	 * @return liefert den Marktanteil der Firma in ganzen Prozent zur�ck
	 */
	public int getMarketShare() {
		return marketShare;
	}

	/**
	 * �berpr�ft einen Marktanteil auf g�ltig
	 * 
	 * @param marketShare
	 *            Marktanteil
	 * @return true: g�ltig false: ung�ltig
	 */
	private boolean checkMarketShare(int marketShare) {
		// Marktanteil mit dem Interval [0;10000]
		return (marketShare >= 0 && marketShare <= 10000);
	}
}