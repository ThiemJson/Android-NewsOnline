package teneocto.thiemjason.newsonline.models;

public class NewsDTO {
    private String id;
    private int image;
    private String url;


    public String getId() {
        return id;
    }

    public NewsDTO(String id, int image , String url) {
        this.id = id;
        this.image = image;
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
