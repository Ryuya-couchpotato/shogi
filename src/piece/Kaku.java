package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Kaku extends Base{
	public void setterLine(boolean line) {
		this.line = line;
	}
	
	public void gradeup() {
		this.v.clear();
		grade = true;
		this.v = Vector.setterMove_kaku_nari();
	}

	void setterMove() {
		this.v = Vector.setterMove_kaku();
	}

	void setterMove_enemy() {
		setterMove();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/kaku.png");
		this.icon_gradeup = new ImageIcon("./picture/kaku_nari.png");
		this.icon_enemy = new ImageIcon("./picture/kaku_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/kaku_nari_enemy.png");
	}

	public Kaku(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.line = true;
		this.name = "kaku";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
