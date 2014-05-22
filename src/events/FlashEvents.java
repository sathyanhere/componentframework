package events;

import exception.CFException;

public interface FlashEvents {
	public void flashClick(final String objectId) throws CFException;
	public String getString(final String objectId)throws CFException;
	public void typeString(final String objectId,String string)throws CFException;
}
