package am.plexonic.common.rs_utils;

/**
 * The bank server path provider enum type.
 */
public enum ServerPathProvider {
    TEST_API        (ServerPathConstants.TEST_API),
    AVAILABLE       (ServerPathConstants.AVAILABLE),
    DAU             (ServerPathConstants.DAU);

    private final String path;


    ServerPathProvider(final String path) {
        this.path = path;
    }

    public final String getPath() {
        return path;
    }

//    public String getServicePath(String serverUrl) {
//        StringBuilder pathBuilder = new StringBuilder();
//        buildServicePath(serverUrl, pathBuilder);
//
//        return pathBuilder.toString();
//    }

//    public String getServicePath() {
//        StringBuilder pathBuilder = new StringBuilder();
//        buildServicePath(pathBuilder);
//
//        return pathBuilder.toString();
//    }
//
//    public String getServicePath(String serverUrl, String... params) {
//        StringBuilder pathBuilder = new StringBuilder();
//        buildServicePath(serverUrl, pathBuilder);
//
//        appendParams(pathBuilder, params);
//
//        return pathBuilder.toString();
//    }
//
//    private void appendParams(StringBuilder pathBuilder, String... params) {
//        for (String param : params) {
//            pathBuilder.append('/').append(UriComponent.encode(param, UriComponent.Type.QUERY));
//        }
//    }
//
//    public String getServicePathWithQueryParams(String serverUrl, String[][] params) {
//        StringBuilder pathBuilder = new StringBuilder();
//        buildServicePath(serverUrl, pathBuilder);
//
//        appendQuerParams(pathBuilder, params);
//
//        return pathBuilder.toString();
//    }
//
//    public String getServicePathWithQueryParams(String[][] params) {
//        StringBuilder pathBuilder = new StringBuilder();
//        buildServicePath(pathBuilder);
//
//        appendQuerParams(pathBuilder, params);
//
//        return pathBuilder.toString();
//    }
//
//    private StringBuilder appendQuerParams(StringBuilder pathBuilder, String[][] params) {
//        pathBuilder.append('?');
//        for (int i = 0; i < params.length; i++) {
//            if (i > 0) {
//                pathBuilder.append('&');
//            }
//            pathBuilder.append(params[i][0]).append('=').append(UriComponent.encode(params[i][1], UriComponent.Type.QUERY_PARAM));
//        }
//
//        return pathBuilder;
//    }
//
//    private void buildServicePath(String serverUrl, StringBuilder pathBuilder) {
//        pathBuilder.append(serverUrl);
//
//        buildServicePath(pathBuilder);
//    }
//
//    private void buildServicePath(StringBuilder pathBuilder) {
//        ServerPathProvider parentPathProvider = serviceTypeToEnumType.get(type);
//        if (parentPathProvider != null) {
//            pathBuilder.append(parentPathProvider.path);
//            if (type != ServiceType.SERVICE) {
//                pathBuilder.append(path);
//            }
//        } else {
//            throw new IllegalStateException("Undefined type of Bankserver Service Path " +
//                    "[Type:" + type + ", Path:" + path + "]");
//        }
//    }

//    private static void initServiceTypeToEnumType() {
//        serviceTypeToEnumType.put(ServiceType.WALLET_CARD, WALLET_CARD);
//    }
}
