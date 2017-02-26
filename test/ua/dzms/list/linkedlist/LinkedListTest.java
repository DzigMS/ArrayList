package ua.dzms.list.linkedlist;

import org.junit.Before;
import org.junit.Test;
import ua.dzms.list.List;
import ua.dzms.list.ListTest;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListTest extends ListTest{

    @Before
    @Override
    public void before() {
        list = new LinkedList<>();
        super.before();
    }
}
