package arraylist;


import linkedlist.MyArrayList;
import linkedlist.MyList;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
    private MyList<String> arr;


  @Before
    public void before(){               //добавление элемента
        arr = new MyArrayList<>();
        arr.add("QWERTY");
    }
    @Test
    public void add_test (){
        assert arr.contains("QWERTY");
    }

    @Test
    public void get_test_index(){
        assert arr.get(0).equals("QWERTY");
    }
    @Test
    public void get_test_element(){
        assert arr.indexOf("QWERTY") == 0;
    }
    @Test
    public void contains_test_index() {
        assert arr.contains(0);
    }
    @Test
    public void contains_test_element() {
        assert arr.contains("QWERTY");
    }
    @Test
    public void remove_test_index() {
        arr.add("ASD");
        arr.remove(0);
        assert !arr.get(0).equals("QWERTY");
    }

    @Test
    public void remove_test_element() {
        arr.add("ASD");
        arr.remove("QWERTY");
        assert !arr.get(0).equals("QWERTY");
    }

    @Test
    public void indexOf_test() {
        assert arr.get(0).equals("QWERTY");
    }

    @Test
    public void size_test() {
        assert arr.size() > 0;
    }

    @Test
    public void clear() {
        arr.clear();
        assert arr.size() == 0;
    }
    @Test
    public void addAll_test() {
        MyArrayList<String> arr1 = new MyArrayList();
        MyArrayList<String> arr2 = new MyArrayList();
        arr1.add("ASD");
        arr1.add("XYS");
        arr2.add("XCV");
        arr1.addAll(arr2);
        assert arr1.size() == 3;
    }
}
