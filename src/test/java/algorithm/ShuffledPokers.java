package algorithm;
import java.util.*;

//需求：使用LinkedList存储一副扑克牌（52张），并且实现洗牌功能

class Poker
{
    public Poker(String color, String num)
    {
        super();
        this.color = color;
        this.num = num;
    }
    String color;
    String num;

    public String toString()
    {
        return color+num;
    }

}

public class ShuffledPokers
{
    public static void main(String[] args)
    {
        //生成52张扑克牌
        String[] colors = {"黑桃","方块","梅花","红桃"};
        String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        LinkedList<Poker> pokers = new LinkedList<Poker>();
        for(int i=0;i < colors.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                pokers.add(new Poker(colors[i],nums[j]));
            }
        }
        //洗牌
        LinkedList<Poker> shuffledPokers = new LinkedList<Poker>();
        while(shuffledPokers.size()<pokers.size())
        {
            Random x = new Random();
            Poker poke = (Poker) pokers.get(x.nextInt(pokers.size()));
            if(!shuffledPokers.contains(poke))
            {
                shuffledPokers.add(poke);
            }
        }
        System.out.println("洗牌前："+pokers);
        System.out.println("洗牌后："+shuffledPokers);
    }
}