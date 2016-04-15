/*
 * Copyright (C) 2016 root
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package study.bot;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author root
 */
public class TweetEngine extends Thread {

    int aRandomTweet;
    char randomChar;
    Query query;
    Twitter twitter;
    QueryResult result;
    Random randomNumber;
    Status tweetResult, status;
    StatusUpdate statusUpdate;

    public TweetEngine(Twitter twitter) {

        this.twitter = twitter;
        this.randomNumber = new Random();

    }

    @Override
    public void run() {

        while (true) {
            
            try {

                TweetsCreator.initializeLists();
                TweetsCreator.addItemsToLists();

                replyToARandomPerson();

                System.out.println(Constants.DONE_1);
                System.out.println(Constants.SLEEP);

                Thread.sleep(50 * 1000);

                postArandomTweet();

                System.out.println(Constants.DONE_2);
                System.out.println(Constants.SLEEP);

                Thread.sleep(30 * 60 * 1000);
                System.out.println(Constants.REPEAT);

            } catch (TwitterException | InterruptedException ex) {

                Logger.getLogger(TweetEngine.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        
    }

    public void replyToARandomPerson() throws TwitterException {

        aRandomTweet = TweetsCreator.getARandomTweet("search");
        query = new Query(TweetsCreator.searches.get(aRandomTweet));

        result = twitter.search(query);
        aRandomTweet = TweetsCreator.getARandomTweet("mention");
        tweetResult = result.getTweets().get(aRandomTweet);

        aRandomTweet = TweetsCreator.getARandomTweet("reply");
        statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + TweetsCreator.replies.get(aRandomTweet));
        statusUpdate.inReplyToStatusId(tweetResult.getId());
        status = twitter.updateStatus(statusUpdate);

    }

    
    
    public void postArandomTweet() throws TwitterException {

        randomNumber = new Random();
        randomChar = (char) (randomNumber.nextInt(26) + 'a');
        aRandomTweet = TweetsCreator.getARandomTweet("tweet");
        status = twitter.updateStatus(TweetsCreator.tweets.get(aRandomTweet) + " " + randomChar);

    }

}

