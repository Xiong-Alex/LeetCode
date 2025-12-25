class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        // Encode String by adding a length + # to indicate the length of the string and signal/identify where to start
        // this ensures we know where to start && we dont accientally cut off a string that has the same char as the delimiter
        for(String s : strs) {
            sb.append(s.length() + "#" + s);
        }

        return sb.toString();
    }


    public List<String> decode(String str) {
        
        List<String> res = new ArrayList<>();
        int i = 0; 

        while ( i < str.length()) {
            int j = i;

            // loop through until j = #
            // that gives us our length substring(i, j)
            // required in case length is double digits
            while(str.charAt(j) != '#') { 
                j++;
            }


            // grab length and parse it into int
            int len = Integer.parseInt(str.substring(i,j));

            // increment j, so j beigns at the String and not delimiter
            j++;
            // add substring (j, j + len)  
            // <j+ len>, in 2nd half j is required to preserve order of our index in the String & + len, gives us the full String 
            res.add(str.substring(j,j + len));

            //Update our starting index to the next string (starting int for next string)
            i = j + len;

        }

        return res;
    }

}
