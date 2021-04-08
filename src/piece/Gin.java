package piece;

import javax.swing.ImageIcon;

import tool.Vector;

public class Gin extends Base{
	public void gradeup() {
		this.v.clear();
		grade = true;
		this.v = (this.getterStatus())? Vector.setterMove_kin() : Vector.setterMove_kin_enemy();
	}

	void setterMove() {
		this.v = Vector.setterMove_gin();
	}

	void setterMove_enemy() {
		this.v = Vector.setterMove_gin_enemy();
	}

	void setterImage() {
		this.icon = new ImageIcon("./picture/gin.png");
		this.icon_gradeup = new ImageIcon("./picture/gin_nari.png");
		this.icon_enemy = new ImageIcon("./picture/gin_enemy.png");
		this.icon_enemy_gradeup = new ImageIcon("./picture/gin_nari_enemy.png");
	}

	public Gin(Vector v, boolean mine) {
		this.setterPosition(v);
		this.setterStatus(mine);
		this.setterImage();
		this.setterButton();
		this.name = "gin";
		
		if(mine == true) this.setterMove();
		else this.setterMove_enemy();
	}
}
