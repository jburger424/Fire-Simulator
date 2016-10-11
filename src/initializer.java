/***
 * Created by Jonathan Burger on 4-14-15
 * Initializes fire simulator
 */
public class initializer {
    /***
     * Initialized fire with specified columns, rows, wind speed, wind direction and dryness level
     * Prints percent of forest burned when fire is no longer burning
     * @param args
     */
    public static void main(String[] args){
        int columns = 40; int rows = 40; double windSpeed = .9; double windDirection = 45; double drynessLevel = .5;
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
