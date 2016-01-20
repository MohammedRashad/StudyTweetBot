/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author rashad
 */
public class StudyBot {

    static Thread thread, thread2;
    static OAuth Auth;
    static TwitterFactory tf;
    static Twitter twitter;
    static Random rn;
    static int searchNumber, replyNumber, tweetNumber;
    static Status status;

    public static void main(String[] args) throws TwitterException {

        Auth = new OAuth();
        Auth.authenicate();

        tf = new TwitterFactory(Auth.cb.build());
        twitter = tf.getInstance();

        List<String> searches = new ArrayList<>();
        searches.add(" نفسي اذاكر");
        searches.add("عايز اذاكر ");
        searches.add("اذاكر ");
        searches.add(" مبذاكرش");
        searches.add(" نذاكر");

        List<String> replies = new ArrayList<>();
        replies.add("ذاكر(ي)");
        replies.add("مبتذاكرش ليه؟");
        replies.add("طب خش ذاكر");
        replies.add("انا بقول تخشوا تذاكروا");

        List<String> tweets = new ArrayList<>();
        tweets.add("خش ذاكر");
        tweets.add("مبتذاكرش ليه؟");
        tweets.add("خشوا ذاكروا يا شباب");
        tweets.add("يلا نذاكر");
        tweets.add("نخش نذاكر بقي؟");
        tweets.add("حتي الروبوتس بتذاكر يا جماعه");
        tweets.add("انا بقول تخشوا تذاكروا");

        thread = new Thread() {

            @Override
            public void run() {

                try {

                    rn = new Random();
                    searchNumber = rn.nextInt(5);
                    replyNumber = rn.nextInt(4);

                    //create a new search, chosoe from random searches
                    Query query = new Query(searches.get(searchNumber));
                    //get the results from that search
                    QueryResult result = twitter.search(query);
                    //get the first tweet from those results
                    Status tweetResult = result.getTweets().get(0);
                    //reply to that tweet, choose from random replies
                    StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + replies.get(replyNumber));
                    statusUpdate.inReplyToStatusId(tweetResult.getId());
                    status = twitter.updateStatus(statusUpdate);
                    //print a message so we know when it finishes
                    System.out.println("Done.");
                    //Sleeps A little
                    Thread.sleep(20 * 60 * 1000);

                } catch (TwitterException | InterruptedException ex) {
                }

            }
        };

        thread2 = new Thread() {

            @Override
            public void run() {

                try {

                    rn = new Random();
                    tweetNumber = rn.nextInt(7);
                    //send a tweet
                    status = twitter.updateStatus(tweets.get(tweetNumber));
                    //print a message so we know when it finishes
                    System.out.println("Done here.");
                    //Sleeps A little
                    Thread.sleep(25 * 60 * 1000);

                } catch (InterruptedException | TwitterException ex) {
                }

            }
        };

        thread.start();
        thread2.start();

    }

}
