package linkedlist;


import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
    public MyList<String> list;

  @Before
    public void before(){                  //добавление элемента
        list = new MyLinkedList<>();
        list.add("QWERTY");
    }
    @Test
    public void add_test (){
        assert list.contains("QWERTY");

    }

    @Test
    public void get_test_index (){
        assert list.get(0) != null;

    }
    @Test
    public void get_test_element(){
        assert list.indexOf("QWERTY") >= 0;
    }

    @Test
    public void contains_test() {
        assert list.contains("QWERTY") ;
    }

    @Test
    public void remove_test_element() {
      list.add("ASD");
      list.remove("QWERTY");
      assert list.size() == 1;
    }

    @Test
    public void remove_test_index() {
        list.add("ASD");
        list.remove(0);
        assert list.size() == 1;
    }
    @Test
    public void indexOf_test() {
        assert list.get(0).equals("QWERTY");
    }
    @Test
    public void size_test() {
        assert list.size() > 0;
    }
    @Test
    public void clear_test() {
        list.clear();
        assert list.size() == 0;
    }
    @Test
    public void addAll_test(){
    MyLinkedList<String> list1 = new MyLinkedList<>();
    MyLinkedList<String> list2 = new MyLinkedList<>();
        list1.add("ASD");
        list1.add("XYS");
        list2.add("XCV");
        list1.addAll(list2);
        assert list1.size() == 3;
    }
}
