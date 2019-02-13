public class LayoutSetting {

    public static final int INIT_thumbsnailPerPage = 24;
    private static int thumbsnailPerPage = INIT_thumbsnailPerPage;


    public static int getThumbsnailPerPage() {
        return thumbsnailPerPage;
    }

    public static void setThumbsnailPerPage(int aThumbsnailPerPage) {
        thumbsnailPerPage = aThumbsnailPerPage;
    }
}
