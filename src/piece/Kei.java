package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Kei extends Base{
	public void gradeup() {
		this.v.clear();
		grade = true;
		this.v = (this.getterStatus())? Vector.setterMove_kin() : Vector.setterMove_kin_enemy();
	}

	void setterMove() {
		this.v = Vector.setterMove_kei();
	}

	void setterMove_enemy() {
		this.v = Vector.setterMove_kei_enemy();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/kei.png");
		this.icon_gradeup = new ImageIcon("./picture/kei_nari.png");
		this.icon_enemy = new ImageIcon("./picture/kei_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/kei_nari_enemy.png");
	}

	public Kei(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.name = "kei";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
