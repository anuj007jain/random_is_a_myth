package com.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by anuj.jain02 on 27/6/16.
 */
public class LC_0030_Substring_With_Concatenation_Of_All_Words {

    Set<Integer> solutionSet = new HashSet<>();
    List<Integer> solutionList = new ArrayList<>();

    private List<Integer> findSubstring(String s, String[] words){
        printAllPermutationsOfAGivenStringArray(s, words, 0, words.length-1 );
        solutionList.addAll(solutionSet);
        return solutionList;
    }

    private void printAllPermutationsOfAGivenStringArray(String s, String[] words ,int l, int h){

        if(l==h){
            StringBuffer check = new StringBuffer();
            for(int i = 0; i < words.length ; i++)
                check.append(words[i]);
            System.out.println(check);
            if(s.contains(check)) {
                int ind = 0;
                while(true) {
                    ind = s.indexOf(check.toString(),ind);
                    if(ind == -1)
                        break;
                    solutionSet.add(ind);
                    ind++;
                }

            }

        }
        for(int i = l ; i <= h ; i++){
            swap(words,l,i);
            printAllPermutationsOfAGivenStringArray(s, words,l+1,h);
            swap(words,l,i);//Backtracking
        }

    }

    private void swap(String[] words, int a, int b){
        String temp =  words[a];
        words[a] = words[b];
        words[b] = temp;
    }


    public static void main(String[] args) {

        LC_0030_Substring_With_Concatenation_Of_All_Words swcoaw = new LC_0030_Substring_With_Concatenation_Of_All_Words();
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        swcoaw.findSubstring(s,words);


    }

}
