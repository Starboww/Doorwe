package in.starbow.doorwe;

public class FoodcategoryItem {
    private int imageId;
    private String title;
    public FoodcategoryItem(Integer imageId, String title){
        this.imageId=imageId;
        this.title =title;
    }
    public int getImageId(){return imageId;}
    public  String getTitle(){return title;}
    public void setTitle(String title){
        this.title=title;
    }
}
