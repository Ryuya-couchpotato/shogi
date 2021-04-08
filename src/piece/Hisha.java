package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Hisha extends Base{
	public void setterLine(boolean line) {
		this.line = line;
	}
	
	public void gradeup() {
		this.v.clear();
		grade = true;
		this.v = Vector.setterMove_hisha_nari();
	}

	void setterMove() {
		this.v = Vector.setterMove_hisha();
	}

	void setterMove_enemy() {
		setterMove();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/hisha.png");
		this.icon_gradeup = new ImageIcon("./picture/hisha_nari.png");
		this.icon_enemy = new ImageIcon("./picture/hisha_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/hisha_nari_enemy.png");
	}

	public Hisha(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.line = true;
		this.name = "hisha";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
