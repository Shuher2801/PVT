/**
 * this program searches in string the paragraphs tags
 * <p>
 * with or without parameters and replace them with simple
 * <p>
 * tags.
 * 
 * @author Ilya
 *
 */
public class FindTeg {

	public static void main(String[] args) {
		String str = "<p id= p1> Newer put of till tomorrow <p>";
		System.out.print(str.replaceAll("<p" + ".*?" + ">", "<p>"));

	}

}
