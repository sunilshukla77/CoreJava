package com.problems;

// Java program to find Minimum Distance
// Between Words of a String
//Minimum distance between 2 words counting the number of characters
// from middle of both words. E.g. ABC is XYZ and ABC & XYZ are two distinct words.
public class WorldDiff {
        // Function to calculate the minimum
// distance between w1 and w2 in s
        static int distance(String s,String w1,String w2)
        {

            if (w1 .equals( w2) )
                return 0 ;

            // get individual words in a list
            String words[] = s.split(" ");

            // assume total length of the string
            // as minimum distance
            int min_dist = (words.length) + 1;

            // traverse through the entire string
            for (int index = 0; index < words.length ; index ++)
            {

                if (words[index] .equals( w1)) {
                    for (int search = 0; search < words.length; search ++) {
                        if (words[search] .equals(w2)) {
                            // the distance between the words is
                            // the index of the first word - the
                            // current word index
                            int curr = Math.abs(index - search) - 1;

                            // comparing current distance with
                            // the previously assumed distance
                            if (curr < min_dist)
                            {
                                min_dist = curr ;
                            }
                        }
                    }
                }
            }

            // w1 and w2 are same and adjacent
            return min_dist;
        }

        // Driver code
        public static void main(String args[])
        {

            String s = "geeks for geeks contribute practice";
            String w1 = "geeks" ;
            String w2 = "practice" ;

            System.out.print( distance(s, w1, w2) );

        }
    }


