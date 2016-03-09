package sort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import shuffles.KnuthShuffle;

public class TestCallbackImpl {

	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testIQuickSort(){
		//Integer[] elems = {56,3,26,42,17,38,9,65,79,23,7,86,35,13};
		//Integer[] elems = {6,2,6,5,6,7,3,6,9};
		//Character[] elems = {'E','C','A','I','E','K','L','P','U','T','M','Q','R','X','O','S'};
		//Character[] elems = {'E','K'};
		//KnuthShuffle.shuffle(elems);
		Integer[] elems = {6, 5, 6, 6, 7, 2, 6, 9, 3};
		System.out.println("Calling Quick sort with these inputs :"+Arrays.toString(elems));
		//QuickSort.aSort(elems,0,elems.length-1);
		QuickSort.iSort(elems,0,elems.length-1);
		System.out.println("Finished Quick sort with these inputs :"+Arrays.toString(elems));
	}
		
		
	//@Test
	public void testSelection(){
		Character[] elems = {'E','C','A','I','E','K','L','P','U','T','M','Q','R','X','O','S'};
		//Character[] elems = {'A','B','C','D','E','F'};
		System.out.println(Selection.getElement(elems, 15));
		assertTrue(Selection.getElement(elems, 1).equals(new Character('C')) );
	}
	
	//@Test
	public void testQuickSort(){
		//Integer[] elems = {56,3,26,42,17,38,9,65,79,23,7,86,35,13};
		//Integer[] elems = {9,2,45,7,3};
		Character[] elems = {'E','C','A','I','E','K','L','P','U','T','M','Q','R','X','O','S'};
		//Character[] elems = {'E','K'};
		System.out.println("Calling Quick sort with these inputs :"+Arrays.toString(elems));
		//QuickSort.aSort(elems,0,elems.length-1);
		KnuthShuffle.shuffle(elems);
		QuickSort.cSort(elems,0,elems.length-1);
		System.out.println("Finished Quick sort with these inputs :"+Arrays.toString(elems));
	}
	
	//@Test
	public void testMergeSort(){
		Integer[] elems = {56,3,26,42,17,38,9,65,79,23,7,86,35,13};
		//Integer[] elems = {9,2,45,7,3};
		System.out.println("Calling Merge sort with these inputs :"+Arrays.toString(elems));
		MergeSort.mergeSort(elems,0,elems.length-1);
		//MergeSort.bottomUpMergeSort(elems);
		//MergeSort.bottomUpMergeSort(elems,0,elems.length-1);
		System.out.println("Finished Merge sort with these inputs :"+Arrays.toString(elems));
	}
	
	//@Test
	public void testShellSort(){
		Integer[] elems = {56,3,26,42,17,38,9,65,79,23,7,86,35};
		System.out.println("Calling shell sort with these inputs :"+Arrays.toString(elems));
		ShellSort.sort(elems);
		System.out.println("Finished shell sort with these inputs :"+Arrays.toString(elems));
	}
	//@Test
	public void testSelectionSort(){
		
		Integer[] elems = {56,3,26,90,17,38};
		System.out.println(Arrays.toString(elems));
		SelectionSort.sort(elems);
		System.out.println(Arrays.toString(elems));
		
	}
	
	//@Test
	public void testInsertionSort(){
		
		Integer[] elems = {56,3,26,42,17,38,9,65,79,23,7,86,35};
		System.out.println("Calling Insertion sort with these inputs :"+Arrays.toString(elems));
		InsertionSort.sort(elems);
		System.out.println("Finished Insertion sort with these inputs :"+Arrays.toString(elems));
		
	}

	//@Test
	public void testTemps(){
		TempComparable a = new TempComparable(10.16);
		TempComparable b = new TempComparable(10.08);
		TempComparable c = new TempComparable(10.00);
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(c));
		System.out.println(a.compareTo(c));
		
		assertTrue(true);
	}
	
	
	
	//@Test
	public void test() {
		Integer[] arr = {9,2,45,7,34,3};
		System.out.println(Arrays.toString(arr));
		SortUtil.sort(arr);
		System.out.println(Arrays.toString(arr));
		assertEquals("2", arr[0].toString());
	}
	
	//@Test
	public void testObjects() {
		
		class Animal implements Comparable<Animal> {

			private String name;
			
			Animal(String name){
				this.name = name;
			}
			@Override
			public int compareTo(Animal o) {
				// TODO Auto-generated method stub
				return this.name.compareTo(o.name);
			}
			public String toString(){
				return name;
			}
		}
		
		
		Animal a = new Animal("Jackal");
		Animal b = new Animal("Fox");
		Animal c = new Animal("Deer");
		Animal d = new Animal("Fish");
		Animal e = new Animal("Ibex");
		
		Animal[] animalArr = {a,b,c,d,e};
		
		System.out.println(Arrays.toString(animalArr));
		SortUtil.sort(animalArr);
		System.out.println(Arrays.toString(animalArr));
	}

}
