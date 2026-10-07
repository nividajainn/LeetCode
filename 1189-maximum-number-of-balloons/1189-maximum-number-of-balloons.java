class Solution {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> map = new HashMap<>();
        
        //store karo words or count
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // balloon ke har word ka count lo p
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2; //repeated h isliye /2
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(
            Math.min(b, a),
            Math.min(Math.min(l, o), n) 
        );
    } //ek bhi letter nhi hoga to 0 min aayega or 1 bhi jyda hua to possible to h word
}