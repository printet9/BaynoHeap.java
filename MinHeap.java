import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Get the index of the parent node
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert an element into the heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return the minimum element (root)
    public int removeMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return min;
    }

    // Heapify upwards to maintain heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) < heap.get(getParentIndex(index))) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    // Heapify downwards to maintain heap property
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);

        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Get the size of the heap
    public int size() {
        return heap.size();
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Print the elements of the heap
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method to test the heap
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(2);

        System.out.println("Heap after insertion:");
        minHeap.printHeap();

        System.out.println("Removed minimum: " + minHeap.removeMin());

        System.out.println("Heap after removal:");
        minHeap.printHeap();
    }
}