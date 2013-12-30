package Scroll;

public class TestScroll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PageScroll testScroll = new PageScroll(5);
		testScroll.findPage(2);
		testScroll.nextPage();
		testScroll.prePage();
		testScroll.lastPage();
		testScroll.firstPage();
		PageScroll.freeConnection();
	}

}
