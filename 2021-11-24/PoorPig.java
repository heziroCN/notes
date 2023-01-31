package haiwaitu.t20211124;

/**
 * @Author huangjunqiao
 * @Date 2021/11/25 23:06
 * @Description 458. 可怜的小猪
 */
public class PoorPig {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 数学，时间：O(1)，空间：O(1)
        // y=f(i,j)表示用i只小猪，测试j轮，能判断最多y个桶里的毒药位置。通过公式递推和二项式定理得：f(i,j)=(j+1)^i
        int states = minutesToTest / minutesToDie + 1;//j+1
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states)) ;//保证检查完所有的桶，所以需要向上取整
        return pigs;
    }
}
