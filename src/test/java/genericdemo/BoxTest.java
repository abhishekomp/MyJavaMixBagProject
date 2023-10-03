package genericdemo;

import org.junit.jupiter.api.Test;


class BoxTest {

    @Test
    public void test_generic_box_using_Integer(){
       Box<Integer> box = new Box<>(5,5,5);
        double volume = box.calculateVolume();
        System.out.println("Volume = " + volume);
    }

    @Test
    public void test_generic_box_using_mix(){
        Box<Number> box = new Box<>(5.1,5,5);
        double volume = box.calculateVolume();
        System.out.println("Volume = " + volume);
    }

    @Test
    public void test_generic_method_using_Integers(){
        final double volume = Box.calculateVolumeGenericMethod(10, 10, 10);
        System.out.println("volume = " + volume);
    }

    @Test
    public void test_generic_method_using_Double(){
        final double volume = Box.calculateVolumeGenericMethod(10.1, 10.1, 10.1);
        System.out.println("volume = " + volume);
    }


}