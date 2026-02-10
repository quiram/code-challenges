package com.github.quiram.contests.weeklyleetcode488.q3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int[] nums, long k, int result) {
        assertEquals(result, solution.countSubarrays(nums, k));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{97972481, 930598563, 314313375, 175573412, 162190171, 219104574, 422802583, 607950364, 592864533, 976554265, 812497864, 680816749, 759971788, 125263581, 87657934, 716673807, 303336691, 71618316, 697802577, 474649598, 373446233, 84929297, 966011901, 774697275, 401252862, 349443940, 541515978, 722312906, 479444254, 439036905, 586856629, 456283761, 486432108, 366271311, 607068433, 567537885, 558649446}, 32999014233L, 702),
                Arguments.of(new int[]{1, 3, 2}, 4, 5),
                Arguments.of(new int[]{1, 2, 3}, 0, 3)
        );
    }
}