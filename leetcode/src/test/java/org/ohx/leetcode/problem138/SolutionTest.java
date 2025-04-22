package org.ohx.leetcode.problem138;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testEmptyList() {
        // 测试空链表
        Node head = null;
        Node result = solution.copyRandomList(head);
        assertNull(result);
    }

    @Test
    public void testSingleNode() {
        // 测试单节点，random指向自身
        Node original = new Node(1);
        original.random = original;

        Node copy = solution.copyRandomList(original);
        assertNotNull(copy);
        assertEquals(1, copy.val);
        assertSame(copy, copy.random); // 新节点的random应指向自身
        assertNull(copy.next);
    }

    @Test
    public void testTwoNodes() {
        // 测试双节点，A.random指向B，B.random为null
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        a.random = b;
        b.random = null;

        Node copy = solution.copyRandomList(a);
        Node copyA = copy;
        Node copyB = copy.next;

        assertEquals(1, copyA.val);
        assertEquals(2, copyB.val);
        assertSame(copyB, copyA.random); // A的random应指向B的副本
        assertNull(copyB.random);
        assertNull(copyB.next);
    }

    @Test
    public void testComplexList() {
        // 测试复杂链表：A→B→C，A.random=C，B.random=A，C.random=null
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        a.random = c;
        b.random = a;
        c.random = null;

        Node copy = solution.copyRandomList(a);
        Node copyA = copy;
        Node copyB = copy.next;
        Node copyC = copyB.next;

        assertEquals(1, copyA.val);
        assertEquals(2, copyB.val);
        assertEquals(3, copyC.val);
        assertSame(copyC, copyA.random); // A的random指向C的副本
        assertSame(copyA, copyB.random); // B的random指向A的副本
        assertNull(copyC.random);
        assertNull(copyC.next);
    }

    @Test
    public void testRandomIsNull() {
        // 测试random为null的情况
        Node a = new Node(1);
        a.random = null;

        Node copy = solution.copyRandomList(a);
        assertNotNull(copy);
        assertNull(copy.random);
        assertNull(copy.next);
    }
}
