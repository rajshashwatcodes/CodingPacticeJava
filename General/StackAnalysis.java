import java.util.Stack;

public class StackAnalysis {

    public static void main(String[] args) {
        // Creating a stack
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Displaying the contents of the stack
        System.out.println("Stack elements: " + stack);

        // Analyzing the stack
        analyzeStack(stack);

        // Popping elements from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Displaying the updated contents of the stack
        System.out.println("Stack elements after popping: " + stack);
    }

    // Function to analyze the stack
    static void analyzeStack(Stack<Integer> stack) {
        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Display the size of the stack
        System.out.println("Size of the stack: " + stack.size());

        // Peek at the top element without removing it
        if (!stack.isEmpty()) {
            System.out.println("Top element of the stack: " + stack.peek());
        }
    }
}
