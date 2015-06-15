/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencodtwitter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author dcuerdogarcia
 */
public class Metodos {

    Twitter twitter;

    /**
     
     */
    public Metodos() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("xxxxxxxxxx")
                .setOAuthConsumerSecret("xxxxxxxxxxxxxxxxxxxxxx")
                .setOAuthAccessToken("xxxxxxxxxxxxxxxxxxxxxx")
                .setOAuthAccessTokenSecret("xxxxxxxxxxxxxxxxxxxxxxxxxx");

        twitter = new TwitterFactory(cb.build()).getInstance();
    }

    /**
     
     *
     * @throws TwitterException
     */
    public void verTimeLine() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando su Timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }

    /**
     
     *
     * @param busqueda
     * @throws TwitterException
     */
    public void buscar(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    /**
     *
     *
     * @param tweet * @throws TwitterException
     */
    public void twitear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Has twiteado el siguiente mensaje [" + status.getText() + "].");

    }
}
