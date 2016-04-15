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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author root
 */
public class TweetsCreator {

    static int aTweet;
    static Random randomNumber;
    static List<String> searches, replies, tweets;

    public static void initializeLists() {

        searches = new ArrayList<>();
        replies = new ArrayList<>();
        tweets = new ArrayList<>();

    }

    public static void addItemsToLists() {

        searches.add(Constants.SEARCH_QUERY_1);
        searches.add(Constants.SEARCH_QUERY_2);
        searches.add(Constants.SEARCH_QUERY_3);
        searches.add(Constants.SEARCH_QUERY_4);
        searches.add(Constants.SEARCH_QUERY_5);
        searches.add(Constants.SEARCH_QUERY_6);
        searches.add(Constants.SEARCH_QUERY_7);
        searches.add(Constants.SEARCH_QUERY_8);

        replies.add(Constants.REPLY_QUERY_1);
        replies.add(Constants.REPLY_QUERY_2);
        replies.add(Constants.REPLY_QUERY_3);
        replies.add(Constants.REPLY_QUERY_4);
        replies.add(Constants.REPLY_QUERY_5);
        replies.add(Constants.REPLY_QUERY_6);
        replies.add(Constants.REPLY_QUERY_7);

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

    public static int getARandomTweet(String key) {

        randomNumber = new Random();
        
        switch (key) {

            case "search":
                aTweet = randomNumber.nextInt(6);
                break;

            case "reply":
                aTweet = randomNumber.nextInt(8);
                break;

            case "mention":
                aTweet = randomNumber.nextInt(20);
                break;

            case "tweet":
                aTweet = randomNumber.nextInt(13);
                break;

        }

        return aTweet;

    }

}
