package a12mob.fiap.rapha.times_app.contants;

/**
 * Created by rapha on 26/11/2016.
 */

public enum  Constants {
    HeiderURL("http://www.mocky.io/");

    private final String url;

    private Constants(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
