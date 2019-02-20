package jianzhi;

/**
 * 题目:
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

/**
 * 算法思想:
 * 先翻转整个句子，然后依次翻转每个单词
 * 根据空格来确定每个单词的起始和终止位置
 */
public class Solution_ReverseSentence
{
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == ' ') {
                int nextblank = i;
                reverse(chars, blank + 1, nextblank - 1);
                blank = nextblank;
            }
        }
        // 最后一个单词进行单独反转
        reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);
    }
    public void reverse(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low ++;
            high --;
        }
    }
}
