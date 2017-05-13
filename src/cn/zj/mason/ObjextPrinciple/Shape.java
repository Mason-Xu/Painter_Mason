package cn.zj.mason.ObjextPrinciple;

public abstract class Shape implements Drawing, Moving {
	// 位置
	int x, y;
	// 高度。宽度
	double width, height;
	// 工具栏里选了那个图形
	int shapetype;
	// 图的名字
	String shapename;

	public void setShape(int x, int y, double width, double height, int shapetype, String shapename) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.shapetype = shapetype;
		this.shapename = shapename;
	}

	@Override
	public void move(int x, int y) {
		this.x = x;
		this.y = y;

	}

	@Override
	public String toString() {
		return shapename;
	}

}
