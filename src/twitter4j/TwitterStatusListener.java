package twitter4j;

import java.util.logging.Logger;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

import com.google.gson.Gson;

public class TwitterStatusListener implements StatusListener {
	

	public TwitterStatusListener() {
		super();
	}

	public void onStatus(Status status) {
		Logger.getGlobal().info("New twitter status from " + status.getUser().getName() + " - " + status.getText());
		Gson gson = new Gson();
		Logger.getGlobal().info(gson.toJson(status));
	}

	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		Logger.getGlobal().info("onDeletionNotice: " + statusDeletionNotice);
	}

	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		Logger.getGlobal().info("onTrackLimitationNotice: " + numberOfLimitedStatuses);
	}

	public void onException(Exception ex) {
		ex.printStackTrace();
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		Logger.getGlobal().info("onScrubGeo: " + arg0 + ", " + arg1);

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		Logger.getGlobal().info("onStallWarning: " + arg0.getMessage());
	}

}
