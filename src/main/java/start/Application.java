package start;


import configs.FacebookConfig;
import configs.DatabaseConfig;
import dao.ContactDAO;
import facebook.FbFriend;
import facebook.FbReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Class finds my facebook friends names and adds them
 * to database
 */
public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(FacebookConfig.class, DatabaseConfig.class);
        appContext.refresh();

        ContactDAO dao = (ContactDAO) appContext.getBean("getJdbcDAO");
        FbReader fb = appContext.getBean(FbReader.class);

        ArrayList<FbFriend> friends = new ArrayList<FbFriend>();
        List<String> friendsNames = fb.getFbInfo();

        for (String friendName : friendsNames) {
            FbFriend fbFriend = new FbFriend();
            fbFriend.setName(friendName);
            friends.add(fbFriend);
        }

        dao.insertAllFriends(friends);
        dao.getFriends();

    }

}
