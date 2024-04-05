import java.util.List;

public class Movie {
    private String name;
    private int duration;// time in minutes
    private String releaseDate;
    private List<String> directors;
    private List<String> distributors;
    private String description;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addDirector(String d){
        directors.add(d);
    }
    public void removeDirector(String d){
        for(String i:directors){
            if(i==d){
                directors.remove(i);
                break;
            }
        }
    }
    public void displayDirectors(){
        System.out.println("Directors: ");
        for(String i: directors){
            System.out.println("\t- "+i);
        }
        System.out.println();
    }
    public void addDistributor(String d){
        this.distributors.add(d);
    }

    public void removeDistributor(String d){
        for(String i:distributors){
            if(i==d){
                distributors.remove(i);
                break;
            }
        }
    }

    public void displayDistributors(){
        System.out.println("Distributors: ");
        for(String i: distributors){
            System.out.println("\t- "+i);
        }
        System.out.println();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
