/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.bot;

import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author rashad
 */
public class OAuth {

    static ConfigurationBuilder cb;

    public void authenicate() {

        
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(Constants.TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(Constants.TWITTER_SECRET_KEY)
                .setOAuthAccessToken(Constants.TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(Constants.TWITTER_ACCESS_TOKEN_SECRET);

        
    }

}
