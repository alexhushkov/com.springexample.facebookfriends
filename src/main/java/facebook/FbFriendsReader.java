package facebook;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.UserInvitableFriend;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class provides access to facebookApi
 */
@Component
public class FbFriendsReader implements FbReader {

    private Facebook facebook;

    public void setFbConnection(String accessToken) {
        facebook = new FacebookTemplate(accessToken);
    }

    /**
     * Receives friends name from facebookApi
     * @return {@code List<String>} friends names
     */
    public List<String> getFbInfo ( ) {
        List<String> friendsList;

        PagedList<UserInvitableFriend> friends = facebook.friendOperations().getInvitableFriends();
        friendsList = facebook.friendOperations().getFriendIds();

        for (UserInvitableFriend friend : friends) {
            friendsList.add(friend.getName());
        }
        return friendsList;
    }

}
