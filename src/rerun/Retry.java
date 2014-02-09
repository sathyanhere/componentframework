package rerun;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

import pages.WebPage;

public class Retry extends RetryAnalyzerCount {
    private int count = 0;
    private final int MAX_COUNT = WebPage.retryCount;
    
    public Retry() {
        setCount(MAX_COUNT);
    }

    @Override
    public boolean retryMethod(ITestResult result) {
        if (count < MAX_COUNT) {
        	System.out.println("Retrying " + result.getName()+" " + count + " times");
            count += 1;
            return true;
        }
        return false;
    }
}
