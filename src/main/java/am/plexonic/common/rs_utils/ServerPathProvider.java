package am.plexonic.common.rs_utils;

/**
 * The bank server path provider enum type.
 */
public enum ServerPathProvider {
    TEST_API                     (ServerPathConstants.TEST_API),
    AVAILABLE                    (ServerPathConstants.AVAILABLE),
    DAU                          (ServerPathConstants.DAU),
    DAU_BY_RETENTION             (ServerPathConstants.DAU_BY_RETENTION);

    private final String path;


    ServerPathProvider(final String path) {
        this.path = path;
    }

    public final String getPath() {
        return path;
    }

}
