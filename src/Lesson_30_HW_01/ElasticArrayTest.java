package Lesson_30_HW_01;

class ElasticArrayTest {
    public static void main(String[] args) {
        ElasticArray<String> stringArray = new ElasticArray<>();

        stringArray.add("Hello");
        stringArray.add("World");
        stringArray.add("Java");

        System.out.println("Element at index 1: " + stringArray.get(1));
        System.out.println("Size before removal: " + stringArray.size());

        String removedElement = stringArray.remove(1);
        System.out.println("Removed element: " + removedElement);
        System.out.println("Size after removal: " + stringArray.size());
    }
}
