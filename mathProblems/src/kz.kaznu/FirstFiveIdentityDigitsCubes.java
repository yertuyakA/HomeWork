package kz.kaznu;

import java.util.ArrayList;
import java.util.List;


/** The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 Find the smallest cube for which exactly five permutations of its digits are cube.
 */

public class FirstFiveIdentityDigitsCubes {
    public static void main(String[] args) {

            List<Integer> cubes = new ArrayList<>();

            int a = 0;
            int i = 0;
            int firstCube = 0;
            int count = 0; // count of cubes with same digits;

        while(count!=3){
                count = 0;
                cubes.add(i, (int) Math.pow(a,3));

                for (Integer cube : cubes) {
                    if (checkForIdenticalDigits(cube, cubes.get(i))) {
                        count++;
                        if (count == 1) {
                            firstCube = cube;
                        }
                    }
                }
                i++;
                a++;
            }
            System.out.println(firstCube);
        }

    public static boolean checkForIdenticalDigits(Integer integer, int a) {

            String s = Integer.toString(integer);
            String str[] = s.split("");
            String z = Integer.toString(a);
            String str2[] = z.split("");

            if(str.length!=str2.length){
                return false;
            }

            int count = 0;

            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    if(str[i].equals(str2[j])){

                        count++;

                        str[i] = "-";
                        str2[j] = "+";

                    }
                }
            }

            if(count==str.length){

                return true;

            }else{

                return false;

            }

        }
}