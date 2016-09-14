package facebook;

import java.util.List;

/**
 * Provides access to facebook readers implementations
 */
public interface FbReader {
    /**
     * Establishes connection to facebook API
     * @param accessToken facebook application access token
     */
    void setFbConnection (String accessToken);

    /**
     * Gets listed information from facebook api
     * @return {@code List}
     */
    List getFbInfo ();
}
