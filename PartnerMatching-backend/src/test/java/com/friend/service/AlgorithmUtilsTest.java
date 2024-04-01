package com.friend.service;

import com.friend.partnermatching.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
@SpringBootTest
public class AlgorithmUtilsTest {

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大二", "男");
        List<String> tagList3 = Arrays.asList("Python", "大二", "女");

        long score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        long score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }
}
