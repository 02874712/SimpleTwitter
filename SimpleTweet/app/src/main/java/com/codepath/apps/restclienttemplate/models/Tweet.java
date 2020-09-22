package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.codepath.apps.restclienttemplate.TimeFormatter.getTimeDifference;
import static com.codepath.apps.restclienttemplate.TimeFormatter.getTimeStamp;

public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    /*In the Tweet model, maybe you’d add a method called getFormattedTimestamp which returns the correct time for the tweet returning TimeFormatter.getTimeDifference(createdAt) with createdAt being the actual date string pulled from the JSON for the tweet (created_at field)
Once you have your timestamp view setup, in the onBindViewHolder method in the RecyclerView, you’d set the getFormattedTimestamp into that new timestamp view (.setText) by using that value to display the correct time for each tweet populated by the adapter. For example, tvTimestamp.setText(tweet.getFormattedTimestamp()) */

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

  /* public static String getFormattedTimestamp(String jsonObject) {
        final Tweet tweet = new Tweet();
        tweet.createdAt = getTimeDifference(tweet.createdAt) + getTimeStamp(tweet.createdAt);
        return tweet.createdAt;
    }
*/
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets= new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}
