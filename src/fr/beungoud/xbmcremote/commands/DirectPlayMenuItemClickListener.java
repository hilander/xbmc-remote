/**
 * 
 */
package fr.beungoud.xbmcremote.commands;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import fr.beungoud.xbmcremote.RequestException;
import fr.beungoud.xbmcremote.XbmcRequester;

/**
 * @author Benoit
 *
 */
public class DirectPlayMenuItemClickListener implements
		OnMenuItemClickListener {

	XbmcRequester requester;
	/**
	 * Constructeur par d�faut
	 */
	public DirectPlayMenuItemClickListener( ) {
		this.requester = XbmcRequester.getInstace();
	}
	
	/* (non-Javadoc)
	 * @see android.view.MenuItem.OnMenuItemClickListener#onMenuItemClick(android.view.MenuItem)
	 */
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		Intent intent = item.getIntent();
		exec (intent);
		return true;
	}
	
	public boolean exec(Intent intent)
	{
		String folder = (String)intent.getExtras().get("FOLDER");
		Integer mediaType = (Integer)intent.getExtras().get("MEDIA_TYPE");

		try {
			
			requester.sendCommand("PlayFile(" + folder + ";" + mediaType +")");
		} catch (RequestException e) {
			return false;
		}
		return true;
	}

}
