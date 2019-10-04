class Solution {
    public String getHint(String secret, String guess) {
        int num_bull = 0;
        int num_cow = 0;
        
        //assume secret.length() == guess.length()
        
        int[] numbers = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) num_bull++;
            else{
                if(numbers[secret.charAt(i) - '0']++ < 0) num_cow++;
                if(numbers[guess.charAt(i) - '0']-- > 0) num_cow++;
            }
        }
        return num_bull + "A" + num_cow + "B";
        
        
    }
}


/***
 public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
*/
