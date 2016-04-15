/**
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

import java.text.ParseException;
import java.util.Calendar;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author rashad
 *
 */
public class StudyBot {

    static OAuth oAuth;

    static Twitter twitter;
    static TweetEngine tweeter;
    static TwitterFactory twitterFactory;
    static Calendar cal;

    public static void main(String[] args) throws TwitterException, ParseException {

        peusdoAI();

        System.out.println("Getting my Shit together...");

        botInitialization("init");

        System.out.println("Hold on, Sir...");

        botInitialization("start");

        System.out.println("3..2..1..Start!");

        tweeter.start();

    }

    public static void peusdoAI() {

        cal = Calendar.getInstance();
        cal.getTime();

        if (cal.get(Calendar.AM_PM) == Calendar.PM) {

            System.out.println("Good Evening, sir");

        } else if (cal.get(Calendar.AM_PM) == Calendar.AM) {

            System.out.println("Good Morning, sir");

        }

    }

    public static void botInitialization(String operation) {

        switch (operation) {

            case "init":

                oAuth = new OAuth();
                oAuth.authenicate();
                
                twitterFactory = new TwitterFactory(OAuth.cb.build());

                break;

            case "start":

                twitter = twitterFactory.getInstance();
                tweeter = new TweetEngine(twitter);

                break;

        }

    }

}
