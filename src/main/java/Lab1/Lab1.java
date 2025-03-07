package Lab1;

public class Lab1 {

    public static char[][] make_forward()
    {
        char[][] pixel = new char[4][13];
        pixel[0][0]=' ';
        pixel[0][1]=' ';
        pixel[0][2]='_';
        pixel[0][3]='_';
        pixel[0][4]='_';
        pixel[0][5]='_';
        pixel[0][6]='_';
        pixel[0][7]='_';
        pixel[0][8]=' ';
        pixel[0][9]=' ';
        pixel[0][10]=' ';
        pixel[0][11]=' ';
        pixel[0][12]=' ';
        pixel[1][0]=' ';
        pixel[1][1]='/';
        pixel[1][2]='|';
        pixel[1][3]='_';
        pixel[1][4]='|';
        pixel[1][5]='|';
        pixel[1][6]='_';
        pixel[1][7]='\\';
        pixel[1][8]='\'';
        pixel[1][9]='.';
        pixel[1][10]='_';
        pixel[1][11]='_';
        pixel[1][12]=' ';
        pixel[2][0]='(';
        pixel[2][1]=' ';
        pixel[2][2]=' ';
        pixel[2][3]=' ';
        pixel[2][4]='_';
        pixel[2][5]=' ';
        pixel[2][6]=' ';
        pixel[2][7]=' ';
        pixel[2][8]=' ';
        pixel[2][9]='_';
        pixel[2][10]=' ';
        pixel[2][11]='_';
        pixel[2][12]='\\';
        pixel[3][0]='=';
        pixel[3][1]='\'';
        pixel[3][2]='-';
        pixel[3][3]='(';
        pixel[3][4]='_';
        pixel[3][5]=')';
        pixel[3][6]='-';
        pixel[3][7]='-';
        pixel[3][8]='(';
        pixel[3][9]='_';
        pixel[3][10]=')';
        pixel[3][11]='-';
        pixel[3][12]='\'';
        return pixel;
    }

    private static void printImage(char[][] image) {
        for (char[] chars : image) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] make_mirror(char[][] in) {
        // setup new array with appropriate sizing
        char[][] mirror;
        mirror = new char[in.length][];
        for (int i = 0; i < in.length; i++) {
            mirror[i] = new char[in[i].length];
        }

        // flip it row-by-row
        for (int i = 0; i < in.length; i++) {
            for (int j = in[i].length; j-- > 0;) {
                char c = in[i][j];
                int col = mirror[i].length - 1 - j;

                c = switch (c) {
                    case '(' -> ')';
                    case ')' -> '(';
                    case '/' -> '\\';
                    case '\\' -> '/';
                    default -> c;
                };


                mirror[i][col] = c;
            }
        }

        return mirror;
    }

    public static void main(String[] args) {
        char[][] image = make_forward();

        printImage(image);

        char[][] mirror = make_mirror(image);
        printImage(mirror);

        // print the "car crash"
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j]);
            }
            for (int j = 0; j < mirror[i].length; j++) {
                System.out.print(mirror[i][j]);
            }
            System.out.println();
        }
    }
}
