

class TextEditor {

    Stack<Character> left;
    Stack<Character> right;

    public TextEditor() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void addText(String text) {

        for (char c : text.toCharArray()) {
            left.push(c);
        }
    }

    public int deleteText(int k) {

        int count = 0;

        while (k > 0 && !left.isEmpty()) {
            left.pop();
            k--;
            count++;
        }

        return count;
    }

    public String cursorLeft(int k) {

        while (k > 0 && !left.isEmpty()) {
            right.push(left.pop());
            k--;
        }

        return last10();
    }

    public String cursorRight(int k) {

        while (k > 0 && !right.isEmpty()) {
            left.push(right.pop());
            k--;
        }

        return last10();
    }

    private String last10() {

        StringBuilder sb = new StringBuilder();

        int size = left.size();
        int start = Math.max(0, size - 10);

        for (int i = start; i < size; i++) {
            sb.append(left.get(i));
        }

        return sb.toString();
    }
}