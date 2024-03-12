package pageUIs.users;

public class HomePageUI {
	// Chua nhung locator/ element cua page nay
	// static: co the truy cap truc tiep tu pv Class - chu k can pham vi tu Instance
	// final: ko cho phep ghi de len bien nay nua
	// ngan can viec gan lai thanh 1 element khac 
	// hang so k cho pheo gan lai chinh sua, bat bien
	// ten bien: static + final (Mac dinh day la hang so - constant)
	// In dam + In nghieng
	// Hang so trong java: Bat buoc viet hoa va phan tach boi dau gach duoi (Convention)
	
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String CUSTOMER_LINK = "//a[@class='ico-account']";
}
