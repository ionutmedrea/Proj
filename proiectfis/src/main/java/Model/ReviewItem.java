package Model;

public class ReviewItem {
    private String name;
    private String review;
    public ReviewItem(){

    }
    public ReviewItem(String name,String review){
            this.name=name;
            this.review=review;
    }
    public String getReview(){
        return review;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewItem rev= (ReviewItem) o;

        if (!name.equals(rev.name)) return false;
        if (!review.equals(rev.review)) return false;

        return false;
    }
    @Override
    public String toString() {
        return "Review{" +
                "name='" + name + '\'' +
                ", review='" + review + '\''
                ;
    }
}
