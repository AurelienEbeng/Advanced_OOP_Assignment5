public class AvailableShowtimes {
    private AvailableShowtimes(){}

    private static MovieShowtime[] availableShowtimes = new MovieShowtime[5];
    private static int size=0;

    public static void addShowtime(MovieShowtime s){
        availableShowtimes[size] = s;
        size++;
    }

    public static void removeShowtime(MovieShowtime s){
        for(MovieShowtime i: availableShowtimes){
            if(i == s){
                i = null;
                size--;
            }
        }
    }

    public static void Display(){
        for(int i = 0; i<size;i++){
            availableShowtimes[i].Display();
        }
    }

    public static MovieShowtime getShowtime(int c){
        return availableShowtimes[c];
    }
}
