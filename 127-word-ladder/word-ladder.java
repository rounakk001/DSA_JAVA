class pair{
    String word;
    int seq;
    pair(String word,int seq){
        this.word=word;
        this.seq=seq;
        }
}

    class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        Queue<pair> q=new LinkedList<>();

        q.add(new pair(beginWord,1));

        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }

while(!q.isEmpty()){

    String word=q.peek().word;
    int steps=q.peek().seq;

   
    if(word.equals(endWord)==true)
    return steps;
     q.remove();

        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char replacedArray[]=word.toCharArray();
                replacedArray[i]=ch;
                String replacedstr=new String(replacedArray);
                 if(st.contains(replacedstr))
                 {
                    q.add(new pair(replacedstr,steps+1));
                    st.remove(replacedstr);
                 }


            }
        }
}
return 0;

    }
}