package mra.com.tastyfoodcafe.New;

/**
 * Created by mr. A on 25-02-2019.
 */

public class SpecialOffers
{
    String id,offername,offerday,image;

    public SpecialOffers()
    {}

    public SpecialOffers(String id, String offername, String offerday,String image) {
        this.id = id;
        this.offername = offername;
        this.offerday = offerday;
        this.image=image;
    }

    public String getId() {
        return id;
    }

    public String getOffername() {
        return offername;
    }

    public String getOfferday() {
        return offerday;
    }

    public String getImage() {
        return image;
    }
}
