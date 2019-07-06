package sagar;

public class AmazonLoginPage extends AmazonBasePage {

	private String accountListlink = "//*[@id=\"nav-link-accountList\"]";

	private String signInLink = "//*[@id=\"nav-link-accountList\"]/span[3]";

	public void openPage(String url) {
		openUrl(url, "https://www.amazon.in/");
	}

	public void clickOnSignInlink() {
		mouseHover("signInLink");
		click(accountListlink, "accountListlink");
	}

}
