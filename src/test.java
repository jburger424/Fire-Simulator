/**
 * Created by Jon on 4/1/15.
 */
public class test {
    public static void main(String[] args){
        int radius =  1;
            for (int dX = -(radius); dX <= radius; dX++) {
                //System.out.println(dX);
                for (int dY = -(radius-Math.abs(dX)); dY <= (radius-Math.abs(dX)); dY++) {
                    System.out.println("x+ "+dX+"\ty+ "+dY);
                }
            }

        }


            }



