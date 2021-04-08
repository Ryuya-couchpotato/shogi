package piece;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import tool.*;

public abstract class Base {
	Vector pos = new Vector();
	ArrayList<Vector> v = new ArrayList<>();
	boolean mine, onBoard = true, grade = false, line = false, gradeup_next = false;
	ImageIcon icon, icon_gradeup, icon_enemy, icon_enemy_gradeup;
	JButton button = new JButton();
	String name;
	
	public void move(Vector v) {
		if(pos.x + v.x < 10 && pos.x + v.x > 0 && pos.y + v.y < 10 && pos.y + v.y > 0) {
			pos.x += v.x;
			pos.y += v.y;
		}
	}
	public void turnToEnemy() {
		if (mine == true) {
			this.mine = false;
			setterMove_enemy();
		} else {
			this.mine = true;
			setterMove();
		}
		setterIcon();
		button.setVisible(false);
		if (name.equals("ou") == false || name.equals("kin") == false)
			grade = false;
		this.onBoard = false;
	}
	public abstract void gradeup();
	
	//////////
	//system
	public ImageIcon getterIcon() { return (this.getterStatus())? this.icon : this.icon_enemy; }
	public ImageIcon getterIcon_gradeup() { return (this.getterStatus())? this.icon_gradeup : this.icon_enemy_gradeup; }
	public JButton getterButton() { return this.button; }
	public String getterName() { return this.name; }
	
	public ArrayList<Vector> getterMove() {
		return v;
	}
	public Vector getterPos() { return this.pos; }
	public boolean getterStatus() { return this.mine; }
	public boolean getterGrade() { return this.grade; }
	public boolean getterLine() { return this.line; }
	public boolean getterOnBoard() { return this.onBoard; }
	public void setterOnBoard(boolean onBoard) { this.onBoard = onBoard; }
	public void setterGradeupNext(boolean gradeup_next) { this.gradeup_next = gradeup_next; }
	public boolean getterGradeupNext() { return this.gradeup_next;}
	
	//////////
	//use in setup
	public boolean setterPosition(Vector v) {
		if(v.x < 10 && v.x > 0 && v.y < 10 && v.y > 0) {
			pos.x = v.x;
			pos.y = v.y;
		}
		return false;
	}
	
	void setterStatus(boolean mine) { this.mine = mine; }
	void setterButton() {
		button.setIcon(getterIcon());
		button.setPreferredSize(new Dimension(50, 50));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}
	void setterIcon() {
		if (this.mine)
			button.setIcon(icon);
		else
			button.setIcon(icon_enemy);
	}
	abstract void setterMove();
	abstract void setterMove_enemy();
	abstract void setterImage();
	//////////
}
