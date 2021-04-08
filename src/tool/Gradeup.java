package tool;

import piece.*;

public class Gradeup {
	public static boolean check(Base base) {
		if (base.getterGrade() == true || base.getterOnBoard() == false)
			return false;
		if (base.getterStatus() && base.getterPos().y <= 3 || base.getterStatus() == false && base.getterPos().y >= 7)
			return true;
		return false;
	}
}
