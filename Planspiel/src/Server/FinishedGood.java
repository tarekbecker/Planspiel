package Server;

public class FinishedGood extends Product {
	/**
	 * Semantischer Konstruktor: Liefert ein neues FinishedGood zur�ck, falls
	 * die Eingaben valide waren. Sonst null.
	 * 
	 * @param quality
	 * @param costs
	 * @param name
	 * @return
	 */
	public static FinishedGood create(int quality, int costs) {
		String name = "Panel";
		try {
			FinishedGood finishedGood = new FinishedGood(quality, name, costs);
			return finishedGood;
		} catch (Exception e) {
			return null; // Kosten oder Qualit�t ist nicht valide.
		}

	}

	/**
	 * privater Konstruktor, der den Oberklassenteilkonstruktor von Product
	 * aufruft.
	 * 
	 * @param quality
	 * @param name
	 * @param costs
	 * @throws Exception
	 */
	private FinishedGood(int quality, String name, int costs) throws Exception {
		super(quality, name, costs);

	}

}