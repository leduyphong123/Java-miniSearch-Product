package entity;

public class Product {
    private static int idDefault=1;
    private int id;
    private String name;
    private long price;
    private String date;
    private String nsx;
    private int like;

    public Product() {
    }

    public Product(int id, String name, long price, String date, String nsx, int like) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.nsx = nsx;
        this.like = like;
    }

    public Product(String name, long price, String date, String nsx, int like) {
        this.id=idDefault;
        this.name = name;
        this.price = price;
        this.date = date;
        this.nsx = nsx;
        this.like = like;
        this.id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", nsx='" + nsx + '\'' +
                ", like=" + like
                ;
    }
}
