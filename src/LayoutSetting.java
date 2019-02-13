public class LayoutSetting {

    public static final int INIT_thumbsnailPerPage = 24;
    private static int thumbsnailPerPage = INIT_thumbsnailPerPage;

    public static int getThumbsnailPerPage() {
        return thumbsnailPerPage;
    }

    public static void setThumbsnailPerPage(int aThumbsnailPerPage) {
        thumbsnailPerPage = aThumbsnailPerPage;
    }

    public static final int INIT_thumbnailRowCount = 3;
    private static int thumbnailRowCount = INIT_thumbnailRowCount;

    public static int getThumbnailRowCount() {
        return thumbnailRowCount;
    }

    public static void setThumbnailRowCount(int aThumbnailRowCount) {
        thumbnailRowCount = aThumbnailRowCount;
    }
}
