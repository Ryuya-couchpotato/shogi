package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Kin extends Base{
	public void gradeup() {}

	void setterMove() {
		this.v = Vector.setterMove_kin();
	}
	void setterMove_enemy() {
		this.v = Vector.setterMove_kin_enemy();
	}
	
	void setterImage() {
		this.icon = new ImageIcon("./picture/kin.png");
		this.icon_enemy = new ImageIcon("./picture/kin_enemy.png");
	}
	
	public Kin(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		
		this.grade = true;
		this.name = "kin";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
