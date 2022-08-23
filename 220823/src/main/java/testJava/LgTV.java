package testJava;

public class LgTV {
	// 생성자자에 의한 전달 방법 
	private TV tv;
	public LgTV(TV tv) {
		this.tv = tv;
	}
	public TV getTv() {
		return tv;
	}

	//setter에 의한 주입방법을 하기 위해
	public void setTv(TV tv) {
		this.tv = tv;
	}

}
