package tool;

import java.util.ArrayList;

public class Vector {
	public int x, y;
	
	public static ArrayList<Vector> setterMove_ou(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, -1);		v.add(vec);
		vec = new Vector(0, -1);		v.add(vec);
		vec = new Vector(-1, -1);	v.add(vec);
		vec = new Vector(1, 0);		v.add(vec);
		vec = new Vector(-1, 0);		v.add(vec);
		vec = new Vector(1, 1);		v.add(vec);
		vec = new Vector(0, 1);		v.add(vec);
		vec = new Vector(-1, 1);		v.add(vec);
		return v;
	}
	public static ArrayList<Vector> setterMove_hisha(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		
		for(int i = 1; i < 9; i++) {
			vec = new Vector(0, i); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(0, -i); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(i, 0); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(-i, 0); v.add(vec);
		}
		return v;
	}
	public static ArrayList<Vector> setterMove_kaku(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		
		for(int i = 1; i < 9; i++) {
			vec = new Vector(i, i); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(i, -i); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(-i, i); v.add(vec);
		}
		for(int i = 1; i < 9; i++) {
			vec = new Vector(-i, -i); v.add(vec);
		}
		return v;
	}
	public static ArrayList<Vector> setterMove_kin(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, -1);		v.add(vec);
		vec = new Vector(0, -1);		v.add(vec);
		vec = new Vector(-1, -1);	v.add(vec);
		vec = new Vector(1, 0);		v.add(vec);
		vec = new Vector(-1, 0);		v.add(vec);
		vec = new Vector(0, 1);		v.add(vec);
		
		//////////
		//111
		//1p1
		//010
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_gin(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, -1);		v.add(vec);
		vec = new Vector(0, -1);		v.add(vec);
		vec = new Vector(-1, -1);	v.add(vec);
		vec = new Vector(1, 1);		v.add(vec);
		vec = new Vector(-1, 1);		v.add(vec);
		
		//////////
		//111
		//0p0
		//101
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_kei(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, -2);		v.add(vec);
		vec = new Vector(-1, -2);		v.add(vec);
		
		//////////
		//101
		//000
		//0p0
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_kyou(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		
		for(int i = 1; i < 9; i++) {
			vec = new Vector(0, -i);
			v.add(vec);
		}
		
		//////////
		//010
		//010
		//0p0
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_fu() {
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec = new Vector(0, -1);	v.add(vec);
		
		return v;
	}

	public static ArrayList<Vector> setterMove_hisha_nari() {
		ArrayList<Vector> v = new ArrayList<Vector>();
		v = setterMove_hisha();
		Vector vec;
		vec = new Vector(1, -1);		v.add(vec);
		vec = new Vector(-1, -1);	v.add(vec);
		vec = new Vector(1, 1);		v.add(vec);
		vec = new Vector(-1, 1);		v.add(vec);

		//////////
		// 101
		// 0p0
		// 101
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_kaku_nari(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		v = setterMove_kaku();
		Vector vec;
		vec = new Vector(0, -1);		v.add(vec);
		vec = new Vector(1, 0);		v.add(vec);
		vec = new Vector(-1, 0);		v.add(vec);
		vec = new Vector(0, 1);		v.add(vec);
		
		//////////
		//010
		//1p1
		//010
		//////////
		return v;
	}
	/////////////////////////////////////////////////////////////////////
	public static ArrayList<Vector> setterMove_kin_enemy(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(0, -1);		v.add(vec);
		vec = new Vector(1, 0);		v.add(vec);
		vec = new Vector(-1, 0);		v.add(vec);
		vec = new Vector(1, 1);		v.add(vec);
		vec = new Vector(0, 1);		v.add(vec);
		vec = new Vector(-1, 1);		v.add(vec);
		
		//////////
		//010
		//1p1
		//111
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_gin_enemy(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, -1);		v.add(vec);
		vec = new Vector(-1, -1);		v.add(vec);
		vec = new Vector(1, 1);		v.add(vec);
		vec = new Vector(0, 1);		v.add(vec);
		vec = new Vector(-1, 1);		v.add(vec);
		
		//////////
		//101
		//0p0
		//111
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_kei_enemy(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		vec = new Vector(1, 2);		v.add(vec);
		vec = new Vector(-1, 2);		v.add(vec);
		
		//////////
		//0p0
		//000
		//101
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_kyou_enemy(){
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec;
		
		for(int i = 1; i < 9; i++) {
			vec = new Vector(0, i);
			v.add(vec);
		}
		
		//////////
		//0p0
		//010
		//010
		//////////
		return v;
	}
	public static ArrayList<Vector> setterMove_fu_enemy() {
		ArrayList<Vector> v = new ArrayList<Vector>();
		Vector vec = new Vector(0, 1);
		v.add(vec);

		return v;
	}
		
	public Vector(){}
	public Vector(int x, int y){ this.x = x; this.y = y; }
}
