/***
 * Created by Jonathan Burger on 4-14-15
 * Initializes fire simulator
 */
public class Init {
    /***
     * Initializes fire with specified wind speed, wind direction and dryness level
     * Prints percent of forest burned when fire is no longer burning
     * @param args -ws windSpeed(0 - 1) -wd windDirection(degrees) -dl drynessLevel(0 - 1)
     */
    public static void main(String[] args){
        int columns = 40; int rows = 40; double windSpeed = .9; double windDirection = 45; double drynessLevel = .5;
        for (int i = 0; i<args.length; i++) {
            String tempArg = args[i];
            if(tempArg.equals("-h")){
                    System.err.println("Help:\n" +
                            "\t-ws windSpeed(0 - 1)\tdefault: .9\n" +
                            "\t-wd windDirection(degrees)\tdefault: 45\n" +
                            "\t-dl drynessLevel(0 - 1)\tdefault: .5\n" +
                            "\t-h help");
                    System.exit(1);
            }
            else if(tempArg.equals("-ws")){
                try {
                    double tempWS = Double.parseDouble(args[i+1]);
                    if(tempWS < 0 || tempWS > 1) throw new NumberFormatException();
                    windSpeed = tempWS;
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Wind Speed must be decimal between 0 and 1");
                    System.exit(1);
                }
            }
            else if(tempArg.equals("-wd")){
                try {
                    double tempWD = Double.parseDouble(args[i+1]);
                    //if(tempWD < 0 || tempWS > 1) throw new NumberFormatException();
                    windDirection = tempWD % 360;
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Wind Direction must be decimal representing degrees");
                    System.exit(1);
                }
            }

            else if(tempArg.equals("-dl")){
                try {
                    double tempDL = Double.parseDouble(args[i+1]);
                    if(tempDL < 0 || tempDL > 1) throw new NumberFormatException();
                    drynessLevel = tempDL;
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Dryness Level must be decimal between 0 and 1");
                    System.exit(1);
                }
            }
        }
        if(args.length < 2){
            System.out.println("Include -h argument to see more options");
        }

        FireSimulator fs = new FireSimulator(columns,rows,windSpeed,windDirection,drynessLevel);

        double lastPercent = 0;
        boolean fireStopped = false;
            while(!fireStopped){
                fs.spread();
                if(lastPercent == fs.getPercentBurned() && lastPercent > 0) fireStopped = true;
                lastPercent = fs.getPercentBurned();
                try{
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        System.out.println(fs.getPercentBurned()+"% Burned");

    }
}
