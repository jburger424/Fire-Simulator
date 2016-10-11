/***
 * Created by Jonathan Burger on 4-14-15
 * Initializes fire simulator
 */
public class initializer {
    /***
     * Initialized fire with specified columns, rows, wind speed, wind direction and dryness level
     * Prints percent of forest burned when fire is no longer burning
     * @param args -s size(# of cols and rows) -ws windSpeed(0 - 1) -wd windDirection(degrees) -dl drynessLevel(0 - 1)
     */
    public static void main(String[] args){
        int columns = 40; int rows = 40; double windSpeed = .9; double windDirection = 45; double drynessLevel = .5;
        for (int i = 0; i<args.length; i++) {
            String tempArg = args[i];
            if(tempArg.equals("-s")){
                try {
                    int tempSize = Integer.parseInt(args[i+1]);
                    if(tempSize < 4) throw new NumberFormatException();
                    columns = rows = tempSize;
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Size must be integer >= 4");
                    System.exit(1);
                }
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
