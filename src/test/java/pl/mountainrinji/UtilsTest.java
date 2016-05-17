package pl.mountainrinji;

public class UtilsTest {

	public static void main(String[] args) {
		System.out.println(Utils.substractTimes("3441:04", "20:02"));
		System.out.println(Utils.substractTimes("03:04", "01:52"));
		System.out.println(Utils.substractTimes("00:44", "00:02"));
		System.out.println(Utils.substractTimes("100:54", "00:57"));
		System.out.println(Utils.substractTimes("03:04", "10:05"));
		
	}

}
