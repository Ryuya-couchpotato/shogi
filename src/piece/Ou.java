package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Ou extends Base{
	public void gradeup() {}

	void setterMove() {
		this.v = Vector.setterMove_ou();
	}

	void setterMove_enemy() {
		setterMove();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/gyoku.png");
		this.icon_gradeup = new ImageIcon("./picture/gyoku_nari.png");
		this.icon_enemy = new ImageIcon("./picture/ou_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/ou_nari_enemy.png");
	}

	public Ou(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		
		this.name = "ou";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
