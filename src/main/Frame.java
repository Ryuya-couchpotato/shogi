package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import tool.*;
import piece.*;

public class Frame extends JFrame implements ActionListener {
	JPanel board = new JPanel();
	JPanel stack_enemy = new JPanel();
	JPanel stack_mine = new JPanel();

	SpringLayout layout = new SpringLayout();
	
	boolean turn = true, isChecked = false;
	int[] stack_num = new int[14];
	ArrayList<Vector> v = new ArrayList<>();

	// image import
	//////////
	ImageIcon board_image = new ImageIcon("./picture/board.png");
	ImageIcon stack_mine_image = new ImageIcon("./picture/stack_mine.png");
	ImageIcon stack_enemy_image = new ImageIcon("./picture/stack_enemy.png");
	ImageIcon select_image = new ImageIcon("./picture/selection.png");

	//////////

	// button(piece & selection)
	//////////
	JButton[] select_button = new JButton[81];
	Vector[] select_button_pos = new Vector[81];
	JButton gradeup = new JButton();
	JButton notGradeup = new JButton();
	JButton[] stack_button = new JButton[14];
	int[] stack_buttonNum = new int[14];
	
	//////////
	
	//piece
	//////////
	Ou[] ou = new Ou[2];
	Hisha[] hisha = new Hisha[2];
	Kaku[] kaku = new Kaku[2];
	Kin[] kin = new Kin[4];
	Gin[] gin = new Gin[4];
	Kei[] kei = new Kei[4];
	Kyou[] kyou = new Kyou[4];
	Fu[] fu = new Fu[18];
	
	Base selected, check;
	Base[] stack = new Base[40];
	
	//////////

	Frame() {
		addMouseListener(new myMouseListener());
		setLayout(layout);
		board.setLayout(layout);
		stack_enemy.setLayout(layout);
		stack_mine.setLayout(layout);
		
		board.add(gradeup);
		board.add(notGradeup);

		for(int i = 0; i < select_button.length; i++) {
			select_button[i] = new JButton(select_image);
			select_button[i].setPreferredSize(new Dimension(50, 50));
			select_button[i].setBorderPainted(false);
			select_button[i].setContentAreaFilled(false);
			select_button[i].addActionListener(this);
			select_button[i].setVisible(false);
			select_button[i].setActionCommand("stepB" + i);
			
			board.add(select_button[i]);
			select_button_pos[i] = new Vector();
		}
		
		ou[0] = new Ou(new Vector(5, 9), true);
		setupButton(ou[0].getterButton(), ou[0]);
		ou[0].getterButton().setActionCommand("stepA,ou,0");
		ou[1] = new Ou(new Vector(5, 1), false);
		setupButton(ou[1].getterButton(), ou[1]);
		ou[1].getterButton().setActionCommand("stepA,ou,1");
		
		hisha[0] = new Hisha(new Vector(2, 8), true);
		setupButton(hisha[0].getterButton(), hisha[0]);
		hisha[0].getterButton().setActionCommand("stepA,hisha,0");
		hisha[1] = new Hisha(new Vector(8, 2), false);
		setupButton(hisha[1].getterButton(), hisha[1]);
		hisha[1].getterButton().setActionCommand("stepA,hisha,1");
		
		kaku[0] = new Kaku(new Vector(8, 8), true);
		setupButton(kaku[0].getterButton(), kaku[0]);
		kaku[0].getterButton().setActionCommand("stepA,kaku,0");
		kaku[1] = new Kaku(new Vector(2, 2), false);
		setupButton(kaku[1].getterButton(), kaku[1]);
		kaku[1].getterButton().setActionCommand("stepA,kaku,1");
		
		for(int i = 0; i < kin.length; i++) {
			kin[i] = new Kin(new Vector((i%2==0)?6:4, (i<2)?9:1), (i<2)? true:false);
			setupButton(kin[i].getterButton(), kin[i]);
			kin[i].getterButton().setActionCommand("stepA,kin," + i);
		}
		
		for(int i = 0; i < gin.length; i++) {
			gin[i] = new Gin(new Vector((i%2==0)?7:3, (i<2)?9:1), (i<2)? true:false);
			setupButton(gin[i].getterButton(), gin[i]);
			gin[i].getterButton().setActionCommand("stepA,gin," + i);
		}
		
		for(int i = 0; i < kei.length; i++) {
			kei[i] = new Kei(new Vector((i%2==0)?8:2, (i<2)?9:1), (i<2)? true:false);
			setupButton(kei[i].getterButton(), kei[i]);
			kei[i].getterButton().setActionCommand("stepA,kei," + i);
		}
		
		for(int i = 0; i < kyou.length; i++) {
			kyou[i] = new Kyou(new Vector((i%2==0)?9:1, (i<2)?9:1), (i<2)? true:false);
			setupButton(kyou[i].getterButton(), kyou[i]);
			kyou[i].getterButton().setActionCommand("stepA,kyou," + i);
		}

		for(int i = 0; i < fu.length/2; i++) {
			fu[i] = new Fu(new Vector(i+1, 7), true);
			setupButton(fu[i].getterButton(), fu[i]);
			fu[i].getterButton().setActionCommand("stepA,fu," + i);
		}
		for(int i = 9; i < fu.length; i++) {
			fu[i] = new Fu(new Vector(i-8, 3), false);
			setupButton(fu[i].getterButton(), fu[i]);
			fu[i].getterButton().setActionCommand("stepA,fu," + i);
		}
		
		for(int i = 0; i < 40; i ++) {
			if (i < 2)
				stack[i] = ou[i];
			else if (i < 4)
				stack[i] = hisha[i-2];
			else if (i < 6)
				stack[i] = kaku[i-4];
			else if (i < 10)
				stack[i] = kin[i-6];
			else if (i < 14)
				stack[i] = gin[i-10];
			else if (i < 18)
				stack[i] = kei[i-14];
			else if (i < 22)
				stack[i] = kyou[i-18];
			else if (i < 40)
				stack[i] = fu[i-22];
			board.add(stack[i].getterButton());
		}
		
		for(int i = 0; i < stack_button.length; i++) {
			stack_button[i] = new JButton();
			stack_buttonNum[i] = 0;
		}
		
		stack_button[0].setIcon(new ImageIcon("./picture/hisha.png"));
		stack_button[1].setIcon(new ImageIcon("./picture/kaku.png"));
		stack_button[2].setIcon(new ImageIcon("./picture/kin.png"));
		stack_button[3].setIcon(new ImageIcon("./picture/gin.png"));
		stack_button[4].setIcon(new ImageIcon("./picture/kei.png"));
		stack_button[5].setIcon(new ImageIcon("./picture/kyou.png"));
		stack_button[6].setIcon(new ImageIcon("./picture/fu.png"));
		stack_button[7].setIcon(new ImageIcon("./picture/hisha_enemy.png"));
		stack_button[8].setIcon(new ImageIcon("./picture/kaku_enemy.png"));
		stack_button[9].setIcon(new ImageIcon("./picture/kin_enemy.png"));
		stack_button[10].setIcon(new ImageIcon("./picture/gin_enemy.png"));
		stack_button[11].setIcon(new ImageIcon("./picture/kei_enemy.png"));
		stack_button[12].setIcon(new ImageIcon("./picture/kyou_enemy.png"));
		stack_button[13].setIcon(new ImageIcon("./picture/fu_enemy.png"));
		
		for(int i = 0; i < stack_button.length/2; i++) {
			setupButton_stack(stack_button[i], i*65, true, "stack," + i, i);
			stack_mine.add(stack_button[i]);
		}
		for(int i = 7; i < stack_button.length; i++) {
			setupButton_stack(stack_button[i], (i-7)*65, false, "stack," + i, i);
			stack_enemy.add(stack_button[i]);
		}

		layout.putConstraint(SpringLayout.NORTH, stack_enemy, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, stack_enemy, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, stack_enemy, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, stack_enemy, 500, SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH, board, 0, SpringLayout.SOUTH, stack_enemy);
		layout.putConstraint(SpringLayout.WEST, board, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, board, 511, SpringLayout.SOUTH, stack_enemy);
		layout.putConstraint(SpringLayout.EAST, board, 0, SpringLayout.EAST, stack_enemy);

		layout.putConstraint(SpringLayout.NORTH, stack_mine, 0, SpringLayout.SOUTH, board);
		layout.putConstraint(SpringLayout.WEST, stack_mine, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, stack_mine, 50, SpringLayout.SOUTH, board);
		layout.putConstraint(SpringLayout.EAST, stack_mine, 0, SpringLayout.EAST, stack_enemy);
		
		JLabel label = new JLabel();
		label.setIcon(board_image);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.TOP);
		layout.putConstraint(SpringLayout.NORTH, label, -52, SpringLayout.NORTH, board);
		layout.putConstraint(SpringLayout.WEST, label, -2, SpringLayout.WEST, board);
		
		JLabel label_stack_mine = new JLabel();
		label_stack_mine.setIcon(stack_mine_image);
		label_stack_mine.setHorizontalAlignment(JLabel.LEFT);
		label_stack_mine.setVerticalAlignment(JLabel.TOP);
		
		JLabel label_stack_enemy = new JLabel();
		label_stack_enemy.setIcon(stack_enemy_image);
		label_stack_enemy.setHorizontalAlignment(JLabel.LEFT);
		label_stack_enemy.setVerticalAlignment(JLabel.TOP);
		
		
		gradeup.addActionListener(this);
		gradeup.setActionCommand("gradeup");
		gradeup.setPreferredSize(new Dimension(50, 50));
		gradeup.setVisible(false);
		notGradeup.setPreferredSize(new Dimension(50, 50));
		notGradeup.addActionListener(this);
		notGradeup.setActionCommand("notgradeup");
		notGradeup.setVisible(false);

		board.add(label);
		stack_mine.add(label_stack_mine);
		stack_enemy.add(label_stack_enemy);

		getContentPane().add(board);
		getContentPane().add(stack_enemy);
		getContentPane().add(stack_mine);
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();

		//stepA: 駒をクリック時実行。移動可能マスを表示。stepA,fu(kin, gin...),i(0~) 
		if(com.contains("stepA")) {
			int num = Integer.parseInt(com.split(",")[2]);
			if(selected != null) {
				for(int i = 0; i < select_button.length; i++) {
					select_button[i].setVisible(false);
				}
			}
			
			if(com.contains("fu")) {
				selected = fu[num];
			}else if(com.contains("hisha")) {
				selected = hisha[num];
			}else if(com.contains("kaku")) {
				selected = kaku[num];
			}else if(com.contains("kin")) {
				selected = kin[num];
			}else if(com.contains("gin")) {
				selected = gin[num];
			}else if(com.contains("kei")) {
				selected = kei[num];
			}else if(com.contains("kyou")) {
				selected = kyou[num];
			}else if(com.contains("ou")) {
				selected = ou[num];
			}
			
			if (turn == selected.getterStatus()) {
				Vector vec;
				boolean avoidCheck = true;//(isChecked)?false:true;
				
				for (int i = 0; i < selected.getterMove().size(); i++) {
					vec = new Vector(selected.getterMove().get(i).x + selected.getterPos().x,
							selected.getterMove().get(i).y + selected.getterPos().y);
					
					if(isChecked) {
						//王手を遮る
						Vector stay = new Vector(selected.getterPos().x, selected.getterPos().y);
						selected.setterPosition(vec);
						avoidCheck = (isCheck())?false:true;
						selected.setterPosition(stay);
						//王手している駒をとる
						if(vec.x == check.getterPos().x && vec.y == check.getterPos().y)
							avoidCheck = true;
					}
					
					//そのマスに他の駒があるか
					if (searchPiece(vec) && searchPiece_enemy(vec) && inLange(vec) && avoidCheck == true
							|| searchPiece(vec) && inLange(vec) && selected.getterLine() == false && avoidCheck == true) {
						select_button[i].setVisible(true);
						select_button_pos[i].x = vec.x;
						select_button_pos[i].y = vec.y;
						
						layout.putConstraint(SpringLayout.NORTH, select_button[i],
								TranslatePosition.getterY(selected.getterPos().y + selected.getterMove().get(i).y),
								SpringLayout.NORTH, board);
						layout.putConstraint(SpringLayout.WEST, select_button[i],
								TranslatePosition.getterX(selected.getterPos().x + selected.getterMove().get(i).x),
								SpringLayout.WEST, board);
					}
					//飛角香が対象。駒を飛び越せない。
					else if (searchPiece_enemy(vec) == false && inLange(vec) && selected.getterLine() && avoidCheck == true) {
						select_button[i].setVisible(true);
						select_button_pos[i].x = vec.x;
						select_button_pos[i].y = vec.y;
						layout.putConstraint(SpringLayout.NORTH, select_button[i],
								TranslatePosition.getterY(selected.getterPos().y + selected.getterMove().get(i).y),
								SpringLayout.NORTH, board);
						layout.putConstraint(SpringLayout.WEST, select_button[i],
								TranslatePosition.getterX(selected.getterPos().x + selected.getterMove().get(i).x),
								SpringLayout.WEST, board);
						if (i < 32)
							i = (i / 8) * 8 + 7;
					} else if (selected.getterLine() && i < 32 && avoidCheck == true) {
						i = (i / 8) * 8 + 7;
					}
				}
			}
		}
		//step2:移動可能マスをクリック時実行。選択済みの駒を移動。
		else if(com.contains("stepB")) {
			int select_num = Integer.parseInt(com.substring(5, com.length()));
			for(int i = 0; i < select_button.length; i++) {
				select_button[i].setVisible(false);
			}
			selected.setterPosition(select_button_pos[select_num]);
			
			selected.getterButton().setVisible(true);
			if(selected.getterOnBoard() == false) {
				int stack_buttonNumber = (selected.getterStatus())? 0 : 7;
				switch(selected.getterName()){
				case "hisha": break;
				case "kaku":stack_buttonNumber += 1; break;
				case "kin":stack_buttonNumber += 2; break;
				case "gin":stack_buttonNumber += 3; break;
				case "kei":stack_buttonNumber += 4; break;
				case "kyou":stack_buttonNumber += 5; break;
				case "fu":stack_buttonNumber += 6; break;
				}
				
				stack_buttonNum[stack_buttonNumber]--;
				if(stack_buttonNum[stack_buttonNumber] > 1)
					stack_button[stack_buttonNumber].setText("" + stack_buttonNum[stack_buttonNumber]);
				else if(stack_buttonNum[stack_buttonNumber] == 1)
					stack_button[stack_buttonNumber].setText("");
				else
					stack_button[stack_buttonNumber].setVisible(false);
			}
			boolean gradeup = Gradeup.check(selected);
			
			//駒取り判定
			for(int i = 0; i < stack.length; i++) {
				if(stack[i].getterPos().x == selected.getterPos().x && stack[i].getterPos().y == selected.getterPos().y && stack[i].getterStatus() != selected.getterStatus() && stack[i].getterOnBoard() == true) {
					/*if(i == 0) {
						JLabel label = new JLabel("you lose");
					    label.setForeground(Color.RED);
					    JOptionPane.showMessageDialog(this, label);
					}else if(i == 1) {
						JLabel label = new JLabel("you win");
					    label.setForeground(Color.RED);
					    JOptionPane.showMessageDialog(this, label);
					}*/
					
					stack[i].turnToEnemy();
					int stack_buttonNumber = (stack[i].getterStatus())? 0 : 7;
					
					switch(stack[i].getterName()){
					case "hisha": break;
					case "kaku":stack_buttonNumber += 1; break;
					case "kin":stack_buttonNumber += 2; break;
					case "gin":stack_buttonNumber += 3; break;
					case "kei":stack_buttonNumber += 4; break;
					case "kyou":stack_buttonNumber += 5; break;
					case "fu":stack_buttonNumber += 6; break;
					}
					stack_button[stack_buttonNumber].setVisible(true);
					stack_buttonNum[stack_buttonNumber]++;
					if(stack_buttonNum[stack_buttonNumber] > 1)
						stack_button[stack_buttonNumber].setText("" + stack_buttonNum[stack_buttonNumber]);
					break;
					
				}
			}
			
			if (gradeup || selected.getterGradeupNext()) {
				pieceButtonStatus(false);
				this.gradeup.setIcon(selected.getterIcon_gradeup());
				notGradeup.setIcon(selected.getterIcon());
				this.gradeup.setVisible(true);
				notGradeup.setVisible(true);
				layout.putConstraint(SpringLayout.NORTH, this.gradeup, 5, SpringLayout.SOUTH, selected.getterButton());
				layout.putConstraint(SpringLayout.WEST, this.gradeup, -26, SpringLayout.WEST, selected.getterButton());
				layout.putConstraint(SpringLayout.NORTH, notGradeup, 5, SpringLayout.SOUTH, selected.getterButton());
				layout.putConstraint(SpringLayout.WEST, notGradeup, 26, SpringLayout.WEST, selected.getterButton());
			}
			
			
			if(selected.getterOnBoard() == false) {
				if (selected.getterStatus() && selected.getterPos().y <= 3 || selected.getterStatus() == false && selected.getterPos().y >= 7)
					selected.setterGradeupNext(true);
			}
			selected.setterOnBoard(true);
			isChecked = isCheck();
			
			layout.putConstraint(SpringLayout.NORTH, selected.getterButton(), TranslatePosition.getterY(selected.getterPos().y), SpringLayout.NORTH, board);
			layout.putConstraint(SpringLayout.WEST, selected.getterButton(), TranslatePosition.getterX(selected.getterPos().x), SpringLayout.WEST, board);
			
			turn = (turn == true) ? false : true;
			
		}else if(com.equals("gradeup")) {
			selected.gradeup();
			selected.getterButton().setIcon(selected.getterIcon_gradeup());
			gradeup.setVisible(false);
			notGradeup.setVisible(false);
			pieceButtonStatus(true);
			isChecked = isCheck();
		}else if(com.equals("notgradeup")) {
			gradeup.setVisible(false);
			notGradeup.setVisible(false);
			pieceButtonStatus(true);
		}else if(com.contains("stack")) {
			for(int i = 0; i < select_button.length; i++)
				select_button[i].setVisible(false);
			int num = Integer.parseInt(com.split(",")[1]), stack_num = -1;
			boolean status = false, isPiece = false, avoidCheck = true;
			
			switch(num){
			case 0:status = true; case 7:stack_num = searchStack(stack, 2, 4, status); break;
			
			case 1:status = true; case 8:stack_num = searchStack(stack, 4, 6, status);break;
			
			case 2:status = true; case 9:stack_num = searchStack(stack, 6, 10, status);break;
			
			case 3:status = true; case 10:stack_num = searchStack(stack, 10, 14, status);break;
			
			case 4:status = true; case 11:stack_num = searchStack(stack, 14, 18, status);break;
			
			case 5:status = true; case 12:stack_num = searchStack(stack, 18, 22, status);break;
			
			case 6:status = true; case 13:stack_num = searchStack(stack, 22, 40, status);break;
			}
			
			if(stack_num != -1) selected = stack[stack_num];

			int x = 0, X = 9, y = 0, Y = 9;
			if(14 <= stack_num && stack_num < 18) {
				if(status) y = 2;
				else Y = 7;
			}else if(18 <= stack_num) {
				if(status) y = 1;
				else Y = 8;
			}
			
			if (turn == selected.getterStatus()) {
				for (int i = x; i < X; i++) {
					if(stack_num >= 22) {
						for(int j = 22; j < stack.length; j++) {
							if(stack[j].getterStatus() == selected.getterStatus() && stack[j].getterPos().x == i+1 && stack[j].getterOnBoard()) {
								isPiece = true;
								break;
							}
						}
					}
					if (isPiece == false) {
						for (int j = y; j < Y; j++) {
							Vector vec = new Vector(i, j);

							for (int k = 0; k < stack.length; k++) {
								if (vec.x + 1 == stack[k].getterPos().x && vec.y + 1 == stack[k].getterPos().y
										&& stack[k].getterOnBoard()) {
									isPiece = true;
									break;
								}
							}
							
							if(isChecked) {
								selected.setterOnBoard(true);
								selected.setterPosition(new Vector(i+1, j+1));
								avoidCheck = (isCheck())?false:true;
								selected.setterOnBoard(false);
							}

							if (isPiece == false && avoidCheck) {
								select_button[i * 9 + j].setVisible(true);
								select_button_pos[i * 9 + j] = new Vector(i + 1, j + 1);
								layout.putConstraint(SpringLayout.NORTH, select_button[i * 9 + j],
										TranslatePosition.getterY(vec.y + 1), SpringLayout.NORTH, board);
								layout.putConstraint(SpringLayout.WEST, select_button[i * 9 + j],
										TranslatePosition.getterX(vec.x + 1), SpringLayout.WEST, board);
							}
							isPiece = false;
						}
					}
					isPiece = false;
				}
			}
		}
		
		layout.putConstraint(SpringLayout.NORTH, board, 0, SpringLayout.SOUTH, stack_enemy);
		layout.putConstraint(SpringLayout.NORTH, stack_enemy, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, stack_mine, 0, SpringLayout.SOUTH, board);
	}
	
	private void setupButton(JButton button, Base base) {
		button.addActionListener(this);
		layout.putConstraint(SpringLayout.NORTH, button, TranslatePosition.getterY(base.getterPos().y), SpringLayout.NORTH, board);
		layout.putConstraint(SpringLayout.WEST, button, TranslatePosition.getterX(base.getterPos().x), SpringLayout.WEST, board);
	}
	
	private void setupButton_stack(JButton button, int x, boolean mine, String command, int i) {
		button.setPreferredSize(new Dimension(95, 50));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		button.setActionCommand(command);
		button.setText(" ");
		
		button.setVisible(false);
		
		if(mine) {
			layout.putConstraint(SpringLayout.WEST, button, x, SpringLayout.WEST, stack_mine);
		}else {
			layout.putConstraint(SpringLayout.WEST, button, x, SpringLayout.WEST, stack_enemy);
		}
	}
	
	private boolean searchPiece(Vector pos) {
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].getterPos().x == pos.x && stack[i].getterPos().y == pos.y && stack[i].getterStatus() == selected.getterStatus() && stack[i].getterOnBoard())
				return false;
		}
		return true;
	}
	
	private boolean searchPiece_enemy(Vector pos) {
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].getterPos().x == pos.x && stack[i].getterPos().y == pos.y && stack[i].getterStatus() != selected.getterStatus() && stack[i].getterOnBoard())
				return false;
		}
		return true;
	}
	
	private boolean inLange(Vector pos) {
		if(pos.x < 10 && pos.x > 0 && pos.y < 10 && pos.y > 0)
			return true;
		return false;
	}
	
	private void pieceButtonStatus(boolean enable) {
		for(int i = 0; i < stack.length; i++) {
			stack[i].getterButton().setEnabled(enable);
		}
	}
	
	private int searchStack(Base[] base, int start, int end, boolean status) {
		for(int i = start; i < end; i++) {
			if(stack[i].getterOnBoard() == false && stack[i].getterStatus() == status) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean isCheck(){
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < stack.length; k++) {
				for (int i = 0; i < stack[k].getterMove().size(); i++) {
					
					if(stack[k].getterOnBoard() == false) break;
					Vector vec = new Vector(stack[k].getterMove().get(i).x + stack[k].getterPos().x,
							stack[k].getterMove().get(i).y + stack[k].getterPos().y);

					if (stack[k].getterLine() == false) {
						if (vec.x == ou[j].getterPos().x && vec.y == ou[j].getterPos().y
								&& stack[k].getterStatus() != ou[j].getterStatus()) {
							this.check = stack[k];
							return true;
						}
					} else {
						if (vec.x == ou[j].getterPos().x && vec.y == ou[j].getterPos().y
								&& stack[k].getterStatus() != ou[j].getterStatus() && stack[k].getterOnBoard()) {
							this.check = stack[k];
							return true;
						} else if (searchPiece(vec) == false && i < 32 || searchPiece_enemy(vec) == false && i < 32) {
							i = (i / 8) * 8 + 7;
						}
					}
					
				}
			}
		}
		return false;
	}
	public class myMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i < select_button.length; i++) {
				select_button[i].setVisible(false);
			}
			layout.putConstraint(SpringLayout.NORTH, board, 0, SpringLayout.SOUTH, stack_enemy);
		}
	}
}
