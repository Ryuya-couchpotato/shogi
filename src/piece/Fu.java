package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Fu extends Base {
	void setterMove() {
		this.v = Vector.setterMove_fu();
	}
	void setterMove_enemy() {
		this.v = Vector.setterMove_fu_enemy();
	}
	
	public void gradeup() {
		this.v.clear();
		grade = true;
		if (this.getterStatus()) {
			this.v = Vector.setterMove_kin();
		} else {
			this.v = Vector.setterMove_kin_enemy();
		}
	}
	
	void setterImage() {
		this.icon = new ImageIcon("./picture/fu.png");
		this.icon_gradeup = new ImageIcon("./picture/fu_nari.png");
		this.icon_enemy = new ImageIcon("./picture/fu_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/fu_nari_enemy.png");
	}
	
	public Fu(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.name = "fu";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
