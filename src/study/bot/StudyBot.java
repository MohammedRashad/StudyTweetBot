/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    static int searchNumber, replyNumber, tweetNumber,mentionNumber;
    static Status status, status2;
    static List<String> searches,replies,tweets;
    static char randomChar; 

    public static void main(String[] args) throws TwitterException {

        Auth = new OAuth();
        Auth.authenicate();

        tf = new TwitterFactory(Auth.cb.build());
        twitter = tf.getInstance();

        lists();

        thread = new Thread() {

            @Override
            public void run() {

                try {

                    while (true) {

                        rn = new Random();
                        searchNumber = rn.nextInt(6);
                        replyNumber = rn.nextInt(7);
                        mentionNumber = rn.nextInt(100);
                        //create a new search, chosoe from random searches
                        Query query = new Query(searches.get(searchNumber));
                        //get the results from that search
                        QueryResult result = twitter.search(query);
                        //get the random tweet from those results
                        Status tweetResult = result.getTweets().get(mentionNumber);
                        //reply to that tweet, choose from random replies
                        StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + replies.get(replyNumber));
                        statusUpdate.inReplyToStatusId(tweetResult.getId());
                        status = twitter.updateStatus(statusUpdate);
                        //print a message so we know when it finishes
                        System.out.println(Constants.DONE_1);
                        System.out.println(Constants.SLEEP);
                        //Sleeps A little
                        Thread.sleep(60 * 1000);

                        //------------------------------------//
                        
                        rn = new Random();
                        tweetNumber = rn.nextInt(14);
                        randomChar = (char) (rn.nextInt(26) + 'a');
                        //send a tweet with random character at the aend to avoid duplication
                        status2 = twitter.updateStatus(tweets.get(tweetNumber) + " "+ randomChar);
                        //print a message so we know when it finishes
                        System.out.println(Constants.DONE_2);
                        System.out.println(Constants.SLEEP);
                        //Sleeps A little
                        Thread.sleep(60 * 60 * 1000);
                        System.out.println(Constants.REPEAT);

                    }

                } catch (TwitterException | InterruptedException ex) {

                    ex.printStackTrace();
                    
                }

            }

        };

        thread.start();

    }

    private static void lists() {
        
        searches = new ArrayList<>();
        searches.add(Constants.SEARCH_QUERY_1);
        searches.add(Constants.SEARCH_QUERY_2);
        searches.add(Constants.SEARCH_QUERY_3);
        searches.add(Constants.SEARCH_QUERY_4);
        searches.add(Constants.SEARCH_QUERY_5);
        searches.add(Constants.SEARCH_QUERY_6);
        searches.add(Constants.SEARCH_QUERY_7);
        searches.add(Constants.SEARCH_QUERY_8);
        
        //--------------//
        
        replies = new ArrayList<>();
        replies.add(Constants.REPLY_QUERY_1);
        replies.add(Constants.REPLY_QUERY_2);
        replies.add(Constants.REPLY_QUERY_3);
        replies.add(Constants.REPLY_QUERY_4);
        replies.add(Constants.REPLY_QUERY_5);
        replies.add(Constants.REPLY_QUERY_6);
        replies.add(Constants.REPLY_QUERY_7);

        //--------------//
        
        tweets = new ArrayList<>();
        tweets.add(Constants.TWEET_QUERY_1);
        tweets.add(Constants.TWEET_QUERY_2);
        tweets.add(Constants.TWEET_QUERY_3);
        tweets.add(Constants.TWEET_QUERY_4);
        tweets.add(Constants.TWEET_QUERY_5);
        tweets.add(Constants.TWEET_QUERY_6);
        tweets.add(Constants.TWEET_QUERY_7);
        tweets.add(Constants.TWEET_QUERY_8);
        tweets.add(Constants.TWEET_QUERY_9);
        tweets.add(Constants.TWEET_QUERY_10);
        tweets.add(Constants.TWEET_QUERY_11);
        tweets.add(Constants.TWEET_QUERY_12);
        tweets.add(Constants.TWEET_QUERY_13);
        tweets.add(Constants.TWEET_QUERY_14);
        
        
    }

}
