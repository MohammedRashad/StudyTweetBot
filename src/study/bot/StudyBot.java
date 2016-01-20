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

    static Thread thread;
    static OAuth Auth;
    static TwitterFactory tf;
    static Twitter twitter;
    static Random rn;
    static int searchNumber, replyNumber, tweetNumber;
    static Status status, status2;

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
        searches.add(" هسقط");

        List<String> replies = new ArrayList<>();
        replies.add("ذاكر(ي)");
        replies.add("مبتذاكرش ليه؟");
        replies.add("طب خش ذاكر");
        replies.add("انا بقول تخشوا تذاكروا");
        replies.add("نخش نذاكر بقي؟");
        replies.add("الفاينال لا يرحم");
        replies.add("خش ذاكر");

        List<String> tweets = new ArrayList<>();
        tweets.add("خش ذاكر");
        tweets.add("مبتذاكرش ليه؟");
        tweets.add("خشوا ذاكروا يا شباب");
        tweets.add("يلا نذاكر");
        tweets.add("نخش نذاكر بقي؟");
        tweets.add("حتي الروبوتس بتذاكر يا جماعه");
        tweets.add("انا بقول تخشوا تذاكروا");
        tweets.add("خشوا ذاكروا");
        tweets.add("مبتذاكروش ليه؟");
        tweets.add("خشوا ذاكروا يا علوق");
        tweets.add(" هوبا يلا نذاكر");
        tweets.add("نخش نذاكر بقي ولا ايه؟");
        tweets.add("الفاينال لا يرحم");
        tweets.add("انا بقول تخشوا تذاكروا احسن ");

        thread = new Thread() {

            @Override
            public void run() {

                try {

                    while (true) {

                        rn = new Random();
                        searchNumber = rn.nextInt(6);
                        replyNumber = rn.nextInt(7);

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
                        System.out.println("Done in thread 1...");
                        System.out.println("Sleeping...");
                        //Sleeps A little
                        Thread.sleep(20*60*1000);
                        
                        //------------------------------------
                        
                        rn = new Random();
                        tweetNumber = rn.nextInt(14);
                        //send a tweet
                        status2 = twitter.updateStatus(tweets.get(tweetNumber) + (char) (rn.nextInt(26) + 'a'));
                        //print a message so we know when it finishes
                        System.out.println("Done here...");
                        System.out.println("Sleeping...");
                        //Sleeps A little
                        Thread.sleep(30*60*1000);
 
                    }

                } catch (TwitterException | InterruptedException ex) {

                    ex.printStackTrace();
                }

            }

        };

     

        thread.start();

    }

}
