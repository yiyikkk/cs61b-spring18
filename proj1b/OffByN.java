public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int n) {
        this.n = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (x == y + n || y == x + n);
    }
}
