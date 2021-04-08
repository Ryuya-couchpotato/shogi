package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Kyou extends Base{
	public void gradeup() {
		this.v.clear();
		grade = true;
		this.v = (this.getterStatus())? Vector.setterMove_kin() : Vector.setterMove_kin_enemy();
	}

	void setterMove() {
		this.v = Vector.setterMove_kyou();
	}

	void setterMove_enemy() {
		this.v = Vector.setterMove_kyou_enemy();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/kyou.png");
		this.icon_gradeup = new ImageIcon("./picture/kyou_nari.png");
		this.icon_enemy = new ImageIcon("./picture/kyou_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/kyou_nari_enemy.png");
	}

	public Kyou(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.line = true;
		this.name = "kyou";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
