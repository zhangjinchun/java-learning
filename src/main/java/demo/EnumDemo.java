package demo;

/**
 * @author zhangjinchun
 * @date 2018/3/5
 */
public class EnumDemo {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }

    public enum Color {
        RED("red color", 0), GREEN("green color", 1), BLUE("blue color", 2), YELLOW(
                "yellow color", 3);

        Color(String name, int id) {
            _name = name;
            _id = id;
        }

        private String _name;
        private int _id;

        public String getName() {
            return _name;
        }

        public int getId() {
            return _id;
        }

        @Override
        public String toString() {
            return _name + "," + _id;
        }
    }
}
