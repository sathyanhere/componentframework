import org.testng.annotations.Test;

import utils.ReportBackUp;

public class Report {
	@Test
	public void genReport() throws Exception{
		ReportBackUp.takeBackUp();
	}
}
