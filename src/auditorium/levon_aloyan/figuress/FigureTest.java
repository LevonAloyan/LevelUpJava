package auditorium.levon_aloyan.figuress;

public class FigureTest {

    public static void main(String[] args) {
        Figure fg  = new Rectangle(10, 10, 70, 40, null);
        ((Rectangle)fg).draw(null);
        Figure [] figures = new Figure[10];

        int len = figures.length;
        for (int i = 0; i < len; i++) {
//            figures[i] = i % 2 == 0
//                    ? new Rectangle(10, 10, 70, 40)
//                    : new Circle(50, 30, 60, 60);
        }


    }

    public static void paint(Figure[] figures) {
        int len = figures.length;
        for (int i = 0; i < len; i++) {
            figures[i].draw(null);
        }
    }

}
