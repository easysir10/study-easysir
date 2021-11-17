package mess;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class MyBloomFilter {



    public static void main(String[] args) {
        // google布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),
                1500, 0.01);

        bloomFilter.put(10);
        bloomFilter.put(100);

        System.out.println(bloomFilter.mightContain(10));
        System.out.println(bloomFilter.mightContain(1000));
    }



}
