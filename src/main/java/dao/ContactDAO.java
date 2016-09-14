package dao;


import facebook.FbFriend;

import java.util.List;

/**
 * Provides access to data access implementations
 */
public interface ContactDAO {
    /**
     * Inserts {@code list<FbFriends>} into facebookFriends db
     * @param friends {@code List<FbFriends>}
     */
    void insertAllFriends(List<FbFriend> friends);

    /**
     * Selects all data from facebookFriends
     * @return {@code List<FbFriends>}
     */
    List<FbFriend> getFriends();
}
