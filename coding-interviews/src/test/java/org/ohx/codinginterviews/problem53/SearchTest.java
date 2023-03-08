package org.ohx.codinginterviews.problem53;

import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/3/8
 */
class SearchTest {
    @Test
    public void test1() {
        Search search = new Search();
        System.out.println(search.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
