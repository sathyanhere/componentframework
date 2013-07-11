package utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProfileUtils {
	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		/*Proxy proxy = new Proxy();
		proxy.setHttpProxy(PROXY);
		proxy.setFtpProxy(PROXY);
		proxy.setSslProxy(PROXY);*/
//		cap.setCapability(CapabilityType.PROXY, proxy);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.http.phishy-userpass-length", 255);
		profile.setAssumeUntrustedCertificateIssuer(false);
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		return cap;
	}
}
