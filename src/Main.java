import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Get today's date
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Format the current date to YYYYMMDD format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(currentDate);

        // Define a date format for input validation
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Movie SpiderMan= new Movie();
        SpiderMan.setName("SpiderMan");
        SpiderMan.setDescription("SpiderMan");
        SpiderMan.setDuration(120);
        SpiderMan.setPrice(15);

        Movie Avengers = new Movie();
        Avengers.setName("Avengers");
        Avengers.setDuration(150);
        Avengers.setPrice(13);

        AvailableMovies.add(Avengers);
        AvailableMovies.add(SpiderMan);

        AvailableMovies.Display();

        CinemaHall c1 = new CinemaHall();
        c1.setHallNumber(1);

        CinemaHall c2 = new CinemaHall();
        c2.setHallNumber(2);

        MovieShowtime m1 = new MovieShowtime();
        m1.setMovie(SpiderMan);
        m1.setScheduledDate("2024-03-31");
        m1.setStartTime("19:30");
        m1.setCinemaHall(c1.clone());

        AvailableShowtimes.addShowtime(m1);

        MovieShowtime m2 = new MovieShowtime();
        m2.setMovie(Avengers);
        m2.setScheduledDate("2024-03-31");
        m2.setStartTime("19:30");
        m2.setCinemaHall(c2.clone());

        AvailableShowtimes.addShowtime(m2);

        AvailableShowtimes.Display();

        CinemaHall cine1 = new CinemaHall();
        cine1.setHallNumber(1);
        CinemaHall cine2 = new CinemaHall();
        cine2.setHallNumber(2);
        CinemaHall cine3 = new CinemaHall();
        cine3.setHallNumber(3);

        HashMapCinemaHall.halls.put(cine1.getHallNumber(),cine1);
        HashMapCinemaHall.halls.put(cine2.getHallNumber(),cine2);
        HashMapCinemaHall.halls.put(cine3.getHallNumber(),cine3);

        for(CinemaHall cine: HashMapCinemaHall.halls.values()){
            System.out.println(cine.getHallNumber());
        }

        CinemaHall cine1Clone = cine1.clone();
        System.out.println(cine1Clone.getHallNumber());


        Ticket t1 = new Ticket();
        t1.setShowtime(AvailableShowtimes.getShowtime(1));
        t1.reserveSeat(1,1);
        t1.reserveSeat(5,9);
        t1.setClientName("Peter");
        t1.setContact("435 5783 6388");
        t1.setShowtime(m2);

        t1.calculateTotalPrice();
        t1.Display();

        // updated ticket
        // the cinema hall variable was added to showtime
        // getMovie in MovieShowtime returns a movie
        // added reserveSeat in Ticket, MovieShowtime and CinemaHall


        byte userChoice;
        boolean validChoice = false;
        char userInp = 'n';
        do {
            System.out.println("==================Cinema System==================");
            System.out.println("\n1. Display Movie Showtimes");
            System.out.println("2. Reserve Movie");
            System.out.println("3. Add movie Description"); // Using Template design pattern
            System.out.println("4. Exit");
            do{
                System.out.print("Choice: ");
                try {
                    userChoice = reader.nextByte();
                    validChoice = true;
                }catch (Exception e){
                    System.out.println("\nInvalid input. Please enter a number (1-4).\n");
                    reader.nextLine();
                    userChoice = 0;
                }
            }while (!validChoice);

            switch (userChoice) {
                //Display the Movies
                case 1:
                    System.out.println("\n");
                    AvailableShowtimes.Display();
                    break;
                // Reserve Movie
                case 2:
                    break;
                // Add Movie
                case 3:
                    String exitChoices = "";
                    do {
                        System.out.print("UserID: ");
                        String userId = reader.next();
                        if (userId.equals("Aurelien")) {
                            System.out.println("\nWelcome " +userId+ "\n\n===================Add movie==================");
                            System.out.print("Add movie: ");
                            String name = reader.next();

                            Movie movie = new Movie();
                            movie.setName(name);
                            movie.setDescription(name);

                            System.out.print("Movie Duration: ");
                            int duration = reader.nextInt();

                            movie.setDuration(duration);

                            String startTime = null;
                            boolean validStartTime = false;
                            do {
                                System.out.print("What schedule does the movie launch (HH:mm)? ");
                                startTime = reader.next();
                                try {
                                    // Validate time format using regex
                                    Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                                    Matcher matcher = pattern.matcher(startTime);
                                    if (matcher.matches()) {
                                        validStartTime = true;
                                    } else {
                                        throw new IllegalArgumentException();
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid time format. Please enter the time in HH:mm (24-hour) format.");
                                }
                            } while (!validStartTime);

                            String scheduleDate = null;
                            boolean validDateFormat = false;
                            do {
                                System.out.println("What date does the movie is released (YYYY-MM-DD)?");
                                scheduleDate = reader.next();
                                try {
                                    // Parse the input date string to Date object
                                    Date parsedDate = inputDateFormat.parse(scheduleDate);
                                    String inputDate = inputDateFormat.format(parsedDate);

                                    // Verify if the input date is from today onwards
                                    if (inputDate.compareTo(today) >= 0) {
                                        validDateFormat = true;
                                    } else {
                                        throw new ParseException("Input date is in the past", 0);
                                    }
                                } catch (ParseException e) {
                                    System.out.println("Invalid date format or date is in the past. Please enter a date from today onwards in YYYYMMDD format.");
                                }
                            } while (!validDateFormat);
                            MovieShowtime m3 = new MovieShowtime();
                            m3.setMovie(movie);
                            m3.setHallNumber(3);
                            m3.setStartTime(startTime);
                            m3.setScheduledDate(scheduleDate);
                            AvailableShowtimes.addShowtime(m3);

                            System.out.println("Successfully added movie");
                        } else {
                            System.out.println("Invalid UserId");
                            do {
                                System.out.println("Do you want to retry? (y/n)");                                exitChoices = reader.next();
                                if (exitChoices.equals("Y") ||  exitChoices .equals("y")) {
                                    System.out.println("\nRestarting");
                                    break;
                                }
                                else if (exitChoices.equals("n") || exitChoices.equals("N")) {
                                    userChoice = 0;
                                    System.out.println("\n");
                                    break;
                                }

                            }while (!exitChoices.equals("Y") ||  !exitChoices.equals("y")||!exitChoices.equals("n") || !exitChoices.equals("N"));
                        }
                    } while (exitChoices.equals("y") || exitChoices.equals("Y"));
                    break;
                case 4:
                    System.out.println("\n===================Exit======================");
                    String exitChoice;
                    do {
                        System.out.println("\nDo you really wish to exit the game? Enter 'y/n' to Exit\n");
                        exitChoice = reader.next();
                        if (exitChoice.equals("Y") ||  exitChoice .equals("y")) {
                            System.out.println("\nGoodbye dear user!");
                            reader.close();
                            System.exit(0);
                        }
                        else if (exitChoice.equals("n") || exitChoice.equals("N")) {
                            userChoice = 0;
                            break;
                        }

                    }while (!exitChoice.equals("Y") ||  !exitChoice.equals("y")||!exitChoice.equals("n") || !exitChoice.equals("N"));
                    break;
                default:
                    System.out.println("Invalid input. Range (1-4)\n");
                    break;
            }
        }while(userChoice != 4);
        reader.close();
    }

    // updated MovieShowtime setSceduleDate();
    // The main has a switch case for the cinemas fonctionality's
    // case 3 has a login fonction in which it lets the user add a new Movie
    // Did the try catchs and do whiles
    






















}
